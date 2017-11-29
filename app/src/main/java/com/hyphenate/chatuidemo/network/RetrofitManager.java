package com.hyphenate.chatuidemo.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.hyphenate.chatuidemo.mvp.model.BlackModel;
import com.hyphenate.chatuidemo.utils.NetUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @文件名: RetrofitManager
 * @创建者: KaneLiu
 * @创建时间: 2017/7/27 0027 14:17
 * @描述：
 */
public class RetrofitManager {
    private ApiService mApiService;
    /**
     * 设缓存有效期为一天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;

    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    private static final String CACHE_CONTROL_AGE = "max-age=0";

    private static volatile OkHttpClient sOkHttpClient;

    private static RetrofitManager retrofitManager;

    public RetrofitManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.SERVICE)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        mApiService = retrofit.create(ApiService.class);
    }

    private OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
//                Cache cache = new Cache(new File(MyApplication.getAppContext().getCacheDir(), "HttpCache"),
//                        1024 * 1024 * 100);
                if (sOkHttpClient == null) {
                    sOkHttpClient = new OkHttpClient
                            .Builder()
//                            .cache(cache)
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(60, TimeUnit.SECONDS)
                            .writeTimeout(60, TimeUnit.SECONDS)
                            .addInterceptor(mRewriteCacheControlInterceptor)
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(mLoggingInterceptor)
                            .build();
                }
            }
        }
        return sOkHttpClient;
    }

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetworkAvailable()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.d("---", "no network");
            } else {
                //添加请求头
                String cacheControl = request.cacheControl().toString();
                Request.Builder rb = request.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .header("Referer", "178trip");
                request = rb.build();
            }

            Response originalResponse = chain.proceed(request);
            if (NetUtil.isNetworkAvailable()) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    private final Interceptor mLoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            Log.i("---", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            Log.i("---", String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    };


    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
            return retrofitManager;
        }
        return retrofitManager;
    }


    /**
     * 根据网络状况获取缓存的策略
     */
    @NonNull
    private String getCacheControl() {
        return NetUtil.isNetworkAvailable() ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }

    public Observable<String> queryGoFlight(String data, String token) {
        return mApiService.queryGoFlight(data, token);
    }

    public Observable<String> getFlightInfo(String data, String token) {
        return mApiService.findFlightInfo(data, token);
    }

    public Observable<String> getBackMoney(String data, String token) {
        return mApiService.getBackMoney(data, token);
    }

    public Observable<String> refounfTickets(String accountName, String files, String orderNo, Integer purchaseChannel, String reason,
                                             String refundAccount, Integer refundMethod, String ticketArray, String validCode,
                                             Integer voluntary, String token) {
        return mApiService.refundTicket(accountName, files, orderNo, purchaseChannel, reason,
                refundAccount, refundMethod, ticketArray, validCode,
                voluntary, token);
    }

    public Observable<String> backTicketCode(String phone, String token) {
        return mApiService.getBackTicketCode(phone, token);
    }

    /**
     * 改签详情
     */
    public Observable<String> findAirChangeInfoByOrder(String data, String token) {
        return mApiService.getfindAirChangeInfoByOrder(data, token);
    }

    public Observable<String> requestChange(String data, String token) {
        return mApiService.requestChange(data, token);
    }


    public Observable<String> postPhoto(List<File> fileList) {
        HashMap<String, RequestBody> stringRequestBodyHashMap = new HashMap<>();
        for (int i = 0; i < fileList.size(); i++) {
            RequestBody rb = RequestBody.create(MediaType.parse("image/*"), fileList.get(i));
            stringRequestBodyHashMap.put("photo" + i, rb);
        }
        return mApiService.postPhoto(stringRequestBodyHashMap);
    }

    /**
     * 验证码
     */
//    public Observable<FetchInfoModel> sendCode(Map<String, String> map) {
//        return mApiService.sendCode(map);
//    }

     /**
     * 注册
     */
//        public Observable<FetchInfoModel> doRegister(Map<String, String> map) {
//            return mApiService.doRegister(map);
//    }

    /**
     * 登录
     */
//    public Observable<UserModel> doLogin(Map<String, String> map){
//        return mApiService.doLogin(map);
//    }
    /**
     * 黑板列表
     */
    public Observable<BlackModel> blackList(Map<String, String> map){
        return mApiService.doLogin(map);
    }
}

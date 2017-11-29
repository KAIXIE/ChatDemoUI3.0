package com.hyphenate.chatuidemo.network;

import com.hyphenate.chatuidemo.mvp.model.BlackModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * @文件名: ApiService
 * @创建者: KaneLiu
 * @创建时间: 2017/7/27 0027 14:17
 * @描述：
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("app/airChange/searchChangeFlight.do")
    Observable<String> queryGoFlight(
            @Field("data") String data,
            @Field("token") String token);

    //退改 获取航段详情
    @FormUrlEncoded
    @POST("/app/refundTicket.do")
    Observable<String> refundTicket(
            @Field("accountName") String accountName,
            @Field("files") String files,
            @Field("orderNo") String orderNo,
            @Field("purchaseChannel") Integer purchaseChannel,
            @Field("reason") String reason,
            @Field("refundAccount") String refundAccount,
            @Field("refundMethod") Integer refundMethod,
            @Field("ticketArray") String ticketArray,
            @Field("validCode") String validCode,
            @Field("voluntary") Integer voluntary,
            @Field("token") String token);

    //退改 获取航段详情
    @FormUrlEncoded
    @POST("app/airFlight/findFlightInfo.do")
    Observable<String> findFlightInfo(
            @Field("data") String data,
            @Field("token") String token);

    //退改 获取航段详情
    @FormUrlEncoded
    @POST("app/airChange/applyChangeTicket.do")
    Observable<String> requestChange(
            @Field("data") String data,
            @Field("token") String token);

    @Multipart
    @POST("")
    Observable<String> postPhoto(
            @PartMap() Map<String, RequestBody> maps
    );
    //退票账号获取验证码
    @FormUrlEncoded
    @POST("app/refundTicket.do")
    Observable<String> getBackTicketCode(
            @Field("phone") String phone,
            @Field("token") String token);
    //
    @FormUrlEncoded
    @POST("app/airChange/findAirChangeInfoByOrder.do")
    Observable<String> getfindAirChangeInfoByOrder(
            @Field("data") String data,
            @Field("token") String token);

    //计算退款金额
    @FormUrlEncoded
    @POST("app/airFlight/calculationRefundPrice.do")
    Observable<String> getBackMoney(
            @Field("data") String data,
            @Field("token") String token);

    //发送验证码
//    @FormUrlEncoded
//    @POST("app/user/addVaildNumber.do")
//    Observable<FetchInfoModel> sendCode(@FieldMap Map<String, String> map);

    //注册
//    @FormUrlEncoded
//    @POST("app/user/registerUser.do")
//    Observable<FetchInfoModel> doRegister(@FieldMap Map<String, String> map);

    //登录
//    @FormUrlEncoded
//    @POST("app/login/appUserlogin.do")
//    Observable<UserModel> doLogin(@FieldMap Map<String, String> map);
    //登录
    @FormUrlEncoded
    @POST("/article/articlePager.do")
    Observable<BlackModel> doLogin(@FieldMap Map<String, String> map);
}

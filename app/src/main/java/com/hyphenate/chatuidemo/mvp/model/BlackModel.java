package com.hyphenate.chatuidemo.mvp.model;

import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */

public class BlackModel {



    /**
     * status : 1
     * ErrorInfo :
     * articlePager : {"total":2,"rows":[{"view":13,"headImg":"1","author":"恰同学-XXX","id":2,"collect":48,"introduction":"[环球时报驻台北特约记者 崔明轩]台湾继19日上午透露解放军一架电子侦察机18日飞经宫古海域、绕台一周飞行后，晚间再度称，解放军19日又","previewimg":"http://115.28.185.203:8003/upload/upload/20171120102058813.png;http://115.28.185.203:8003/upload/upload/20171120102144127.png;http://115.28.185.203:8003/upload/upload/20171120102146183.png"},{"view":13,"headImg":"1","author":"恰同学-XXX","id":5,"collect":48,"introduction":"[环球时报驻台北特约记者 崔明轩]台湾继19日上午透露解放军一架电子侦察机18日飞经宫古海域、绕台一周飞行后，晚间再度称，解放军19日又","previewimg":"http://115.28.185.203:8003/upload/upload/20171120102058813.png;http://115.28.185.203:8003/upload/upload/20171120102144127.png;http://115.28.185.203:8003/upload/upload/20171120102146183.png"}]}
     * pageCount : 1
     */

    private String status;
    private String ErrorInfo;
    private ArticlePagerBean articlePager;
    private int pageCount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorInfo() {
        return ErrorInfo;
    }

    public void setErrorInfo(String ErrorInfo) {
        this.ErrorInfo = ErrorInfo;
    }

    public ArticlePagerBean getArticlePager() {
        return articlePager;
    }

    public void setArticlePager(ArticlePagerBean articlePager) {
        this.articlePager = articlePager;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public static class ArticlePagerBean {
        /**
         * total : 2
         * rows : [{"view":13,"headImg":"1","author":"恰同学-XXX","id":2,"collect":48,"introduction":"[环球时报驻台北特约记者 崔明轩]台湾继19日上午透露解放军一架电子侦察机18日飞经宫古海域、绕台一周飞行后，晚间再度称，解放军19日又","previewimg":"http://115.28.185.203:8003/upload/upload/20171120102058813.png;http://115.28.185.203:8003/upload/upload/20171120102144127.png;http://115.28.185.203:8003/upload/upload/20171120102146183.png"},{"view":13,"headImg":"1","author":"恰同学-XXX","id":5,"collect":48,"introduction":"[环球时报驻台北特约记者 崔明轩]台湾继19日上午透露解放军一架电子侦察机18日飞经宫古海域、绕台一周飞行后，晚间再度称，解放军19日又","previewimg":"http://115.28.185.203:8003/upload/upload/20171120102058813.png;http://115.28.185.203:8003/upload/upload/20171120102144127.png;http://115.28.185.203:8003/upload/upload/20171120102146183.png"}]
         */

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * view : 13
             * headImg : 1
             * author : 恰同学-XXX
             * id : 2
             * collect : 48
             * introduction : [环球时报驻台北特约记者 崔明轩]台湾继19日上午透露解放军一架电子侦察机18日飞经宫古海域、绕台一周飞行后，晚间再度称，解放军19日又
             * previewimg : http://115.28.185.203:8003/upload/upload/20171120102058813.png;http://115.28.185.203:8003/upload/upload/20171120102144127.png;http://115.28.185.203:8003/upload/upload/20171120102146183.png
             */

            private int view;
            private String headImg;
            private String author;
            private int id;
            private int collect;
            private String introduction;
            private String previewimg;

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCollect() {
                return collect;
            }

            public void setCollect(int collect) {
                this.collect = collect;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getPreviewimg() {
                return previewimg;
            }

            public void setPreviewimg(String previewimg) {
                this.previewimg = previewimg;
            }
        }
    }
}

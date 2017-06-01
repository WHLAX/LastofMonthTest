package com.ydtx.lastofmonthtest.bean;

import java.util.List;

/**
 * 作者： 武星宇
 * 日期： 2017/6/1.
 * 类用途：
 */

public class ZuixinBean {


    /**
     * date : 20170601
     * stories : [{"images":["https://pic4.zhimg.com/v2-b3f2c49b93c9924bf4209ef66e97f5af.jpg"],"type":0,"id":9450319,"ga_prefix":"060108","title":"普通人会编程，能为工作带来哪些优势？"},{"images":["https://pic2.zhimg.com/v2-07d45da65a63bc9d17292c62357c02d1.jpg"],"type":0,"id":9442959,"ga_prefix":"060107","title":"怎么卤牛肉，才有绝妙的口感和味道"},{"images":["https://pic1.zhimg.com/v2-d33eee804c199d70e703f7bede102974.jpg"],"type":0,"id":9451266,"ga_prefix":"060107","title":"职场头两年 · 我知道第一份工作很重要，但到底该怎么选？"},{"images":["https://pic4.zhimg.com/v2-866f8eeecf1e737d21b06a6500b3b89f.jpg"],"type":0,"id":9451093,"ga_prefix":"060107","title":"看不懂，陌陌财报说营收大涨，为什么股价反而跌了？"},{"images":["https://pic1.zhimg.com/v2-440c4ccde6b87f14d1efdcdc2d1abdcc.jpg"],"type":0,"id":9449341,"ga_prefix":"060106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-6a32633b331c1f77b1295a1cc116c1fa.jpg","type":0,"id":9451093,"ga_prefix":"060107","title":"看不懂，陌陌财报说营收大涨，为什么股价反而跌了？"},{"image":"https://pic3.zhimg.com/v2-21c57ed85ecbf27badb24917fbcd888e.jpg","type":0,"id":9449645,"ga_prefix":"053109","title":"我们擅长的，AI 还有一些办不到；\r\nAI 擅长的，我们永远也办不到"},{"image":"https://pic3.zhimg.com/v2-84b8ca90609b83cbf77d74a1accdd6ce.jpg","type":0,"id":9449109,"ga_prefix":"053107","title":"当你说「我有一个朋友\u2026\u2026」，我意味深长地笑了"},{"image":"https://pic2.zhimg.com/v2-4c708d0ebb43bd5dcf81358668cf7825.jpg","type":0,"id":9441460,"ga_prefix":"053007","title":"原来淘金的人真能捡到实打实的金子（但是你不用想了）"},{"image":"https://pic2.zhimg.com/v2-9937576dc406cd42634a34c9a8886ce1.jpg","type":0,"id":9442721,"ga_prefix":"053009","title":"她把小脑运动神经受损的儿子送进哈佛，单亲家庭不一定只有伤害"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-b3f2c49b93c9924bf4209ef66e97f5af.jpg"]
         * type : 0
         * id : 9450319
         * ga_prefix : 060108
         * title : 普通人会编程，能为工作带来哪些优势？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-6a32633b331c1f77b1295a1cc116c1fa.jpg
         * type : 0
         * id : 9451093
         * ga_prefix : 060107
         * title : 看不懂，陌陌财报说营收大涨，为什么股价反而跌了？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

package com.ydtx.lastofmonthtest.okhttputils;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *作者：武星宇
 *时间：2017/6/1  9:33
 *本类说明:封装类
 */


public class NetworkUtils {
    //创建okHttpClient对象
    private static final OkHttpClient okhttpclient = new OkHttpClient();

    /**
     * 获取请求对象request
     *  @param url
     *  @return
     */
    private static Request getRequestFromUrl(String url) {
        Request request = new Request.Builder().url(url).build();
        return request;
    }

    /**
     * 获取响应对象
     * @param url
     * @return
     * @throws IOException
     */
    private static Response getResponseFromUrl(String url) throws IOException {
        Request request = getRequestFromUrl(url);
        Response response = okhttpclient.newCall(request).execute();
        return response;
    }



    /**
     * 获取responseBody对象
     * @param url
     * @return
     * @throws IOException
     */
    private static ResponseBody getResponseBodyFromUrl(String url) throws IOException {
        Response response = getResponseFromUrl(url);
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

    /**
     * 通过网络请求获取字符串
     * @param url
     * @return
     * @throws IOException
     */
    public static String loadStringFromUrl(String url) throws IOException {
        ResponseBody responseBody = getResponseBodyFromUrl(url);
        if (responseBody != null) {
            return responseBody.string();
        }
        return null;
    }

    /**
     * 开启异步线程，通过回调方法获取数据
     *
     * @param url
     * @param callback
     */
    public static void loadData(String url, Callback callback) {
        Request request = getRequestFromUrl(url);
        okhttpclient.newCall(request).enqueue(callback);
    }



    /**
     * 通过网络请求获取字符串
     * @param url
     * @return
     * @throws IOException
     */
    public byte[] loadByteFromUrl(String url) throws IOException {
        ResponseBody responseBody = getResponseBodyFromUrl(url);
        if (responseBody != null) {
            return responseBody.bytes();
        }
        return null;
    }

    /**
     * 通过网络请求获取输入流
     * @param url
     * @return
     * @throws IOException
     */
    public InputStream loadStemFromUrl(String url) throws IOException {
        ResponseBody responseBody = getResponseBodyFromUrl(url);
        if (responseBody != null) {
            return responseBody.byteStream();
        }
        return null;
    }









}

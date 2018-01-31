package com.nf.sb_demo.sms.service;


import com.nf.sb_demo.sms.utils.CommonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Service
public class MeiShengSMSServiceImpl implements SMSService {

    static String HttpUrl = "http://api.rcscloud.cn:8030/rcsapi/rest";
    static String ACCOUNT_SID = "ZH000000540";
    static String ACCOUNT_APIKEY = "a85f409e-cf61-4d3f-a107-559bed41873c";
    static final String CHARSET_UTF8 = "utf-8";
    static String extno = "222";

    @Override
    public String sendSMS(String to, String what, int templateNo) {
        String resultJson = "";
        HttpClient httpClient = null;
        try {
            // 构造发送的内容
            HttpPost sms = new HttpPost(HttpUrl + "/sms/sendtplsms.json");
            sms.setHeader("Content-Type", "application/x-www-form-urlencoded");
            sms.setHeader("Content-Encoding", CHARSET_UTF8);
            List<NameValuePair> nvps = Arrays.asList(
                    new BasicNameValuePair("sid", ACCOUNT_SID),
                    new BasicNameValuePair("sign", encrypt(ACCOUNT_SID + ACCOUNT_APIKEY + templateNo + to + what)),
                    new BasicNameValuePair("extno", extno),
                    new BasicNameValuePair("tplid", templateNo + ""),
                    new BasicNameValuePair("mobile", to),
                    new BasicNameValuePair("content", what));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, CHARSET_UTF8);
            sms.setEntity(entity);


            // 通过httpclient发送信息出去
            // 1. 创建客户端
            httpClient = HttpClientBuilder.create().build();
            // 2. 发送内容，得到返回
            HttpResponse response = httpClient.execute(sms);
            HttpEntity httpEntity = response.getEntity();


            //返回JSON字符串格式，用户根据实际业务进行解析处理
            if (httpEntity != null) {
                resultJson = EntityUtils.toString(httpEntity, CHARSET_UTF8);
            }

            EntityUtils.consume(entity);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return resultJson;
    }

    @Override
    public String sendSMS(String to, String what) {
        return sendSMS(to, what, 9);
    }

    private String encrypt(String msg) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return CommonUtils.md5Digest(CommonUtils.changeCharset(msg, CHARSET_UTF8), CHARSET_UTF8);
    }
}
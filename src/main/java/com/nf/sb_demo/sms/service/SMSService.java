package com.nf.sb_demo.sms.service;

public interface SMSService {
    String sendSMS(String to, String what);

    /**
     * template: 01 验证码
     *           02 祝福短信
     * @param to
     * @param what
     * @param templateNo
     * @return
     */
    String sendSMS(String to, String what, int templateNo);
}

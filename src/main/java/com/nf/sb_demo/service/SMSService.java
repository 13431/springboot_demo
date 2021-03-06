package com.nf.sb_demo.service;

public interface SMSService extends Sender {
    /**
     * template: 01 验证码
     *           02 祝福短信
     * @param to
     * @param what
     * @param templateNo
     * @return
     */
    String send(String to, String what, int templateNo);
}

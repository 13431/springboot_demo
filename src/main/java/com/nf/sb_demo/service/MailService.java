package com.nf.sb_demo.service;

public interface MailService extends Sender {
    String send(String to, String what, String type);
}

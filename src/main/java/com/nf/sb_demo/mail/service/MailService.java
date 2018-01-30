package com.nf.sb_demo.mail.service;

public interface MailService {
    String sendSimple(String to, String what);
    String sendComlex(String to, String what);
}

package com.nf.sb_demo.service;

public interface Mail extends Sender {
    String send(String to, String what, String type);
}

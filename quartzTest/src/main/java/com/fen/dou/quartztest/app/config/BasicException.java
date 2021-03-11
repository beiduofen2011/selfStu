package com.fen.dou.quartztest.app.config;

public class BasicException extends RuntimeException {
    private static final long serialVersionUID = -4352210411313726288L;

    public BasicException(String code) {
        super(code);
    }

    public BasicException(String code,Throwable cause) {
        super(code,cause);
    }
}

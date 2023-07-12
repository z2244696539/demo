package com.demo.pojo;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功");

    private final Integer code;

    private final String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
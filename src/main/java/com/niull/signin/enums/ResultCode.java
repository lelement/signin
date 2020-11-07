package com.niull.signin.enums;

import lombok.Getter;

/**
 * @Author niull
 * @Date 2020/10/10 15:39
 * @Description 牛立露你就写点注释吧
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

package com.csuylg.common.web;

import java.io.Serializable;

/**
 * 公共响应对象
 *
 * @author dyf
 */
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public CommonResponse(Boolean result) {
        this.result = result;
    }

    public static CommonResponse success() {
        return new CommonResponse(true);
    }

    public static CommonResponse fail() {
        return new CommonResponse(false);
    }
}

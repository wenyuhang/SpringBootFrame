package com.wl3321.frame.exception;

import com.wl3321.frame.constant.Status;
import lombok.Getter;

/**
 * author : WYH
 * e-mail : wenyuhang@qinjia001.com
 * date   : 2020/8/6 11:09
 * desc   : 页面异常
 */
@Getter
public class PageException extends BaseException {

    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}

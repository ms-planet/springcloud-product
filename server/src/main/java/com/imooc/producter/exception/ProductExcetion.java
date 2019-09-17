package com.imooc.producter.exception;

import com.imooc.producter.enums.ResultEnum;

/**
 * @author zxlei
 * @date 2019/8/23 14:36
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ProductExcetion extends RuntimeException {

    private Integer code;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ProductExcetion(Integer code, String message) {
        super(message);
        this.code = code;
    }


    public ProductExcetion(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

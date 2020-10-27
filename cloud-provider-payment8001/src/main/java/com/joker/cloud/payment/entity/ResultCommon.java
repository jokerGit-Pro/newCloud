package com.joker.cloud.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author:Tom-joker
 * @Date:2020/10/26
 * @version:1.0
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResultCommon<T> {

    private Integer code;
    private String message;
    private T data;

    public ResultCommon(Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}

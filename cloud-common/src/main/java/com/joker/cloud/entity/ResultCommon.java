package com.joker.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author:Tom-joker
 * @Date:2020/10/26
 * @version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResultCommon<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public ResultCommon(Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}

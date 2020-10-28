package com.joker.cloud.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author joker
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Payment对象", description="支付表")
public class Payment implements Serializable  {

private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "序列号")
    private String serial;


}

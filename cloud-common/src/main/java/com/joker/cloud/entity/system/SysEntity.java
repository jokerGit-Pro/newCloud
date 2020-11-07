package com.joker.cloud.entity.system;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**  日志实体类
 * @Author:Tom-joker
 * @Date:2020/11/3
 * @version:1.0
 */
@Data
@Excel(value = "日志报表")
@EqualsAndHashCode
@Accessors(chain = true)
public class SysEntity implements Serializable {

    @ExcelField("主键")
    private Integer id;

    @ExcelField("操作Ip")
    private String requestIp;

    @ExcelField("操作类型 1.操作记录，2.异常记录")
    private Integer type;

    @ExcelField("操作人")
    private Integer userName;

    @ExcelField("操作描述")
    private String description;

    @ExcelField("请求方法")
    private String actionMethod;

    @ExcelField("请求Url")
    private String actionUrl;

    @ExcelField("请求参数")
    private String params;

    @ExcelField("浏览器")
    private String ua;

    @ExcelField("类路径")
    private String classpath;

    @ExcelField("请求方法")
    private String requestMethod;

    @ExcelField("开始时间")
    private LocalDateTime startTime;

    @ExcelField("完成时间")
    private LocalDateTime finishTime;

    @ExcelField("耗时")
    private Long consumingTime;

    @ExcelField("异常详情信息，堆栈信息")
    private String exDetial;

    @ExcelField("exDesc")
    private String exDesc;
}

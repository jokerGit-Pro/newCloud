package com.joker.cloud.payment.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * @Author:Tom-joker
 * @Date:2020/10/26
 * @version:1.0
 */

@Component
//@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
@MapperScan(basePackages = "com.joker.cloud.payment.mapper")
public class MybatisPlusConfig  {

    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor() ;
        performanceInterceptor.setMaxTime(100);
        performanceInterceptor.setWriteInLog(true);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }


}

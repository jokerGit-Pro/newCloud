package com.joker.cloud.payment.aop;

import com.joker.cloud.payment.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Objects;

/**
 * 日志切面 @Author:Tom-joker @Date:2020/11/3
 *
 * @version:1.0
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {

  /** 事件发布是由ApplicationContext对象管控的，发布事件前需要引入此对象 */
  @Autowired private ApplicationContext applicationContext;

  /**
   * 功能描述: 定义controller切入点拦截规则，拦截SysLog方法
   *
   * @anthor:Tom-Joker
   * @date:
   */
  @Pointcut("@annotation(com.joker.cloud.payment.annotation.SysLog)")
  public void sysLogAspect() {}

  /**
   * 拦截前操作
   *
   * @param joinPoint
   */
  @Before(value = "sysLogAspect()")
  public void recordLog(JoinPoint joinPoint) {
    long beginTime = Instant.now().toEpochMilli();

    HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
            .getRequest();
  }
}

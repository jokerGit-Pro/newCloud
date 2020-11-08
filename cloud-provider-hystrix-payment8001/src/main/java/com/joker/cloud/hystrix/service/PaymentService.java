package com.joker.cloud.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author:Tom-joker
 * @Date:2020/11/7
 * @version:1.0
 */
@Service
public class PaymentService {
    //*************************************服务降级   ↓*******************************************************

    public String payment_Ok(){
        return "当前·线程："+Thread.currentThread().getName()+" 执行OK";
    }

    /**
     *  execution.isolation.thread.timeoutInMilliseconds 3000：规定了该业务方法的执行时间，超时就会执行降级方法
     *  如果在3000毫秒内执行方法时遇到异常，直接就会执行降级方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "payment_TimeOout_Handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String payment_TimeOout(){
        try{
            //int age=10/0;
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "当前 线程："+Thread.currentThread().getName()+" 执行超时 ";
    }

    public String payment_TimeOout_Handler(){
        return "当前 线程："+Thread.currentThread().getName()+" 8001 由于超时，执行了降级方法";
    }
    //*************************************服务降级   ↑*******************************************************

    //*************************************服务熔断   ↓**************************************
    /*@HystrixCommand(fallbackMethod = "payCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//开启熔断器   5秒内 10次请求失败率达到60开启熔断器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求峰值
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),// 休眠时间窗口
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") //开启熔断的百分比
    })*/
    @HystrixCommand(fallbackMethod = "payCircuitBreakerHandler",
            groupKey = "strGroupCommand",commandKey = "strCommand",
            threadPoolKey = "strThreadPool",commandProperties = {
            //隔离策略，THREAD表示线程池隔离   SEMAPHORE表示信号量隔离
            @HystrixProperty(name="execution.isolation.strategy",value = "THREAD"),
            //当隔离策略选择信号量隔离的时候，用来设置信号量的大小
            @HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests",value = "10"),
            //配置命令执行的超时时间
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
            //是否启用超时时间
            @HystrixProperty(name="execution.timeout.enabled",value = "true"),
            //执行超时的时候是否中断
            @HystrixProperty(name="execution.isolation.thread.interruptOnTimeout",value = "true"),
            //执行被取消的时候是否中断
            @HystrixProperty(name="execution.isolation.thread.interruptOnFutureCancel",value = "true"),
            //允许回调方法执行的最大并发数
            @HystrixProperty(name="fallback.isolation.semaphore.maxConcurrentRequests",value = "10"),
            //服务降级是否启用，是否执行回调函数
            @HystrixProperty(name="fallback.enabled",value = "true"),
            //是否启用断路器
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            // 滚动事件窗中，断路器的最小请求数。例如，默认该值为20，如果滚动时间窗（10s）
            // 仅收到了19个请求，即使是这19个请求全都失败了，断路器也不会打开
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            // 在滚动时间窗中，请求数量超过 circuitBreaker.requestVolumeThreshold 的情况下
            //如果错误请求数的百分比超过当前值，断路器就会打开，否则处于关闭状态
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
            // 该属性用来设置当前断路器处于打开状态时后的休眠时间。
            // 休眠时间结束后，断路器会处于半开状态，尝试熔断的请求命令，如果依然失败，就继续将熔断器设为打开状态
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            // 断路器强制打开
            @HystrixProperty(name="circuitBreaker.forceOpen",value = "true"),
            //断路器强制关闭
            @HystrixProperty(name="circuitBreaker.forceClosed",value = "false"),
            // 滚动事件窗设置，该时间用于断路器判断健康度时需要手机信息的持续时间
            @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value = "10000"),
            // 该属性用来设置滚动时间窗统计指标信息时划分为"桶"的数量，断路器在收集指标时会根据
            //设置的时间窗拆分成多个”桶"来累计各度量值，每个”桶“记录了一段时间内的采集指标
            //比如 10 秒内拆分成10个"桶"收集，所以timeMilleseconds必须能被numBuckets整除，否则会抛异常
            @HystrixProperty(name="metrics.rollingStats.numBuckets",value = "10"),
            //该属性用来设置对命令执行的延迟是否使用百分位来跟踪和计算。
            // 如果设置为false,那么所有的概要统计都将返回-1
            @HystrixProperty(name="metrics.rollingPercentile.enabled",value = "true"),
            // 该属性用来设置百分位统计的滚动窗口的持续时间，单位毫秒
            @HystrixProperty(name="metrics.rollingPercentile.timeInMilliseconds",value = "60000"),
            // 该属性用来设置百分位统计滚动窗口的中使用"桶"的数量
            @HystrixProperty(name="metrics.rollingPercentile.numBuckets",value = "10"),
            // 该属性用来设置执行过程中，每个"桶"中保留的最大执行次数，如果在滚动事件窗内发生戳过该设定的执行次数，就从最初的位置开始重写
            //例如，将该值设置为100，滚动窗口为10s,若在10s内，一个桶内发生了500次执行，
            //那么该“桶”中只保留最后的100次执行统计；另外增大该值将会增加内存的消耗，并增加排序百分比数所需的计算时间
            @HystrixProperty(name="metrics.rollingPercentile.bucketSize",value = "100"),
            //该属性用来设置采集影响断路器状态的健康快照（请求的成功，错误百分比）的间隔等待时间
            @HystrixProperty(name="metrics.healthSnapshot.intervalInMilliseconds",value = "500"),
            //是否开启请求缓存
            @HystrixProperty(name="requestCache.enabled",value = "true"),
            //HystrixCommand的执行和事件是否打印到HystrixRequestLog中
            @HystrixProperty(name="requestLog.enabled",value = "true"),
            @HystrixProperty(name="execution.isolation.strategy",value = "THREAD"),
    }, threadPoolProperties = {
            //该参数用来设置执行命令线程池的核心线程数，该值也就是命令执行的最大并发数
            @HystrixProperty(name="coreSize",value="10"),
            // 该参数用来设置线程的最大队列大小，当设置为-1时，线程池将使用SynchronousQueue 实现的队列
            // 否则将使用 LinkedBlockingQueue实现的队列
            @HystrixProperty(name="maxQueueSize",value="-1"),
            @HystrixProperty(name="coreSize",value="10"),
            // 该参数用来为队列设置拒绝阈值，通过该参数，即使队列并没有达到最大值也能拒绝请求
            // 该参数主要是对linkedBlockingQueue 队列的补充，因为LinkedBlockingQueue不能动态修改它的
            // 对象大小，而通过该属性就可以调整拒绝请求的队列大小了
            @HystrixProperty(name="queueSizeRejectionThreshold",value="5")
            }
    )
    public String payCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id不能小于0，请重新输入");
        }
        String serialNo = IdUtil.randomUUID();
        return "支付服务调用成功，订单流水号为："+serialNo;
    }

    public String payCircuitBreakerHandler(@PathVariable("id")Integer id){
        return "订单服务调用失败，请核实数据后重试";
    }

    //*************************************服务熔断   ↑**************************************
}

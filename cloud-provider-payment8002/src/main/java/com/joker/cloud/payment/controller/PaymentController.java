package com.joker.cloud.payment.controller;


import com.joker.cloud.entity.Payment;
import com.joker.cloud.entity.ResultCommon;
import com.joker.cloud.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author joker
 * @since 2020-10-26
 */
@Slf4j
@RestController
@RequestMapping("/payment")
@Api(tags = "支付管理")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("create")
    @ApiOperation("新增支付记录")
    public ResultCommon save(@RequestBody Payment payment){
        paymentService.save(payment);
        log.info("插入数据库成功");
        return new ResultCommon(200,"插入数据库成功,端口为："+port,1);
    }

    @GetMapping("get/{id}")
    @ApiOperation("查询支付记录")
    public ResultCommon<Payment> getPayment(@PathVariable Long id){
        Payment byId = paymentService.getById(id);
        return new ResultCommon<Payment>(200,"查询成功,端口为："+port,byId);
    }



}


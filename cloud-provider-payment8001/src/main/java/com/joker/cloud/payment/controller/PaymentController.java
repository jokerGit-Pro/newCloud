package com.joker.cloud.payment.controller;


import com.joker.cloud.payment.entity.Payment;
import com.joker.cloud.payment.entity.ResultCommon;
import com.joker.cloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("create")
    public ResultCommon save(@RequestBody Payment payment){
        paymentService.save(payment);
        log.info("插入数据库成功");
        return new ResultCommon(200,"插入数据库成功",1);
    }

    @GetMapping("get/{id}")
    public ResultCommon<Payment> getPayment(@PathVariable Long id){
        Payment byId = paymentService.getById(id);
        return new ResultCommon<Payment>(200,"查询成功",byId);
    }

}


package com.joker.cloud.payment.service.impl;

import com.joker.cloud.payment.entity.Payment;
import com.joker.cloud.payment.mapper.PaymentMapper;
import com.joker.cloud.payment.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author joker
 * @since 2020-10-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}

package com.ie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ie.entity.PaymentEntity;
import com.ie.mapper.PaymentMapper;
import com.ie.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ddk
 * @date 2021/10/22
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentEntity> implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public List<PaymentEntity> getPaymentList() {
        LambdaQueryWrapper<PaymentEntity> wrapper = new LambdaQueryWrapper<PaymentEntity>();
        return super.baseMapper.selectList(wrapper);
    }

    @Override
    public Boolean addPayment(PaymentEntity payment) {
        return super.save(payment);
    }

    @Override
    public PaymentEntity findPaymentById(Long id) {
        LambdaQueryWrapper<PaymentEntity> wrapper = new LambdaQueryWrapper<PaymentEntity>()
                .eq(PaymentEntity::getId, id);
        return super.baseMapper.selectOne(wrapper);
    }
}

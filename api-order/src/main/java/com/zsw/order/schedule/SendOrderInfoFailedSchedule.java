package com.zsw.order.schedule;


import com.zsw.common.common.ErrorCode;
import com.zsw.common.constant.RedisConstant;
import com.zsw.common.exception.BusinessException;
import com.zsw.common.model.entity.Order;
import com.zsw.order.utils.OrderMqUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.zsw.common.constant.LockConstant.ORDER_SEND_FAILED;


/**
 * 订单发送失败重试定时任务
 */
@Slf4j
@Component
@EnableAsync
@EnableScheduling
public class SendOrderInfoFailedSchedule {
    @Resource
    RedissonClient redissonClient;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    OrderMqUtils orderMqUtils;

    @Scheduled(cron = "*/60 * * * * ?")
    public void sendOrderInfoFailed(){
        RLock lock = redissonClient.getLock(ORDER_SEND_FAILED);
        try {
            boolean tryLock = lock.tryLock(20, 10, TimeUnit.SECONDS);
            if(tryLock){
                Set keys = redisTemplate.keys(RedisConstant.SEND_ORDER_PREFIX + "*");
                for (Object key : keys) {
                    //重新发送
                    Order order = (Order) redisTemplate.opsForValue().get(key);
                    redisTemplate.delete(key);
                    orderMqUtils.sendOrderSnInfo(order);
                }
            }
        } catch (InterruptedException e) {
            log.error("===定时任务:获取失败生产者发送消息redis出现bug===");
            throw new BusinessException(ErrorCode.OPERATION_ERROR,e.getMessage());
        }finally {
            lock.unlock();
        }

    }
}

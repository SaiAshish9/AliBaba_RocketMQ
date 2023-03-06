package com.sai.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(
        topic = "greetings-topic",
        selectorExpression = " letter = 'm' or letter = 't' " ,
        selectorType = SelectorType.SQL92,
        consumerGroup = "greetings-consumer-group"
)
public class SqlSelectorConsumer implements RocketMQListener<Greeting> {

    @Override
    public void onMessage(Greeting message){
        log.info("greeting : " + message);
    }

}

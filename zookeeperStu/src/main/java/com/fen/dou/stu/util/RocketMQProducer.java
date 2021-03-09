package com.fen.dou.stu.util;


import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by 落叶 on 2019/10/26.
 */
public enum RocketMQProducer {
  INSTANCE;

  private Producer producer;

  RocketMQProducer() {
    producer = new Producer();
  }

  public Producer getInstance(){
    return producer;
  }

  public class Producer{
    private DefaultMQProducer defaultMQProducer;

    public void init(String nameServer,String producerGroup) throws MQClientException {
      defaultMQProducer = new DefaultMQProducer();
      defaultMQProducer.setNamesrvAddr(nameServer);
      defaultMQProducer.setProducerGroup(producerGroup);
      defaultMQProducer.start();
    }

    public SendResult sendMessage(String topic, MessageRequest messageRequest) throws Exception {
      Message msg = new Message(topic,messageRequest.getJSON().getBytes(StandardCharsets.UTF_8));
      return defaultMQProducer.send(msg);
    }

    public SendResult sendOrderedMessage(String topic,MessageRequest messageRequest) throws Exception{
      Message msg = new Message(topic,messageRequest.getJSON().getBytes(StandardCharsets.UTF_8));
      return defaultMQProducer.send(msg, new MessageQueueSelector() {
        @Override
        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
          Integer qid = (Integer) arg;
          return mqs.get(qid);
        }
      },1);
    }

    public void close(){
      if(defaultMQProducer != null){
        defaultMQProducer.shutdown();
      }
    }
  }
}

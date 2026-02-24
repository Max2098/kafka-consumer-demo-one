package org.one.demo.consumer.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.one.demo.consumer.kafka.data.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaListenerExample {

    @KafkaListener(topics = "user-topic", groupId = "user-group",
            containerFactory = "userKafkaListenerContainerFactory")
    void listenerWithMessageConverter(User user) {
        log.info("Received message through MessageConverterUserListener [{}]", user);
    }

//    @KafkaListener(topics = "topic-1,topic-2", groupId = "group1")
//    void listener(@Payload String data,
//                  @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
//                  @Header(KafkaHeaders.OFFSET) int offset) {
//        log.info("Received message [{}] from group1, partition-{} with offset-{}",
//                data,
//                partition,
//                offset);
//    }

//    @KafkaListener(
//            groupId = "group2",
//            topicPartitions = @TopicPartition(topic = "topic-2",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0"),
//                            @PartitionOffset(partition = "3", initialOffset = "0")}))
//    public void listenToPartition(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
//        log.info("Received Message [{}] from partition-{}",
//                message,
//                partition);
//    }
}
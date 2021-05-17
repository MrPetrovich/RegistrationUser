package dev.redlab.verificator.jms;

import dev.redlab.verificator.models.ValidationStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaConsumer {

    private final KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "verification", groupId = "group_id")
    public void consume(@Header(value = KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Payload String json) {
        if(Integer.valueOf(key) < 10) {
            kafkaProducerService.sendMessage(key, ValidationStatus.GOOD.name());
        }else{
            kafkaProducerService.sendMessage(key, ValidationStatus.BAD.name());
        }
    }
}

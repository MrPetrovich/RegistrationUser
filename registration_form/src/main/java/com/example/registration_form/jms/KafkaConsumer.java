package com.example.registration_form.jms;

import com.example.registration_form.exception.UserInfoException;
import com.example.registration_form.service.MailService;
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

    private final MailService mailService;

    @KafkaListener(topics = "done", groupId = "group_id")
    public void consume(@Header(value = KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Payload String response) throws UserInfoException {
        if(!key.isEmpty() && !key.isBlank()) {
            mailService.prepareAndSendEmail(key, response);
        }else{
            log.error("Key is empty");
        }
    }
}

package com.example.registration_form.jms;

public interface KafkaProducer {

    void sendMessage(Integer id, String json);
}

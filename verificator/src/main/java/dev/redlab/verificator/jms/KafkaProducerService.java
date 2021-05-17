package dev.redlab.verificator.jms;

public interface KafkaProducerService {

    void sendMessage(String id, String response);
}

package at.fhtw.swkom.paperless.services.comm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    public void sendMessage(Object message) {
        log.info("Sending {}} to exchange {} with routing key {}", message, exchangeName, routingKey);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}

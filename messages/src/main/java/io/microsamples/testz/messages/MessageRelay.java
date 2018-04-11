package io.microsamples.testz.messages;

import org.springframework.integration.annotation.Publisher;
import org.springframework.stereotype.Component;

@Component
public class MessageRelay {

    @Publisher(channel = "banks")
    public String notifyShipments(String message) {
        return message;
    }

    @Publisher(channel = "creditors")
    public String notifyPayments(String message) {
        return message;

    }

    @Publisher(channel = "family")
    public String notifyCommunication(String message) {
        return message;
    }
}

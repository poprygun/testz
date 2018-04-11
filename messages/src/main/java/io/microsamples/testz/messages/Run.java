package io.microsamples.testz.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(Channels.class)
public class Run {
    
    @Autowired
    private MessageRelay messageRelay;

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

    @StreamListener("bancrapcyNotification")
    public void handleEvent(String message) {
        messageRelay.notifyShipments(message);
        messageRelay.notifyPayments(message);
        messageRelay.notifyCommunication(message);
    }

}

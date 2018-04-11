package io.microsamples.testz.messages;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    @Input("bancrapcyNotification")
    SubscribableChannel bancrapcyNotification();

    @Output("creditors")
    MessageChannel creditors();

    @Output("banks")
    MessageChannel banks();

    @Output("family")
    MessageChannel family();
}

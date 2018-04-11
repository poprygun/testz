package io.microsamples.testz.messages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ChannelsProcessorTests {

    @Autowired
    Channels channels;

    @Autowired
    MessageCollector messageCollector;

    BlockingQueue payments;
    BlockingQueue shipments;
    BlockingQueue communication;

    @Before
    public void setUp(){
        payments = messageCollector.forChannel(channels.creditors());
        shipments = messageCollector.forChannel(channels.banks());
        communication = messageCollector.forChannel(channels.family());
    }

    @Test
    public void shouldEmitToAllChannels(){
        String incomingMessage = "IncomingMessage";
        channels.bancrapcyNotification().send(new GenericMessage<>(incomingMessage));

        BlockingQueue[] queues = {payments, shipments, communication};

        for (BlockingQueue queue : queues) {
            GenericMessage<String> poll = (GenericMessage<String>) queue.poll();
            assertThat(poll.getPayload(), is(incomingMessage));
        }

    }

}

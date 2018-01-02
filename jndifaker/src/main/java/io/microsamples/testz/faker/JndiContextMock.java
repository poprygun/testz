package io.microsamples.testz.faker;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

import javax.naming.NamingException;

@Slf4j
@Configuration
public class JndiContextMock {

    public void init() {
        try {
            SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
            builder.bind( "jdbc/mydb" , new ImaginaryDataSource() );
            builder.bind("jms/myConnectionFacory", new RMQConnectionFactory());
            builder.activate();
        } catch (NamingException e) {
            String message = "Error activating DataSource";
            log.error(message);
            throw new RuntimeException(message);
        }
    }
}

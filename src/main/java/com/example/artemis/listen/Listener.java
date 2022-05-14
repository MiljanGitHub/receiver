package com.example.artemis.listen;

import com.example.artemis.config.JmsConfig;
import com.example.artemis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Component
@EnableJms
public class Listener {

    @Autowired
    private JmsTemplate jmsTemplate;

//    just testing, didn't help
//    @Autowired
//    private Queue queue;

    @JmsListener(destination = JmsConfig.QUEUE)
    public void listen(Student student){
        System.out.println(student);
    }

    //just testing, didn't help
    public void setConnectionFactory(ConnectionFactory cf) {
        this.jmsTemplate = new JmsTemplate(cf);
    }

    //just testing, didn't help
   /*
   public void setQueue(Queue queue) {
        this.queue = queue;
    } */


   /* @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        //factory.setConnectionFactory(connectionFactory());
        //factory.setDestinationResolver(destinationResolver());
        factory.setSessionTransacted(true);
        factory.setConcurrency("3-10");
        return factory;
    }*/
}

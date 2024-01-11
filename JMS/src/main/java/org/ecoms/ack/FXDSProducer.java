package org.ecoms.ack;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class FXDSProducer {
    public static void main(String[] args) throws NamingException {
        InitialContext initialContext = new InitialContext();
        Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");
        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext(JMSContext.CLIENT_ACKNOWLEDGE)) {
            // JMSContext jmsContext = cf.createContext(JMSContext.AUTO_ACKNOWLEDGE)
            JMSProducer producer = jmsContext.createProducer();
            producer.send(requestQueue, "Message 1");

        }


    }
}

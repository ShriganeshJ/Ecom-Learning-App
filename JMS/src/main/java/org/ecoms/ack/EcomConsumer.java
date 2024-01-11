package org.ecoms.ack;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EcomConsumer {
    public static void main(String[] args) throws NamingException {
        InitialContext initialContext = new InitialContext();
        javax.jms.Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");
        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {

            JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
           TextMessage textMessage =(TextMessage) consumer.receive();
            System.out.println("Message:: "+textMessage.getText());
            //client acknowledgment
            textMessage.acknowledge();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}

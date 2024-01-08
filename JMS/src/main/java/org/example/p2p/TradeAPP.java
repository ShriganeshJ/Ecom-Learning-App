package org.example.p2p;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.example.p2p.model.Patient;
import org.example.p2p.model.StaticDataContractService;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TradeAPP {

/**
 * Tread APP base on k1 Number
 * Get Entitlement and UserInfo
 *
 */
    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext initialContext = new InitialContext();
        Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");
        Queue replyQueue = (Queue) initialContext.lookup("queue/replyQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSProducer producer = jmsContext.createProducer();
            System.out.println("Send k1 Number");
            String k1Number="k11254";
            producer.send(requestQueue,k1Number);

            JMSConsumer consumer = jmsContext.createConsumer(replyQueue);
            MapMessage replyMessage = (MapMessage) consumer.receive(30000);
            System.out.println("Patient eligibility is:" + replyMessage.getObject("Key"));
        }
    }
}

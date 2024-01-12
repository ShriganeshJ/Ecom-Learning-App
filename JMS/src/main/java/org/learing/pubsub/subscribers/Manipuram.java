package org.learing.pubsub.subscribers;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.learing.pubsub.pojo.GoldRate;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Manipuram {
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext initialContext = new InitialContext();
        Topic topic = (Topic) initialContext.lookup("topic/goldRateTopic");


        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSConsumer consumer = jmsContext.createConsumer(topic);
            Message message = consumer.receive();
            GoldRate goldRate = (GoldRate) message.getBody(GoldRate.class);

            System.out.println("Manipuram Jewellers Todays rate ");
            System.out.println("24k Global "+goldRate.getGloabalGOld24Krates());
            System.out.println("22k Global "+goldRate.getGloablGold22Krates());
            System.out.println("24k localGold "+goldRate.getLocalGold24Krates());
            System.out.println("22k localGold "+goldRate.getLocalGold22KRates());

        }
    }
}

package org.example.pubsub.subscribers;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.example.pubsub.pojo.GoldRate;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Kalyan {
    public static void main(String[] args) throws NamingException, JMSException,InterruptedException {
        InitialContext initialContext = new InitialContext();
        Topic topic = (Topic) initialContext.lookup("topic/goldRateTopic");


        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            //durable subscriber
            jmsContext.setClientID("KalyanJewellers");
            JMSConsumer consumer = jmsContext.createDurableConsumer(topic,"KalyanSubscription");
            consumer.close();
            System.out.println("KalyanJewellers offline");
            Thread.sleep(10000);
            System.out.println("KalyanJewellers is online");
            consumer = jmsContext.createDurableConsumer(topic,"KalyanSubscription");

            Message message = consumer.receive();
            GoldRate goldRate = (GoldRate) message.getBody(GoldRate.class);

            System.out.println("Kalyan Jewellers Todays rate ");
            System.out.println("24k Global "+goldRate.getGloabalGOld24Krates());
            System.out.println("22k Global "+goldRate.getGloablGold22Krates());
            System.out.println("24k localGold "+goldRate.getLocalGold24Krates());
            System.out.println("22k localGold "+goldRate.getLocalGold22KRates());

            //To unsubscribe
            consumer.close();
            jmsContext.unsubscribe("KalyanSubscription");

        }
    }
}

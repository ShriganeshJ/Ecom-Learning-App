package org.ecoms.pubsub.subscribers;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.ecoms.pubsub.pojo.GoldRate;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Muthooth {
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext initialContext = new InitialContext();
        Topic topic = (Topic) initialContext.lookup("topic/goldRateTopic");


        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSConsumer consumer = jmsContext.createConsumer(topic);
            Message message = consumer.receive();
            GoldRate goldRate = (GoldRate) message.getBody(GoldRate.class);

            System.out.println("Muthooth Jewellers Todays rate ");
            System.out.println("24k Global "+goldRate.getGloabalGOld24Krates());
            System.out.println("22k Global "+goldRate.getGloablGold22Krates());
            System.out.println("24k localGold "+goldRate.getLocalGold24Krates());
            System.out.println("22k localGold "+goldRate.getLocalGold22KRates());


            //for shared consumer
            System.out.println("for shred consumer");
            JMSConsumer consumer1 = jmsContext.createSharedConsumer(topic, "sharedConsumer");
            JMSConsumer consumer2 = jmsContext.createSharedConsumer(topic, "sharedConsumer");
            for (int i = 1; i <= 10; i += 2) {
                Message message1 = consumer1.receive();
                GoldRate goldRate1 = (GoldRate) message1.getBody(GoldRate.class);
                System.out.println("Consumer 1: " + goldRate1.getLocalGold24Krates());

                Message message2 = consumer2.receive();
                GoldRate goldRate2 = (GoldRate) message2.getBody(GoldRate.class);
                System.out.println("Consumer 2: " + goldRate2.getLocalGold24Krates());

            }
            }

        }
    }


package org.example.pubsub;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.example.pubsub.pojo.GoldRate;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GoldRateAPI {

    public static void main(String[] args) throws NamingException {
        InitialContext initialContext = new InitialContext();
        Topic topic = (Topic) initialContext.lookup("topic/goldRateTopic");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {

            GoldRate goldRate = new GoldRate();
            goldRate.setLocalGold22KRates(52000.00);
            goldRate.setLocalGold24Krates(58000.00);
            goldRate.setGloablGold22Krates(45000.00);
            goldRate.setGloabalGOld24Krates(48000.00);
               jmsContext.createProducer().send(topic,goldRate);

            System.out.println("Messge Send");

            //for shared consumer
            Thread.sleep(10000);
            JMSContext jmsContext2 = cf.createContext();
            GoldRate goldRate2 = new GoldRate();
            goldRate2.setLocalGold24Krates(58000.00);

            for(int i=0;i<10;i++)
            {
                jmsContext2.createProducer().send(topic,goldRate2);

            }
            System.out.println("Messge Send for shared consumers");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    }


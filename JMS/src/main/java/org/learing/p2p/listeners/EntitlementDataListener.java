package org.learing.p2p.listeners;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class EntitlementDataListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
         System.out.println("In On Message");

        try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
			JMSContext jmsContext = cf.createContext()) {
			String msg=  message.getBody(String.class);
            InitialContext initialContext = new InitialContext();
            Queue replyQueue = (Queue) initialContext.lookup("queue/replyQueue");
			String k1Number=msg;
            System.out.println("K1 Number in listener: "+msg);
			MapMessage mapMessage =jmsContext.createMapMessage();
			if(k1Number.equalsIgnoreCase("k11254"))
			{
				mapMessage.setObject("Key","Object Found k11254");

			}
			else
			{
				mapMessage.setObject("Key","Object Not Found ");
			}
			JMSProducer producer = jmsContext.createProducer();
			System.out.println("Set message and Sedn to replyQueue"+mapMessage.getObject("Key"));
			producer.send(replyQueue, mapMessage);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

}

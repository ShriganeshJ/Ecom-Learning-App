package org.example.p2p.listeners;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.example.p2p.model.StaticDataContractService;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.io.Serializable;

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
			ObjectMessage replayMessage =jmsContext.createObjectMessage();
			if(k1Number.equalsIgnoreCase("k11254"))
			{
				replayMessage.setObject((Serializable) StaticDataContractService.newBuilder().build());
			}
			else
			{
				replayMessage.setObject("K1 Not Found");
			}
			JMSProducer producer = jmsContext.createProducer();
			producer.send(replyQueue, replayMessage);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

}

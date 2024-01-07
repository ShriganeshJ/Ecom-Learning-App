package org.example.basic;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// JMS Priority is 0-9 and 9 is  high priority;
// 4 is default priority

public class MessagePriority {

	public static void main(String[] args) throws NamingException {
		InitialContext context = new InitialContext();
		Queue queue = (Queue) context.lookup("queue/myQueue");
		
		try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()){
			JMSProducer producer = jmsContext.createProducer();
			
			String[] messages = new String[3];
			messages[0] = "Message One";
			messages[1] = "Message Two";
			messages[2] = "Message Three";
			
			producer.setPriority(3);
			producer.send(queue, messages[0]);
			
			producer.setPriority(4);
			producer.send(queue, messages[1]);
			
			producer.setPriority(9) ;
			producer.send(queue, messages[2]);
			
			JMSConsumer consumer = jmsContext.createConsumer(queue);
			
			for(int i=0;i<3;i++) {
				Message receivedMessage = consumer.receive();
				System.out.println(consumer.receiveBody(String.class));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

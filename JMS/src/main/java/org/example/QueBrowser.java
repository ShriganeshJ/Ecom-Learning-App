package org.example;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;


//Queue Browser :: A client uses a QueueBrowser object to look at messages on a queue without removing them.
//Message is deleted from queue only when consumer consume message
public class QueBrowser {

	public static void main(String[] args) {

		InitialContext initialContext = null;
		Connection connection = null;

		try {
			initialContext = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
			 connection = cf.createConnection();
			Session session = connection.createSession();
			Queue queue = (Queue) initialContext.lookup("queue/myQueue");
			MessageProducer producer = session.createProducer(queue);
			TextMessage message = session.createTextMessage("Ecom/sdvs/currency");
			TextMessage message2 = session.createTextMessage("Ecom/sdvs/branch");
			producer.send(message);producer.send(message2);

			QueueBrowser queueBrowser = session.createBrowser(queue);
			var queueE=queueBrowser.getEnumeration();

			 while (queueE.hasMoreElements()) {
				 TextMessage textMessage = (TextMessage) queueE.nextElement();
				 System.out.println("Message Sent Queue:" + textMessage.getText());
			 }

			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();
			TextMessage messageReceived = (TextMessage) consumer.receive(5000);
			System.out.println("Message Received: " + messageReceived.getText());
			TextMessage messageReceived2 = (TextMessage) consumer.receive(5000);
			System.out.println("Message Received: " + messageReceived2.getText());

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			if(initialContext!=null) {
				try {
					initialContext.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			
			if(connection!=null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

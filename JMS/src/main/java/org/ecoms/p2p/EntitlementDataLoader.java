package org.ecoms.p2p;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.ecoms.p2p.listeners.EntitlementDataListener;



public class EntitlementDataLoader {

	public static void main(String[] args) throws NamingException, InterruptedException {

		InitialContext initialContext = new InitialContext();
		Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");


		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
			 JMSContext jmsContext = cf.createContext()) {

			JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
			consumer.setMessageListener(new EntitlementDataListener());
			Thread.sleep(30000);


		};

	}

}

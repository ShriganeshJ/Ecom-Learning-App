package org.ecoms.jsm2;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsContext_JMS_v2 {
    public static void main(String[] args) throws NamingException {
        // When the initial context is constructed, its environment is
        // initialized with properties defined in the environment parameter passed to the constructor
        InitialContext initialContext = new InitialContext();
        //lookup the queue
        Queue queue = (Queue) initialContext.lookup("queue/myQueue");
        //try with resources
        try(ActiveMQConnectionFactory factory =new ActiveMQConnectionFactory())
        {
            //This is introduced in JMS 2.0
            //
            JMSContext context = factory.createContext();
            //sender
            context.createProducer().send(queue,"ECOM-Learning-Text-Message");
            //receiver
            String messageReceiver = context.createConsumer(queue).receiveBody(String.class);
            System.out.println("Message is :: "+messageReceiver);



        }
    }
}

package org.learing.grouping;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageGrouping {
    private static InitialContext initialContext = null;
    private static ConnectionFactory connectionFactory = null;
    private static JMSContext jmsContext = null;
    private static Queue requestQueue = null;
    private static JMSConsumer consumer = null;
    private static JMSProducer producer = null;

    public static void main(String[] args) {

        try {
            initialContext = new InitialContext();
            requestQueue = (Queue) initialContext.lookup("queue/requestQueue");
            connectionFactory = new ActiveMQConnectionFactory();
            jmsContext = connectionFactory.createContext(JMSContext.SESSION_TRANSACTED);

          //  createProducer(jmsContext);


        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (initialContext != null) {
                try {
                    initialContext.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }

            if (jmsContext != null) {
                jmsContext.close();
            }

        }
    }

    private static void createProducer(JMSContext jmsContext) throws JMSException {

      jmsContext.createProducer();
      int count=10;
      TextMessage[] messages = new TextMessage[count];
      for(int i=0;i<count;i++)
      {
          messages[i]=jmsContext.createTextMessage("Group-0 message"+i);
          messages[i].setStringProperty("JMSXGroupID","Group-0");
          producer.send(requestQueue,messages[i]);
      }
    }
}


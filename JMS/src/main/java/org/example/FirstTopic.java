package org.example;

import javax.jms.*;
import javax.naming.InitialContext;
//One To Many-Topic
public class FirstTopic {
    public static void main(String[] args) throws Exception {
        InitialContext initialContext = null;

        //Initial context create env
        initialContext= new InitialContext();
        //Get connection from factory
        ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
        Connection connection=  cf.createConnection();
        //Create Session
        Session session = connection.createSession();
        //Create Topic
        Topic topic = (Topic) initialContext.lookup("topic/myTopic");
        //create producer using topic
        MessageProducer producer = session.createProducer(topic);

        /************** Consumer ***************************/

        //create Consumer1
        MessageConsumer consumer1 = session.createConsumer(topic);
        //create Consumer2
        MessageConsumer consumer2 = session.createConsumer(topic);
        //create Consumer3
        MessageConsumer consumer3 = session.createConsumer(topic);

        //Produce Message
        TextMessage message = session.createTextMessage("I am topic Pub-sub");
        producer.send(message);
        System.out.println("Message Sent: " + message.getText());
        //start connection
        connection.start();




        //Receive Message
        TextMessage messageReceived1 = (TextMessage) consumer1.receive(5000);
        System.out.println("Message Received consumer 1: " + messageReceived1.getText());

        TextMessage messageReceived2 = (TextMessage) consumer2.receive(5000);
        System.out.println("Message Received consumer 2: " + messageReceived2.getText());

        TextMessage messageReceived3 = (TextMessage) consumer3.receive(5000);
        System.out.println("Message Received consumer 3: " + messageReceived3.getText());

        connection.close();
        initialContext.close();


    }
}

package org.ecoms.filters;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.ecoms.filters.model.Claim;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClaimManagment {
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext initialContext = new InitialContext();
        Queue requestQueue = (Queue) initialContext.lookup("queue/claimQueue");

        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext()) {
            JMSProducer jmsProducer = jmsContext.createProducer();
            //apply selector
            String selector1 ="hospitalId=10 AND docName=TRUE ";
            String selector2 ="claimAmount BETWEEN 10000 AND 50000";
            String selector3 ="doctorName LIKE 'J%'";
            /**
             * Using JMS HEADER
             * use JMS Header-> JMSPriority
             */
            String selector4 ="doctorType IN ('neuro','psych') OR JMSPriority BETWEEN 5 AND 9";

            JMSConsumer consumer = jmsContext.createConsumer(requestQueue,selector3);
            ObjectMessage  objectMessage= jmsContext.createObjectMessage();
            //set Id for object
            objectMessage.setIntProperty("hospitalId", 10);
            objectMessage.setBooleanProperty("docName",true);
            objectMessage.setStringProperty("doctorName","John");
            objectMessage.setDoubleProperty("claimAmount",10000);
            objectMessage.setStringProperty("doctorType", "gyna");
            Claim claim = new Claim();
            claim.setHospitalId(14785);
            claim.setClaimAmount(10000);
            claim.setDoctorName("John");
            claim.setDoctorType("gyna");
            claim.setInsuranceProvider("blue cross");
            objectMessage.setObject(claim);
            jmsProducer.send(requestQueue, objectMessage);
            //consumer
            Claim receiveBody = consumer.receiveBody(Claim.class);
            //System.out.println("Selector 1 Message are::"+"Claim Amount "+receiveBody.getClaimAmount()+" DocName "+receiveBody.getDoctorName());
            //System.out.println("Selector 2 Message are::"+"Claim Amount "+receiveBody.getClaimAmount()+" DocName "+receiveBody.getDoctorName());
            //System.out.println("Selector 3 Message are::"+"Claim Amount "+receiveBody.getClaimAmount()+" DocName "+receiveBody.getDoctorName());
            System.out.println("Selector 4 Message are::"+"Claim Amount "+receiveBody.getClaimAmount()+" DocName "+receiveBody.getDoctorName());
        }
    }
}
package PubSub.ACKNOWLEDGE;

import Models.Article;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.util.Date;

public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory= new ConnectionFactory();
        //требует явного подтверждения - acknowledge() из приемника
        try(JMSContext context = factory.createContext("admin", "admin", JMSContext.CLIENT_ACKNOWLEDGE)){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination priceInfo  = context.createTopic("PubSub");


            for (int i=0; i<5; i++) {
                Article message = new Article("Message", new Date());
                ObjectMessage objMsg = context.createObjectMessage(message);
                context.createProducer().send(priceInfo, objMsg);
                Thread.sleep(1000);
                System.out.println("Message №" + (i+1));
            }
        } catch (JMSException | InterruptedException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
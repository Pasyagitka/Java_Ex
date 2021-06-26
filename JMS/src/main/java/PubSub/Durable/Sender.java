package PubSub.Durable;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import java.util.Random;

public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory= new ConnectionFactory();
        try(JMSContext context = factory.createContext("admin", "admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination priceInfo  = context.createTopic("PubSub");
            while (true) {
                context.createProducer().send(priceInfo, "durability message");
                Thread.sleep(5000);
            }
        } catch (JMSException | InterruptedException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
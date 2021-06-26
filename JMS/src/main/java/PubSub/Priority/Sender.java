package PubSub.Priority;

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
                int priority = new Random().nextInt(8) + 1;
                System.out.println("Send message with priority " + priority);
                //устанавливаем от 1 до 8 рандомно приориет сообщению
                context.createProducer().setPriority(priority).send(priceInfo, "message with priority " + priority);
                Thread.sleep(1000);
            }
        } catch (JMSException | InterruptedException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
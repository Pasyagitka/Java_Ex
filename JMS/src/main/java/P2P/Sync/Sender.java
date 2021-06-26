package P2P.Sync;

import Models.Article;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;
import java.util.Date;

public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory= new ConnectionFactory();

        try(JMSContext context = factory.createContext("admin", "admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination messagesQueue = context.createQueue("P2PSyncQueue");
            Article message = new Article("Sync message", new Date());
            ObjectMessage objMsg = context.createObjectMessage(message);

            JMSProducer producer = context.createProducer();
            producer.send(messagesQueue, objMsg);
            System.out.println("Async message send");

        } catch (JMSException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
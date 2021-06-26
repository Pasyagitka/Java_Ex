package PubSub.Filter;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Random;

public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory= new ConnectionFactory();
        try(JMSContext context = factory.createContext("admin", "admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            TextMessage outMsg = context.createTextMessage();
            //посылаем рандомное число от 1 до 3
            int number = new Random().nextInt(3);
            outMsg.setText("send number " + number);
            outMsg.setIntProperty("symbol", number);

            Destination priceInfo  = context.createTopic("PubSub");
            context.createProducer().send(priceInfo, outMsg);
            System.out.println("Send message:" + outMsg);
        } catch (JMSException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
package PubSub.Filter;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Sender {
    public static void main(String[] args){
        ConnectionFactory factory= new ConnectionFactory();

        try(JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination destination  = context.createTopic("Ekz");

            ArrayList<String> messages = new ArrayList<String>();
            messages.add("AAA");
            messages.add("Ma");
            messages.add("Ooo");

            for (int i=0; i < 5; i++) {
                TextMessage outMsg = context.createTextMessage();
                int number = new Random().nextInt(3);
                String forSend = messages.get(number);
                outMsg.setText("Сообщение " + forSend);
                outMsg.setStringProperty("New", forSend);

                context.createProducer().send(destination, outMsg);
                System.out.println("Отправлено сообщение:" + outMsg);
            }

        } catch (JMSException e) {
            System.out.println("ConnectionConfigurationError: " + e.getMessage());
        }
    }
}
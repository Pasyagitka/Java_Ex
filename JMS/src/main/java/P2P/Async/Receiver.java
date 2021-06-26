package P2P.Async;

import javax.jms.*;

import Models.Article;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

public class Receiver implements MessageListener {
    private ConnectionFactory factory = new ConnectionFactory();
    private JMSConsumer consumer;

    Receiver() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676, mq://127.0.0.1:7676");
            Destination messageQueue = context.createQueue("P2PAsyncQueue");

            consumer = context.createConsumer(messageQueue);
            consumer.setMessageListener(this); //устанавливаем какой объект будет прослушивать
            System.out.println("Listening to P2PAsyncQueue...");
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException | JMSException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onMessage(javax.jms.Message message) {
        try {
            System.out.println("Received async message: "+ message.getBody(Article.class));
            System.out.println( message);

        } catch (Exception e) {
            System.err.println("JMSException: " + e.toString());
        }
    }

    public static void main (String[] args){
        new Receiver();
    }
}
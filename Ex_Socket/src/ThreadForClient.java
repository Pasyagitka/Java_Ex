import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadForClient implements Runnable {
    private static Socket clientSocket;
    private int numberOfYes; //todo static
    private int numberOfNo;

    public ThreadForClient(Socket client) {
        ThreadForClient.clientSocket = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            while (!clientSocket.isClosed()) {
                String entry = in.readUTF();
                switch (entry) {
                    case "/yes":
                        numberOfYes++;
                        out.writeUTF("Вызвана команда yes");
                        break;
                    case "/no":
                        numberOfNo++;
                        out.writeUTF("Вызвана команда no");
                        break;
                    case "/getall":
                        out.writeUTF("Количество команд 'yes' - " + numberOfYes + " количество команд 'no' - " + numberOfNo);
                        break;
                    case "/help":
                        out.writeUTF("/yes, /no, /help, /getall - количество /yes и /no");
                        break;
                    default:
                        out.writeUTF("Неизвестная команда");
                        break;
                }
                out.flush();
            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


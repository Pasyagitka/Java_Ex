import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 3345);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()) )
        {
            System.out.println("Client connected to socket.");
            while(!socket.isOutputShutdown()){
                if(br.ready()){
                    String clientCommand = br.readLine();

                    if(clientCommand.equalsIgnoreCase("exit")){
                        break;
                    }

                    dataOutputStream.writeUTF(clientCommand);
                    dataOutputStream.flush();

                    Thread.sleep(200); //сервер может не успеть ответить иначе
                    String in = dataInputStream.readUTF();
                    System.out.println(in);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
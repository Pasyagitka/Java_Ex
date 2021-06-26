import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    //альтернатива классу Thread
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3345)) {
            while (!server.isClosed()) {
                Socket client = server.accept(); //зависает пока не придет клиент
                ThreadForClient monoThreadClientHandler = new ThreadForClient(client);
                executorService.submit(monoThreadClientHandler); //ставит задачу в очередь на выполнение, завершение выполнения задачи
                System.out.println("Клиент подключился");
            }
            executorService.shutdown(); //упорядоченное завершение работы, при котором ранее отправленные задачи выполняются,
            // а новые задачи не принимаются
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

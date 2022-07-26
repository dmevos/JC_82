import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        System.out.println("Запустили сервер");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // ждем подключения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.printf("Принято новое соединенение. Порт: %d%n", clientSocket.getPort());

                out.println("Привет, как тебя зовут?");
                String name = in.readLine();
                String child = "1";
                String plus = "";
                while (!(child.equals("да") || child.equals("нет"))) {
                    out.println(plus + name +", тебе есть 10 лет? (да/нет)");
                    child = in.readLine();
                    if (child.equals("нет")) {
                        out.println("Добро пожаловать в детскую зону!");
                    } else if (child.equals("да")) {
                        out.println("Добро пожаловать в зону для взрослых!");
                    } else {
                        plus= "Я так и не понял, сколько же тебе лет. ";
                    }
                }
            }
        }
    }
}
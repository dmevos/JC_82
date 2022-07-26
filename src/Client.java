import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8081;
        Scanner scanner = new Scanner(System.in);
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String resp = "1";
            while (!resp.contains("Добро пожаловать")) {
                resp = in.readLine();
                System.out.println(resp);
                if (!resp.contains("Добро пожаловать")) {
                    out.println(scanner.nextLine());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

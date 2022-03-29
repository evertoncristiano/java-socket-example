import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket socketServer = null;

        try {
            socketServer = new ServerSocket(5050);
            socket = socketServer.accept();

            DataInputStream received = new DataInputStream(socket.getInputStream());
            DataOutputStream sent = new DataOutputStream(socket.getOutputStream());

            System.out.println("(clente): " + received.readUTF());
            sent.writeUTF("O Servidor recebeu sua mensagem");
        } catch (IOException ex) {
            System.err.println("Failed to connect");
        } finally {
            try {
                socket.close();
                socketServer.close();
            } catch (IOException e) {
                System.err.println("Failed to close connection");
            }
        }
    }
}
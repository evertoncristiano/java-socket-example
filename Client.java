import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("127.0.0.1", 5050);

            DataInputStream received = new DataInputStream(socket.getInputStream());
            DataOutputStream sent = new DataOutputStream(socket.getOutputStream());

            sent.writeUTF("Aqui e um cliente falando");
            System.out.println("(servidor): " + received.readUTF());
        } catch (IOException ex) {
            System.err.println("Failed to connect");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Failed to close connection");
            }
        }
    }
}
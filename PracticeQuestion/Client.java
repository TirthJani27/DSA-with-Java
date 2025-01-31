import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws Exception{
        Socket s =new Socket();
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("Hello Server");
        dos.flush();
        dos.close();
        s.close();
    }
}
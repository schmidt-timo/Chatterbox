/*
    @author: Timo Schmidt, Chung-Fan Tsai
    @version: 2019.10.20
 */

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        try {
            int port = 8000;
            Socket s = new Socket("localhost", port);
            System.out.println("Client is connected to port " + port + " ...");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String incoming = "";
            String outgoing = "";

            while (!incoming.equals("quit")) {

                System.out.print("> ");

                incoming = br.readLine();
                dos.writeUTF(incoming);
                dos.flush();

                outgoing = dis.readUTF();
                System.out.println("Server: " + outgoing);

            }

            dos.close();
            s.close();

        }

        catch (IOException e) {
            System.out.println("IOException"); // handle exception
            e.printStackTrace();
        }
    }

}

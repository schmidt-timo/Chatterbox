/*
    @author: Timo Schmidt, Chung-Fan Tsai
    @version: 2019.10.20
 */

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        try {
            int port = 8000;
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server is connected to port " + port + " ...");

            Socket s = ss.accept(); // establish connection

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String incoming = "";
            String outgoing = "";

            while (!incoming.equals("quit")) {

                incoming = dis.readUTF();
                System.out.println("Client: " + incoming);

                System.out.print("> ");

                outgoing = br.readLine();
                dos.writeUTF(outgoing);
                dos.flush();

            }

            dis.close();
            s.close();
            ss.close();

        }

        catch (IOException e) {
            System.out.println("IOException"); // handle exception
            e.printStackTrace();
        }

    }

}

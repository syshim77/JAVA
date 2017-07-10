package Lec14;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ServerBackground {
    private ServerSocket serverSocket; // server socket
    private Socket socket; // save the received socket
    private ServerGUI gui;
    private String msg;
    private DataInputStream in; // data input stream
    private DataOutputStream out; // data output stream
    private String nick;
    private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
    /**    
    private final static String FILE_TO_SEND = "D:\\AIlab\\2017 Spring\\JavaCourse\\work\\messenger\\src\\FT\\1.png";
    private FileInputStream fis = null;
    private BufferedInputStream bis = null;
    private OutputStream os = null; 
    */
    public void setGui(ServerGUI gui) {
        this.gui = gui;
    }

    public static void main(String[] args) {
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
    }

    public void setting(){
        try{// Set up server and process connections
            //Collections.synchronizedMap(clientMap); For multi-client purpose
            // Create server socket
            serverSocket = new ServerSocket(7777);
            
            // Accept connections
            while(true){
                System.out.println("waiting.....");
                socket = serverSocket.accept(); 
                System.out.println("Connected from " + socket.getInetAddress() + ".");
                
                // Create input stream attached to socket
                in = new DataInputStream(socket.getInputStream());
                // Create output stream attached to socket
                out = new DataOutputStream(socket.getOutputStream());
                // process messages sent from client
                while(true){
                    msg = in.readUTF(); 
                    gui.appendMsg(msg);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            // close all connection and release resource
            try {
                in.close();
                out.close();
                serverSocket.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
    public void sendFile(Socket socket) throws IOException {
        // TO DO : Using socket, send file to client
    }

    public void addClient(String nick, DataOutputStream out) throws IOException {
        // TO DO : add client using HashMap 
    }

    public void removeClient(String nick) {
        // TO DO : remove client
    }
    
    public void sendMessage (String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageMap (String msg){
        Iterator<String> iterator = clientMap.keySet().iterator(); // Set keySet as iterator
        String key = "";

        while(iterator.hasNext()){
            key = iterator.next();// get key value from iterator
            try{
                clientMap.get(key).writeUTF(msg);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    class Receiver extends Thread {

        public Receiver(Socket socket) {
            try {
                nick = in.readUTF();
                addClient(nick, out);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (in != null) {
                // TO DO : process messages sent from client
                }
            } catch (Exception e) {
                // TO DO : remove client
            }
        }
    }
}
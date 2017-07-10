package Lec14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;
 
public class ClientBackground {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ClientGUI gui;
    private String msg;
    private String nickName ;    
    
    public void setGui(ClientGUI gui) {
        this.gui = gui;
    }    

    public static void main(String[] args) {
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connect();
    }
    
    public void connect(){
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                     // create socket to make connection to server
                    socket = new Socket("127.0.0.1", 7777);
                    gui.appendMsg("Connected to Server\n");
                    // Create input and output stream attached to socket
                    out = new DataOutputStream(socket.getOutputStream());
                    in = new DataInputStream(socket.getInputStream());
                    // process messages sent from server
                    out.writeUTF(nickName + " is connected! \n");
                    gui.appendMsg("client : complete to send the nickname! \n");
                    while(true){
                        msg = in.readUTF();
                        gui.appendMsg(msg);
                    }
                    
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {// close all connection and release resource
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.start();
        
    }
    
    public void sendMessage(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setNickname(String nickName){
        this.nickName = nickName;
    }
}
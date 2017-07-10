package Lec14;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class ClientGUI extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JTextArea jta = new JTextArea(40,25);
    private JTextField jtf = new JTextField(25);
    private ClientBackground client = new ClientBackground();
    private static String nickName;
    
    public ClientGUI(){
        
        add(jta, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(800, 100, 400, 600);
        setTitle("Client");
        
        client.setGui(this);
        client.setNickname(nickName);
        client.connect();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create your nickname : ");
        nickName = scanner.nextLine();
        scanner.close();
        new ClientGUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg =nickName+":"+ jtf.getText() + "\n";
        jta.append(msg);
        client.sendMessage(msg);
        jtf.setText("");
 
    }
    public void appendMsg(String msg) {
        jta.append(msg);
    }
 
}
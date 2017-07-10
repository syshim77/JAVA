// 12161605 �ɼ���

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class ServerGUI extends JFrame implements ActionListener{
    
    private static final long serialVersionUID =1L;
    private JTextArea jta = new JTextArea(40,25);
    private JTextField jtf = new JTextField(25);
    private ServerBackground server = new ServerBackground();
    
    public ServerGUI() throws IOException{
        
        add(jta, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200, 100, 400, 600);
        setTitle("Server");
        server.setGui(this);
        server.setting();
    }
    
    public static void main(String[] args) throws IOException{
        new ServerGUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "Server : " +jtf.getText() + "\n";
        server.sendMessage(msg);
        appendMsg(msg);
        jtf.setText("");
    }
    
    public void appendMsg(String msg) {
        jta.append(msg);
    }
}
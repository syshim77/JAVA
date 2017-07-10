package Lec08;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.KeyboardFocusManager;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JPanel pnDisplay;
    private JPanel pnInput;
    private JPanel pnHistory;
    private JTextField textField;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnAdd;
    private JButton btnClearAll;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnMinus;
    private JButton btnClearText;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnMultiply;
    private JButton btnOver;
    private JButton btn0;
    private JButton btnDot;
    private JButton btnEqual;
    private JButton btnDivide;
    private JButton btnSquared;
    private JList list;

    // String to store input data
    private String num1;
    private String num2;
    private String operator;
    private String preInput;
    public final String NUMBER = "N";
    public final String OPERATOR = "O";
    private final String NONE = "NONE";
    private DefaultListModel<String> listData;
    private JButton btnBackspace;
    private JButton btnNewButton_1;
    private JButton btnNewButton;
    private JButton btnNewButton_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimpleCalculator frame = new SimpleCalculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SimpleCalculator() {

        /*
         * GUI code
         */
        // init the data
        num1 = NONE;
        num2 = NONE;
        operator = NONE;
        preInput = NONE;
        
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1006, 739);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        pnDisplay = new JPanel();
        contentPane.add(pnDisplay, BorderLayout.NORTH);
        pnDisplay.setLayout(new GridLayout(0, 1, 0, 0));

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("Courier New", Font.PLAIN, 24));
        pnDisplay.add(textField);
        textField.setColumns(10);

        pnInput = new JPanel();
        contentPane.add(pnInput, BorderLayout.CENTER);
        pnInput.setLayout(new GridLayout(4, 6, 4, 4));

        btn7 = new JButton("7");
        btn7.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn7.addActionListener(this);
        pnInput.add(btn7);

        btn8 = new JButton("8");
        btn8.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn8.addActionListener(this);
        pnInput.add(btn8);

        btn9 = new JButton("9");
        btn9.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn9.addActionListener(this);
        pnInput.add(btn9);

        btnAdd = new JButton("+");
        btnAdd.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btnAdd.addActionListener(this);
        pnInput.add(btnAdd);

        btnClearAll = new JButton("C");
        btnClearAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
             // reset all the data
                textField.setText("");
                num1 = NONE;
                num2 = NONE;
                operator = NONE;
                preInput = NONE;
                listData.clear();
            }
        });
        btnClearAll.setFont(new Font("±¼¸²", Font.BOLD, 14));
        pnInput.add(btnClearAll);

        btnBackspace = new JButton("");
        btnBackspace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().length() > 0) {
                    StringBuffer sb = new StringBuffer(textField.getText());
                    sb = sb.deleteCharAt(textField.getText().length()-1);
                    textField.setText(sb.toString());
                }
            }
        });
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\workspace\\Lab07\\src\\backspace.png").getImage()
                .getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        btnBackspace.setIcon(imageIcon);
        // JFrame resize solution

        btnBackspace.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pnInput.add(btnBackspace);

        btn4 = new JButton("4");
        btn4.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn4.addActionListener(this);
        pnInput.add(btn4);

        btn5 = new JButton("5");
        btn5.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn5.addActionListener(this);
        pnInput.add(btn5);

        btn6 = new JButton("6");
        btn6.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn6.addActionListener(this);
        pnInput.add(btn6);

        btnMinus = new JButton("-");
        btnMinus.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btnMinus.addActionListener(this);
        pnInput.add(btnMinus);

        btnClearText = new JButton("CE");
        btnClearText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // reset the textfield only
                textField.setText("");
                textField.setEditable(true);
            }
        });
        btnClearText.setFont(new Font("±¼¸²", Font.BOLD, 14));
        pnInput.add(btnClearText);

        btnNewButton_1 = new JButton("");
        pnInput.add(btnNewButton_1);

        btn1 = new JButton("1");
        btn1.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn1.addActionListener(this);
        pnInput.add(btn1);

        btn2 = new JButton("2");
        btn2.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn2.addActionListener(this);
        pnInput.add(btn2);

        btn3 = new JButton("3");
        btn3.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn3.addActionListener(this);
        pnInput.add(btn3);

        btnDivide = new JButton("/");
        btnDivide.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btnDivide.addActionListener(this);
        pnInput.add(btnDivide);

        btnOver = new JButton("1/x");
        btnOver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = "1";                
                num2 = textField.getText();
                String ret = doMath(num1, "/", num2);
                
                // update the list
                listData.addElement(num1);
                listData.addElement("/");
                listData.addElement(num2);
                listData.addElement("=");
                listData.addElement(ret);
                listData.addElement("-----");
                
                // scroll down the list
                list.ensureIndexIsVisible(listData.getSize() - 1);
                
                // reset the input filed
                operator = NONE;
                num1 = NONE;
                num2 = NONE;
                preInput = NONE;
            }
        });
        btnOver.setFont(new Font("±¼¸²", Font.BOLD, 13));
        pnInput.add(btnOver);

        btn0 = new JButton("0");
        btn0.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btn0.addActionListener(this);

        btnNewButton = new JButton("");
        pnInput.add(btnNewButton);
        pnInput.add(btn0);

        btnDot = new JButton(".");
        btnDot.setFont(new Font("±¼¸²", Font.BOLD, 14));
        pnInput.add(btnDot);

        btnEqual = new JButton("=");
        btnEqual.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btnEqual.addActionListener(this);
        pnInput.add(btnEqual);

        btnMultiply = new JButton("*");
        btnMultiply.setFont(new Font("±¼¸²", Font.BOLD, 14));
        btnMultiply.addActionListener(this);
        pnInput.add(btnMultiply);

        btnSquared = new JButton("x" + Character.toString('\u00B2'));
        btnSquared.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = textField.getText();                
                num2 = textField.getText();
                String ret = doMath(num1, "*", num2);
                
                // update the list
                listData.addElement(num1);
                listData.addElement("*");
                listData.addElement(num2);
                listData.addElement("=");
                listData.addElement(ret);
                listData.addElement("-----");
                
                // scroll down the list
                list.ensureIndexIsVisible(listData.getSize() - 1);
                
                // reset the input filed
                operator = NONE;
                num1 = NONE;
                num2 = NONE;
                preInput = NONE;
            }
        });
        btnSquared.setFont(new Font("±¼¸²", Font.BOLD, 14));
        pnInput.add(btnSquared);

        btnNewButton_2 = new JButton("");
        pnInput.add(btnNewButton_2);

        pnHistory = new JPanel();
        contentPane.add(pnHistory, BorderLayout.EAST);
        pnHistory.setLayout(new GridLayout(0, 1, 0, 0));
        pnHistory.setPreferredSize(new Dimension(120, 200));

        listData = new DefaultListModel();
        list = new JList(listData);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                // get the object on which the event occurred 
                JList lst = (JList)arg0.getSource();
                try {
                    // try to convert to integer
                    String str = listData.getElementAt(lst.getSelectedIndex());
                    Double.parseDouble(str); 
                    textField.setText(str);
                    preInput = NUMBER;
                }catch (NumberFormatException  e){
                    // do nothing
                }
                
            }
        });
        pnHistory.add(new JScrollPane(list));
        
        /*
         * End of GUI code
         */
    
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_TYPED) {
                    // System.out.println("Got key event!" + e.getKeyChar());
                    // Convert char to string and do the same thing like button
                    // events
                    String s = String.valueOf(e.getKeyChar());

                    // When the number button is clicked, update the input
                    // number
                    if (s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0) {
                        if (preInput.equals(NUMBER)) {
                            textField.setText(textField.getText() + s);
                        } else {
                            textField.setText(s);
                        }
                        preInput = NUMBER;
                    }
                    // When the operator button is clicked
                    else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                        if (preInput.equals(NUMBER)) {
                            // update the list
                            listData.addElement(textField.getText());
                            listData.addElement(s);

                            if (operator.equals(NONE)) { // check if there is
                                                         // operator exist then
                                                         // save the number
                                num1 = textField.getText();

                            } else { // check if there is operator exist then do
                                     // the operator
                                num1 = doMath(num1, operator, textField.getText());
                                // display the result
                                textField.setText(num1);
                            }

                            operator = s;
                            num2 = NONE;
                        } else if (preInput == OPERATOR) {
                            operator = s;
                            // remove the last operator in list and add new one
                            listData.removeElementAt(listData.getSize() - 1);
                            listData.addElement(s);
                        } else {
                            // do nothing
                        }
                        preInput = OPERATOR;
                        // When the = operator button or Enter button is clicked
                    } else if (s.equals("=") || e.getKeyChar() == KeyEvent.VK_ENTER) {
                        if (preInput.equals(NUMBER)) { // only calculate when
                                                       // all 2 number

                            // update the list
                            listData.addElement(textField.getText());
                            listData.addElement("=");

                            // calculate the previous operator before store the
                            // new one
                            num1 = doMath(num1, operator, textField.getText());

                            // display the result
                            textField.setText(num1);
                            listData.addElement(num1);
                            listData.addElement("-----");

                            // reset the input filed
                            operator = NONE;
                            num1 = NONE;
                            num2 = NONE;
                            preInput = NONE;
                        }
                    }
                }

                // scroll down the list
                list.ensureIndexIsVisible(listData.getSize() - 1);

                return false;
            }
        });
    }


    // Receive the events from all buttons
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Get the string from the button
        String s = ae.getActionCommand();

        // When the number button is clicked, update the input number
        if (s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0) {
            if (preInput.equals(NUMBER)) {
                textField.setText(textField.getText() + s);
            } else {
                textField.setText(s);
            }
            preInput = NUMBER;
        }
        // When the operator button is clicked
        else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            if (preInput.equals(NUMBER)) {
                // update the list
                listData.addElement(textField.getText());
                listData.addElement(s);

                if (operator.equals(NONE)) { // check if there is operator exist
                                             // then save the number
                    num1 = textField.getText();

                } else { // check if there is operator exist then do the
                         // operator
                    num1 = doMath(num1, operator, textField.getText());
                    // display the result
                    textField.setText(num1);
                }

                operator = s;
                num2 = NONE;
            } else if (preInput == OPERATOR) {
                operator = s;
                // remove the last operator in list and add new one
                listData.removeElementAt(listData.getSize() - 1);
                listData.addElement(s);
            } else {
                // do nothing
            }
            preInput = OPERATOR;
            // When the = operator button is clicked
        } else if (s.equals("=")) {
            if (preInput.equals(NUMBER)) { // only calculate when all 2 number

                // update the list
                listData.addElement(textField.getText());
                listData.addElement("=");

                // calculate the previous operator before store the new one
                num1 = doMath(num1, operator, textField.getText());

                // display the result
                textField.setText(num1);
                listData.addElement(num1);
                listData.addElement("-----");

                // reset the input filed
                operator = NONE;
                num1 = NONE;
                num2 = NONE;
                preInput = NONE;
            }
        }

        // scroll down the list
        list.ensureIndexIsVisible(listData.getSize() - 1);
    }

    /**
     * Do the operator and return the value in String.
     * 
     * @param num1
     *            1st number
     * @param num2
     *            2nd number
     * @param op
     *            the operator
     * @return result
     */
    private String doMath(String num1, String op, String num2) {
        // convertString to number
        Double number1 = Double.parseDouble(num1);
        Double number2 = Double.parseDouble(num2);

        // do the operator
        switch (op) {
        case "+":
            number1 = number1 + number2;
            break;
        case "-":
            number1 = number1 - number2;
            break;
        case "*":
            number1 = number1 * number2;
            break;
        case "/":
            number1 = number1 / number2;
            break;
        default:
            break;
        }

        // convert to string and return it
        return ("" + number1);
    }

}
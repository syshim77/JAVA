package Lec07;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConverterFrame extends JFrame {
	private JLabel lblDistance;
	private JTextField txtKmDistance;
	private JButton btnCalculate;
	private JTextField txtMileDistance;

	public ConverterFrame() {
		// call super constructor to set the name
		super("Converter");
		lblDistance = new JLabel("Distance in Km");
		txtKmDistance = new JTextField(10);
		btnCalculate = new JButton("Calculate");
		txtMileDistance = new JTextField(50);
		txtMileDistance.setEditable(false);

		getContentPane().setLayout(new GridLayout(2, 2));
		getContentPane().add(lblDistance);
		getContentPane().add(txtKmDistance);
		getContentPane().add(btnCalculate);
		getContentPane().add(txtMileDistance);

		btnCalculate.addActionListener(new CalculateHandler());
	}

	public class CalculateHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double km = Double.parseDouble(txtKmDistance.getText());
			String ret = String.format("%.3f mile(s)", km * 1.60934);
			txtMileDistance.setText(ret);
		}
	}
	public void showFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,150);
		setVisible(true);
	}
}
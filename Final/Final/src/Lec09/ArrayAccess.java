package Lec09;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayAccess extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtInputField;
	private JLabel lblNewLabel_1;
	private JTextField txtNumber;
	private JLabel lblNewLabel_2;
	private JTextField txtIndex;

	private int index = 0;
	private int array[] = new int[10];
	private JLabel lblArray;

	private final static Logger LOGGER = Logger.getLogger(ArrayAccess.class.getName());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayAccess frame = new ArrayAccess();
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
	public ArrayAccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
		        FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow(2)"),},
			new RowSpec[] {
			    FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,}));

		lblNewLabel = new JLabel("Input number of array");
		lblNewLabel.setFont(new Font("Gulim", Font.PLAIN, 18));
		panel.add(lblNewLabel, "2, 2, right, default");

		txtInputField = new JTextField();
		txtInputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * Create a try block in which the application reads the number
				 * entered in the inputField and assigns it to the next index in
				 * the array, then increments instance variable index.
				 */

				/*
				 * Write catch handlers that catch the two types of exceptions
				 * that the previous try block might throw
				 * (NumberFormatException and ArrayIndexOutOfBoundsException),
				 * and display appropriate messages in error message dialogs.
				 */

				try {
					int num = Integer.parseInt(txtInputField.getText());

					// determine whether num is a duplicate
					insertToArray(num);

				} catch (DuplicateValueException duplicateEx) {
					JOptionPane.showMessageDialog(null, "Please enter only unique integers", "Duplicate Value",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException formatEx) {
					JOptionPane.showMessageDialog(null, "Please enter only integer values", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				} catch (ArrayIndexOutOfBoundsException outOfBoundsEx) {
					JOptionPane.showMessageDialog(null, "Array may contain only 10 elements", "Array Full",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					updateArrayDisplay();
					txtInputField.setText("");
				} // end catch
			}
		});
		txtInputField.setFont(new Font("Gulim", Font.PLAIN, 18));
		panel.add(txtInputField, "4, 2, fill, default");
		txtInputField.setColumns(10);

		lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setFont(new Font("Gulim", Font.PLAIN, 18));
		panel.add(lblNewLabel_1, "2, 4, right, default");

		txtNumber = new JTextField();
		txtNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Create a try block in which the application reads from
				 * txtNumber the number the user wants to find in the array,
				 * then searches the current array contents for the number. If
				 * the number is found, the outputField should display all the
				 * indices in which the number was found. If the number is not
				 * found, a NumberNotFoundException should be thrown.
				 */

				/*
				 * Write catch handlers that catch the two types of exceptions
				 * that the try block might throw (NumberFormatException and
				 * NumberNotFoundException), and display appropriate messages in
				 * error message dialogs.
				 */
				try {
					int num = Integer.parseInt(txtNumber.getText());
					int foundVal = -1;
					// result =
					// String.format("%d was in the following fields of the array: ",
					// num);

					for (int i = 0; i < index; i++) {
						if (num == array[i]) {
							foundVal = i;
						}
					}

					if (foundVal == -1) {
						throw new NumberNotFoundException();
					}

					txtIndex.setText(String.format("%d", foundVal));
				} catch (NumberFormatException formatException) {
					txtIndex.setText("");
					JOptionPane.showMessageDialog(null, "Please enter only integer values", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberNotFoundException numberException) {
					txtIndex.setText("");
					JOptionPane.showMessageDialog(null, numberException.getMessage(), "Not Found",
							JOptionPane.ERROR_MESSAGE);
				} // end catch
			}
		});
		txtNumber.setFont(new Font("Gulim", Font.PLAIN, 18));
		panel.add(txtNumber, "4, 4, fill, default");
		txtNumber.setColumns(10);

		lblNewLabel_2 = new JLabel("Index");
		lblNewLabel_2.setFont(new Font("Gulim", Font.PLAIN, 18));
		panel.add(lblNewLabel_2, "2, 6, right, default");

		txtIndex = new JTextField();
		txtIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Create a try block in which the application reads from
				 * txtIndex the index of a value in the array, then displays the
				 * value at that index in the txtNumber. If the index input by
				 * the user is not a number a NumberFormatException should be
				 * thrown. If the number input by the user is outside the array
				 * bounds or represents an element in which the application has
				 * not stored a value, an ArrayIndexOutOfBoundsException should
				 * be thrown.
				 */

				/*
				 * Write catch handlers that catch the two types of exceptions
				 * the try block might throw (NumberFormatException and
				 * ArrayIndexOutOfBoundsException), and display appropriate
				 * messages in error message dialogs.
				 */
				try {
					int num = Integer.parseInt(txtIndex.getText());

					if (num >= index || num < 0)
						throw new ArrayIndexOutOfBoundsException("Index Not Found.");
					txtNumber.setText(String.format("%d", array[num]));
				} catch (NumberFormatException formatException) {
					txtNumber.setText("");
					JOptionPane.showMessageDialog(null, "Array indices must be integer values", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				} catch (ArrayIndexOutOfBoundsException outOfBounds) {
					txtNumber.setText("");
					JOptionPane.showMessageDialog(null, outOfBounds.getMessage(), "Index Out of Bounds",
							JOptionPane.ERROR_MESSAGE);
				} // end catch

			}
		});
		txtIndex.setFont(new Font("Gulim", Font.PLAIN, 18));
		panel.add(txtIndex, "4, 6, fill, default");
		txtIndex.setColumns(10);

		lblArray = new JLabel("");
		
		lblArray.setHorizontalAlignment(SwingConstants.CENTER);
		lblArray.setFont(new Font("Gulim", Font.ITALIC, 18));
		panel.add(lblArray, "2, 8, 3, 1");
	}

	public void insertToArray(int num) throws DuplicateValueException, ArrayIndexOutOfBoundsException {
		for (int i = 0; i < index; i++) {
			if (num == array[i])
				throw new DuplicateValueException();
		} // end for
		array[index] = num; // place value in array
		index++;
	}

	private void updateArrayDisplay() {
		String str = "";
		for (int i = 0; i < index; i++) {
			str = str + array[i] + " ";
		}
		lblArray.setText(str);
	}

}

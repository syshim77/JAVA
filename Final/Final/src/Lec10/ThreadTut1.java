package Lec10;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class ThreadTut1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JButton btnStop;
	JButton btnStart;
	JTextArea txtArea;
	JProgressBar progressBar;
	JLabel lblStatus;
	private JScrollPane scrollPane;
	
	Random rand = new Random();
	
	Thread workThread;
	WorkerClass worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadTut1 frame = new ThreadTut1();
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
	public ThreadTut1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnInput = new JPanel();
		contentPane.add(pnInput, BorderLayout.NORTH);
		pnInput.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("Number of loops");
		pnInput.add(lblNewLabel);

		textField = new JTextField();
		pnInput.add(textField);
		textField.setColumns(10);

		btnStart = new JButton("Run");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// reset all views
				progressBar.setValue(0); // reset JProgressBar
				txtArea.setText(""); // clear JTextArea
				lblStatus.setText(""); // clear JLabel

				// get user input
				int number;
				try {
					number = Integer.parseInt(textField.getText());
				} catch (NumberFormatException ex) {
					lblStatus.setText("Enter an integer.");
					return;
				} // end try

				// create and start a thread
				// workThread = new Thread(new CalculatorClass(number));
				// workThread.start();

				worker = new WorkerClass(number);
				worker.addPropertyChangeListener(new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent e) {
						// if the changed property is progress, update the progress bar
						if (e.getPropertyName().equals("progress")) {
							int newValue = (Integer) e.getNewValue();
							progressBar.setValue(newValue);
						}

					}

				});

				worker.execute();

			}
		});
		pnInput.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// workThread.interrupt();
				worker.stopWork();
			}
		});
		btnStop.setEnabled(false);
		pnInput.add(btnStop);

		JPanel pnList = new JPanel();
		contentPane.add(pnList, BorderLayout.CENTER);
		SpringLayout sl_pnList = new SpringLayout();
		pnList.setLayout(sl_pnList);

		txtArea = new JTextArea();
		txtArea.setEditable(false);

		scrollPane = new JScrollPane(txtArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sl_pnList.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, pnList);
		sl_pnList.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, pnList);
		sl_pnList.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.SOUTH, pnList);
		sl_pnList.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, pnList);

		pnList.add(scrollPane);

		JPanel pnStatus = new JPanel();
		contentPane.add(pnStatus, BorderLayout.SOUTH);
		pnStatus.setLayout(new GridLayout(0, 2, 10, 0));

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		pnStatus.add(progressBar);

		lblStatus = new JLabel();
		pnStatus.add(lblStatus);
	}

	public class WorkerClass extends SwingWorker<Integer, String> {
		int num;
		boolean stopped;

		public WorkerClass(int number) {
			num = number;
			stopped = false;
		}

		@Override
		protected Integer doInBackground() throws Exception {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(false);
			btnStop.setEnabled(true);
			lblStatus.setText("Running...");
			int cnt = 0;
			try {
				for (int i = 0; i < num; i++) {
					if (stopped) {
						break;
					}
					// do some complex work here
					Thread.sleep(100);

					// update the result
					cnt++;

					// update the view
					setProgress((i + 1) * 100 / num);
					publish((i+1) + ". Random number =" + rand.nextDouble());

				}
				// update the status
				lblStatus.setText("Printed " + cnt + " number");
			} catch (InterruptedException e) {
				// update the status
				lblStatus.setText("Error performing computation.");
			}
			return cnt;
		}

		// displays published values
		protected void process(List<String> publishedVals) {
			for (int i = 0; i < publishedVals.size(); i++) {
				txtArea.append(publishedVals.get(i) + "\n");
				txtArea.setCaretPosition(txtArea.getDocument().getLength());
			}
		} // end method process

		// code to execute when doInBackground completes
		protected void done() {
			// disable Start button and enable Cancel button
			btnStart.setEnabled(true);
			btnStop.setEnabled(false);
			int retNum = 0;
			try {
				retNum = get();
				lblStatus.setText("Finish " + retNum + " works.");
			} catch (InterruptedException ex) {
				lblStatus.setText("Interrupted while waiting for results.");
			}catch (ExecutionException ex) {
				lblStatus.setText("Error performing computation.");
			} // end try catch
		}

		public void stopWork() {
			stopped = true;
		}

	}
}

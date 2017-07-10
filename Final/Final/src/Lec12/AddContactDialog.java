package Lec12;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddContactDialog extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldName;
	private JTextField txtFieldPhone;
	
	private String name;
	private String phone;

	/**
	 * Create the dialog.
	 */
	public AddContactDialog(JFrame parent)
	{
		super(parent, true);

		setTitle("Add Contact");
		setBounds(100, 100, 350, 150);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(15, 17, 60, 20);
			contentPanel.add(lblName);
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			txtFieldName = new JTextField();
			txtFieldName.setBounds(80, 15, 240, 25);
			contentPanel.add(txtFieldName);
			txtFieldName.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(15, 47, 60, 20);
			contentPanel.add(lblPhone);
			lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			txtFieldPhone = new JTextField();
			txtFieldPhone.setBounds(80, 45, 240, 25);
			contentPanel.add(txtFieldPhone);
			txtFieldPhone.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						name = txtFieldName.getText();
						phone = txtFieldPhone.getText();
						
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						name = "";
						phone = "";
						
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String getName()
	{
		return name;
	}

	public String getPhone()
	{
		return phone;
	}

}

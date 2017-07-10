package Lec13;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ContactDialog extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldName;
	private JTextField txtFieldPhone;
	
	private String name;
	private String phone;

	/**
	 * Create the dialog.
	 */
	public ContactDialog(JFrame frame)
	{
		super(frame, true);
		
		setTitle("Contact Info");
		setBounds(100, 100, 360, 140);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(5);
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 0, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{90, 300, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name: ");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.weighty = 1.0;
			gbc_lblName.weightx = 1.0;
			gbc_lblName.fill = GridBagConstraints.VERTICAL;
			gbc_lblName.insets = new Insets(5, 5, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			txtFieldName = new JTextField();
			GridBagConstraints gbc_txtFieldName = new GridBagConstraints();
			gbc_txtFieldName.weighty = 1.0;
			gbc_txtFieldName.weightx = 1.0;
			gbc_txtFieldName.insets = new Insets(5, 5, 5, 5);
			gbc_txtFieldName.fill = GridBagConstraints.BOTH;
			gbc_txtFieldName.gridx = 1;
			gbc_txtFieldName.gridy = 0;
			contentPanel.add(txtFieldName, gbc_txtFieldName);
			txtFieldName.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone: ");
			GridBagConstraints gbc_lblPhone = new GridBagConstraints();
			gbc_lblPhone.anchor = GridBagConstraints.EAST;
			gbc_lblPhone.fill = GridBagConstraints.VERTICAL;
			gbc_lblPhone.weighty = 1.0;
			gbc_lblPhone.weightx = 1.0;
			gbc_lblPhone.insets = new Insets(0, 5, 5, 5);
			gbc_lblPhone.gridx = 0;
			gbc_lblPhone.gridy = 1;
			contentPanel.add(lblPhone, gbc_lblPhone);
		}
		{
			txtFieldPhone = new JTextField();
			GridBagConstraints gbc_txtFieldPhone = new GridBagConstraints();
			gbc_txtFieldPhone.weighty = 1.0;
			gbc_txtFieldPhone.weightx = 1.0;
			gbc_txtFieldPhone.insets = new Insets(0, 5, 5, 5);
			gbc_txtFieldPhone.fill = GridBagConstraints.BOTH;
			gbc_txtFieldPhone.gridx = 1;
			gbc_txtFieldPhone.gridy = 1;
			contentPanel.add(txtFieldPhone, gbc_txtFieldPhone);
			txtFieldPhone.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 5, 0, 5));
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public ContactDialog(JFrame frame, String name, String phone)
	{
		this(frame);
		txtFieldName.setText(name);
		txtFieldPhone.setText(phone);
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	
}

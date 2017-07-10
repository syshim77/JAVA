package Lec13;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ContactPanel extends JPanel
{
	private JLabel lblName;
	private JButton btnEdit;
	private JLabel lblPhone;
	private JButton btnDelete;
	
	private String name;
	private String phone;
	
	private Phonebook parent;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public ContactPanel(Phonebook phonebook)
	{
		setSize(new Dimension(360, 60));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 80, 80, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblName = new JLabel();
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.weighty = 1.0;
		gbc_lblName.weightx = 1.0;
		gbc_lblName.gridwidth = 3;
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(5, 5, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ContactDialog dlg = new ContactDialog(null, lblName.getText(), lblPhone.getText());
				dlg.setVisible(true);
				
				if (dlg.getName() != null && dlg.getPhone() != null)
				{
					parent.getListPanel().get(parent.getListPanel().lastIndexOf(ContactPanel.this)).setName(dlg.getName().trim());
					parent.getListPanel().get(parent.getListPanel().lastIndexOf(ContactPanel.this)).setPhone(dlg.getPhone().trim());
					lblName.setText(dlg.getName().trim());
					lblPhone.setText(dlg.getPhone().trim());
				}
				dlg.dispose();
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.weighty = 1.0;
		gbc_btnEdit.weightx = 1.0;
		gbc_btnEdit.insets = new Insets(5, 5, 5, 5);
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 0;
		add(btnEdit, gbc_btnEdit);
		
		lblPhone = new JLabel();
		lblPhone.setFont(new Font("Dialog", Font.ITALIC, 12));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.weighty = 1.0;
		gbc_lblPhone.weightx = 1.0;
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.gridwidth = 3;
		gbc_lblPhone.insets = new Insets(0, 15, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 1;
		add(lblPhone, gbc_lblPhone);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				parent.removeContactPanel(ContactPanel.this);
				parent.updateGUI();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.weighty = 1.0;
		gbc_btnDelete.insets = new Insets(0, 5, 5, 5);
		gbc_btnDelete.weightx = 1.0;
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 1;
		add(btnDelete, gbc_btnDelete);
		
		parent = phonebook;
		name = "";
		phone = "";
	}
	
	public ContactPanel(Phonebook phonebook, String name, String phone)
	{
		this(phonebook);
		setName(name);
		setPhone(phone);
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
		lblName.setText(name);
	}

	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
		lblPhone.setText(phone);
	}
}

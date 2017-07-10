package Lec13;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Phonebook extends JFrame
{

	private JPanel contentPane;
	private JTextField txtFldFilter;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JPanel pnList;

	private List<ContactPanel> listPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Phonebook frame = new Phonebook();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Phonebook()
	{
		setTitle("Phonebook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		txtFldFilter = new JTextField();
		txtFldFilter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				filter();
			}
		});
		contentPane.add(txtFldFilter, BorderLayout.NORTH);
		txtFldFilter.setColumns(10);

		pnList = new JPanel();
		pnList.setLayout(new GridLayout(0, 1, 0, 2));
		scrollPane = new JScrollPane(pnList);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ContactDialog dlg = new ContactDialog(Phonebook.this);
				dlg.setVisible(true);
				if ((dlg.getName() != null) && (dlg.getPhone() != null))
				{
					if ((dlg.getName().trim().length() > 0) && (dlg.getPhone().trim().length() > 0))
					{
						listPanel.add(new ContactPanel(Phonebook.this, dlg.getName(), dlg.getPhone()));
						pnList.add(listPanel.get(listPanel.size() - 1));
						updateGUI();
						scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
					}
				}
				dlg.dispose();
			}
		});
		contentPane.add(btnAdd, BorderLayout.SOUTH);

		listPanel = new ArrayList<ContactPanel>();
		initData();
	}

	private void initData()
	{
		for (int i = 0; i < ContactData.rawData.length; i++)
		{
			String[] spl = ContactData.rawData[i].split(":");
			if ((spl != null) && (spl.length == 2))
			{
				listPanel.add(new ContactPanel(Phonebook.this, spl[0].trim(), spl[1].trim()));
				pnList.add(listPanel.get(listPanel.size() - 1));
			}
		}
	}
	
	private void filter()
	{
		pnList.removeAll();
		
		for (int i = 0; i < listPanel.size(); i++)
		{
			if (listPanel.get(i).getPhone().matches(txtFldFilter.getText()))
			{
				pnList.add(listPanel.get(i));
			}
		}
		
		for (int i = 0; i < listPanel.size(); i++)
        {
            if (listPanel.get(i).getName().matches(txtFldFilter.getText()))
            {
                pnList.add(listPanel.get(i));
            }
        }
		
		updateGUI();
	}
	
	public void updateGUI()
	{
		revalidate();
		repaint();
	}

	public void removeContactPanel(ContactPanel contactPanel)
	{
		pnList.remove(contactPanel);
		listPanel.remove(contactPanel);
	}

	public List<ContactPanel> getListPanel()
	{
		return listPanel;
	}
}

package Lec12;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Phonebook extends JFrame
{
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAction;
	private JMenuItem mntmAdd;
	private JMenuItem mntmDelete;
	private JMenuItem mntmExit;
	private JMenu mnCollections;
	private JMenuItem mntmSort;
	private JMenuItem mntmShuffle;
	private JMenuItem mntmDuplicate;
	private JMenuItem mntmRemDup;
	private JSplitPane splitPane;
	private JScrollPane sp;
	private JScrollPane spDup;
	private JLabel lblStatus;

	private List<String> listData;
	private JTextArea txtArea;

	private Vector<String> vectorData;
	private DefaultListModel<String> listModel;
	private JList<String> jlist;
	

	private boolean isSort;
	private JMenuItem mntmDelItem;

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
		try
		{
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Phonebook.png")));
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (NullPointerException ex)
		{
			System.out.println("Error: " + ex.toString());
		}
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.toString());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAction = new JMenu("Action");
		menuBar.add(mnAction);

		mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String str = (String) JOptionPane.showInputDialog(Phonebook.this, "Input name and number: ", "Add Contact", JOptionPane.PLAIN_MESSAGE);
				AddContactDialog dlg = new AddContactDialog(Phonebook.this);
				dlg.setVisible(true);
				if ((dlg.getName() != null) && (dlg.getPhone() != null))
				{
					if ((dlg.getName().trim().length() > 0) && (dlg.getPhone().trim().length() > 0))
					{
						listData.add(dlg.getName() + ": " + dlg.getPhone());
						showList();
					}
				}
			}
		});
		mnAction.add(mntmAdd);

		mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String s = (String) JOptionPane.showInputDialog(Phonebook.this, "Input the index to delete",
						"Delete Contact", JOptionPane.PLAIN_MESSAGE);
				if ((s != null) && (s.length() > 0))
				{
					try
					{
						int index = Integer.parseInt(s);
						listData.remove(index);
					}
					catch (NumberFormatException ex)
					{
						System.out.println("Error: " + ex.toString());
					}
					catch (IndexOutOfBoundsException ex)
					{
						System.out.println("Error: " + ex.toString());
					}
					showList();
				}
			}
		});
		mnAction.add(mntmDelete);

		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				System.exit(0);
			}
		});
		mnAction.add(mntmExit);

		mnCollections = new JMenu("Collections");
		menuBar.add(mnCollections);

		mntmSort = new JMenuItem("Sort");
		mntmSort.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isSort == false)
				{
					Collections.sort(listData);
					isSort = true;
				}
				else
				{
					Collections.sort(listData, Collections.reverseOrder());
					isSort = false;
				}
				showList();
			}
		});
		mnCollections.add(mntmSort);

		mntmShuffle = new JMenuItem("Shuffle");
		mntmShuffle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Collections.shuffle(listData);
				showList();
			}
		});
		mnCollections.add(mntmShuffle);

		mntmDuplicate = new JMenuItem("Duplicate");
		mntmDuplicate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				listModel.clear();
				
				vectorData = new Vector<String>(listData);
				
				Collections.copy(vectorData, listData);
				
				Iterator<String> itVec = vectorData.iterator();
				while (itVec.hasNext())
				{
					listModel.addElement(itVec.next());
				}
				
				if (!listModel.isEmpty())
				{
					jlist.setSelectedIndex(listModel.size() - 1);
					jlist.ensureIndexIsVisible(listModel.size() - 1);
				}
			}
		});
		mnCollections.add(mntmDuplicate);

		mntmRemDup = new JMenuItem("Remove Duplicate");
		mntmRemDup.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if ((vectorData != null) && (vectorData.size() > 0))
				{
					vectorData.removeAllElements();
					listModel.clear();
				}
			}
		});
		mnCollections.add(mntmRemDup);
		
		mntmDelItem = new JMenuItem("Delete Item");
		mntmDelItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				deleteItem();
			}
		});
		mnCollections.add(mntmDelItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		listData = new ArrayList<String>();
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Dialog", Font.BOLD, 12));
		sp = new JScrollPane(txtArea);

		listModel = new DefaultListModel<String>();
		jlist = new JList<String>(listModel);
		jlist.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_DELETE)
				{
					deleteItem();
				}
			}
		});
		spDup = new JScrollPane(jlist);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, spDup);
		splitPane.setResizeWeight(0.5);
		contentPane.add(splitPane, BorderLayout.CENTER);

		lblStatus = new JLabel("Total 0 records.");
		contentPane.add(lblStatus, BorderLayout.SOUTH);

		initData();
		showList();
		isSort = false;
	}

	private void initData()
	{
		for (int i = 0; i < PhoneData.names.length; i++)
		{
			listData.add(PhoneData.names[i] + ": " + PhoneData.phones[i]);
		}
	}

	private void showList()
	{
		txtArea.setText("");
		for (int i = 0; i < listData.size(); i++)
		{
			txtArea.append(listData.get(i) + "\n");
		}
		lblStatus.setText("Total " + listData.size() + " records.");
	}
	
	private void deleteItem()
	{
		if((vectorData != null) && (vectorData.size() > 0))
		{
			int index = jlist.getSelectedIndex();
			if (index != -1)
			{
				vectorData.remove(index);
				listModel.remove(index);
			}
			else
			{
				JOptionPane.showMessageDialog(Phonebook.this, "Select item from duplicate List!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(Phonebook.this, "Nothing to delete.", "No Item", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

package myPackage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SwitchInformationToDE extends javax.swing.JDialog {
	private JList ItemList;
	private JTextField idText;
	private JButton jButton1;
	private JButton RefreshButton;
	private JButton DeleteButton;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JScrollPane jScrollPane1;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField partText;
	private JTextField initiatorText;
	private JTextField reasonText;
	private JTextField commentText;
	private JTextField priorityText;
	private JTextField supplierText;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();

	/**
	* Auto-generated main method to display this JDialog
	*/
	
	public SwitchInformationToDE(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Search a switch");
				{
					initiatorText = new JTextField();
					getContentPane().add(initiatorText);
					initiatorText.setBounds(410, 134, 114, 34);
				}
				
				
				
				
				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(410, 214, 105, 28);
				}
				{
					partText = new JTextField();
					getContentPane().add(partText);
					partText.setBounds(621, 133, 105, 40);
				}
				{
					reasonText = new JTextField();
					getContentPane().add(reasonText);
					reasonText.setBounds(428, 354, 281, 39);
				}
				{
					priorityText = new JTextField();
					getContentPane().add(priorityText);
					priorityText.setBounds(626, 220, 103, 39);
				}
				{
					supplierText = new JTextField();
					getContentPane().add(supplierText);
					supplierText.setBounds(410, 276, 88, 39);
				}
				{
					commentText = new JTextField();
					getContentPane().add(commentText);
					commentText.setBounds(427, 405, 288, 83);
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Close");
					jButton1.setBounds(99, 396, 91, 28);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("jButton1.actionPerformed, event="
									+ evt);
							//TODO add your code for jButton1.actionPerformed
							dispose();
						}
					});
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Initiator:");
					jLabel1.setBounds(281, 134, 129, 34);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Switch ID:");
					jLabel2.setBounds(269, 214, 115, 24);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Part:");
					jLabel3.setBounds(548, 137, 63, 28);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("Switch Information");
					jLabel4.setBounds(335, 40, 298, 52);
					jLabel4.setFont(new java.awt.Font("Arial",1,26));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Delete");
					DeleteButton.setBounds(99, 292, 98, 28);
					DeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("DeleteButton.actionPerformed, event="
									+ evt);
							//TODO add your code for DeleteButton.actionPerformed
							int indx = ItemList.getSelectedIndex();
							itemNameContainer.remove(indx);
							itemContainer.remove(indx);
							initiatorText.setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							priorityText.setText(null);
							supplierText.setText(null);
							commentText.setText(null);
							ItemList.updateUI();
						}
					});
				}
				{
					RefreshButton = new JButton();
					getContentPane().add(RefreshButton);
					RefreshButton.setText("Refresh");
					RefreshButton.setBounds(99, 344, 84, 28);
					RefreshButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("RefreshButton.actionPerformed, event="
									+ evt);
							//TODO add your code for RefreshButton.actionPerformed
							ItemList.updateUI();
							
							initiatorText.setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							priorityText.setText(null);
							supplierText.setText(null);
							commentText.setText(null);
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(79, 122, 147, 154);
					{
						ListModel ItemListModel = new DefaultComboBoxModel(
								itemNameContainer);
						ItemList = new JList();
						jScrollPane1.setViewportView(ItemList);
						ItemList.setModel(ItemListModel);
						ItemList.setBounds(83, 33, 135, 144);
						ItemList.setBorder(new LineBorder(new java.awt.Color(
								0,
								0,
								0), 1, false));
						ItemList.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								int indx = ItemList.getSelectedIndex();
								Switch sw = (Switch) itemContainer.get(indx);
								initiatorText.setText(sw.getInitiator());
								idText.setText(String.valueOf(sw.getID()));
								partText.setText(sw.getPart());
								priorityText.setText(sw.getPriority());
								supplierText.setText(sw.getSupplier());
								reasonText.setText(sw.getReason());
								commentText.setText(sw.getComment());
								
								
							}
						});
					}
				}

				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("Reason:");
					jLabel5.setBounds(281, 357, 135, 32);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("Comment:");
					jLabel6.setBounds(269, 424, 134, 32);
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("Priority:");
					jLabel7.setBounds(533, 223, 93, 32);
				}
				{
					jLabel8 = new JLabel();
					getContentPane().add(jLabel8);
					jLabel8.setText("Supplier:");
					jLabel8.setBounds(281, 276, 93, 32);
				}
				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(3, -6, 898, 700);
					
				}

			}
			this.setSize(861, 572);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

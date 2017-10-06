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
public class NewOrderInformation extends javax.swing.JDialog {
	private JList ItemList;
	private JTextField idText;
	private JButton jButton1;
	private JButton RefreshButton;
	private JButton DeleteButton;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JScrollPane jScrollPane1;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField priorityText;
	private JTextField supplierText;
	private JTextField quantityText;
	private JTextField linkText;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();

	/**
	* Auto-generated main method to display this JDialog
	*/
	
	public NewOrderInformation(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setLocationRelativeTo(null);
				getContentPane().setLayout(null);
				this.setTitle("New order");
				{
					supplierText = new JTextField();
					getContentPane().add(supplierText);
					supplierText.setBounds(372, 280, 120, 32);
				}
				
				
				
				
				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(366, 137, 126, 37);
				}
				{
					priorityText = new JTextField();
					getContentPane().add(priorityText);
					priorityText.setBounds(366, 211, 116, 38);
				}
				{
					quantityText = new JTextField();
					getContentPane().add(quantityText);
					quantityText.setBounds(371, 338, 121, 39);
				}
				{
					linkText = new JTextField();
					getContentPane().add(linkText);
					linkText.setBounds(365, 403, 453, 39);
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Close");
					jButton1.setBounds(80, 442, 91, 28);
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
					jLabel1.setText("Supplier:");
					jLabel1.setBounds(267, 343, 274, 28);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("ID:");
					jLabel2.setBounds(285, 140, 63, 28);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Priority:");
					jLabel3.setBounds(262, 216, 135, 28);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("New Order Information");
					jLabel4.setBounds(154, 51, 294, 28);
					jLabel4.setFont(new java.awt.Font("Arial",1,26));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Confirm");
					DeleteButton.setBounds(80, 323, 98, 28);
					DeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("DeleteButton.actionPerformed, event="
									+ evt);
							//TODO add your code for DeleteButton.actionPerformed
							int indx = ItemList.getSelectedIndex();
							itemNameContainer.remove(indx);
							itemContainer.remove(indx);
							supplierText .setText(null); // clean up the textbox
							priorityText.setText(null);
							idText.setText(null);
							quantityText.setText(null); // clean up the textbox
					
							linkText.setText(null);
							ItemList.updateUI();
						}
					});
				}
				{
					RefreshButton = new JButton();
					getContentPane().add(RefreshButton);
					RefreshButton.setText("Refresh");
					RefreshButton.setBounds(80, 380, 84, 28);
					RefreshButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("RefreshButton.actionPerformed, event="
									+ evt);
							//TODO add your code for RefreshButton.actionPerformed
							ItemList.updateUI();
							
							supplierText .setText(null); // clean up the textbox
							priorityText.setText(null);
							idText.setText(null);
							quantityText.setText(null); // clean up the textbox
							linkText.setText(null);
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(47, 114, 155, 168);
					{
						ListModel ItemListModel = new DefaultComboBoxModel(
								itemNameContainer);
						ItemList = new JList();
						jScrollPane1.setViewportView(ItemList);
						ItemList.setModel(ItemListModel);
						ItemList.setBounds(67, 159, 144, 151);
						ItemList.setBorder(new LineBorder(new java.awt.Color(
								0,
								0,
								0), 1, false));
						ItemList.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								int indx = ItemList.getSelectedIndex();
								Order od = (Order) itemContainer
								.get(indx);
								idText.setText(String.valueOf(od.getID()));
								priorityText.setText(od.getPriority());
								supplierText.setText(od.getQuantity());					
								quantityText.setText(od.getSupplier());
								linkText.setText(od.getLink());
								
							}
						});
					}
				}

				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("Quantity:");
					jLabel5.setBounds(262, 282, 98, 32);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("Link:");
					jLabel6.setBounds(281, 402, 106, 32);
				}

				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-26, -40, 897, 700);
					
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("(Please downlode the technicial documents)");
					jLabel7.setBounds(293, 445, 470, 32);
				}

			}
			this.setSize(861, 572);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

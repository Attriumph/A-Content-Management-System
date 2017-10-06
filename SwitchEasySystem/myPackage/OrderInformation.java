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
public class OrderInformation extends javax.swing.JDialog {
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
	
	public OrderInformation(Vector items, Vector names) {
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
				this.setTitle("Order Information");
				{
					supplierText = new JTextField();
					getContentPane().add(supplierText);
					supplierText.setBounds(369, 252, 160, 30);
				}
				
				
				
				
				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(362, 98, 166, 28);
				}
				{
					priorityText = new JTextField();
					getContentPane().add(priorityText);
					priorityText.setBounds(362, 147, 166, 28);
				}
				{
					quantityText = new JTextField();
					getContentPane().add(quantityText);
					quantityText.setBounds(369, 203, 158, 31);
				}
				{
					linkText = new JTextField();
					getContentPane().add(linkText);
					linkText.setBounds(362, 317, 453, 39);
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Close");
					jButton1.setBounds(65, 443, 124, 28);
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
					jLabel1.setBounds(255, 204, 138, 28);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Part");
					jLabel2.setBounds(264, 98, 63, 28);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Priority:");
					jLabel3.setBounds(254, 147, 135, 28);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("Order Information");
					jLabel4.setBounds(290, 46, 300, 28);
					jLabel4.setFont(new java.awt.Font("Arial",1,26));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Confirm");
					DeleteButton.setBounds(65, 307, 116, 28);
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
					RefreshButton.setBounds(65, 375, 116, 28);
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
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("Quantity:");
					jLabel5.setBounds(248, 251, 103, 32);
				}
				{
					ListModel ItemListModel = new DefaultComboBoxModel(
							itemNameContainer);
					ItemList = new JList();
					getContentPane().add(ItemList);
					ItemList.setModel(ItemListModel);
					ItemList.setBounds(63, 111, 144, 151);
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
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(67, 111, 138, 148);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("Link:");
					jLabel6.setBounds(270, 320, 106, 32);
				}

				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-6, 6, 862, 700);
					
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("(Please downlode the technicial documents)");
					jLabel7.setBounds(272, 376, 516, 32);
				}

			}
			this.setSize(861, 572);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

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
public class NewFeedbackInformation extends javax.swing.JDialog {
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
	private JTextField partText;
	private JTextField resultFBText;
	private JTextField reasonText;
	private JTextField solutionText;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();

	/**
	* Auto-generated main method to display this JDialog
	*/
	
	public NewFeedbackInformation(Vector items, Vector names) {
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
				this.setTitle("New Feedback");
				{
					resultFBText = new JTextField();
					getContentPane().add(resultFBText);
					resultFBText.setBounds(465, 210, 114, 28);
				}
				
				
				
				
				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(460, 114, 127, 28);
				}
				{
					partText = new JTextField();
					getContentPane().add(partText);
					partText.setBounds(460, 163, 119, 35);
				}
				{
					reasonText = new JTextField();
					getContentPane().add(reasonText);
					reasonText.setBounds(420, 263, 290, 57);
				}
				{
					solutionText = new JTextField();
					getContentPane().add(solutionText);
					solutionText.setBounds(420, 367, 290, 52);
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Close");
					jButton1.setBounds(54, 413, 91, 28);
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
					jLabel1.setText("Revision of feedback");
					jLabel1.setBounds(224, 210, 274, 28);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Object ID:");
					jLabel2.setBounds(291, 106, 135, 24);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Feedback for");
					jLabel3.setBounds(271, 147, 155, 28);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("New Feedback");
					jLabel4.setBounds(315, 53, 248, 28);
					jLabel4.setFont(new java.awt.Font("Arial",0,26));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Delete");
					DeleteButton.setBounds(53, 248, 98, 28);
					DeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("DeleteButton.actionPerformed, event="
									+ evt);
							//TODO add your code for DeleteButton.actionPerformed
							int indx = ItemList.getSelectedIndex();
							itemNameContainer.remove(indx);
							itemContainer.remove(indx);
							resultFBText .setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
					
							solutionText.setText(null);
							ItemList.updateUI();
						}
					});
				}
				{
					RefreshButton = new JButton();
					getContentPane().add(RefreshButton);
					RefreshButton.setText("Refresh");
					RefreshButton.setBounds(53, 320, 84, 28);
					RefreshButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("RefreshButton.actionPerformed, event="
									+ evt);
							//TODO add your code for RefreshButton.actionPerformed
							ItemList.updateUI();
							
							resultFBText .setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							solutionText.setText(null);
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(42, 42, 147, 154);
					{
						ListModel ItemListModel = new DefaultComboBoxModel(
							itemNameContainer);
						ItemList = new JList();
						jScrollPane1.setViewportView(ItemList);
						ItemList.setModel(ItemListModel);
						ItemList.setBounds(42, 175, 154, 2961);
						ItemList.setBorder(new LineBorder(new java.awt.Color(
							0,
							0,
							0), 1, false));
						ItemList.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								int indx = ItemList.getSelectedIndex();
								Feedback fb = (Feedback) itemContainer.get(indx);
								idText.setText(String.valueOf(fb.getID()));
								partText.setText(fb.getPart());
								resultFBText.setText(fb.getRevision());
								reasonText.setText(fb.getReason());
								solutionText.setText(fb.getSolution());
								
								
							
							}
						});
					}
				}
				
				
				
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("Reason:");
					jLabel5.setBounds(288, 266, 120, 32);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("Solution:");
					jLabel6.setBounds(283, 354, 106, 32);
				}
				
				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-9, -26, 906, 700);
					
				}
				{
					jLabel7 = new JLabel();
					getContentPane().add(jLabel7);
					jLabel7.setText("(Feedback/Switch)");
					jLabel7.setBounds(249, 172, 193, 32);
				}

			}
			this.setSize(861, 572);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

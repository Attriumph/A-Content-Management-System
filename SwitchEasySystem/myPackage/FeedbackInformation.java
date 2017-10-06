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
public class FeedbackInformation extends javax.swing.JDialog {
	private JList ItemList;
	private JTextField idText;
	private JButton jButton1;
	private JButton RefreshButton;
	private JButton DeleteButton;
	private JLabel jLabel4;
	private JLabel jLabel5;
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
	
	public FeedbackInformation(Vector items, Vector names) {
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
				this.setTitle("Search a Feedback");
				{
					resultFBText = new JTextField();
					getContentPane().add(resultFBText);
					resultFBText.setBounds(548, 147, 105, 28);
				}
				
				
				
				
				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(308, 98, 105, 28);
				}
				{
					partText = new JTextField();
					getContentPane().add(partText);
					partText.setBounds(306, 147, 110, 28);
				}
				{
					reasonText = new JTextField();
					getContentPane().add(reasonText);
					reasonText.setBounds(420, 254, 323, 82);
				}
				{
					solutionText = new JTextField();
					getContentPane().add(solutionText);
					solutionText.setBounds(424, 380, 319, 74);
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
					jLabel1.setText("Revision of feedback:");
					jLabel1.setBounds(504, 98, 274, 28);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("ID:");
					jLabel2.setBounds(245, 98, 63, 28);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Part:");
					jLabel3.setBounds(245, 147, 63, 28);
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setBounds(147, 7, 154, 28);
					jLabel4.setFont(new java.awt.Font("Tahoma",1,14));
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
					jScrollPane1.setBounds(31, 46, 157, 158);
					{
						ListModel ItemListModel = new DefaultComboBoxModel(
								itemNameContainer);
						ItemList = new JList();
						jScrollPane1.setViewportView(ItemList);
						ItemList.setModel(ItemListModel);
						ItemList.setBounds(62, 97, 136, 143);
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
								solutionText.setText(fb.getSolution());
								reasonText.setText(fb.getReason());
								
								
							}
						});
					}
				}

				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("Reason:");
					jLabel5.setBounds(257, 257, 95, 32);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText("Solution:");
					jLabel6.setBounds(246, 369, 106, 32);
				}

				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-9, -22, 889, 700);
					
				}

			}
			this.setSize(861, 572);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

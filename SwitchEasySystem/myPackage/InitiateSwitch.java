package myPackage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
public class InitiateSwitch extends javax.swing.JDialog {
	private JTextField idText;
	private JTextField commentText;
	private JTextField supplierText;
	private JTextField priorityText;
	private JTextField reasonText;
	private JLabel comment;
	private JLabel supplier;
	private JLabel priority;
	private JLabel reason;
	private JButton AddButton;
	private JLabel jLabel5;
	private JList jList1;
	private JLabel jLabel4;
	private JButton jButton1;
	private JButton DeleteButton;
	private JButton CancelButton;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField initiatorText;
	private JTextField partText;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();
	private Vector switchContainer = new Vector();
	//private DefaultListModel listModel = new DefaultListModel();

	/**
	* Auto-generated main method to display this JDialog
	*/

	public InitiateSwitch(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			
			{
				getContentPane().setLayout(null);
				this.setTitle("Initiate a switch");
			

				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(165, 197, 143, 28);
					idText.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					partText = new JTextField();
					getContentPane().add(partText);
					partText.setBounds(158, 263, 140, 28);
					partText.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					initiatorText = new JTextField();
					getContentPane().add(initiatorText);
					initiatorText.setBounds(158, 113, 144, 28);
					initiatorText.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Initiator:");
					jLabel1.setBounds(54, 112, 133, 28);
					jLabel1.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Switch ID:");
					jLabel2.setBounds(43, 190, 141, 28);
					jLabel2.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Part:");
					jLabel3.setBounds(60, 265, 63, 28);
					jLabel3.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					AddButton = new JButton();
					getContentPane().add(AddButton);
					AddButton.setText("Add");
					AddButton.setBounds(129, 478, 84, 28);
					AddButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/add.png")));
					AddButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("AddButton.actionPerformed, event="
									+ evt);
							//TODO add your code for AddButton.actionPerformed
							String in = initiatorText.getText(); // get name from textbox
							String pt = partText.getText(); // get brand from textbox
							String id = idText.getText(); //cast text to double
							String  r= reasonText.getText();
							String prio = priorityText.getText();
							String sp = supplierText.getText();
							String com = commentText.getText();
							
				
							Switch newItem= new Switch(in, id, pt,prio,sp,r,com); 
							
							itemContainer.add(newItem); // add new item into the container
							itemNameContainer.add(newItem.getInitiator());
							
							
								
							
							//Create a new workbook for writing data
							HSSFWorkbook wb2 = new HSSFWorkbook();
							//Create a new sheet:
							HSSFSheet newsheet = wb2.createSheet("AddedSwitch");
							//Create a new row:
							for (int i=0; i<1; i++){
								HSSFRow newrow = newsheet.createRow(i);
								for (short j=0; j<7; j++){
								
								HSSFCell cell = newrow.createCell(j);
							
									 
									if(j == 0) {
										cell.setCellValue(in);
										
									}
									else if(j==1){
										cell.setCellValue(pt);
									}
									else if(j==2){
										cell.setCellValue(id);
									}
									else if(j==3){
										cell.setCellValue(r);
									}
									else if(j==4){
										cell.setCellValue(prio);
									}
									else if(j==5){
										cell.setCellValue(sp);
									}
									else if(j==6){
										cell.setCellValue(com);
									}
									
									//Write the book into the output file stream
									try {
										wb2.write(new FileOutputStream("C://Users/attri/Desktop/SwitchEasySystem_Group#2/newSwitch.xls"));
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									FileOutputStream os;
									//Close the output file stream
									
										}
									
							}	
							
							
							
							jList1.updateUI();	// Update the list after adding new item.
							initiatorText.setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							priorityText.setText(null);
							supplierText.setText(null);
							commentText.setText(null); // clean up the textbox
								
						}
					});
				}
			
				
				{
					CancelButton = new JButton();
					getContentPane().add(CancelButton);
					CancelButton.setText("Close");
					CancelButton.setBounds(724, 478, 91, 28);
					CancelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/leave.png")));
					CancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("CancelButton.actionPerformed, event="
									+ evt);
							//TODO add your code for CancelButton.actionPerformed
							dispose();
						}
					});
				}
				{
					ListModel jList1Model = new DefaultComboBoxModel(
						itemNameContainer);
					jList1 = new JList();
					getContentPane().add(jList1);
					jList1.setModel(jList1Model);
					jList1.setBounds(815, 161, 156, 269);
					jList1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Delete");
					DeleteButton.setBounds(320, 478, 91, 28);
					DeleteButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/delete.png")));
					DeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("DeleteButton.actionPerformed, event="
									+ evt);
							//TODO add your code for DeleteButton.actionPerformed
							int selindex = jList1.getSelectedIndex();
							String itm = (String) jList1.getSelectedValue(); //get selected item from list
							itemNameContainer.remove(itm);
							itemContainer.remove(selindex); // remove the selected item from the container
							jList1.updateUI(); // then update the list to reflect the delete.
						}
					});
				}
				{
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("Initiate a switch");
					jLabel4.setBounds(371, 42, 284, 28);
					jLabel4.setFont(new java.awt.Font("Arial",1,28));
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Refresh");
					jButton1.setBounds(526, 478, 84, 28);
					jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/refresh.png")));
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("jButton1.actionPerformed, event="
									+ evt);
							//TODO add your code for jButton1.actionPerformed
							jList1.updateUI();
							initiatorText.setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							priorityText.setText(null);
							supplierText.setText(null);
							commentText.setText(null); // clean up the textbox
						}
					});
				}
				{
					reason = new JLabel();
					getContentPane().add(reason);
					reason.setText("Reason:");
					reason.setBounds(401, 120, 120, 32);
					reason.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					priority = new JLabel();
					getContentPane().add(priority);
					priority.setText("Priority:");
					priority.setBounds(53, 325, 75, 32);
					priority.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					supplier = new JLabel();
					getContentPane().add(supplier);
					supplier.setText("Supplier:");
					supplier.setBounds(41, 392, 172, 32);
					supplier.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					comment = new JLabel();
					getContentPane().add(comment);
					comment.setText("Comment:");
					comment.setBounds(396, 274, 135, 32);
					comment.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					reasonText = new JTextField();
					getContentPane().add(reasonText);
					reasonText.setBounds(549, 120, 207, 117);
					reasonText.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					priorityText = new JTextField();
					getContentPane().add(priorityText);
					priorityText.setBounds(158, 336, 149, 29);
					priorityText.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					supplierText = new JTextField();
					getContentPane().add(supplierText);
					supplierText.setBounds(158, 394, 142, 27);
					supplierText.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					commentText = new JTextField();
					getContentPane().add(commentText);
					commentText.setBounds(549, 279, 201, 143);
					commentText.setFont(new java.awt.Font("Arial",0,24));
				}
				
				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-4, 2, 1039, 700);
					
				}
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("Switch List");
					jLabel5.setBounds(821, 110, 138, 32);
					jLabel5.setFont(new java.awt.Font("Arial",0,24));
				}

			}
			this.setSize(1008, 671);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateList(){
		
	}

}

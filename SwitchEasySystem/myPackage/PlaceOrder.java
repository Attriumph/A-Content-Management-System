package myPackage;
//4.26 feedback界面ok，下一步需要进行feedback和feedbackprocessor
//4.26要在上一层读feedback表
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
import javax.swing.JScrollPane;
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
public class PlaceOrder extends javax.swing.JDialog {
	private JTextField idText;
	private JTextField linkText;
	private JTextField supplierText;
	private JLabel comment;
	private JLabel reason;
	private JButton AddButton;
	private JLabel jLabel5;
	private JScrollPane jScrollPane1;
	private JLabel jLabel6;
	private JList jList1;
	private JLabel jLabel4;
	private JButton jButton1;
	private JButton DeleteButton;
	private JButton CancelButton;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField quantityText;
	private JTextField priorityText;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();
	//private DefaultListModel listModel = new DefaultListModel();

	/**
	* Auto-generated main method to display this JDialog
	*/

	public PlaceOrder(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Place An Order");

				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(343, 121, 140, 28);
				}
				{
					priorityText = new JTextField();
					getContentPane().add(priorityText);
					priorityText.setBounds(343, 181, 140, 28);
				}
				{
					quantityText = new JTextField();
					getContentPane().add(quantityText);
					quantityText.setBounds(343, 241, 140, 28);
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Quantity:");
					jLabel1.setBounds(184, 241, 131, 28);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Item:");
					jLabel2.setBounds(207, 122, 108, 28);
					jLabel2.setFont(new java.awt.Font("Arial",0,24));
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Priority:");
					jLabel3.setBounds(201, 181, 173, 28);
				}
				{
					AddButton = new JButton();
					getContentPane().add(AddButton);
					AddButton.setText("Add");
					AddButton.setBounds(625, 361, 84, 28);
					AddButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("AddButton.actionPerformed, event="
									+ evt);
							//TODO add your code for AddButton.actionPerformed
							String id = idText.getText(); // get name from textbox
							String pri = priorityText.getText(); // get brand from textbox
							String qu = quantityText.getText();
							String sp = supplierText.getText();
							String l = linkText.getText();
							
							Feedback newItem= new Feedback(id,pri,qu,sp,l); // create a new item instance
							itemContainer.add(newItem); // add new item into the container
							itemNameContainer.add(newItem.getID());
							
							//Create a new workbook for writing data
							HSSFWorkbook wb2 = new HSSFWorkbook();
							//Create a new sheet:
							HSSFSheet newsheet = wb2.createSheet("AddedOrder");
							//Create a new row:
							for (int i=0; i<1; i++){
								HSSFRow newrow = newsheet.createRow(i);
								for (short j=0; j<5; j++){
								
								HSSFCell cell = newrow.createCell(j);
							
									 
									if(j == 0) {
										cell.setCellValue(id);
										
									}
									else if(j==1){
										cell.setCellValue(pri);
									}
									else if(j==2){
										cell.setCellValue(qu);
									}
									else if(j==3){
										cell.setCellValue(sp);
									}
									else if(j==4){
										cell.setCellValue(l);
									}
									
									
									//Write the book into the output file stream
									try {
										wb2.write(new FileOutputStream("C://Users/attri/Desktop/SwitchEasySystem_Group#2/newOrder.xls"));
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
							priorityText.setText(null); // clean up the textbox
							quantityText.setText(null);
							idText.setText(null);
							supplierText.setText(null); // clean up the textbox
							linkText.setText(null); // clean up the textbox
							
						}
					});
				}
				{
					CancelButton = new JButton();
					getContentPane().add(CancelButton);
					CancelButton.setText("Close");
					CancelButton.setBounds(634, 490, 91, 28);
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
					jList1.setBounds(619, 76, 114, 231);
					jList1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Delete");
					DeleteButton.setBounds(627, 405, 91, 28);
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
					jLabel4.setText("Place an Order");
					jLabel4.setBounds(250, 49, 196, 28);
					jLabel4.setFont(new java.awt.Font("Arial",1,26));
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Refresh");
					jButton1.setBounds(634, 451, 84, 28);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("jButton1.actionPerformed, event="
									+ evt);
							//TODO add your code for jButton1.actionPerformed
							jList1.updateUI();
							priorityText.setText(null); // clean up the textbox
							quantityText.setText(null);
							idText.setText(null);
							supplierText.setText(null); // clean up the textbox
							linkText.setText(null); 
						}
					});
				}
				{
					reason = new JLabel();
					getContentPane().add(reason);
					reason.setText("Chosen Supplier:");
					reason.setBounds(134, 308, 201, 32);
				}
				{
					comment = new JLabel();
					getContentPane().add(comment);
					comment.setText("Link:");
					comment.setBounds(134, 373, 106, 32);
				}
				{
					supplierText = new JTextField();
					getContentPane().add(supplierText);
					supplierText.setBounds(340, 307, 143, 35);
				}
				{
					linkText = new JTextField();
					getContentPane().add(linkText);
					linkText.setBounds(212, 370, 407, 39);
				}
				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-7, -3, 821, 700);
					
				}
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("(technicial documents, such Drawing");
					jLabel5.setBounds(129, 409, 599, 32);
				}
				{
					jLabel6 = new JLabel();
					getContentPane().add(jLabel6);
					jLabel6.setText(", Instruction and etc.)");
					jLabel6.setBounds(141, 448, 223, 32);
				}
				

			}
			this.setSize(818, 590);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateList(){
		
	}

}

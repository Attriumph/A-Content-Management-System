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
public class SubmitFeedback extends javax.swing.JDialog {
	private JTextField idText;
	private JTextField solutionText;
	private JTextField reasonText;
	private JLabel comment;
	private JLabel reason;
	private JButton AddButton;
	private JLabel jLabel5;
	private JLabel jLabel1;
	private JList jList1;
	private JLabel jLabel4;
	private JButton jButton1;
	private JButton DeleteButton;
	private JButton CancelButton;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JTextField resultFBText;
	private JTextField partText;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();
	//private DefaultListModel listModel = new DefaultListModel();

	/**
	* Auto-generated main method to display this JDialog
	*/

	public SubmitFeedback(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Submit A Feedback");

				{
					idText = new JTextField();
					getContentPane().add(idText);
					idText.setBounds(255, 70, 140, 28);
				}
				{
					partText = new JTextField();
					getContentPane().add(partText);
					partText.setBounds(253, 123, 140, 35);
				}
				{
					resultFBText = new JTextField();
					getContentPane().add(resultFBText);
					resultFBText.setBounds(253, 177, 137, 35);
				}
				{
					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText(" Object ID:");
					jLabel2.setBounds(102, 70, 198, 28);
				}
				{
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Feedback for");
					jLabel3.setBounds(76, 110, 246, 28);
				}
				{
					AddButton = new JButton();
					getContentPane().add(AddButton);
					AddButton.setText("Add");
					AddButton.setBounds(65, 381, 84, 28);
					AddButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("AddButton.actionPerformed, event="
									+ evt);
							//TODO add your code for AddButton.actionPerformed
							String id = idText.getText(); // get name from textbox
							String pt = partText.getText(); // get brand from textbox
							String rv = resultFBText.getText();
							String  r= reasonText.getText();
							String sl = solutionText.getText();
							
							Feedback newItem= new Feedback(id,pt,rv,r,sl); // create a new item instance
							itemContainer.add(newItem); // add new item into the container
							itemNameContainer.add(newItem.getID());
							
							//Create a new workbook for writing data
							HSSFWorkbook wb3 = new HSSFWorkbook();
							//Create a new sheet:
							HSSFSheet newsheet = wb3.createSheet("AddedFeedback");
							//Create a new row:
							for (int i=0; i<1; i++){
								HSSFRow newrow = newsheet.createRow(i);
								for (short j=0; j<5; j++){
								
								HSSFCell cell = newrow.createCell(j);
							
									 
									if(j == 0) {
										cell.setCellValue(id);
										
									}
									else if(j==1){
										cell.setCellValue(pt);
									}
									else if(j==2){
										cell.setCellValue(rv);
									}
									else if(j==3){
										cell.setCellValue(r);
									}
									else if(j==4){
										cell.setCellValue(sl);
									}
									
									
									//Write the book into the output file stream
									try {
										wb3.write(new FileOutputStream("C://Users/attri/Desktop/SwitchEasySystem_Group#2/newFeedback.xls"));
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
							resultFBText.setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							solutionText.setText(null); // clean up the textbox
							
						}
					});
				}
				{
					CancelButton = new JButton();
					getContentPane().add(CancelButton);
					CancelButton.setText("Close");
					CancelButton.setBounds(447, 382, 91, 28);
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
					jList1.setBounds(582, 83, 114, 242);
					jList1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					DeleteButton = new JButton();
					getContentPane().add(DeleteButton);
					DeleteButton.setText("Delete");
					DeleteButton.setBounds(192, 381, 91, 28);
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
					jLabel4.setText("Submit Feedback");
					jLabel4.setBounds(269, 30, 251, 28);
					jLabel4.setFont(new java.awt.Font("Arial",1,26));
				}
				{
					jButton1 = new JButton();
					getContentPane().add(jButton1);
					jButton1.setText("Refresh");
					jButton1.setBounds(319, 382, 84, 28);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
								.println("jButton1.actionPerformed, event="
									+ evt);
							//TODO add your code for jButton1.actionPerformed
							jList1.updateUI();
							resultFBText.setText(null); // clean up the textbox
							partText.setText(null);
							idText.setText(null);
							reasonText.setText(null); // clean up the textbox
							solutionText.setText(null); // clean up the textbox
						}
					});
				}
				{
					reason = new JLabel();
					getContentPane().add(reason);
					reason.setText("Reason:");
					reason.setBounds(136, 249, 120, 32);
				}
				{
					comment = new JLabel();
					getContentPane().add(comment);
					comment.setText("Solution:");
					comment.setBounds(132, 314, 106, 32);
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Result(Y/N):");
					jLabel1.setBounds(93, 178, 124, 32);
				}
				{
					reasonText = new JTextField();
					getContentPane().add(reasonText);
					reasonText.setBounds(255, 234, 262, 63);
				}
				{
					jLabel5 = new JLabel();
					getContentPane().add(jLabel5);
					jLabel5.setText("(Feedback/Switch):");
					jLabel5.setBounds(43, 134, 198, 32);
				}
				{
					solutionText = new JTextField();
					getContentPane().add(solutionText);
					solutionText.setBounds(256, 314, 262, 39);
				}

				{
					JLabel background2 = new JLabel();
					getContentPane().add(background2);
					ImageIcon icon = new ImageIcon("images/background.jpg");
					background2.setIcon(icon);
					background2.setBounds(-12, 2, 821, 700);
					
				}
				
			}
			this.setSize(735, 495);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateList(){
		
	}

}

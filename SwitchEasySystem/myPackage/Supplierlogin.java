package myPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


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
public class Supplierlogin extends javax.swing.JDialog {
	private JButton jButton1;
	private JLabel jLabel1;
	private JButton jButton2;
	private Vector containerOfItems = new Vector();
	private Vector containerOfItemNames = new Vector();
	private JLabel jLabel2;
	private JPasswordField jPasswordField1;
	private JTextField usernameField;
	
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();
	private Vector accountContainer = new Vector();
	public Supplierlogin(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		
		initGUI();
	}
	
	public static void main(String[] args) {
		Supplierlogin inst = new Supplierlogin();
		inst.setVisible(true);
	}
	
	public Supplierlogin() {
		super();
		//Populate instances in from reading an Excel file:
		try {
			
this.setLocationRelativeTo(null);
			
			//Create an input file stream for reading from an Excel file.
			POIFSFileSystem fs =
				new POIFSFileSystem(new FileInputStream("Accounts.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);

			HSSFSheet sheet1 = wb.getSheet("Accounts");
		
			RowProcessor accountip = AccountsProcessor.getInstance();
			
			Vector items = accountip.process(sheet1);
			accountContainer = items;//¶ªÊ§µÄ´úÂë
			for (int i=0; i<items.size(); i++)
			

			{
				Accounts item = (Accounts)items.get(i);
				containerOfItems.add(item);
				containerOfItemNames.add(item.getName());
				System.out.println( item.getName() + " " + item.getPasscode() + " " + item.getType());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Log in");
				jButton1.setBounds(145, 309, 175, 51);
				jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/login.png")));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton1.actionPerformed, event="
							+ evt);
						//TODO add your code for jButton1.actionPerformed
						String username = usernameField.getText();
						System.out.println(username);
						int passcode = Integer.parseInt(jPasswordField1.getText());
				        System.out.println(passcode);
						boolean open=false;
						for (int i=0; i<accountContainer.size(); i++){
						Accounts item = (Accounts)accountContainer.get(i);
						System.out.println(item.getName()+" " + item.getPasscode() + " " + item.getType());
						if (item.Accountscheck(username,passcode,"supplier")==true)
						{UIforSupplier sup = new UIforSupplier ();
						sup.show();
						open=true;
						dispose();}
						}
						if (open==false){
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null, "Wrong Username/Password, PLEASE input right Username/Password", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, options, options[0]);}
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Cancel");
				jButton2.setBounds(488, 312, 197, 48);
				jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit.png")));
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton2.actionPerformed, event="
							+ evt);
						//TODO add your code for jButton2.actionPerformed
						dispose();
					}
				});
			}
			
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Username:");
				jLabel1.setBounds(190, 116, 331, 28);
				jLabel1.setDoubleBuffered(true);
				jLabel1.setFont(new java.awt.Font("Arial",1,26));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Password:");
				jLabel2.setBounds(187, 194, 158, 32);
				jLabel2.setFont(new java.awt.Font("Arial",1,26));
			}
			{
				usernameField = new JTextField();
				getContentPane().add(usernameField);
				usernameField.setBounds(357, 116, 211, 39);
			}
			{
				jPasswordField1 = new JPasswordField();
				getContentPane().add(jPasswordField1);
				jPasswordField1.setBounds(357, 191, 217, 39);
			}
			
			
			{
				JLabel background2 = new JLabel();
				getContentPane().add(background2);
				ImageIcon icon = new ImageIcon("images/background.jpg");
				background2.setIcon(icon);
				background2.setBounds(503, 11, 821, 700);
				
			}


			pack();
			this.setSize(826, 481);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

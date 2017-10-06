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
public class UserChoose extends javax.swing.JDialog {
	private JButton jButton1;
	private JLabel jLabel1;
	private JButton jButton2;
	private Vector containerOfItems = new Vector();
	private Vector containerOfItemNames = new Vector();
	private JLabel user4;
	private JLabel user3;
	private Vector containerOfAccounts = new Vector();
	private Vector containerOfName = new Vector();
	private JButton QCE;
	private JButton DE;
	private JLabel background;
	private JLabel user1;
	private JLabel user2;
	
	
	public static void main(String[] args) {
		UserChoose inst = new UserChoose();
		inst.setVisible(true);
		
	}
	
	public UserChoose() {
		super();
		//Populate instances in from reading an Excel file:
		try {
			this.setLocationRelativeTo(null);
			POIFSFileSystem fs =
				new POIFSFileSystem(new FileInputStream("accounts.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			
			HSSFSheet sheet1 = wb.getSheet("Accounts");
			RowProcessor cpip = AccountsProcessor.getInstance();
			Vector items = cpip.process(sheet1);
			for (int i=0; i<items.size(); i++)
		

			{
				Accounts item = (Accounts)items.get(i);
				containerOfAccounts.add(item);
				containerOfName.add(item.getName());
				System.out.println( item.getName()+ " " + item.getPasscode() + " " + item.getType());
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
			this.setTitle("Switch Easy System 1.0 ");
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Supplier");
				jButton1.setBounds(687, 574, 148, 41);
				jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/u4.png")));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton1.actionPerformed, event="
							+ evt);
						//TODO add your code for jButton1.actionPerformed
						Supplierlogin userchoose4 = new Supplierlogin();
						userchoose4.show();
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("ME");
				jButton2.setBounds(218, 570, 180, 45);
				jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/u3.png")));
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton2.actionPerformed, event="
							+ evt);
						//TODO add your code for jButton2.actionPerformed
						MElogin userchoose3 = new MElogin();
						userchoose3.show();
					}
				});
			}
			
			
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(190, 116, 331, 28);
				jLabel1.setDoubleBuffered(true);
				jLabel1.setFont(new java.awt.Font("Tahoma",0,16));
			}
			{
				DE = new JButton();
				getContentPane().add(DE);
				DE.setText("Design Engineer");
				DE.setBounds(190, 294, 189, 47);
				DE.setOpaque(true);
				DE.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/u1.png")));
				
				DE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("DE.actionPerformed, event="+evt);
						//TODO add your code for DE.actionPerformed
						DElogin userchoose = new DElogin();
						userchoose.show();
					}
				});
			}
			{
				QCE = new JButton();
				getContentPane().add(QCE);
				QCE.setText("QCE");
				QCE.setBounds(682, 288, 141, 39);
				QCE.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/u2.png")));
				QCE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("QCE.actionPerformed, event="+evt);
						//TODO add your code for QCE.actionPerformed
						QCElogin userchoose2 = new QCElogin();
						userchoose2.show();
					}
				});
			}
			{
				user1 = new JLabel();
				getContentPane().add(user1);
				ImageIcon icon = new ImageIcon("images/DE.png");
				user1.setIcon(icon);
				user1.setBounds(202, 24, 340, 264);
			}
			{
				user2 = new JLabel();
				getContentPane().add(user2);
				ImageIcon icon = new ImageIcon("images/QCE.png");
				user2.setIcon(icon);
				user2.setBounds(707, 28, 302, 261);
			}
			{
				user3 = new JLabel();
				getContentPane().add(user3);
				ImageIcon icon = new ImageIcon("images/Me1.png");
				user3.setIcon(icon);
				user3.setBounds(91, 397, 314, 148);
			}
			{
				user4 = new JLabel();
				getContentPane().add(user4);
				ImageIcon icon = new ImageIcon("images/suppier.png");
				user4.setIcon(icon);
				user4.setBounds(656, 376, 223, 146);
			}
			{
				background = new JLabel();
				getContentPane().add(background);
				ImageIcon icon = new ImageIcon("images/background.jpg");
				background.setIcon(icon);
				background.setBounds(9, 4, 1015, 761);
			}
			
			pack();
			this.setSize(1044, 734);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

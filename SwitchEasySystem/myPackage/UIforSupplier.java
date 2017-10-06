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
public class UIforSupplier extends javax.swing.JDialog {
	private JButton jButton1;
	private JLabel jLabel1;
	private JButton jButton2;
	private Vector containerOfItems = new Vector();
	private Vector containerOfItemNames = new Vector();
	private Vector containerOfNewSwitch = new Vector();
	private Vector containerOfNewSwitchNames = new Vector();
	private Vector containerOfFeedbacks = new Vector();
	private Vector containerOfFeedbackNames = new Vector();
	private Vector containerOfOrders = new Vector();
	private Vector containerOfOrderNames = new Vector();
	private Vector containerOfNewOrders = new Vector();
	private Vector containerOfNewOrderNames = new Vector();
	private JLabel jLabel3;
	private JLabel jLabel4;
	private Vector containerOfNewOrder = new Vector();
	
	private JButton jButton7;

	private JLabel jLabel2;
	private JButton jButton6;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private Vector itemContainer = new Vector();
	private Vector itemNameContainer = new Vector();
	
	public UIforSupplier(Vector items, Vector names) {
		super();
		itemContainer = items;
		itemNameContainer = names;
		
		initGUI();
	}
	
	public static void main(String[] args) {
		UIforSupplier inst = new UIforSupplier();
		inst.setVisible(true);
	}
	
	public UIforSupplier() {
		super();
		//Populate instances in from reading an Excel file:
		try {
			
			//Create an input file stream for reading from an Excel file.
			POIFSFileSystem fs =
				new POIFSFileSystem(new FileInputStream("Book1.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
		
			HSSFSheet sheet1 = wb.getSheet("Switch");
			HSSFSheet sheet2 = wb.getSheet("Order");
			HSSFSheet sheet3 = wb.getSheet("Feedback");
			
			RowProcessor swip = SwitchProcessor.getInstance();
			RowProcessor odip = OrderProcessor.getInstance();
			RowProcessor feedbackip = FeedbackProcessor.getInstance();
			
			Vector items = swip.process(sheet1);
			Vector orders = odip.process(sheet2);
			Vector feedbacks = feedbackip.process(sheet3);
			System.out.println("Feedback size: " + feedbacks.size());
			for (int i=0; i<items.size(); i++)
			
			{
				Switch item = (Switch)items.get(i);
				containerOfItems.add(item);
				containerOfItemNames.add(item.getInitiator());
				System.out.println( item.getInitiator() + " " + item.getID() + " " + item.getPart()
						+ " " + item.getPriority() + " " + item.getSupplier()+ " " + item.getReason() + " " + item.getComment());
			}
			//¶Ábook1£¬sheet2
			for (int i=0; i<orders.size(); i++)
			{
				Order order = (Order)orders.get(i);
				containerOfOrders.add(order);
				containerOfOrderNames.add(order.getID());
				System.out.println( order.getID() + " " + order.getPriority() + " " + order.getQuantity()
						+ " " + order.getSupplier() + " " + order.getLink());
			}
			
			
			for (int i=0; i<feedbacks.size(); i++)
		
			{
				System.out.println("feedbacksize="+feedbacks.size());
				Feedback feedback = (Feedback)feedbacks.get(i);
				containerOfFeedbacks.add(feedback);
				containerOfFeedbackNames.add(feedback.getID());
				System.out.println( feedback.getID() + " " + feedback.getPart() + " " + feedback.getRevision()+ " " + feedback.getReason()+ " " + feedback.getSolution());
			}
			//read new Switch
			POIFSFileSystem fs2 =
				new POIFSFileSystem(new FileInputStream("newSwitch.xls"));
			HSSFWorkbook wb2 = new HSSFWorkbook(fs2);
			HSSFSheet sheet11 = wb2.getSheet("AddedSwitch");
			RowProcessor swip2 = NewSwitchProcessor.getInstance();
			Vector items2 = swip2.process(sheet11);
			System.out.println("size="+items2.size());
			
			for (int i=0; i<items2.size(); i++)
				
			{
				System.out.println("size2="+items.size());
				Switch item = (Switch)items2.get(i);
				containerOfNewSwitch.add(item);
				System.out.println("Newsiwtch:"+containerOfNewSwitch.get(i));
				containerOfNewSwitchNames.add(item.getInitiator());
				System.out.println( item.getInitiator() + " " + item.getID() + " " + item.getPart()
						+ " " + item.getPriority() + " " + item.getSupplier()+ " " + item.getReason() + " " + item.getComment());
			}
			//read new Order
			POIFSFileSystem fs3 =
				new POIFSFileSystem(new FileInputStream("newOrder.xls"));
			HSSFWorkbook wb3 = new HSSFWorkbook(fs3);
			HSSFSheet sheet21 = wb3.getSheet("AddedOrder");
			RowProcessor odip2 = NewOrderProcessor.getInstance();
			Vector items3 = odip2.process(sheet21);
			for (int i=0; i<items3.size(); i++)
			{
				System.out.println("size3="+items3.size());
				Order item1 = (Order)items3.get(i);
				containerOfNewOrder.add(item1);
				System.out.println("NewOrder:"+containerOfNewOrder.get(i));
				containerOfNewOrderNames.add(item1.getID());
				System.out.println( item1.getID() + " " + item1.getPriority() + " " + item1.getQuantity()
						+ " " + item1.getSupplier()+ " " + item1.getLink() );
			}
			
			
		}
		
		
		
		
		catch (FileNotFoundException e) {
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
			this.setTitle("UI for Supplier");
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Initiate Switch");
				jButton1.setBounds(130, 184, 231, 43);
				jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/start.png")));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton1.actionPerformed, event="
							+ evt);
						//TODO add your code for jButton1.actionPerformed
						InitiateSwitch initiateSwitch = new InitiateSwitch (containerOfItems, containerOfItemNames);
						initiateSwitch.show();
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Switch Information");
				jButton2.setBounds(129, 260, 232, 44);
				jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/search.png")));
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton2.actionPerformed, event="
							+ evt);
						//TODO add your code for jButton2.actionPerformed
						SwitchInformationToDE recDialog = new SwitchInformationToDE(containerOfItems, containerOfItemNames);
						recDialog.show();
					}
				});
			}
			{
				jButton5 = new JButton();
				getContentPane().add(jButton5);
				jButton5.setText("Order Information");
				jButton5.setBounds(708, 262, 236, 39);
				jButton5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/search.png")));
				jButton5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton5.actionPerformed, event="+evt);
						//TODO add your code for jButton5.actionPerformed
						OrderInformation orderview = new OrderInformation(containerOfOrders, containerOfOrderNames);
						orderview.show();
					}
				});
			}
			{
				jButton4 = new JButton();
				getContentPane().add(jButton4);
				jButton4.setText("Feedback Information");
				jButton4.setBounds(402, 262, 247, 39);
				jButton4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/search.png")));
				jButton4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton4.actionPerformed, event="+evt);
						//TODO add your code for jButton4.actionPerformed
						
						FeedbackInformation fbview = new FeedbackInformation(containerOfItems, containerOfItemNames);
						fbview.show();
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Function");
				jLabel1.setBounds(450, 102, 331, 28);
				jLabel1.setDoubleBuffered(true);
				jLabel1.setFont(new java.awt.Font("Arial",1,26));
			}
			{
				jButton6 = new JButton();
				getContentPane().add(jButton6);
				jButton6.setText("New Switch ");
				jButton6.setBounds(195, 472, 145, 39);
				jButton6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/switchinformation.gif")));
				jButton6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton6.actionPerformed, event="+evt);
						//TODO add your code for jButton6.actionPerformed
						
						NewSwitchInformation recDialog = new NewSwitchInformation(containerOfNewSwitch, containerOfNewSwitchNames);
						recDialog.show();
					}
				});
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Submit Feedback");
				jButton3.setBounds(407, 186, 198, 39);
				jButton3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/send.png")));
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton3.actionPerformed, event="+evt);
						//TODO add your code for jButton3.actionPerformed
						SubmitFeedback fbde = new SubmitFeedback  (containerOfItems, containerOfItemNames);
						fbde.show();
					}
				});
				
				
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Notification");
				jLabel2.setBounds(438, 349, 158, 32);
				jLabel2.setFont(new java.awt.Font("Arial",1,26));
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("==============================================================================================================================================================================================");
				jLabel3.setBounds(-14, 136, 1773, 32);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("===================================================================================================================================================================");
				jLabel4.setBounds(-27, 393, 2160, 32);
			}
			{
				jButton7 = new JButton();
				getContentPane().add(jButton7);
				jButton7.setText("New Order");
				jButton7.setBounds(648, 464, 130, 39);
				jButton7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/neworder.gif")));
				jButton7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton7.actionPerformed, event="+evt);
						//TODO add your code for jButton7.actionPerformed
						NewOrderInformation recDialog = new NewOrderInformation(containerOfNewOrder, containerOfNewOrderNames);
						recDialog.show();
						
					}
				});
			}

			{
				JLabel background2 = new JLabel();
				getContentPane().add(background2);
				ImageIcon icon = new ImageIcon("images/background.jpg");
				background2.setIcon(icon);
				background2.setBounds(-2, -5, 1034, 711);
				
			}

			pack();
			this.setSize(1010, 698);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

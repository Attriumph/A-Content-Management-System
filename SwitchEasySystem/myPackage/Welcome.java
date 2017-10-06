package myPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class Welcome extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton jButton1;
	private JLabel Background;
	private JMenu jMenu2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private JMenuBar About;
	private JButton jButton2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Welcome inst = new Welcome();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Welcome() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Switch Easy System 1.0__By AME of USC");
			getContentPane().setForeground(new java.awt.Color(255,255,255));
			{
				About = new JMenuBar();
				setJMenuBar(About);
				{
					jMenu1 = new JMenu();
					About.add(jMenu1);
					jMenu1.setText("About");
					jMenu1.setFont(new java.awt.Font("Segoe UI",0,26));
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Introducation");
						jMenuItem1.setFont(new java.awt.Font("Segoe UI",0,26));
						jMenuItem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.out.println("jMenuItem1.actionPerformed, event="+evt);
								//TODO add your code for jMenuItem1.actionPerformed
								Introducation intro = new Introducation(null);
								intro.show();
							}
						});
					}
				}
				{
					jMenu2 = new JMenu();
					About.add(jMenu2);
					jMenu2.setText("Contact us");
					jMenu2.setFont(new java.awt.Font("Segoe UI",0,26));
				}
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Switch Easy System");
				jLabel1.setBounds(103, 168, 589, 93);
				jLabel1.setFont(new java.awt.Font("Agency FB",1,72));
				jLabel1.setForeground(new java.awt.Color(128,128,0));
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Enter");
				jButton1.setBounds(209, 484, 152, 46);
				jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/enter.png")));
				jButton1.setFont(new java.awt.Font("Segoe UI",0,28));
				jButton1.setForeground(new java.awt.Color(128,128,0));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton1.actionPerformed, event="+evt);
						//TODO add your code for jButton1.actionPerformed
						UserChoose usechoose = new UserChoose();
						usechoose.show();
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Exit");
				jButton2.setBounds(210, 590, 151, 46);
				jButton2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/leave.png")));
				jButton2.setFont(new java.awt.Font("Segoe UI",0,28));
				jButton2.setForeground(new java.awt.Color(128,128,0));
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButton2.actionPerformed, event="+evt);
						//TODO add your code for jButton2.actionPerformed
						dispose();
					}
				});
			}
			{
				Background = new JLabel();
				getContentPane().add(Background);
				ImageIcon icon = new ImageIcon("images/4.jpg");
				Background.setIcon(icon);
				Background.setBounds(-259, -72, 1673, 928);
			}
			pack();
			this.setSize(1400, 937);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}

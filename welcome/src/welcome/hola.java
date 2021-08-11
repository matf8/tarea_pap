package welcome;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Properties;

public class hola extends JFrame implements ActionListener{

	private JTextField t1;
	private JPasswordField p;
	private JLabel l1, l2, l3, l4, l5;
	private JButton b1, b2;	
	//public static String n = "";
	//public static boolean PASS_OK = false;

	public hola(){		
		setLayout(null);
		setTitle("welcome");
		getContentPane().setBackground(new Color(163,163,163));
		setIconImage(new ImageIcon(getClass().getResource("img/logoC.png")).getImage());
		setExtendedState(JFrame.ICONIFIED); // boton minimizar, pero arrancar minimizada la app
		setState(Frame.NORMAL);	// restore minimize

		ImageIcon imagen = new ImageIcon("img/img1.png");
		l1 = new JLabel(imagen);
		l1.setBounds(100,100,300,300);
		
		add(l1);

		l2 = new JLabel("LOG IN");			
		l2.setBounds(65,175,200,30);
		l2.setFont(new Font("Andale Mono", 3, 18));
		l2.setForeground(new Color(255,255,255));
		add(l2);

		l3 = new JLabel("user");
		l3.setBounds(45,200,200,30);
		l3.setFont(new Font("Euphemia", 1, 12));
		l3.setForeground(new Color(255,255,255));
		add(l3);

		p = new JPasswordField();
		p.setBounds(45,290,255,25);
		p.setBackground(new Color(244,244,244));
		add(p);
		l4 = new JLabel("pass");
		l4.setBounds(45,260,100,30);
		l4.setFont(new Font("Euphemia", 1, 12));
		l4.setForeground(new Color(255,255,255));
		add(l4);

		t1 = new JTextField();
		t1.setBounds(45,230,255,25);
		t1.setBackground(new Color(244,244,244));
		t1.setFont(new Font("Andale Mono", 1, 12));
		t1.setForeground(new Color(255,0,0));
		add(t1);
		
		b1 = new JButton("sign in");
		b1.setBounds(40,345,100,30);
		b1.setBackground(new Color(255,255,255));
		b1.setFont(new Font("Euphemia", 3, 14));
		b1.setForeground(new Color(0,0,0));
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("exit");
		b2.setBounds(160,345,100,30);
		b2.setBackground(new Color(255,255,255));
		b2.setFont(new Font("Euphemia", 3, 14));
		b2.setForeground(new Color(0,0,0));
		b2.addActionListener(this);
		add(b2);

	}
	
	
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b2){
			System.exit(0);
		}

		if (e.getSource() == b1){
			JOptionPane.showMessageDialog(null, "user unregistered");
				// log in check con bd
				/*String url = "jdbc:mysql://localhost:3306/user_ts"; 
				Properties info = new Properties();
				info.put("user", "root"); 
				info.put("password", "flashh");			
				Connection cn = DriverManager.getConnection(url, info);    
				PreparedStatement st = cn.prepareStatement("select user, password from usuarios where user = ?");
				n = t1.getText().trim() // get user
				st.setString(1, n);
				ResultSet rs = st.executeQuery();					
				if (rs.next()){
					do{
						String user = rs.getString("user");
						String pass = rs.getString("password");						
						System.out.println("user: " + user + " pass " + pass);
						if (user.equals(n)){
                           char[] input = p.getPassword();  // get password
						   String p = String.valueOf(input);
                           if (p.equals(pass))
                                PASS_OK = true;
						   else e1 = Err.P_OK;
						}
					} while (rs.next());
			*/
		}

	}
	
	public static void main(String[] args) {		

		hola k = new hola();
		k.setBounds(0,0,350,450);
		k.setVisible(true);
		k.setLayout(null);
		k.setLocationRelativeTo(null);
		k.setResizable(false);
	}
}	
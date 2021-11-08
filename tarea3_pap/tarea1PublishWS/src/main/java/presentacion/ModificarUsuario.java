package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interfaces.IControladorUsuario;
import datatypes.DtUsuario;
import datatypes.DtEspectador;
import datatypes.DtArtista;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ModificarUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorUsuario icon;	
	private JPasswordField txtPassword, txtPassword2;
	private JTextField txtNombre, txtApellido, txtCorreo, txtFnac, txtBio, txtUrl, txtDesc;
	private JLabel lbNickname, lblNombre, lbPassword, lbFramePass;
	private JButton bSeleccionar, bCancelar, bModificar, bAceptarPass, bAceptar;
	private JComboBox<String> cBUsuarios;	
	private final static String newline = "\n";
	private char [] p = new char [20];
	private JInternalFrame framePassword = new JInternalFrame();
	//private boolean cambioPass = false;
	//private String p1, p2;
	
	public ModificarUsuario(IControladorUsuario icon) {
		getContentPane().setBackground(new Color(0, 0, 51));	
		this.icon = icon;
		setResizable(false);        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Usuario");
		setBounds(100, 100, 496, 336);
		getContentPane().setLayout(null);	
		
		framePassword.setBackground(new Color(0, 0, 51));
		framePassword.setClosable(true);
		framePassword.setTitle("confirmaci\u00F3n");
		framePassword.setResizable(false);
		framePassword.setBounds(96, 65, 235, 169);
		framePassword.getContentPane().setLayout(null);
		getContentPane().add(framePassword);		
		
		lbFramePass = new JLabel("Re ingrese la password");
		lbFramePass.setForeground(SystemColor.text);
		lbFramePass.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbFramePass.setBounds(30, 25, 144, 20);
		framePassword.getContentPane().add(lbFramePass);
		
		txtPassword2 = new JPasswordField();		
		txtPassword2.setBounds(30, 56, 150, 20);		
		framePassword.getContentPane().add(txtPassword2);
		
		bAceptarPass = new JButton("");
		bAceptarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
		bAceptarPass.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/aceptar-icon-48px.png")));
		bAceptarPass.setToolTipText("Aceptar modificaci\u00F3n");
		bAceptarPass.setBorder(null);
		bAceptarPass.setBackground(new Color(0, 0, 51));
		bAceptarPass.setBounds(86, 91, 41, 37);
		framePassword.getContentPane().add(bAceptarPass);				
				
		lbNickname = new JLabel("Nickname");
		lbNickname.setForeground(SystemColor.text);
		lbNickname.setFont(new Font("Arial", Font.BOLD, 11));
		lbNickname.setBounds(20, 20, 125, 14);
		getContentPane().add(lbNickname);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(SystemColor.text);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 11));
	    lblNombre.setBounds(20, 65, 81, 14);
	    getContentPane().add(lblNombre);
		
	    txtNombre = new JTextField();	    
	    txtNombre.setBackground(SystemColor.inactiveCaption);
	    txtNombre.setBounds(20, 80, 130, 19);
	    getContentPane().add(txtNombre);
	    txtNombre.setColumns(10);		
		
		cBUsuarios = new JComboBox<String>();
		cBUsuarios.setBounds(20, 35, 125, 20);
		getContentPane().add(cBUsuarios);
		ArrayList<String> lU = icon.listarUsuarios();
		for (String s: lU) {
			cBUsuarios.addItem(s);
		}
		cBUsuarios.setSelectedItem(null);		
			
		bSeleccionar = new JButton("");
		bSeleccionar.setToolTipText("Mostrar datos");
		bSeleccionar.setBorderPainted(false);
		bSeleccionar.setForeground(new Color(0, 0, 51));
		bSeleccionar.setOpaque(false);
		bSeleccionar.setBackground(new Color(0, 0, 51));
		bSeleccionar.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/icono-modificar.png")));
		bSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarActionPerformed(e);				
			}
		});
		bSeleccionar.setBounds(165, 38, 39, 41);	
		getContentPane().add(bSeleccionar);		
		
		bAceptar = new JButton("");
		bAceptar.setBorder(null);
		bAceptar.setBackground(new Color(0, 0, 51));
		bAceptar.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/aceptar-icon-48px.png")));
		bAceptar.setToolTipText("Aceptar modificaci\u00F3n");
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				try {
					modificarActionPerformed(e);								
				} catch (Exception j) {
		            JOptionPane.showMessageDialog(bSeleccionar, j.getMessage(), "modificar usuario", JOptionPane.ERROR_MESSAGE);
				}			
			}
		});
		bAceptar.setBounds(283, 255, 48, 48);	
		getContentPane().add(bAceptar);		
				
		bCancelar = new JButton("");
		bCancelar.setBorder(null);
		bCancelar.setBackground(new Color(0, 0, 51));
		bCancelar.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/cancelar-icon-48px.png")));
		bCancelar.setToolTipText("Cancelar");
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarActionPerformed(e);
			}
		});
		bCancelar.setBounds(361, 255, 48, 48);
		getContentPane().add(bCancelar);
		
		JLabel lbApellido = new JLabel("Apellido");
		lbApellido.setForeground(SystemColor.text);
		lbApellido.setFont(new Font("Arial", Font.BOLD, 11));
		lbApellido.setBounds(20, 110, 81, 14);
		getContentPane().add(lbApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(SystemColor.inactiveCaption);
		txtApellido.setColumns(10);
		txtApellido.setBounds(20, 125, 130, 19);
		getContentPane().add(txtApellido);
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(SystemColor.inactiveCaption);
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(20, 170, 130, 19);
		getContentPane().add(txtCorreo);
		
		JLabel lbCorreo = new JLabel("Correo");
		lbCorreo.setForeground(SystemColor.text);
		lbCorreo.setFont(new Font("Arial", Font.BOLD, 11));
		lbCorreo.setBounds(20, 155, 81, 14);
		getContentPane().add(lbCorreo);
		
		txtFnac = new JTextField();
		txtFnac.setBackground(SystemColor.inactiveCaption);
		txtFnac.setColumns(10);
		txtFnac.setBounds(20, 215, 130, 19);
		getContentPane().add(txtFnac);
		
		JLabel lbFnac = new JLabel("Fecha de nacimiento");
		lbFnac.setForeground(SystemColor.text);
		lbFnac.setFont(new Font("Arial", Font.BOLD, 11));
		lbFnac.setBounds(20, 200, 125, 14);
		getContentPane().add(lbFnac);
		
		txtBio = new JTextField();
		txtBio.setBackground(SystemColor.inactiveCaption);
		txtBio.setEnabled(false);
		txtBio.setColumns(10);
		txtBio.setBounds(240, 80, 210, 44);
		getContentPane().add(txtBio);
		
		JLabel lbBio = new JLabel("Biograf\u00EDa");
		lbBio.setForeground(SystemColor.text);
		lbBio.setFont(new Font("Arial", Font.BOLD, 11));
		lbBio.setBounds(240, 65, 81, 14);
		getContentPane().add(lbBio);
		
		txtUrl = new JTextField();
		txtUrl.setBackground(SystemColor.inactiveCaption);
		txtUrl.setEnabled(false);
		txtUrl.setColumns(10);
		txtUrl.setBounds(240, 150, 182, 19);
		getContentPane().add(txtUrl);
		
		JLabel lbURL = new JLabel("URL");
		lbURL.setForeground(SystemColor.text);
		lbURL.setFont(new Font("Arial", Font.BOLD, 11));
		lbURL.setBounds(240, 135, 81, 14);
		getContentPane().add(lbURL);
		
		txtDesc = new JTextField();
		txtDesc.setBackground(SystemColor.inactiveCaption);
		txtDesc.setEnabled(false);
		txtDesc.setColumns(10);
		txtDesc.setBounds(240, 195, 210, 56);
		getContentPane().add(txtDesc);
		
		JLabel lbDesc = new JLabel("Descripci\u00F3n");
		lbDesc.setForeground(SystemColor.text);
		lbDesc.setFont(new Font("Arial", Font.BOLD, 11));
		lbDesc.setBounds(240, 200, 81, 14);
		getContentPane().add(lbDesc);				
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel.setBounds(220, 5, 244, 56);
		getContentPane().add(lblNewLabel);
		
		lbPassword = new JLabel("Password");
		lbPassword.setForeground(SystemColor.text);
		lbPassword.setFont(new Font("Arial", Font.BOLD, 11));
		lbPassword.setBounds(20, 245, 81, 14);
		getContentPane().add(lbPassword);		
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(SystemColor.inactiveCaption);
		txtPassword.setForeground(SystemColor.text);
		txtPassword.setBounds(20, 260, 130, 19);
		txtPassword.setEnabled(false);
		getContentPane().add(txtPassword);				
	}	
		
	protected void seleccionarActionPerformed(ActionEvent e){
		DtUsuario dtu = icon.seleccionarUsuario((String) cBUsuarios.getSelectedItem().toString());
		DtArtista dta = null;		
		if (dtu instanceof DtEspectador) {
			txtDesc.setText("");	
			txtUrl.setText("");
			txtBio.setText("");	
		}		
		if (dtu instanceof DtArtista)
			dta = (DtArtista) dtu;			
		txtNombre.setText(dtu.getNombre());
		txtPassword.setText(dtu.getPasswd());
		p = txtPassword.getPassword();
	    txtApellido.setText(dtu.getApellido());	    
	    txtCorreo.setText(dtu.getMail());  
	    
	    Date f = dtu.getFnac();
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(f);
	    String m = String.format("%02d", cal.get(Calendar.MONTH));
	    String d = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
	    String a = String.valueOf(cal.get(Calendar.YEAR));	   		   	
	    String fecha = d + "/" + m + "/" + a;
	    
	    txtFnac.setText(fecha);	    
		if (dta != null) {
			txtDesc.setEnabled(true);
			txtUrl.setEnabled(true);
			txtBio.setEnabled(true);
			txtDesc.setText(dta.getDescripcion());	
			txtUrl.setText(dta.getURL());
			txtBio.setText(dta.getBiografia());			
		}    			
	}	

	private void aceptarModificar() {
	   
	    /*char[] pass = this.txtPassword.getPassword();
    	String password = String.valueOf(pass);   
    	p1 = password;
    	String password2 = ""; 		
    	
    	if (!p1.equals(String.valueOf(p))) {    		// cambio la pass
    		framePassword.setVisible(true);
    		while (true) {
    			char[] pass2 = this.txtPassword2.getPassword();
        		password2 = String.valueOf(pass2); 
        		cambioPass = true;
        		p2 = password2;        	
        		break;
    		}
    	}
		framePassword.setVisible(false);
		limpiarPassword();	*/	
	}
	
	private void limpiarPassword() {
		txtPassword2.setText("");
		txtPassword.setText("");		
	}
	
	protected void modificarActionPerformed(ActionEvent e) {		    
	    String nombre = this.txtNombre.getText();
	    String correo = this.txtCorreo.getText();	    
	    String ap = this.txtApellido.getText();	
	    String fnac = this.txtFnac.getText();		    
	    LocalDate f = null;	    	    
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    try {
			f = LocalDate.parse(fnac, format);
		} catch (Exception e1) {
			txtFnac.setText("");
			throw e1;
		}	    
	    String bio = this.txtBio.getText();
    	String desc = this.txtDesc.getText();
    	String url = this.txtUrl.getText();   
    	
    	DtUsuario dtu = null;
    	/*if (cambioPass == true) 
    		if (!bio.isEmpty() || !desc.isEmpty() || !url.isEmpty()) 
    			dtu = new DtArtista((String) cBUsuarios.getSelectedItem().toString(), nombre, ap, f, correo, desc, url, bio, String.valueOf(p));
    		else dtu = new DtEspectador((String) cBUsuarios.getSelectedItem().toString(), nombre, ap, f, correo,  String.valueOf(p));
    	else */
    	
    	ZoneId defaultZoneId = ZoneId.systemDefault();   
            
        Date date = Date.from(f.atStartOfDay(defaultZoneId).toInstant());
    	
    	
    	if (!bio.isEmpty() || !desc.isEmpty() || !url.isEmpty()) 
			dtu = new DtArtista((String) cBUsuarios.getSelectedItem().toString(), nombre, ap, date, correo, desc, url, bio, String.valueOf(p));
		else dtu = new DtEspectador((String) cBUsuarios.getSelectedItem().toString(), nombre, ap, date, correo, String.valueOf(p));			
	    
		icon.modificarUsuario(dtu, null);	    	   	
		JOptionPane.showMessageDialog(this, "El usuario fue modificado correctamente", "modificar usuario", JOptionPane.INFORMATION_MESSAGE);  
		this.setVisible(false);
		limpiarFormulario(); 
		cargarLista();
	}			
	
	protected void CancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}

	protected void limpiarFormulario() {
        txtNombre.setText("");
        cBUsuarios.setSelectedItem(null);
        txtApellido.setText("");
        txtFnac.setText("");
        txtCorreo.setText("");
        txtBio.setText("");
        txtUrl.setText("");
    	txtDesc.setText("");
	}
	 
	public void cargarLista() {
		ArrayList<String> lU = icon.listarUsuarios();
		cBUsuarios.removeAllItems();
		for (String s: lU) {
			cBUsuarios.addItem(s);
		}
		cBUsuarios.setSelectedItem(null);
	}
}
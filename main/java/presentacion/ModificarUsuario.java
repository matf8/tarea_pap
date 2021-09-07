package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IControladorUsuario;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import datatypes.DtUsuario;
import excepciones.CorreoExisteException;
import excepciones.UsuarioExisteException;
import datatypes.DtEspectador;
import datatypes.DtArtista;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ModificarUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorUsuario icon;	
	private JTextField txtNickname, txtNombre, txtApellido, txtCorreo, txtFnac, txtBio, txtUrl, txtDesc;;
	private JLabel lbNickname, lblNombre;
	private JButton bSeleccionar, bCancelar, bModificar;
	private JButton bSeleccionar_1;
	private JComboBox<String> cBUsuarios;	
	private final static String newline = "\n";
	
	public ModificarUsuario(IControladorUsuario icon) {
		getContentPane().setBackground(new Color(0, 0, 51));	
		this.icon = icon;
		setResizable(false);        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Usuario");
		setBounds(100, 100, 496, 336);
		getContentPane().setLayout(null);
				
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
		
		bSeleccionar_1 = new JButton("");
		bSeleccionar_1.setBorder(null);
		bSeleccionar_1.setBackground(new Color(0, 0, 51));
		bSeleccionar_1.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/aceptar-icon-48px.png")));
		bSeleccionar_1.setToolTipText("Aceptar modificaci\u00F3n");
		bSeleccionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					modificarActionPerformed(e);								
				} catch (Exception j) {
					txtFnac.setText("");
		            JOptionPane.showMessageDialog(bSeleccionar, j.getMessage(), "modificar usuario", JOptionPane.ERROR_MESSAGE);

				}				
			}
		});
		bSeleccionar_1.setBounds(283, 255, 48, 48);	
		getContentPane().add(bSeleccionar_1);		
				
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
		lbDesc.setBounds(240, 180, 81, 14);
		getContentPane().add(lbDesc);				
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel.setBounds(220, 5, 244, 56);
		getContentPane().add(lblNewLabel);
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
	    txtApellido.setText(dtu.getApellido());	    
	    txtCorreo.setText(dtu.getMail());  
	    LocalDate f = dtu.getFnac();	   
	    int año = f.getYear();		    	    	   
	    String m = String.format("%02d", f.getMonthValue());
	    String d = String.format("%02d", f.getDayOfMonth());	   		   	
	    String fecha = d + "/" + m + "/" + String.valueOf(año);  	    	   	 
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

	protected void modificarActionPerformed(ActionEvent e){		
	    String nombre = this.txtNombre.getText();
	    String correo = this.txtCorreo.getText();	    
	    String ap = this.txtApellido.getText();	
	    String fnac = this.txtFnac.getText();		    
	    LocalDate f = null;	    	    
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    try {
			f = LocalDate.parse(fnac, format);
		} catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "Fecha inválida [dd/MM/yyyy]", "modificar usuario", JOptionPane.ERROR_MESSAGE);
			throw e1;
		}	    
	    String bio = this.txtBio.getText();
    	String desc = this.txtDesc.getText();
    	String url = this.txtUrl.getText();    	
    	DtUsuario dtu = null;
	    if (!bio.isEmpty() || !desc.isEmpty() || !url.isEmpty()) 
	       dtu = new DtArtista((String) cBUsuarios.getSelectedItem().toString(), nombre, ap, f, correo, desc, url, bio);
	     else dtu = new DtEspectador((String) cBUsuarios.getSelectedItem().toString(), nombre, ap, f, correo);
	    
		icon.modificarUsuario(dtu);	    	   	
		JOptionPane.showMessageDialog(this, "El usuario fue modificado correctamente", "modificar usuario", JOptionPane.INFORMATION_MESSAGE);  
		this.setVisible(false);
		limpiarFormulario(); 
		cargarLista();
	}			
	
	protected void CancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}

	private void limpiarFormulario() {
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
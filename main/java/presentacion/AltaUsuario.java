package presentacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import datatypes.DtEspectador;
import datatypes.DtArtista;

import interfaces.IControladorUsuario;

import excepciones.UsuarioExisteException;
import excepciones.CorreoExisteException;
import excepciones.NombreNullException;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class AltaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorUsuario icon;
	
	private JTextField txtNick, txtNombre, txtCorreo, txtApellido, txtFnac, txtBio, txtDesc, txtUrl;
	private JButton bAceptar, bCancelar;
	private JRadioButton rbArtista, rbEspectador;
	private JLabel lbNick, lblNombre, lbApellido, lbFnac, lbCorreo, lbBio, lbDesc, lbUrl, lbiconoUsuario;
	private final ButtonGroup buttonGroup = new ButtonGroup();
		
	public AltaUsuario(IControladorUsuario icon) {
		this.icon = icon;
		setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("alta usuario");
		setBounds(100, 100, 528, 418);
		getContentPane().setLayout(null);
		
		lbBio = new JLabel("Biografia");
		lbBio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbBio.setBounds(289, 61, 86, 14);
		lbBio.setVisible(false);
		getContentPane().add(lbBio);	
		
		txtBio = new JTextField("");
		txtBio.setBackground(SystemColor.inactiveCaption);
		txtBio.setBounds(289, 77, 201, 46);
		txtBio.setVisible(false);
		getContentPane().add(txtBio);
		txtBio.setColumns(10);
		
		lbUrl = new JLabel("URL");
		lbUrl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbUrl.setBounds(289, 134, 46, 14);
		lbUrl.setVisible(false);
		getContentPane().add(lbUrl);
		
		txtUrl = new JTextField();
		txtUrl.setBackground(SystemColor.inactiveCaption);
		txtUrl.setBounds(289, 153, 201, 19);
		txtUrl.setVisible(false);
		getContentPane().add(txtUrl);
		txtUrl.setColumns(10);
		
		lbDesc = new JLabel("Descripción");
		lbDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbDesc.setBounds(289, 183, 86, 14);
		lbDesc.setVisible(false);
		getContentPane().add(lbDesc);	
		
		txtDesc = new JTextField();
		txtDesc.setBackground(SystemColor.inactiveCaption);
		txtDesc.setBounds(289, 208, 201, 102);
		txtDesc.setVisible(false);
		getContentPane().add(txtDesc);
		txtDesc.setColumns(10);		
				
		bAceptar = new JButton("");
		bAceptar.setToolTipText("Aceptar");
		bAceptar.setBorderPainted(false);
		bAceptar.setIcon(new ImageIcon(AltaUsuario.class.getResource("/recursos/aceptar-icon-48px.png")));
		bAceptar.setBackground(SystemColor.text);
		bAceptar.setBounds(331, 321, 46, 43);
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				try {
					altaUsuarioAceptarActionPerformed(arg0);
				} catch (UsuarioExisteException e) {
				     txtNick.setText("");
				} catch (CorreoExisteException i) {
					txtCorreo.setText("");
				}catch (NombreNullException n) {
		            JOptionPane.showMessageDialog(bAceptar, n.getMessage(), "alta usuario", JOptionPane.ERROR_MESSAGE); // usuario o correo ya existe		           				
				} catch (Exception j) {
					txtFnac.setText("");
				}
			}
		});
		getContentPane().add(bAceptar);
		
		bCancelar = new JButton("");
		bCancelar.setToolTipText("Cancelar");
		bCancelar.setBorderPainted(false);
		bCancelar.setIcon(new ImageIcon(AltaUsuario.class.getResource("/recursos/cancelar-icon-48px.png")));
		bCancelar.setBackground(SystemColor.text);
		bCancelar.setBounds(404, 321, 46, 43);
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerformed(e);
			}
		});
		getContentPane().add(bCancelar);	
		
		rbEspectador = new JRadioButton("Espectador");
		rbEspectador.setFont(new Font("Tahoma", Font.BOLD, 11));
		rbEspectador.setForeground(SystemColor.text);
		rbEspectador.setBackground(new Color(0, 0, 51));
		rbEspectador.setBounds(32, 310, 109, 23);
		getContentPane().add(rbEspectador);
		rbEspectador.setSelected(true);
		rbEspectador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lbBio.setVisible(false);
			txtBio.setVisible(false);
			lbDesc.setVisible(false);
			txtDesc.setVisible(false);
			lbUrl.setVisible(false);
			txtUrl.setVisible(false);
			txtBio.setText("");
		    txtUrl.setText("");
		    txtDesc.setText("");
		}
		});		
		buttonGroup.add(rbEspectador);
		
	    rbArtista = new JRadioButton("Artista");
	    rbArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
	    rbArtista.setForeground(SystemColor.text);
	    rbArtista.setBackground(new Color(0, 0, 51));
	    rbArtista.setBounds(32, 339, 109, 23);
	    getContentPane().add(rbArtista);
	    rbArtista.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		lbBio.setVisible(true);
	    		txtBio.setVisible(true);
	    		lbDesc.setVisible(true);
	    		txtDesc.setVisible(true);
	    		lbUrl.setVisible(true);
	    		txtUrl.setVisible(true);
	    	}
	    });			
	    buttonGroup.add(rbArtista);
	    
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 264, 388);
		getContentPane().add(panel);
		panel.setLayout(null);
		    
	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setIcon(new ImageIcon(AltaUsuario.class.getResource("/recursos/coronaticketsSmall.png")));
	    lblNewLabel.setBounds(10, 20, 244, 54);
	    panel.add(lblNewLabel);
	    
	    txtCorreo = new JTextField();
	    txtCorreo.setBackground(SystemColor.inactiveCaption);
	    txtCorreo.setBounds(36, 281, 128, 19);
	    panel.add(txtCorreo);
	    txtCorreo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mousePressed(MouseEvent e) {
	    		if(txtCorreo.getText().equals("ejemplo@gmail.com")) {
	    			txtCorreo.setText("");
	    			txtCorreo.setForeground(Color.black);
	    		}
	    	}
	    });
	    txtCorreo.setForeground(Color.GRAY);
	    txtCorreo.setText("ejemplo@gmail.com");
	    txtCorreo.setColumns(10);
	    
	    lbCorreo = new JLabel("Correo");
	    lbCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lbCorreo.setForeground(SystemColor.text);
	    lbCorreo.setBounds(38, 268, 127, 14);
	    panel.add(lbCorreo);
	    
	    txtFnac = new JTextField();
	    txtFnac.setBackground(SystemColor.inactiveCaption);
	    txtFnac.setBounds(36, 240, 130, 19);
	    panel.add(txtFnac);
	    txtFnac.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mousePressed(MouseEvent e) {
	    		if(txtFnac.getText().equals("dd/mm/yyyy")) {
	    			txtFnac.setText("");
	    			txtFnac.setForeground(Color.black);
	    		}
	    	}
	    });
	    txtFnac.setForeground(Color.GRAY);
	    txtFnac.setText("dd/mm/yyyy");
	    txtFnac.setColumns(10);
	    
	    lbFnac = new JLabel("Fecha de nacimiento");
	    lbFnac.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lbFnac.setForeground(SystemColor.text);
	    lbFnac.setBounds(36, 225, 158, 14);
	    panel.add(lbFnac);
	    
	    txtApellido = new JTextField();
	    txtApellido.setBackground(SystemColor.inactiveCaption);
	    txtApellido.setBounds(36, 197, 128, 19);
	    panel.add(txtApellido);
	    txtApellido.setColumns(10);
	    
	    lbApellido = new JLabel("Apellido");
	    lbApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lbApellido.setForeground(SystemColor.text);
	    lbApellido.setBounds(38, 179, 98, 14);
	    panel.add(lbApellido);
	    
	    txtNombre = new JTextField();
	    txtNombre.setBackground(SystemColor.inactiveCaption);
	    txtNombre.setBounds(36, 152, 130, 19);
	    panel.add(txtNombre);
	    txtNombre.setColumns(10);
	    
	    lblNombre = new JLabel("Nombre");
	    lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblNombre.setForeground(SystemColor.text);
	    lblNombre.setBounds(36, 137, 81, 14);
	    panel.add(lblNombre);
	    
	    txtNick = new JTextField();
	    txtNick.setBackground(SystemColor.inactiveCaption);
	    txtNick.setBounds(36, 112, 130, 19);
	    panel.add(txtNick);
	    txtNick.setColumns(10);
	    
	    lbNick = new JLabel("Nickname");
	    lbNick.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lbNick.setForeground(SystemColor.text);
	    lbNick.setBounds(36, 97, 81, 14);
	    panel.add(lbNick);
	    
	    JLabel lbiconoUsuario = new JLabel("");
	    lbiconoUsuario.setIcon(new ImageIcon(AltaUsuario.class.getResource("/recursos/userIcons.png")));
	    lbiconoUsuario.setBounds(277, 70, 228, 240);
	    getContentPane().add(lbiconoUsuario);		
	}
	
	protected void altaUsuarioAceptarActionPerformed(ActionEvent arg0) throws UsuarioExisteException, CorreoExisteException, NombreNullException {			
		String nick = this.txtNick.getText();
	    if(nick.isEmpty()) {
	    	throw new NombreNullException("el Nick no puede estar vacio");
	    } 
	    
	    String correo = this.txtCorreo.getText();
	    if(correo.isEmpty() || correo.contentEquals("ejemplo@gmail.com")) {
	    	throw new NombreNullException("el Correo no puede estar vacio");
	    } 
	    String nombre = this.txtNombre.getText();
	    String fnac = this.txtFnac.getText();
	    String ap = this.txtApellido.getText();	
	    LocalDate f = null;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
	    try {
			f = LocalDate.parse(fnac, format);			
			} catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "alta usuario", JOptionPane.ERROR_MESSAGE); // usuario o correo ya existe		           		

			throw e1;
		}	         
	    
	    if (rbArtista.isSelected()) {
	    	String bio = this.txtBio.getText();
	    	String desc = this.txtDesc.getText();
	    	String url = this.txtUrl.getText();
	        DtArtista dta = new DtArtista(nick, nombre, ap, f, correo, desc, url, bio);     
	        this.icon.ingresarDatosArtista(dta);
	        try {
	        	this.icon.chequearDisponibilidadCorreo(correo);
	        	this.icon.chequearDisponibilidadNickname(nick);
	        	this.icon.altaUsuario();
	        	JOptionPane.showMessageDialog(this, "usuario creado exitosamente", "alta usuario", JOptionPane.INFORMATION_MESSAGE);
	        	limpiarFormulario();
	    		setVisible(false);	
	        } catch (UsuarioExisteException e) {
	            JOptionPane.showMessageDialog(this, e.getMessage(), "alta usuario", JOptionPane.ERROR_MESSAGE); // usuario o correo ya existe		           		
	            throw e;
	        }catch (CorreoExisteException e1) {
	            JOptionPane.showMessageDialog(this, e1.getMessage(), "alta usuario", JOptionPane.ERROR_MESSAGE); // usuario o correo ya existe		           		
	            throw e1;
	        }
	    } else {     
	        DtEspectador dte = new DtEspectador(nick, nombre, ap, f, correo);
	        this.icon.ingresarDatosEspectador(dte);
	        try {
	        	this.icon.chequearDisponibilidadCorreo(correo);
	        	this.icon.chequearDisponibilidadNickname(nick);
	        	this.icon.altaUsuario();
	        	JOptionPane.showMessageDialog(this, "usuario creado exitosamente", "alta espectador", JOptionPane.INFORMATION_MESSAGE);
	        	limpiarFormulario();
	    		setVisible(false);	
	        } catch (UsuarioExisteException e) {
	            JOptionPane.showMessageDialog(this, e.getMessage(), "alta espectador", JOptionPane.ERROR_MESSAGE); // usuario o correo ya existe
	            throw e;
	        }		    
	    }
	    
	}
	
	protected void altaUsuarioCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	 private void limpiarFormulario() {
        txtNombre.setText("");
        txtNick.setText("");
        txtApellido.setText("");
        txtFnac.setText("");
        txtCorreo.setText("");
        txtBio.setText("");
    	txtUrl.setText("");
    	txtDesc.setText("");;
	 }
}
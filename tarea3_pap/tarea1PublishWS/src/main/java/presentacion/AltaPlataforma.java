package presentacion;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import datatypes.DtPlataforma;
import excepciones.NombreNullException;
import interfaces.IControladorPlataforma;
import java.awt.Color;

public class AltaPlataforma extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	
	private IControladorPlataforma icon;	
	private JTextField txtNombrePlataforma, txtDescripcion, txtURL;
	private JLabel lbPlataforma, lbDescrpcion, lbURL;
	private JButton bAceptar, bCancelar;
	
	public AltaPlataforma(IControladorPlataforma icon) {
		getContentPane().setBackground(SystemColor.inactiveCaption);		
		this.icon = icon;
		setResizable(false);        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("alta plataforma");
		setBounds(100, 100, 438, 327);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 438, 327);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtNombrePlataforma = new JTextField();
		
		txtNombrePlataforma.setBackground(SystemColor.inactiveCaption);
		txtNombrePlataforma.setBounds(154, 71, 112, 20);
		panel_1.add(txtNombrePlataforma);
//		txtNombrePlataforma.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(txtNombrePlataforma.getText().isEmpty()) {
//					chequearVacio(txtNombrePlataforma.getText());
//				}else chequearExiste(txtNombrePlataforma.getText());
//			}
//		});
		txtNombrePlataforma.setColumns(10);
		
		txtURL = new JTextField();
		txtURL.setBackground(SystemColor.inactiveCaption);
		txtURL.setBounds(154, 102, 172, 20);
		panel_1.add(txtURL);
		txtURL.setColumns(10);
		
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBackground(SystemColor.inactiveCaption);
		txtDescripcion.setBounds(154, 142, 172, 55);
		panel_1.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		bAceptar = new JButton("");
		bAceptar.setToolTipText("Aceptar");
		bAceptar.setBorderPainted(false);
		bAceptar.setIcon(new ImageIcon(AltaPlataforma.class.getResource("/recursos/aceptar-icon-48px.png")));
		bAceptar.setBackground(new Color(0, 0, 51));
		bAceptar.setBounds(154, 222, 45, 41);
		panel_1.add(bAceptar);
		
		bCancelar = new JButton("");
		bCancelar.setToolTipText("Cancelar");
		bCancelar.setBorderPainted(false);
		bCancelar.setIcon(new ImageIcon(AltaPlataforma.class.getResource("/recursos/cancelar-icon-48px.png")));
		bCancelar.setBackground(new Color(0, 0, 51));
		bCancelar.setBounds(233, 222, 45, 41);
		panel_1.add(bCancelar);
		
		lbDescrpcion = new JLabel("Descripcion");
		lbDescrpcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbDescrpcion.setForeground(SystemColor.text);
		lbDescrpcion.setBackground(SystemColor.window);
		lbDescrpcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDescrpcion.setBounds(62, 145, 86, 14);
		panel_1.add(lbDescrpcion);
		
		lbURL = new JLabel("URL");
		lbURL.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbURL.setForeground(SystemColor.text);
		lbURL.setBackground(SystemColor.text);
		lbURL.setHorizontalAlignment(SwingConstants.RIGHT);
		lbURL.setBounds(50, 105, 98, 14);
		panel_1.add(lbURL);
		
		lbPlataforma = new JLabel("Nombre plataforma");
		lbPlataforma.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbPlataforma.setForeground(SystemColor.text);
		lbPlataforma.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPlataforma.setBounds(26, 74, 125, 14);
		panel_1.add(lbPlataforma);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AltaPlataforma.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel.setBounds(80, 10, 240, 53);
		panel_1.add(lblNewLabel);
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPlataformaCancelarActionPerformed(e);
			}
		});
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaPlataformaAceptarActionPerformed(e);
				} catch (NombreNullException e1) {
					 JOptionPane.showMessageDialog(bAceptar, e1.getMessage(), "alta plataforma", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}		
	
	protected void altaPlataformaAceptarActionPerformed(ActionEvent e) throws NombreNullException{
		String nombreP, desc, url;		
				
		nombreP = txtNombrePlataforma.getText();		
		url = txtURL.getText();
		desc = txtDescripcion.getText();
		
		String nick = this.txtNombrePlataforma.getText();
	    if(nick.isEmpty()) {
	    	throw new NombreNullException("El nombre de la plataforma no puede estar vacio");
	    } 
				
		DtPlataforma dtp = new DtPlataforma(nombreP, desc, url);
		
		try {			
			this.icon.ingresarDatosPlataforma(dtp);
			this.icon.chequearDisponibilidadPlataforma(nombreP);
			this.icon.altaPlataforma();
        	JOptionPane.showMessageDialog(this, "Plataforma creada exitosamente", "alta plataforma", JOptionPane.INFORMATION_MESSAGE);
        	limpiarFormulario();
    		setVisible(false);	
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage(), "alta plataforma", JOptionPane.ERROR_MESSAGE);	           		
		}			
	}		
	
	protected void altaPlataformaCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}

	protected void limpiarFormulario() {	
		txtNombrePlataforma.setText("");
		txtDescripcion.setText("");	
		txtURL.setText("");		
	 }
	
//	private void chequearExiste(String nombreP) {
//		try {			
//			this.icon.chequearDisponibilidadPlataforma(nombreP);
//		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(this, e2.getMessage(), "alta plataforma", JOptionPane.ERROR_MESSAGE);
//			txtNombrePlataforma.setText("");
//			txtNombrePlataforma.transferFocusBackward();
//			txtNombrePlataforma.requestFocus();
//		}
//	}
//	
//	private void chequearVacio(String nombreP) {
//		if(nombreP.isEmpty())
//			JOptionPane.showMessageDialog(this, "No puedes dejar el campo Nombre vacio", "alta plataforma", JOptionPane.ERROR_MESSAGE);
//			txtNombrePlataforma.transferFocusBackward();
//			txtNombrePlataforma.requestFocus();
//	}
}
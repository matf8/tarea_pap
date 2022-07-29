package presentacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import datatypes.DtEspectaculo;
import excepciones.NombreNullException;
import interfaces.IControladorEspectaculo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class AltaEspectaculo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorEspectaculo icon;	
	private JTextField txtNombrePlataforma,	txtArtistaOrg, txtDescripcion, txtNombreEspec, txtDuracion, txtCantMin,	txtCantMax, txtURL, txtCosto;
	private JLabel lbPlataforma, lbArtista, lbDescrpcion, lbNombreEspectaculo, lbCantMinEspec, lbDuracion, lblCandMax, lbURL, lbCosto;
	private JButton bAceptar, bCancelar;
	private JPanel panel;
	private JLabel lblNewLabel;
	
	public AltaEspectaculo(IControladorEspectaculo icon) {		
		this.icon = icon;
		setResizable(false);    
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("alta espectaculo");
		setBounds(100, 100, 527, 421);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 511, 391);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(119, 11, 252, 66);
		lblNewLabel.setIcon(new ImageIcon(AltaEspectaculo.class.getResource("/recursos/coronaticketsSmall.png")));
		panel.add(lblNewLabel);
		
		lbURL = new JLabel("URL");
		lbURL.setBounds(285, 215, 159, 14);
		panel.add(lbURL);
		lbURL.setForeground(SystemColor.text);
		lbURL.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtURL = new JTextField();
		txtURL.setBounds(285, 232, 150, 20);
		panel.add(txtURL);
		txtURL.setBackground(SystemColor.inactiveCaption);
		txtURL.setColumns(10);
		
		lbCosto = new JLabel("Costo");
		lbCosto.setBounds(285, 259, 63, 14);
		panel.add(lbCosto);
		lbCosto.setForeground(SystemColor.text);
		lbCosto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCosto = new JTextField();
		txtCosto.setBounds(285, 274, 86, 20);
		panel.add(txtCosto);
		txtCosto.setBackground(SystemColor.inactiveCaption);
		txtCosto.setColumns(10);
		
		lbNombreEspectaculo = new JLabel("Nombre espectáculo");
		lbNombreEspectaculo.setBounds(70, 265, 154, 14);
		panel.add(lbNombreEspectaculo);
		lbNombreEspectaculo.setForeground(SystemColor.text);
		lbNombreEspectaculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNombreEspec = new JTextField();
		txtNombreEspec.setBounds(70, 280, 106, 20);
		panel.add(txtNombreEspec);
		txtNombreEspec.setBackground(SystemColor.inactiveCaption);
		txtNombreEspec.setColumns(10);
		
		lbDuracion = new JLabel("Duracion (min)");
		lbDuracion.setBounds(285, 79, 106, 14);
		panel.add(lbDuracion);
		lbDuracion.setForeground(SystemColor.text);
		lbDuracion.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(285, 94, 86, 20);
		panel.add(txtDuracion);
		txtDuracion.setBackground(SystemColor.inactiveCaption);
		txtDuracion.setColumns(10);
		
	    lbCantMinEspec = new JLabel("Cant. m\u00EDnima de espectadores");
	    lbCantMinEspec.setBounds(285, 124, 208, 14);
	    panel.add(lbCantMinEspec);
	    lbCantMinEspec.setForeground(SystemColor.text);
	    lbCantMinEspec.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	    txtCantMin = new JTextField();
	    txtCantMin.setBounds(285, 139, 86, 20);
	    panel.add(txtCantMin);
	    txtCantMin.setBackground(SystemColor.inactiveCaption);
	    txtCantMin.setColumns(10);
	    
	    lblCandMax = new JLabel("Cant. m\u00E1xima de espectadores");
	    lblCandMax.setBounds(285, 169, 208, 14);
	    panel.add(lblCandMax);
	    lblCandMax.setForeground(SystemColor.text);
	    lblCandMax.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	    txtCantMax = new JTextField();
	    txtCantMax.setBounds(285, 184, 86, 20);
	    panel.add(txtCantMax);
	    txtCantMax.setBackground(SystemColor.inactiveCaption);
	    txtCantMax.setColumns(10);
	    
	    bAceptar = new JButton("");
	    bAceptar.setToolTipText("Aceptar");
	    bAceptar.setBackground(new Color(0, 0, 51));
	    bAceptar.setBorderPainted(false);
	    bAceptar.setIcon(new ImageIcon(AltaEspectaculo.class.getResource("/recursos/aceptar-icon-48px.png")));
	    bAceptar.setBounds(189, 325, 45, 43);
	    panel.add(bAceptar);
	    
	    bCancelar = new JButton("");
	    bCancelar.setToolTipText("Cancelar");
	    bCancelar.setBackground(new Color(0, 0, 51));
	    bCancelar.setBorderPainted(false);
	    bCancelar.setIcon(new ImageIcon(AltaEspectaculo.class.getResource("/recursos/cancelar-icon-48px.png")));
	    bCancelar.setBounds(275, 325, 45, 43);
	    panel.add(bCancelar);
	    
	    txtDescripcion = new JTextField();
	    txtDescripcion.setBounds(70, 184, 150, 70);
	    panel.add(txtDescripcion);
	    txtDescripcion.setBackground(SystemColor.inactiveCaption);
	    txtDescripcion.setColumns(10);
	    
	    lbPlataforma = new JLabel("Nombre plataforma");
	    lbPlataforma.setBounds(70, 79, 125, 14);
	    panel.add(lbPlataforma);
	    lbPlataforma.setForeground(SystemColor.text);
	    lbPlataforma.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	    txtNombrePlataforma = new JTextField();
	    txtNombrePlataforma.setBounds(70, 94, 106, 20);
	    panel.add(txtNombrePlataforma);
	    txtNombrePlataforma.setBackground(SystemColor.inactiveCaption);
	    txtNombrePlataforma.setColumns(10);
	    
	    lbArtista = new JLabel("Artista organizador");
	    lbArtista.setBounds(70, 124, 125, 14);
	    panel.add(lbArtista);
	    lbArtista.setForeground(SystemColor.text);
	    lbArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	    txtArtistaOrg = new JTextField();
	    txtArtistaOrg.setBounds(70, 139, 106, 20);
	    panel.add(txtArtistaOrg);
	    txtArtistaOrg.setBackground(SystemColor.inactiveCaption);
	    txtArtistaOrg.setColumns(10);
	    
	    lbDescrpcion = new JLabel("Descripción");
	    lbDescrpcion.setBounds(70, 169, 86, 14);
	    panel.add(lbDescrpcion);
	    lbDescrpcion.setForeground(SystemColor.text);
	    lbDescrpcion.setFont(new Font("Tahoma", Font.BOLD, 11));
	    bCancelar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		altaEspectaculoCancelarActionPerformed(e);
	    	}
	    });
	    bAceptar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					altaEspectaculoAceptarActionPerformed(e);
				} catch (NombreNullException e1) {
					  JOptionPane.showMessageDialog(bAceptar, e1.getMessage(), "alta espectaculo", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	}	
	
	protected void altaEspectaculoAceptarActionPerformed(ActionEvent e) throws NombreNullException{
		
		String nombreP, nombreE, url, desc, artistaOrg;
		Integer cantmin, cantmax, duracion;
		Float costo;	
		LocalDate f = LocalDate.now();				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		f.format(formatter);	
		
		nombreP = txtNombrePlataforma.getText();
		artistaOrg = txtArtistaOrg.getText();		
		nombreE = txtNombreEspec.getText();
		url = txtURL.getText();
		desc = txtDescripcion.getText();	
		
		String nick = this.txtNombreEspec.getText();
	    if(nick.isEmpty()) {
	    	throw new NombreNullException("El nombre del espectaculo no puede estar vacio");
	    } 
		
		cantmin = Integer.parseInt(txtCantMin.getText());	
		cantmax = Integer.parseInt(txtCantMax.getText());		
		duracion = Integer.parseInt(txtDuracion.getText());	
		costo = Float.parseFloat(txtCosto.getText());

		boolean cannot = true;
		while (cannot) {			
			if (cantmin < 0 || cantmin > cantmax) {
				JOptionPane.showMessageDialog(this, "Ingrese una cantidad mínima de espectadores válida", "alta espectáculo", JOptionPane.ERROR_MESSAGE); 
				txtCantMin.setText("");
				cannot = false;
			}
			if (cantmax < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese una cantidad máxima de espectadores válida", "alta espectáculo", JOptionPane.ERROR_MESSAGE); 				
				txtCantMax.setText("");
				cannot = false;
			}
			if (duracion < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese una duración válida", "alta espectáculo", JOptionPane.ERROR_MESSAGE); 				
				txtDuracion.setText("");
				cannot = false;
			}
			if (costo < 0) {
				JOptionPane.showMessageDialog(this, "El costo del especátulo no puede ser negativo", "alta espectáculo", JOptionPane.ERROR_MESSAGE);
				txtCosto.setText("");
				cannot = false;
			}	
			
			if (cannot) {	
				cannot = false;
				DtEspectaculo dte = new DtEspectaculo(nombreE, desc, url, duracion, cantmax, cantmin, costo, f, artistaOrg, nombreP);		
				try {
					this.icon.ingresarEspectaculo(nombreP, artistaOrg, dte, null);
					this.icon.chequearDisponibilidadNombre(nombreE);
					this.icon.altaEspectaculo();
		        	JOptionPane.showMessageDialog(this, "Espectáculo creado exitosamente", "alta espectaculo", JOptionPane.INFORMATION_MESSAGE);
		        	limpiarFormulario();
		    		setVisible(false);	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, e2.getMessage(), "alta espectáculo", JOptionPane.ERROR_MESSAGE);           		
				}	
			}
		}		
	}	
	
	protected void altaEspectaculoCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	protected void limpiarFormulario() {	
		txtNombrePlataforma.setText("");
		txtArtistaOrg.setText("");
		txtDescripcion.setText("");
		txtNombreEspec.setText("");
		txtDuracion.setText("");
		txtCantMin.setText("");
		txtCantMax.setText("");
		txtURL.setText("");
		txtCosto.setText("");
	 }	 
}
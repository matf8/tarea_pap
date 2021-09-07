package presentacion;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import datatypes.DtPaquete;
import excepciones.NombreNullException;
import excepciones.PaqueteNoValidoException;
import interfaces.IControladorPaquete;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CrearPaquete extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorPaquete icon;	
	private JTextField txtNombrePaquete, txtFechaI, txtFechaF, txtDescuento, txtDescripcion;
	private JLabel lbNombrePaquete, lbFechaI, lbFechaF, lbDescuento, lbDescripcion;
	private JButton bAceptar, bCancelar, bAgregar;	
	private JCheckBox nCheck;
	
	public CrearPaquete(IControladorPaquete icon) {
		getContentPane().setBackground(new Color(0, 0, 51));		
		this.icon = icon;
		setResizable(false);        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("crear paquete de espectáculos");
		setBounds(0, 0, 280, 400);
		getContentPane().setLayout(null);
		
		lbNombrePaquete = new JLabel("Nombre");
		lbNombrePaquete.setForeground(SystemColor.text);
		lbNombrePaquete.setBounds(51, 74, 150, 14);
		lbNombrePaquete.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(lbNombrePaquete);
		txtNombrePaquete = new JTextField();
		txtNombrePaquete.setBackground(SystemColor.inactiveCaption);
		txtNombrePaquete.setBounds(51, 89, 150, 20);			
		getContentPane().add(txtNombrePaquete);
						
		lbDescripcion = new JLabel("Descripción");
		lbDescripcion.setForeground(SystemColor.text);
		lbDescripcion.setBounds(51, 119, 159, 14);
		lbDescripcion.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(lbDescripcion);
		txtDescripcion = new JTextField();
		txtDescripcion.setBackground(SystemColor.inactiveCaption);
		txtDescripcion.setBounds(51, 134, 150, 20);
		getContentPane().add(txtDescripcion);
		
		lbFechaI = new JLabel("Fecha inicio");
		lbFechaI.setForeground(SystemColor.text);
		lbFechaI.setBounds(51, 164, 159, 14);
		lbFechaI.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(lbFechaI);
		txtFechaI = new JTextField();
		txtFechaI.setBackground(SystemColor.inactiveCaption);
		txtFechaI.setBounds(51, 179, 150, 20);
		getContentPane().add(txtFechaI);
		
		lbFechaF = new JLabel("Fecha fin");
		lbFechaF.setForeground(SystemColor.text);
		lbFechaF.setBounds(51, 209, 159, 14);
		lbFechaF.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(lbFechaF);
		txtFechaF = new JTextField();
		txtFechaF.setBackground(SystemColor.inactiveCaption);
		txtFechaF.setBounds(51, 224, 150, 20);
		getContentPane().add(txtFechaF);
		
		lbDescuento = new JLabel("% Descuento");
		lbDescuento.setForeground(SystemColor.text);
		lbDescuento.setBounds(51, 249, 159, 14);
		lbDescuento.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(lbDescuento);
		txtDescuento = new JTextField();
		txtDescuento.setBackground(SystemColor.inactiveCaption);
		txtDescuento.setBounds(51, 264, 150, 20);
		getContentPane().add(txtDescuento);		
		
		/*lbEspectaculo = new JLabel("Espectáculo");
		lbEspectaculo.setBounds(22, 250, 159, 14);
		lbEspectaculo.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(lbEspectaculo);
		txtEspectaculo = new JTextField();
		txtEspectaculo.setBounds(22, 265, 150, 20);
		getContentPane().add(txtEspectaculo);
		
		bAgregar = new JButton("Agregar espectáculo");
		bAgregar.setBounds(199, 264, 150, 23);
		bAgregar.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(bAgregar);
		bAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}			
		});*/
		
		bAceptar = new JButton("");
		bAceptar.setToolTipText("Aceptar");
		bAceptar.setBorder(null);
		bAceptar.setBackground(new Color(0, 0, 51));
		bAceptar.setIcon(new ImageIcon(CrearPaquete.class.getResource("/recursos/aceptar-icon-48px.png")));
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aceptarCrearPaquete(e);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(bAgregar, e1.getMessage(), "crear paquete", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		bAceptar.setBounds(69, 295, 45, 41);
		bAceptar.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(bAceptar);
		
		bCancelar = new JButton("");
		bCancelar.setToolTipText("Cancelar");
		bCancelar.setBorder(null);
		bCancelar.setBackground(new Color(0, 0, 51));
		bCancelar.setIcon(new ImageIcon(CrearPaquete.class.getResource("/recursos/cancelar-icon-48px.png")));
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarCrearPaquete(e);				
			}
		});
		bCancelar.setBounds(146, 295, 45, 41);
		bCancelar.setFont(new Font("Arial", Font.BOLD, 11));
		getContentPane().add(bCancelar);
		
		nCheck = new JCheckBox();
		nCheck.setBounds(214, 89, 21, 14);
		nCheck.setVisible(false);		        
		getContentPane().add(nCheck);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CrearPaquete.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel.setBounds(10, 23, 244, 55);
		getContentPane().add(lblNewLabel);
		
		/*scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 45, 161, 185);
		getContentPane().add(scrollPane);
		
		txAEspectaculos = new JTextArea();
		txAEspectaculos.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		txAEspectaculos.setLineWrap(true);
		txAEspectaculos.setEditable(false);
		txAEspectaculos.setVisible(false);
		scrollPane.setViewportView(txAEspectaculos);
		
		lbEspectaculosPaquete = new JLabel("Espect\u00E1culos");
		lbEspectaculosPaquete.setFont(new Font("Arial", Font.BOLD, 11));
		lbEspectaculosPaquete.setBounds(359, 28, 150, 14);
		lbEspectaculosPaquete.setVisible(false);
		getContentPane().add(lbEspectaculosPaquete);*/			
	}
	
	private void aceptarCrearPaquete(ActionEvent e) throws PaqueteNoValidoException, NombreNullException, Exception{
		String nombre, desc, fechaI, fechaF;
		float descuento;
		LocalDate fechaFin = null;	
		LocalDate fechaIni = null;
		LocalDate fechaR = LocalDate.now();
		DateTimeFormatter formatter1;		
		formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		fechaR.format(formatter1);		
		try {
			fechaI = txtFechaI.getText();
			fechaIni = LocalDate.parse(fechaI, formatter1);					
		} catch (Exception e1) {
			txtFechaI.setText("");
			throw new Exception("La fecha inicial no es válida [dd/MM/yyyy]"); 	
		}
		try {
			fechaF = txtFechaF.getText();
			fechaFin = LocalDate.parse(fechaF, formatter1);	
		} catch (Exception e1) {
			txtFechaF.setText("");
			throw new Exception("La fecha final no es válida [dd/MM/yyyy]"); 	
		}	
		
		if(fechaFin.isBefore(fechaIni)) {
			throw new Exception("La fecha final debe ser posterior a la inicial");
		}
		
		nombre = txtNombrePaquete.getText();		
		if (nombre.isEmpty())
			throw new NombreNullException("El nombre del paquete no puede ser vacío");
		
		desc = txtDescripcion.getText();
		
		String d = txtDescuento.getText();		
		descuento = Float.parseFloat(d);
		
		DtPaquete dtp = null;		
		
		if (icon.chequearDisponibilidadPaquete(nombre)) {
			ArrayList<String> l = null;
			dtp = new DtPaquete(nombre, desc, fechaIni, fechaFin, fechaR, descuento, l);
		} else {
			throw new PaqueteNoValidoException("Nombre inválido " + nombre + " ya existe en el sistema");
		}
		
		icon.ingresarDatosPaquete(dtp);
		icon.altaPaquete();		
		JOptionPane.showMessageDialog(this, "El paquete fue agregado correctamente", "crear paquete", JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
		setVisible(false);
	}	
	
	private void cancelarCrearPaquete(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}

	private void limpiarFormulario() {
		txtDescuento.setText("");
		txtFechaF.setText("");
		txtFechaI.setText("");	
		txtDescripcion.setText("");
		txtNombrePaquete.setText("");
	}	
}
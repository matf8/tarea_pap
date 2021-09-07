package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.*;

import datatypes.DtFuncion;
import excepciones.NombreNullException;
import excepciones.PlataformaNoExisteException;
import interfaces.IControladorFuncion;
import persistencia.Conexion;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.SystemColor;

public class AltaFuncion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorFuncion icon;		
	private JLabel lbEspectaculo, lbHora, lbFuncion;
	private JButton bAceptar, bCancelar;
	private JTextField txtFuncion, txtInvitados, txtPlataforma, txtHora, txtFecha;;
	private JComboBox<String> cbEspectaculo;
	
	public AltaFuncion(IControladorFuncion icon) {		
		this.icon = icon;
		setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("alta función");
		setBounds(100, 100, 438, 327);
		setFont(new Font("Arial", Font.BOLD, 10));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 422, 297);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton bAgregar = new JButton("Agregar Artista");
		bAgregar.setBounds(271, 215, 130, 23);
		panel.add(bAgregar);
		
		JLabel lbFecha = new JLabel("Fecha");
		lbFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFecha.setBounds(259, 125, 46, 14);
		panel.add(lbFecha);
		lbFecha.setForeground(SystemColor.text);
		lbFecha.setFont(new Font("Arial", Font.BOLD, 10));
		
		txtFecha = new JTextField();
		txtFecha.setBounds(315, 119, 86, 20);
		panel.add(txtFecha);
		txtFecha.setForeground(Color.GRAY);
		txtFecha.setText("dd/mm/yyyy");
		txtFecha.setBackground(SystemColor.inactiveCaption);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(315, 149, 86, 20);
		panel.add(txtHora);
		txtHora.setForeground(Color.GRAY);
		txtHora.setText("xx:xx");
		txtHora.setBackground(SystemColor.inactiveCaption);
		txtHora.setColumns(10);
		
		lbHora = new JLabel("Hora Inicio");
		lbHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lbHora.setBounds(222, 155, 86, 14);
		panel.add(lbHora);
		lbHora.setForeground(SystemColor.text);
		lbHora.setFont(new Font("Arial", Font.BOLD, 10));
		
		JLabel lbArtistasInvitados = new JLabel("Artistas invitados");
		lbArtistasInvitados.setHorizontalAlignment(SwingConstants.RIGHT);
		lbArtistasInvitados.setBounds(198, 190, 110, 14);
		panel.add(lbArtistasInvitados);
		lbArtistasInvitados.setForeground(SystemColor.text);
		lbArtistasInvitados.setFont(new Font("Arial", Font.BOLD, 10));
		
		txtInvitados = new JTextField();
		txtInvitados.setBounds(315, 184, 86, 20);
		panel.add(txtInvitados);
		txtInvitados.setBackground(SystemColor.inactiveCaption);
		txtInvitados.setColumns(10);
		
		lbFuncion = new JLabel("Nombre Función");
		lbFuncion.setBounds(207, 94, 98, 14);
		panel.add(lbFuncion);
		lbFuncion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFuncion.setForeground(SystemColor.text);
		lbFuncion.setFont(new Font("Arial", Font.BOLD, 10));
		
		txtFuncion = new JTextField();
		txtFuncion.setBounds(315, 91, 86, 20);
		panel.add(txtFuncion);
		txtFuncion.setBackground(SystemColor.inactiveCaption);
		txtFuncion.setColumns(10);
		
		cbEspectaculo = new JComboBox <String> ();		
		cbEspectaculo.setBounds(36, 150, 142, 18);
		panel.add(cbEspectaculo);
		cbEspectaculo.setBackground(SystemColor.text);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBounds(36, 91, 142, 20);
		panel.add(txtPlataforma);
		txtPlataforma.setBackground(SystemColor.inactiveCaption);
		txtPlataforma.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ingresarDatosCB();
			}			
		});		
		//txtPlataforma.setColumns(10);
		
		lbEspectaculo = new JLabel("Seleccionar espectáculo");
		lbEspectaculo.setBounds(36, 133, 152, 14);
		panel.add(lbEspectaculo);
		lbEspectaculo.setHorizontalAlignment(SwingConstants.LEFT);
		lbEspectaculo.setForeground(SystemColor.text);
		lbEspectaculo.setFont(new Font("Arial", Font.BOLD, 10));
		
		JLabel lbPlataforma = new JLabel("Nombre Plataforma");
		lbPlataforma.setBounds(36, 74, 142, 14);
		panel.add(lbPlataforma);
		lbPlataforma.setHorizontalAlignment(SwingConstants.LEFT);
		lbPlataforma.setForeground(SystemColor.text);
		lbPlataforma.setFont(new Font("Arial", Font.BOLD, 10));
		
		bCancelar = new JButton("");
		bCancelar.setToolTipText("Cancelar");
		bCancelar.setBackground(new Color(0, 0, 51));
		bCancelar.setBorderPainted(false);
		bCancelar.setIcon(new ImageIcon(AltaFuncion.class.getResource("/recursos/cancelar-icon-48px.png")));
		bCancelar.setBounds(216, 239, 46, 47);
		panel.add(bCancelar);
		
		bAceptar = new JButton("");
		bAceptar.setToolTipText("Aceptar");
		bAceptar.setBackground(new Color(0, 0, 51));
		bAceptar.setBorderPainted(false);
		bAceptar.setIcon(new ImageIcon(AltaFuncion.class.getResource("/recursos/aceptar-icon-48px.png")));
		bAceptar.setBounds(153, 239, 46, 47);
		panel.add(bAceptar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AltaFuncion.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel.setBounds(87, 11, 244, 58);
		panel.add(lblNewLabel);
		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaFuncionAceptarActionPerformed(e);
				} catch (Exception e1) {
					  JOptionPane.showMessageDialog(bAceptar, e1.getMessage(), "alta funcion", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaFuncionCancelarActionPerformed(e);
			}
		});
		
		txtHora.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtHora.getText().equals("xx:xx")) {
	    			txtHora.setText("");
	    			txtHora.setForeground(Color.black);
	    		}
			}
		});
//		txtHora.addMouseListener(new MouseAdapter() {
//	    	@Override
//	    	public void mousePressed(MouseEvent e) {
//	    		if(txtHora.getText().equals("xx:xx")) {
//	    			txtHora.setText("");
//	    			txtHora.setForeground(Color.black);
//	    		}
//	    	}
//	    });
		
		txtFecha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFecha.getText().equals("dd/mm/yyyy")) {
	    			txtFecha.setText("");
	    			txtFecha.setForeground(Color.black);
	    		}
			}
		});
//		txtFecha.addMouseListener(new MouseAdapter() {
//	    	@Override
//	    	public void mousePressed(MouseEvent e) {
//	    		if(txtFecha.getText().equals("dd/mm/yyyy")) {
//	    			txtFecha.setText("");
//	    			txtFecha.setForeground(Color.black);
//	    		}
//	    	}
//	    });
		bAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String invi;
				invi = txtInvitados.getText();
				try{
					icon.ingresarArtista(invi);
					JOptionPane.showMessageDialog(bAgregar, "El artista fue agregado correctamente", "alta función", JOptionPane.INFORMATION_MESSAGE);  
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(bAgregar, e2.getMessage(), "alta función", JOptionPane.ERROR_MESSAGE);           		
				}	
			}
		});
	}	
	
	protected void altaFuncionAceptarActionPerformed(ActionEvent e) throws NombreNullException, Exception{
		String nombreE, nombreF, horaInicio, fechaFuncion;
		ArrayList<String> listaI = null;
		LocalDate fechaF = null;	
		LocalTime horaI = null;
					
		DateTimeFormatter formatter1;
		LocalDate fechaR;
		fechaR = LocalDate.now();
		DateTimeFormatter formatter2;
		formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fechaR.format(formatter2);
		formatter1 = DateTimeFormatter.ofPattern("HH:mm");
		try {
			horaInicio = txtHora.getText();
			horaI = LocalTime.parse(horaInicio, formatter1);
		} catch (Exception e1) {
			txtHora.setText("");
			throw new Exception("La hora es invalida[hh:mm]"); 
		}
		try {
			fechaFuncion = txtFecha.getText();
			fechaF = LocalDate.parse(fechaFuncion, formatter2);
		} catch (Exception e1) {
			txtFecha.setText("");
			throw new Exception("La fecha no es valida[dd/MM/yyyy]");
		}
				
		nombreE = cbEspectaculo.getSelectedItem().toString();
		nombreF = txtFuncion.getText();
		
		String nick = this.txtFuncion.getText();
	    if(nick.isEmpty()) {
	    	throw new NombreNullException("El nombre de la función no puede estar vacío");
	    } 
		
		DtFuncion dtf = new DtFuncion(nombreF, fechaF, horaI, fechaR, listaI); 
		
		try {
			this.icon.seleccionarEspectaculo(nombreE);
			this.icon.ingresarFuncion(dtf);			
			this.icon.chequearDisponibilidadNombreFuncion(nombreF);
			this.icon.altaFuncion();
        	JOptionPane.showMessageDialog(this, "Funcion creada exitosamente", "alta funciÃ³n", JOptionPane.INFORMATION_MESSAGE);
        	limpiarFormulario();
    		setVisible(false);	
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage(), "alta funciÃ³n", JOptionPane.ERROR_MESSAGE);	           		
		}		
	}
	
	protected void altaFuncionCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}

	private void limpiarFormulario() {
		txtPlataforma.setText("");
		txtFuncion.setText("");
		txtFecha.setForeground(Color.GRAY);
		txtFecha.setText("dd/mm/yyyy");
		txtHora.setForeground(Color.GRAY);
		txtHora.setText("xx:xx");
	}
	
	private void ingresarDatosCB() {
		ArrayList<String> lista = null;
		try {
			cbEspectaculo.removeAllItems();		
			lista = this.icon.listarEspectaculos(txtPlataforma.getText());
			for(String t: lista) {
				cbEspectaculo.addItem(t);				
			}
		} catch (PlataformaNoExisteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "alta funcion", JOptionPane.ERROR_MESSAGE);
		}		
	}
}
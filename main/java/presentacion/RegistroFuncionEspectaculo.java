package presentacion;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import datatypes.DtFuncion;
import datatypes.DtRegistroCompleto;
import excepciones.EspectaculoNoValidoException;
import excepciones.FuncionNoValidaException;
import excepciones.PlataformaNoExisteException;
import interfaces.IControladorFuncion;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class RegistroFuncionEspectaculo extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorFuncion icon;
	private JComboBox<String> cBEspectaculo, cBFuncion, cBEspectador;
	private JLabel lbPlataforma, lbEspectaculo;
	private JTextField txtPlataforma;
	private JButton bEspectaculo, bMostrar;
	private JTextArea txtrDt, txtrRegistros;
	private JLabel lbFuncion;
	private JScrollPane scrollPane, scrollPane2;
	private JLabel lbEspectador;
	private JList<DtRegistroCompleto> registrosEspectador;
	private DefaultListModel<DtRegistroCompleto> lR;
	
	public RegistroFuncionEspectaculo(IControladorFuncion icon) {
		this.icon = icon;
		getContentPane().setBackground(new Color(0, 0, 51));
		setBounds(100, 100, 525, 513);		
		getContentPane().setLayout(null);		
		
		lbPlataforma = new JLabel("Nombre Plataforma");
		lbPlataforma.setBounds(35, 35, 142, 14);
		getContentPane().add(lbPlataforma);
		lbPlataforma.setHorizontalAlignment(SwingConstants.LEFT);
		lbPlataforma.setForeground(SystemColor.text);
		lbPlataforma.setFont(new Font("Arial", Font.BOLD, 10));
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBounds(34, 50, 110, 20);
		getContentPane().add(txtPlataforma);
		txtPlataforma.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ingresarDatosCB();
			}			
		});	

		lbEspectaculo = new JLabel("Espect\u00E1culo");
		lbEspectaculo.setHorizontalAlignment(SwingConstants.LEFT);
		lbEspectaculo.setForeground(Color.WHITE);
		lbEspectaculo.setFont(new Font("Arial", Font.BOLD, 10));
		lbEspectaculo.setBounds(35, 80, 142, 14);
		getContentPane().add(lbEspectaculo);
		
		txtrDt = new JTextArea();
		txtrDt.setForeground(SystemColor.text);
		txtrDt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de funci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtrDt.setBounds(317, 34, 0, 0);
		txtrDt.setBackground(new Color(0, 0, 51));
		txtrDt.setEditable(false);
		scrollPane = new JScrollPane(txtrDt);
		scrollPane.setBorder(null);
		scrollPane.setBounds(324, 49, 156, 188);
		getContentPane().add(scrollPane);
				
		cBEspectaculo = new JComboBox <String> ();
		cBEspectaculo.setBackground(new Color(255, 255, 255));
		cBEspectaculo.setBounds(35, 95, 110, 22);
		getContentPane().add(cBEspectaculo);	
		
		cBFuncion = new JComboBox <String> ();
		cBFuncion.setBackground(new Color(255, 255, 255));
		cBFuncion.setBounds(35, 140, 110, 22);
		getContentPane().add(cBFuncion);	
				
		bEspectaculo = new JButton("Seleccionar");
		bEspectaculo.setBounds(165, 95, 100, 22);
		getContentPane().add(bEspectaculo);
		bEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> auxl=null;
				try {
					icon.seleccionarEspectaculo((String)cBEspectaculo.getSelectedItem());			
					auxl = icon.listarFunciones();
					cBFuncion.setEnabled(true);
					cBFuncion.removeAllItems();
					txtrDt.setEnabled(false);
					txtrDt.setText("");					
					if (!auxl.isEmpty()) {
						for (String s : auxl) 
							cBFuncion.addItem(s);
					} else JOptionPane.showMessageDialog(txtPlataforma, "El espectáculo no tiene funciones asociadas", "consulta funcion", JOptionPane.WARNING_MESSAGE);		
					cBFuncion.setSelectedItem(null);
				} catch (EspectaculoNoValidoException e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta funcion", JOptionPane.ERROR_MESSAGE);
				}			
			}
		});
		
		lbFuncion = new JLabel("Funci\u00F3n");
		lbFuncion.setHorizontalAlignment(SwingConstants.LEFT);
		lbFuncion.setForeground(Color.WHITE);
		lbFuncion.setFont(new Font("Arial", Font.BOLD, 10));
		lbFuncion.setBounds(35, 125, 142, 14);
		getContentPane().add(lbFuncion);
		
		bMostrar = new JButton("Mostrar");
		bMostrar.setBounds(165, 140, 100, 22);
		getContentPane().add(bMostrar);			
		bMostrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DtFuncion dtf = null;
			try {							
				dtf = icon.seleccionarFuncion((String)cBFuncion.getSelectedItem());
				txtrDt.setEnabled(true);
				txtrDt.setText(dtf.toString());
			} catch (FuncionNoValidaException e1) {
				JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta funcion",JOptionPane.ERROR_MESSAGE);
			} 		
		}
		});	
				
		cBEspectador = new JComboBox<String>();
		cBEspectador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				seleccionarEspectador(e);
			}
		});
		
		cBEspectador.setBounds(35, 185, 110, 20);
		getContentPane().add(cBEspectador);
		ArrayList<String> lU = icon.listarEspectadores();
		for (String s: lU) {
			cBEspectador.addItem(s);
		}
		cBEspectador.setSelectedItem(null);	
		
		lbEspectador = new JLabel("Espectadores");
		lbEspectador.setHorizontalAlignment(SwingConstants.LEFT);
		lbEspectador.setForeground(Color.WHITE);
		lbEspectador.setFont(new Font("Arial", Font.BOLD, 10));
		lbEspectador.setBounds(35, 170, 142, 14);
		getContentPane().add(lbEspectador);
		
		txtrRegistros = new JTextArea();
		txtrRegistros.setForeground(SystemColor.text);
		txtrRegistros.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtrRegistros.setBounds(317, 34, 0, 0);
		txtrRegistros.setBackground(new Color(0, 0, 51));
		txtrRegistros.setEditable(false);
				
		//scrollPane2 = new JScrollPane(txtrRegistros);
		scrollPane2 = new JScrollPane();
		scrollPane2.setBackground(new Color(0, 0, 51));
		scrollPane2.setBorder(null);
		scrollPane2.setBounds(35, 235, 156, 188);
		scrollPane2.setVisible(true);
		getContentPane().add(scrollPane2);
		
		
		lR = new DefaultListModel<DtRegistroCompleto>();
		registrosEspectador = new JList<DtRegistroCompleto>(lR);
		registrosEspectador.setForeground(new Color(255, 255, 255));	
		registrosEspectador.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		registrosEspectador.setBackground(new Color(0, 0, 51));
		registrosEspectador.setVisible(false);
		scrollPane2.setViewportView(registrosEspectador);	
		
		JButton btnR = new JButton("Registrar");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					registrar();
				}catch (Exception e1) {}
			}
		});
		btnR.setBounds(244, 401, 100, 22);
		getContentPane().add(btnR);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
			
		});
		btnCancelar.setBounds(380, 401, 100, 22);
		getContentPane().add(btnCancelar);
	}
	
	private void ingresarDatosCB() {
		ArrayList<String> lista = null;
		try {
			cBEspectaculo.removeAllItems();		
			lista = this.icon.listarEspectaculos(txtPlataforma.getText());
			for(String t: lista) {
				cBEspectaculo.addItem(t);				
			}
		} catch (PlataformaNoExisteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "alta funcion", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	private void seleccionarEspectador(FocusEvent e) {
		String u = (String) cBEspectaculo.getSelectedItem();
		ArrayList<DtRegistroCompleto> r = null;
		registrosEspectador.setVisible(true);
		try {
			r = icon.listarRegistros(u);
			for (DtRegistroCompleto d: r)
				lR.addElement(d);
		} catch (Exception e1) {}
				
	}
	
	private void registrar() throws Exception {				
		List<DtRegistroCompleto> rS = registrosEspectador.getSelectedValuesList();
		if (rS.size() != 3 && rS.size() != 0)
			throw new Exception ("Debe seleccionar 3 registros");
		else  {					
			List<Integer> k = new ArrayList<>();			
			for (DtRegistroCompleto dtr: rS) {
				k.add(dtr.getId());
				
			icon.altaRegistro(k);
        	JOptionPane.showMessageDialog(this, "Registro creado exitosamente", "registro función", JOptionPane.INFORMATION_MESSAGE);
			cancelar();	
		
		}
		
		}
		
	}
	
	
	private void cancelar() {
		limpiarFormulario();
        setVisible(false);
	}

	private void limpiarFormulario() {	
		txtPlataforma.setText("");
		txtrDt.setText("");	
		txtrRegistros.setText("");
		cBEspectaculo.setSelectedItem(null);
		cBFuncion.setSelectedItem(null);
		cBEspectador.setSelectedItem(null);
	 }	
}

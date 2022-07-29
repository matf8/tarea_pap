package presentacion;

import interfaces.IControladorEspectaculo;

import excepciones.EspectaculoNoValidoException;
import excepciones.FuncionNoValidaException;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoExisteException;

import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import datatypes.DtEspectaculoCompleto;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;

public class ConsultaEspectaculo extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IControladorEspectaculo icon;
	private JTextField txtPlataforma;
	private JComboBox<String> cBEspectaculos, cBFunciones, cBPaquetes;
	private DtEspectaculoCompleto dtec;
	private JTextPane txtPaneDt;
	private JTextArea txtAreaExtraDt;
	
	public ConsultaEspectaculo(IControladorEspectaculo icon) {
		getContentPane().setBackground(new Color(0, 0, 51));
		this.icon = icon;		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setResizable(false);
		setTitle("consulta espectáculo");		
		setBounds(100, 100, 573, 529);
		getContentPane().setLayout(null);		
		
		cBEspectaculos = new JComboBox<String>();
		cBEspectaculos.setBackground(SystemColor.text);
		cBEspectaculos.setBounds(20, 173, 146, 26);
		getContentPane().add(cBEspectaculos);
		
		JLabel lbEspectaculo = new JLabel("Espectáculos");
		lbEspectaculo.setForeground(SystemColor.text);
		lbEspectaculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEspectaculo.setBounds(20, 151, 203, 20);
		getContentPane().add(lbEspectaculo);
		
		JLabel lbPlataforma = new JLabel("Plataforma");
		lbPlataforma.setForeground(SystemColor.text);
		lbPlataforma.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbPlataforma.setBounds(20, 83, 101, 20);
		getContentPane().add(lbPlataforma);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBackground(SystemColor.inactiveCaption);
		txtPlataforma.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					txtPaneDt.setText("");
					txtAreaExtraDt.setText("");
					cBEspectaculos.removeAllItems();
					cBFunciones.removeAllItems();
					cBPaquetes.removeAllItems();					
					ArrayList<String> auxl = icon.listarEspectaculos(txtPlataforma.getText());
					for (String s: auxl) {
						cBEspectaculos.addItem(s);
					}
				} catch (PlataformaNoExisteException e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta función", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		txtPlataforma.setBounds(20, 103, 146, 26);
		getContentPane().add(txtPlataforma);
		txtPlataforma.setColumns(10);
		
		JButton btnCheckEspectaculo = new JButton("Consultar");
		btnCheckEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtPaneDt.setText("");
					txtAreaExtraDt.setText("");					
					dtec = icon.seleccionarEspectaculo((String) cBEspectaculos.getSelectedItem());
					txtPaneDt.setText(dtec.toString());
					ArrayList<String> auxl = (ArrayList) dtec.getFuncionesAsociadas();
					cBFunciones.removeAllItems();
					for (String s: auxl) {
						cBFunciones.addItem(s);
					}
					auxl = (ArrayList) dtec.getPaquetesAsociados();
					cBPaquetes.removeAllItems();
					for (String s: auxl) {
						cBPaquetes.addItem(s);
					}					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta función", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		btnCheckEspectaculo.setBounds(205, 172, 115, 29);
		getContentPane().add(btnCheckEspectaculo);
		
		txtPaneDt = new JTextPane();
		txtPaneDt.setDisabledTextColor(SystemColor.text);
		txtPaneDt.setForeground(SystemColor.text);
		txtPaneDt.setMargin(new Insets(0, 0, 0, 0));
		txtPaneDt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de Espect\u00E1culos", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		txtPaneDt.setBackground(new Color(0, 0, 51));
		txtPaneDt.setEditable(false);
		txtPaneDt.setBounds(342, 16, 203, 240);
		getContentPane().add(txtPaneDt);
		
		JScrollPane scrollPane2 = new JScrollPane(txtPaneDt);
		scrollPane2.setForeground(SystemColor.text);
		scrollPane2.setBounds(342, 16, 203, 240);
		scrollPane2.setBorder(null);
		getContentPane().add(scrollPane2);
		
		JLabel lblFuncionesAsociadas = new JLabel("Funciones Asociadas");
		lblFuncionesAsociadas.setForeground(SystemColor.text);
		lblFuncionesAsociadas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuncionesAsociadas.setBounds(20, 306, 157, 20);
		getContentPane().add(lblFuncionesAsociadas);
		
		cBFunciones = new JComboBox<String>();
		cBFunciones.setBackground(SystemColor.text);
		cBFunciones.setBounds(20, 327, 146, 26);
		getContentPane().add(cBFunciones);
		
		JLabel lblPaquetesAsociados = new JLabel("Paquetes Asociados");
		lblPaquetesAsociados.setForeground(SystemColor.text);
		lblPaquetesAsociados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaquetesAsociados.setBounds(20, 382, 146, 20);
		getContentPane().add(lblPaquetesAsociados);
		
		cBPaquetes = new JComboBox<String>();
		cBPaquetes.setBackground(SystemColor.text);
		cBPaquetes.setBounds(20, 401, 146, 26);
		getContentPane().add(cBPaquetes);
		
		JButton bFuncion = new JButton("Consultar");
		bFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAreaExtraDt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de funci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
				txtAreaExtraDt.setDisabledTextColor(SystemColor.text);
				try {
					if (cBFunciones.getSelectedItem() != null) {
						DtFuncion dtf = icon.seleccionarFuncion(cBFunciones.getSelectedItem().toString());
						txtAreaExtraDt.setText(dtf.toString());
					}
				} catch (FuncionNoValidaException e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta función", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		bFuncion.setBounds(205, 326, 115, 29);
		getContentPane().add(bFuncion);
		
		JButton bPaquete = new JButton("Consultar");
		bPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAreaExtraDt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de paquete", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
				txtAreaExtraDt.setDisabledTextColor(SystemColor.text);
				try {
					if (cBPaquetes.getSelectedItem() != null) {
						DtPaquete dtp = icon.seleccionarPaquete(cBPaquetes.getSelectedItem().toString());
						txtAreaExtraDt.setText(dtp.toString());
					}
				} catch (PaqueteNoValidoException e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta función", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		bPaquete.setBounds(205, 399, 115, 29);
		getContentPane().add(bPaquete);
			
		txtAreaExtraDt = new JTextArea();
		txtAreaExtraDt.setLineWrap(true);
		txtAreaExtraDt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAreaExtraDt.setForeground(SystemColor.text);
		txtAreaExtraDt.setDisabledTextColor(SystemColor.text);
		txtAreaExtraDt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtAreaExtraDt.setBackground(new Color(0, 0, 51));
		txtAreaExtraDt.setEditable(false);
		txtAreaExtraDt.setBounds(342, 276, 203, 205);
		getContentPane().add(txtAreaExtraDt);
		
		JScrollPane scrollPane = new JScrollPane(txtAreaExtraDt);
		scrollPane.setForeground(SystemColor.text);
		scrollPane.setBounds(342, 276, 203, 205);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane);		
		
		JLabel lbConsultasExtra = new JLabel("CONSULTAS EXTRAS");
		lbConsultasExtra.setForeground(SystemColor.text);
		lbConsultasExtra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbConsultasExtra.setBounds(121, 261, 133, 20);
		getContentPane().add(lbConsultasExtra);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultaEspectaculo.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel.setBounds(54, 16, 278, 66);
		getContentPane().add(lblNewLabel);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setBackground(new Color(0, 0, 51));
		btnCancelar.setBorder(null);
		btnCancelar.setIcon(new ImageIcon(ConsultaEspectaculo.class.getResource("/recursos/cancelar-icon-48px.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(240, 440, 48, 48);
		getContentPane().add(btnCancelar);		
	}
	
	protected void limpiarFormulario() {
		cBEspectaculos.removeAllItems();
		cBFunciones.removeAllItems(); 
		cBPaquetes.removeAllItems();
		txtPlataforma.setText("");
		txtPaneDt.setText("");
		txtAreaExtraDt.setText("");
	}
	
	private void cancelar() {
		cBEspectaculos.removeAllItems();
		cBFunciones.removeAllItems(); 
		cBPaquetes.removeAllItems();
		txtPlataforma.setText("");
		txtPaneDt.setText("");
		txtAreaExtraDt.setText("");
		this.setVisible(false);		
	}
}

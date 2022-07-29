package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import datatypes.DtEspectaculoCompleto;
import datatypes.DtPaquete;
import interfaces.IControladorPaquete;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ConsultaPaquete extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorPaquete icon;
	private JComboBox<String> comboBoxPaquetes;
	private JTextArea textAreaDtPaquete;
	private JComboBox<String> comboBoxEspectaculo;
	private JTextArea textAreaDtEspectaculo ;
	private JButton btnCancelar;
	private JScrollPane scrollPane1, scrollPane2;	

	public ConsultaPaquete(IControladorPaquete iconP) {
		getContentPane().setBackground(new Color(0, 0, 51));
		icon=iconP;
		setResizable(false);
		setClosable(true);
		setTitle("consulta paquete");
		setBounds(0, 0, 491, 442);
		getContentPane().setLayout(null);
		
		textAreaDtEspectaculo = new JTextArea();
		textAreaDtEspectaculo.setForeground(SystemColor.text);
		textAreaDtEspectaculo.setDisabledTextColor(SystemColor.text);
		textAreaDtEspectaculo.setBorder(new TitledBorder(null, "Datos de espect\u00E1culo", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		textAreaDtEspectaculo.setBackground(new Color(0, 0, 51));
		textAreaDtEspectaculo.setEditable(false);
		textAreaDtEspectaculo.setFont(new Font("Arial", Font.PLAIN, 13));
		textAreaDtEspectaculo.setLineWrap(true);
		textAreaDtEspectaculo.setBounds(214, 208, 237, 137);
		getContentPane().add(textAreaDtEspectaculo);
		
		scrollPane1 = new JScrollPane(textAreaDtEspectaculo);
		scrollPane1.setBorder(null);
		scrollPane1.setLocation(220, 210);
		scrollPane1.setSize(237, 142);
		getContentPane().add(scrollPane1);
		
		
		comboBoxPaquetes = new JComboBox<String>();
		comboBoxPaquetes.setBounds(15, 70, 157, 26);
		getContentPane().add(comboBoxPaquetes);
		
		JLabel lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setForeground(SystemColor.text);
		lblPaquetes.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPaquetes.setBounds(15, 48, 69, 20);
		getContentPane().add(lblPaquetes);
		
		textAreaDtPaquete = new JTextArea();
		textAreaDtPaquete.setForeground(SystemColor.text);
		textAreaDtPaquete.setDisabledTextColor(SystemColor.text);
		textAreaDtPaquete.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de paquete", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textAreaDtPaquete.setBackground(new Color(0, 0, 51));
		textAreaDtPaquete.setEditable(false);
		textAreaDtPaquete.setFont(new Font("Arial", Font.PLAIN, 13));
		textAreaDtPaquete.setLineWrap(true);
		textAreaDtPaquete.setBounds(214, 34, 237, 142);
		getContentPane().add(textAreaDtPaquete);
		
		JLabel lblEspectaculosDelPaquete = new JLabel("Espectaculos del Paquete");
		lblEspectaculosDelPaquete.setForeground(SystemColor.text);
		lblEspectaculosDelPaquete.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEspectaculosDelPaquete.setBounds(15, 222, 184, 20);
		getContentPane().add(lblEspectaculosDelPaquete);
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.setBounds(15, 244, 157, 26);
		getContentPane().add(comboBoxEspectaculo);
		
		JButton btnPaquete = new JButton("Consultar");
		btnPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPaquete();
			}
		});
		btnPaquete.setBounds(25, 112, 115, 29);
		getContentPane().add(btnPaquete);
		
		JButton btnEspectaculo = new JButton("Consultar");
		btnEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkEspectaculo();
				} catch (Exception e1) {					
					e1.printStackTrace();
				}
			}
			
		});
		btnEspectaculo.setBounds(25, 286, 115, 29);
		getContentPane().add(btnEspectaculo);
		
		btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(0, 0, 51));
		btnCancelar.setIcon(new ImageIcon(ConsultaPaquete.class.getResource("/recursos/cancelar-icon-48px.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(384, 356, 48, 48);
		getContentPane().add(btnCancelar);
		
		scrollPane2 = new JScrollPane(textAreaDtPaquete);
		scrollPane2.setForeground(SystemColor.text);
		scrollPane2.setBounds(220, 50, 237, 142);
		scrollPane2.setBorder(null);
		getContentPane().add(scrollPane2);
	}
	
	public void cargarPaquetes() {
		ArrayList<String> arrayS=icon.listarPaquetes();
		this.comboBoxPaquetes.removeAllItems();
		for(String s: arrayS) {
			comboBoxPaquetes.addItem(s);
		}			
	}

	private void checkPaquete() {
		DtPaquete aux=icon.seleccionarPaquete((String)comboBoxPaquetes.getSelectedItem());
		textAreaDtPaquete.setText(aux.toString());
		ArrayList<String> arrayS=(ArrayList<String>)aux.getEspectaculos();
		comboBoxEspectaculo.removeAllItems();
		for(String s: arrayS) {
			comboBoxEspectaculo.addItem(s);
		}
	}
	
	private void checkEspectaculo() throws Exception {
		DtEspectaculoCompleto aux=icon.seleccionarEspectaculo((String)comboBoxEspectaculo.getSelectedItem());
		textAreaDtEspectaculo.setText(aux.toString());
	}
	
	protected void limpiarFormulario() {
		comboBoxEspectaculo.removeAllItems();
		comboBoxPaquetes.removeAllItems(); 
		textAreaDtEspectaculo.setText("");
		textAreaDtPaquete.setText("");
	}
	
	private void cancelar() {
		comboBoxEspectaculo.removeAllItems();
		comboBoxPaquetes.removeAllItems(); 
		textAreaDtEspectaculo.setText("");
		textAreaDtPaquete.setText("");
		this.setVisible(false);
	}
}



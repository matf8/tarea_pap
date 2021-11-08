package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import excepciones.PlataformaNoValidaException;
import interfaces.IControladorPaquete;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AgregarEspectaculosAPaquete extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorPaquete icon;
	private JTextField textFieldPlataforma;
	private JComboBox<String>  comboBoxEspectaculos;
	JComboBox<String> comboBoxPaquete;

	public AgregarEspectaculosAPaquete(IControladorPaquete iconP) {
		getContentPane().setForeground(SystemColor.text);
		getContentPane().setBackground(new Color(0, 0, 51));
		
		icon=iconP;
		setClosable(true);
		setResizable(false);
		setTitle("agregar espectaculo a paquete");
		setBounds(100, 100, 310, 350);
		getContentPane().setLayout(null);
		
		comboBoxPaquete = new JComboBox<String> ();
		comboBoxPaquete.setBounds(15, 54, 262, 26);
		getContentPane().add(comboBoxPaquete);
		
		JLabel lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setForeground(SystemColor.text);
		lblPaquetes.setBounds(15, 27, 69, 20);
		getContentPane().add(lblPaquetes);
		
		textFieldPlataforma = new JTextField();
		textFieldPlataforma.setBackground(SystemColor.inactiveCaption);
		textFieldPlataforma.setBounds(16, 118, 113, 26);
		getContentPane().add(textFieldPlataforma);
		textFieldPlataforma.setColumns(10);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setForeground(SystemColor.text);
		lblPlataforma.setBounds(15, 94, 126, 20);
		getContentPane().add(lblPlataforma);
		
		comboBoxEspectaculos = new JComboBox<String> ();
		comboBoxEspectaculos.setBounds(15, 217, 262, 26);
		getContentPane().add(comboBoxEspectaculos);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos");
		lblEspectaculos.setForeground(SystemColor.text);
		lblEspectaculos.setBounds(15, 191, 113, 20);
		getContentPane().add(lblEspectaculos);
		
		JButton btnAceptar = new JButton("");
		btnAceptar.setToolTipText("Aceptar");
		btnAceptar.setBorder(null);
		btnAceptar.setBackground(new Color(0, 0, 51));
		btnAceptar.setIcon(new ImageIcon(AgregarEspectaculosAPaquete.class.getResource("/recursos/aceptar-icon-48px.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarEspectaculo();
			}
		});
		btnAceptar.setBounds(85, 262, 48, 48);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(0, 0, 51));
		btnCancelar.setIcon(new ImageIcon(AgregarEspectaculosAPaquete.class.getResource("/recursos/cancelar-icon-48px.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(162, 262, 48, 48);
		getContentPane().add(btnCancelar);
		
		JButton btnListarEspectaculos = new JButton("Listar Espectáculos");
		btnListarEspectaculos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListarEspectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarEspectaculos();
				} catch (PlataformaNoValidaException e1) {
					textFieldPlataforma.setText("");
					JOptionPane.showMessageDialog(btnListarEspectaculos, e1.getMessage(), "agregar espectaculo a paquete", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		btnListarEspectaculos.setBounds(139, 117, 138, 29);
		getContentPane().add(btnListarEspectaculos);

	}
	
	protected void cargarPaquetes() {
		comboBoxPaquete.removeAllItems();
		ArrayList<String> arrayS=icon.listarPaquetes();
		for (String s: arrayS) {
			comboBoxPaquete.addItem(s);
		}
	}
	
	private void listarEspectaculos() throws PlataformaNoValidaException {
		ArrayList<String> arrayE= icon.seleccionarPlataforma(textFieldPlataforma.getText(),(String) comboBoxPaquete.getSelectedItem());
		comboBoxEspectaculos.removeAllItems();
		for(String s:arrayE) {
			comboBoxEspectaculos.addItem(s);
		}
	}
	
	private void aceptarEspectaculo() {
		icon.agregarEspectaculoAPaquete((String)comboBoxEspectaculos.getSelectedItem());
		JOptionPane.showMessageDialog(this, "espectáculo agregado correctamente", "agregar espectaculo a paquete", JOptionPane.INFORMATION_MESSAGE); 
		cancelar();	
	}
	
	protected void limpiarFormulario() {
		textFieldPlataforma.setText("");
		comboBoxEspectaculos.removeAllItems();
		comboBoxPaquete.removeAllItems();
	}
	
	private void cancelar() {
		limpiarFormulario();
		this.setVisible(false);
	}
}

package presentacion;

import interfaces.IControladorFuncion;

import datatypes.DtFuncion;

import excepciones.EspectaculoNoValidoException;
import excepciones.FuncionNoValidaException;
import excepciones.PlataformaNoExisteException;

import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ConsultaFuncion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorFuncion icon;	
	private JTextField txtPlataforma;	
	private JComboBox<String> cBEspectaculo, cBFuncion;
	private DtFuncion dtf;
	private JTextArea txtrDt;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	public ConsultaFuncion(IControladorFuncion icon) {
		this.icon = icon;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setResizable(false);		
		setTitle("consulta funcion");
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 494, 320);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBounds(20, 89, 146, 26);
		panel.add(txtPlataforma);
		txtPlataforma.setBackground(SystemColor.inactiveCaption);
		txtPlataforma.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ArrayList<String> auxl = null;
				try {
					cBEspectaculo.setEnabled(true);
					cBFuncion.setEnabled(false);
					txtrDt.setEnabled(false);
					txtrDt.setText("");
					cBEspectaculo.removeAllItems();
					cBFuncion.removeAllItems();
					auxl = icon.listarEspectaculos(txtPlataforma.getText());
					for (String s: auxl) {
						cBEspectaculo.addItem(s);
					}
					cBEspectaculo.setSelectedItem(null);
				} catch (PlataformaNoExisteException e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta funcion", JOptionPane.ERROR_MESSAGE); 
				}				
			}
		});
		txtPlataforma.setColumns(10);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(20, 70, 111, 20);
		panel.add(lblPlataforma);
		lblPlataforma.setForeground(SystemColor.text);
		lblPlataforma.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		lblEspectaculo.setBounds(20, 124, 111, 20);
		panel.add(lblEspectaculo);
		lblEspectaculo.setForeground(SystemColor.text);
		lblEspectaculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		cBEspectaculo = new JComboBox<String>();
		cBEspectaculo.setBounds(20, 145, 146, 26);
		panel.add(cBEspectaculo);
		cBEspectaculo.setBackground(SystemColor.text);
		cBEspectaculo.setEnabled(true);
		
		JLabel lblFuncion = new JLabel("Funcion");
		lblFuncion.setBounds(20, 182, 69, 20);
		panel.add(lblFuncion);
		lblFuncion.setForeground(SystemColor.text);
		lblFuncion.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		cBFuncion = new JComboBox<String> ();
		cBFuncion.setBounds(20, 204, 146, 26);
		panel.add(cBFuncion);
		cBFuncion.setBackground(SystemColor.text);
		cBFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		cBFuncion.setEnabled(true);
		
		JButton btnFuncion = new JButton("Mostrar");
		btnFuncion.setBounds(181, 203, 93, 29);
		panel.add(btnFuncion);
		
		JButton btnEspectaculo = new JButton("Seleccionar");
		btnEspectaculo.setBounds(181, 144, 93, 29);
		panel.add(btnEspectaculo);
		
		txtrDt = new JTextArea();
		txtrDt.setForeground(SystemColor.text);
		txtrDt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de Funci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtrDt.setBounds(306, 60, 165, 172);
		panel.add(txtrDt);
		txtrDt.setBackground(new Color(0, 0, 51));
		txtrDt.setEditable(false);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConsultaFuncion.class.getResource("/recursos/coronaticketsSmall.png")));
		lblNewLabel_1.setBounds(41, 2, 255, 66);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Cancelar");
		btnNewButton.setBackground(new Color(0, 0, 51));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(ConsultaFuncion.class.getResource("/recursos/cancelar-icon-48px.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(e);
			}
		});
		btnNewButton.setBounds(372, 249, 43, 45);
		panel.add(btnNewButton);
		btnEspectaculo.addActionListener(new ActionListener() {
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
		btnFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {							
					dtf = icon.seleccionarFuncion((String)cBFuncion.getSelectedItem());
					txtrDt.setEnabled(true);
					txtrDt.setText(dtf.toString());
				} catch (FuncionNoValidaException e1) {
					JOptionPane.showMessageDialog(txtPlataforma, e1.getMessage(), "consulta funcion",JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
	}
	private void cancelar(ActionEvent e) {
		cBEspectaculo.removeAllItems();
		cBFuncion.removeAllItems();
		txtrDt.setText("");
		txtPlataforma.setText("");
		this.setVisible(false);
	}
}

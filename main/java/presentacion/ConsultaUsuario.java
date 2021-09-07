package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import interfaces.IControladorUsuario;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import datatypes.DtUsuario;
import datatypes.DtEspectador;
import datatypes.DtArtista;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class ConsultaUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorUsuario icon;	
	private JLabel lbNickname;
	private JButton bSeleccionar, bCancelar;
	private JComboBox<String> cBUsuarios;
	private JTextArea txtrDt, txtrEspecYRegistros;
	private final static String newline = "\n";
	
	public ConsultaUsuario(IControladorUsuario icon) {
		getContentPane().setBackground(new Color(0, 0, 51));	
		this.icon = icon;
		setResizable(false);        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta Usuario");
		setBounds(100, 100, 496, 326);
		getContentPane().setLayout(null);
		
		txtrEspecYRegistros = new JTextArea();
		txtrEspecYRegistros.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		txtrEspecYRegistros.setBackground(new Color(0, 0, 51));
		txtrEspecYRegistros.setLineWrap(true);
		txtrEspecYRegistros.setForeground(SystemColor.text);
		txtrEspecYRegistros.setWrapStyleWord(true);
		txtrEspecYRegistros.setEnabled(false);
		txtrEspecYRegistros.setEditable(false);
		txtrEspecYRegistros.setBounds(20, 107, 206, 178);
		getContentPane().add(txtrEspecYRegistros);
		
		lbNickname = new JLabel("Nickname");
		lbNickname.setForeground(SystemColor.text);
		lbNickname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbNickname.setBounds(20, 33, 125, 14);
		getContentPane().add(lbNickname);
		
		cBUsuarios = new JComboBox<String>();
		cBUsuarios.setBounds(20, 48, 125, 20);
		getContentPane().add(cBUsuarios);
		
		txtrDt = new JTextArea();
		txtrDt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrDt.setBorder(new TitledBorder(null, "Datos de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		txtrDt.setBackground(new Color(0, 0, 51));
		txtrDt.setLineWrap(true);
		txtrDt.setForeground(SystemColor.text);
		txtrDt.setEnabled(false);
		txtrDt.setWrapStyleWord(true);
		txtrDt.setEditable(false);
		txtrDt.setBounds(10, -13, 143, 170);
		getContentPane().add(txtrDt);
		
		JScrollPane scrollPane = new JScrollPane(txtrDt);
		scrollPane.setBounds(269, 33, 206, 187);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane);			
			
		bSeleccionar = new JButton("Seleccionar");
		bSeleccionar.setFont(new Font("Arial", Font.PLAIN, 11));
		bSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarActionPerformed(e);
			}
		});
		bSeleccionar.setBounds(159, 45, 89, 23);	
		getContentPane().add(bSeleccionar);		
				
		bCancelar = new JButton("");
		bCancelar.setToolTipText("Cancelar");
		bCancelar.setBackground(new Color(0, 0, 51));
		bCancelar.setBorderPainted(false);
		bCancelar.setIcon(new ImageIcon(ConsultaUsuario.class.getResource("/recursos/cancelar-icon-48px.png")));
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarActionPerformed(e);
			}
		});
		bCancelar.setBounds(350, 231, 43, 43);
		getContentPane().add(bCancelar);
		
	}	
		
	protected void seleccionarActionPerformed(ActionEvent e){
		DtUsuario dtu = icon.seleccionarUsuario((String) cBUsuarios.getSelectedItem().toString());
		DtArtista dta = null;
		DtEspectador dte = null;
		txtrEspecYRegistros.setText("");
		
		
		if (dtu instanceof DtArtista)
			dta = (DtArtista) dtu;
		if (dtu instanceof DtEspectador)
			dte = (DtEspectador) dtu;
		
		if (dta != null) {
			txtrEspecYRegistros.setBorder(new TitledBorder(null, "Espectáculos Organizados", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
			txtrDt.setText(dta.toString());
			ArrayList<String> eO = icon.mostrarEspectaculosOrganizados(dta);
			for (String s: eO) 
				txtrEspecYRegistros.append(s + newline);	
		}
		else if (dte != null) {
			txtrEspecYRegistros.setBorder(new TitledBorder(null, "Registros a funciones", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
			txtrDt.setText(dte.toString());
			String k = "registros...";
			txtrEspecYRegistros.append(k + newline);
		}						
	}		
	
	protected void CancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}

	private void limpiarFormulario() {	
		cBUsuarios.setSelectedItem(null);
		txtrDt.setText("");
		txtrEspecYRegistros.setText("");
	 }
	
	public void cargarLista() {
		ArrayList<String> lU = icon.listarUsuarios();
		cBUsuarios.removeAllItems();
		for (String s: lU) {
			cBUsuarios.addItem(s);
		}
		cBUsuarios.setSelectedItem(null);
	}
}

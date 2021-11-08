package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import interfaces.IControladorUsuario;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import datatypes.DtUsuario;
import datatypes.DtEspectador;
import datatypes.DtRegistro;
import datatypes.DtArtista;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

public class ConsultaUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorUsuario icon;	
	private JLabel lbNickname;
	private JButton bSeleccionar, bCancelar;
	private JComboBox<String> cBUsuarios;
	private JTextArea txtrDt, txtrEspecYRegistros;
	private JScrollPane scrollPane, scrollPane2;
	private final static String newline = "\n";
	
	
	public ConsultaUsuario(IControladorUsuario icon) {
		this.icon = icon;
		getContentPane().setBackground(new Color(0, 0, 51));	
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
		scrollPane2 = new JScrollPane(txtrEspecYRegistros);
		scrollPane2.setBorder(null);
		scrollPane2.setBackground(new Color(0, 0, 51));
		scrollPane2.setBounds(20, 107, 206, 178);
		getContentPane().add(scrollPane2);
		
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
		scrollPane = new JScrollPane(txtrDt);
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
			ArrayList<String> eO = icon.mostrarEspectaculosOrganizados(dta.getNickName());
			for (String s: eO) 
				txtrEspecYRegistros.append(s + newline);	
		}
		else if (dte != null) {
			txtrEspecYRegistros.setBorder(new TitledBorder(null, "Registros a funciones", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
			txtrDt.setText(dte.toString());
			ArrayList<DtRegistro> eR = icon.mostrarRegistrosEspectador(dte.getNickName());
			for (DtRegistro k: eR) 
				txtrEspecYRegistros.append(k.toString() + newline);	
			
		}						
	}		
	
	protected void CancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}

	protected void limpiarFormulario() {	
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

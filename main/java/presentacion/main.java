package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import interfaces.*;

public class main {
	private JFrame frame;	
	private AltaUsuario altaUsuarioFrame;
	private AltaEspectaculo altaEspectaculoFrame;
	private AltaPlataforma altaPlataformaFrame;
	private AltaFuncion altaFuncionFrame;
	private ConsultaFuncion	consultaFuncionFrame;
	private ConsultaEspectaculo consultaEspectaculoFrame;
	private ConsultaUsuario consultaUsuarioFrame;
	private ModificarUsuario modificarUsuarioFrame;	
	private CrearPaquete crearPaqueteFrame;
	private ConsultaPaquete consultaPaqueteFrame;
	private AgregarEspectaculosAPaquete agregarEspectaculosAPaqueteFrame;
	private RegistroFuncionEspectaculo registroFrame;
	
	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					main window = new main();					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
	}
	
	public main() {				
		initialize();
		
		Fabrica fabrica = Fabrica.getInstancia();
        IControladorUsuario iconU = fabrica.getIControladorUsuario();
        IControladorEspectaculo iconE = fabrica.getIControladorEspectaculo();
        IControladorPlataforma iconP = fabrica.getIControladorPlataforma();
        IControladorFuncion iconF = fabrica.getIControladorFuncion();
        IControladorPaquete iconPaq = fabrica.getIControladorPaquete();

		//alta usuario
		altaUsuarioFrame = new AltaUsuario(iconU);
		altaUsuarioFrame.setBounds(0, 0, 528, 418);
		altaUsuarioFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioFrame);

		//alta espectaculo
		altaEspectaculoFrame = new AltaEspectaculo(iconE);
		altaEspectaculoFrame.setBounds(0, 0, 527, 421);		
		altaEspectaculoFrame.setVisible(false);
		frame.getContentPane().add(altaEspectaculoFrame);

		//alta funcion
		altaFuncionFrame = new AltaFuncion(iconF);
		altaFuncionFrame.setBounds(0, 0, 438, 327);
		altaFuncionFrame.setVisible(false);
		frame.getContentPane().add(altaFuncionFrame);

		//consulta espectaculo
		consultaEspectaculoFrame = new ConsultaEspectaculo(iconE);
		consultaEspectaculoFrame.setBounds(0, 0, 590, 521);
		consultaEspectaculoFrame.setVisible(false);
		frame.getContentPane().add(consultaEspectaculoFrame);		
		
		//consulta funcion
		consultaFuncionFrame = new ConsultaFuncion(iconF);
		consultaFuncionFrame.setBounds(0, 11, 510, 350);		
		consultaFuncionFrame.setVisible(false);
		frame.getContentPane().add(consultaFuncionFrame);		
		
		//alta plataforma
		altaPlataformaFrame = new AltaPlataforma(iconP);
		altaPlataformaFrame.setBounds(0, 0, 438, 327);
		altaPlataformaFrame.setVisible(false);
		frame.getContentPane().add(altaPlataformaFrame);
		
		//consulta usuario
		consultaUsuarioFrame = new ConsultaUsuario(iconU);  
		consultaUsuarioFrame.setBounds(0, 0, 500, 350);
		consultaUsuarioFrame.setVisible(false);
		frame.getContentPane().add(consultaUsuarioFrame);
		
		//modificar usuario
		modificarUsuarioFrame = new ModificarUsuario(iconU);
		modificarUsuarioFrame.setBounds(0, 0, 470, 336);
		modificarUsuarioFrame.setVisible(false);
		frame.getContentPane().add(modificarUsuarioFrame);
		
		//crear paquete
		crearPaqueteFrame = new CrearPaquete(iconPaq);
		crearPaqueteFrame.setBounds(0, 0, 280, 400);
		crearPaqueteFrame.setVisible(false);
		frame.getContentPane().add(crearPaqueteFrame);
		
		//consulta paquete
		consultaPaqueteFrame = new ConsultaPaquete(iconPaq);
		consultaPaqueteFrame.setBounds(0, 0, 491, 442);
		consultaPaqueteFrame.setVisible(false);
		frame.getContentPane().add(consultaPaqueteFrame);

		//agregar espectaculos a paqute
		agregarEspectaculosAPaqueteFrame = new AgregarEspectaculosAPaquete(iconPaq);
		agregarEspectaculosAPaqueteFrame.setBounds(0, 0, 310, 350);
		agregarEspectaculosAPaqueteFrame.setVisible(false);
		frame.getContentPane().add(agregarEspectaculosAPaqueteFrame);
		
		registroFrame = new RegistroFuncionEspectaculo(iconF);
		//registroFrame.setBounds(0, 0, 491, 442);
		registroFrame.setVisible(false);
		frame.getContentPane().add(registroFrame);
		
		
		JLabel lbBienvenida = new JLabel("");
		lbBienvenida.setIcon(new ImageIcon(main.class.getResource("/recursos/coronaticketsUY2.png")));
		lbBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lbBienvenida.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lbBienvenida.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lbBienvenida.setBounds(0, 70, 634, 324);
		frame.getContentPane().add(lbBienvenida);
		
		JLabel lbDeveolper = new JLabel("Developed by MCNC \u00A9");
		lbDeveolper.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lbDeveolper.setBounds(440, 470, 177, 62);
		frame.getContentPane().add(lbDeveolper);	
	}
		
	private void initialize() {					
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(main.class.getResource("/recursos/uy.jpg")));
		frame.setIconImage(new ImageIcon(getClass().getResource("/recursos/uy.jpg")).getImage());

		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setResizable(true);
		frame.setBounds(100, 100, 622, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("coronaTickets.uy");
				
		JMenuBar upmenu = new JMenuBar();
		upmenu.setBackground(Color.WHITE);
		upmenu.setFont(new Font("Lucida Bright", Font.PLAIN, 12));		
		frame.setJMenuBar(upmenu);
		
		JMenu mUsuario = new JMenu("usuario");
		mUsuario.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		upmenu.add(mUsuario);
		
		JMenuItem iAltaUsuario = new JMenuItem("alta usuario");
		iAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioFrame.setVisible(true);			
			}
		});
		iAltaUsuario.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iAltaUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		iAltaUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mUsuario.add(iAltaUsuario);	
		
		JMenuItem iConsultaUsuario = new JMenuItem("consulta usuario");
		iConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioFrame.cargarLista();
				consultaUsuarioFrame.setVisible(true);			
			}
		});
		iConsultaUsuario.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iConsultaUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		iConsultaUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mUsuario.add(iConsultaUsuario);
		
		JMenuItem iModificarUsuario = new JMenuItem("modificar usuario");
		iModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuarioFrame.cargarLista();
				modificarUsuarioFrame.setVisible(true);			
			}
		});
		iModificarUsuario.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iModificarUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		iModificarUsuario.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mUsuario.add(iModificarUsuario);		
		
		JMenu mEspectaculo = new JMenu("espectáculo");
		mEspectaculo.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		upmenu.add(mEspectaculo);
		
		JMenuItem iIngresarEspectaculo = new JMenuItem("alta espectáculo");
		iIngresarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEspectaculoFrame.setVisible(true);			
			}
		});
		iIngresarEspectaculo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iIngresarEspectaculo.setHorizontalAlignment(SwingConstants.LEFT);
		iIngresarEspectaculo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mEspectaculo.add(iIngresarEspectaculo);
		
		JMenu mFuncion = new JMenu("función");
		mFuncion.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		upmenu.add(mFuncion);
		
		JMenuItem iIngresarFuncion = new JMenuItem("alta función");
		iIngresarFuncion.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iIngresarFuncion.setHorizontalAlignment(SwingConstants.LEFT);
		iIngresarFuncion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mFuncion.add(iIngresarFuncion);
	
		iIngresarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaFuncionFrame.setVisible(true);			
			}
		});
		
		JMenuItem iConsultaEspectaculo = new JMenuItem("consulta espectáculo");
		iConsultaEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaEspectaculoFrame.setVisible(true);
			}
		});
		iConsultaEspectaculo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iConsultaEspectaculo.setHorizontalAlignment(SwingConstants.LEFT);
		iConsultaEspectaculo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mEspectaculo.add(iConsultaEspectaculo);
		
		JMenuItem iConsultaFuncion = new JMenuItem("consulta función");
		iConsultaFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaFuncionFrame.setVisible(true);			
			}
		});
		iConsultaFuncion.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iConsultaFuncion.setHorizontalAlignment(SwingConstants.LEFT);
		iConsultaFuncion.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mFuncion.add(iConsultaFuncion);
		
		JMenuItem iRegistro = new JMenuItem("registro a función de espectáculo");
		iRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroFrame.setVisible(true);			
			}
		});
		iRegistro.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		iRegistro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mFuncion.add(iRegistro);
		
		JMenu mPlataforma = new JMenu("plataforma");
		mPlataforma.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		upmenu.add(mPlataforma);
		
		JMenuItem iAltaPlataforma = new JMenuItem("alta plataforma");
		iAltaPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPlataformaFrame.setVisible(true);			
			}
		});
		iConsultaFuncion.setHorizontalAlignment(SwingConstants.LEFT);
		iAltaPlataforma.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iAltaPlataforma.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mPlataforma.add(iAltaPlataforma);
		
		JMenu mPaquetes = new JMenu("paquetes");
		mPaquetes.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		upmenu.add(mPaquetes);
		
		JMenuItem iCrearPaquetes = new JMenuItem("crear paquete de espectáculos");
		iCrearPaquetes.setHorizontalAlignment(SwingConstants.LEFT);
		iCrearPaquetes.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iCrearPaquetes.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		iCrearPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPaqueteFrame.setVisible(true);			
			}
		});
		mPaquetes.add(iCrearPaquetes);
		
		JMenuItem iConsultaPaquetes = new JMenuItem("consulta paquete");
		iConsultaPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaPaqueteFrame.cargarPaquetes();
				consultaPaqueteFrame.setVisible(true);
			}
		});
		iConsultaPaquetes.setHorizontalAlignment(SwingConstants.LEFT);
		iConsultaPaquetes.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		iConsultaPaquetes.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 10));
		mPaquetes.add(iConsultaPaquetes);
		
		JMenuItem mntmAgregarEspectculoA = new JMenuItem("agregar espect\u00E1culo a paquete");
		mntmAgregarEspectculoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEspectaculosAPaqueteFrame.cargarPaquetes();
				agregarEspectaculosAPaqueteFrame.setVisible(true);
			}
			
		});
		mntmAgregarEspectculoA.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAgregarEspectculoA.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mntmAgregarEspectculoA.setFont(new Font("Dialog", Font.PLAIN, 10));
		mPaquetes.add(mntmAgregarEspectculoA);
	}	
}

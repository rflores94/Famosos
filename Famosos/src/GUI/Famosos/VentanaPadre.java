package GUI.Famosos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import Estructura.Famosos.Equipos;
import Estructura.Famosos.Famosos;
import Estructura.Famosos.PosicionJugador;
import Estructura.Famosos.SalonFama;
import javax.swing.border.LineBorder;

import Estructura.Famosos.CanalesTelevision;
import Estructura.Famosos.TipoCantante;

public class VentanaPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField Nombre;
	protected JLabel lblNombre;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JButton annadir;
	protected JButton eliminar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton buscar;
	protected JButton salir;
	protected JTextField AnnoNacimiento;
	protected JLabel lblEquipo;
	protected JLabel lblPosicin;
	protected JComboBox Posicion;
	protected JLabel lblPelculaMsFamosa;
	protected JTextField peliculaFamosa;
	protected JLabel lblGoles;
	protected JTextField Goles;
	protected JLabel lblPrgrama;
	protected JTextField Programa;
	protected JTextField ultimoDisco;
	protected JLabel lblAoNacimiento;
	protected JComboBox cBEquipo;
	protected JPanel OscarPanel;
	protected JRadioButton rdbtnS;
	protected JRadioButton rdbtnNo;
	protected JLabel lblCanal;
	protected JComboBox Canales;
	protected JLabel lblTipoCantante;
	protected JComboBox tipoCantante;
	protected JLabel lblltimoDisco;

	public VentanaPadre() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 11, 76, 30);
		
		Nombre = new JTextField();
		Nombre.addFocusListener(new FocusAdapter() {
		});
		
		Nombre.setBounds(26, 40, 92, 20);
		Nombre.setColumns(10);
		
		annadir = new JButton("A\u00F1adir");
		annadir.setBounds(205, 164, 86, 23);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(205, 164, 86, 23);
		
		buttonAnterior = new JButton();
		ImageIcon izda = new ImageIcon("src/img/flechaIzquierda.png");
		buttonAnterior.setIcon(izda);
		getContentPane().add(buttonAnterior);
		buttonAnterior.setBounds(212, 164, 35, 23);
		
		buttonSiguiente = new JButton();
		ImageIcon dcha = new ImageIcon("src/img/flechaDerecha.png");
		buttonSiguiente.setIcon(dcha);
		getContentPane().add(buttonSiguiente);
		buttonSiguiente.setBounds(257, 164, 35, 23);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(205, 164, 86, 23);
		
		salir = new JButton("Salir");
		salir.setBounds(300, 164, 76, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(lblNombre);
		getContentPane().add(annadir);
		getContentPane().add(eliminar);
		getContentPane().add(buttonAnterior);
		getContentPane().add(buttonSiguiente);
		getContentPane().add(buscar);
		getContentPane().add(salir);
		getContentPane().add(Nombre);
		
		lblAoNacimiento = new JLabel("Año Nacimiento");
		lblAoNacimiento.setBounds(26, 72, 116, 15);
		getContentPane().add(lblAoNacimiento);
		
		AnnoNacimiento = new JTextField();
		AnnoNacimiento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if((!Famosos.esValida(AnnoNacimiento.getText())))
					AnnoNacimiento.setForeground(java.awt.Color.RED);
				else if(Famosos.esValida(AnnoNacimiento.getText()))
					AnnoNacimiento.setForeground(java.awt.Color.BLACK);
			}
		});
		AnnoNacimiento.setBounds(26, 99, 92, 19);
		getContentPane().add(AnnoNacimiento);
		AnnoNacimiento.setColumns(10);
		
		cBEquipo = new JComboBox();
		cBEquipo.setModel(new DefaultComboBoxModel(Equipos.values()));
		cBEquipo.setBounds(212, 37, 137, 24);
		getContentPane().add(cBEquipo);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(212, 19, 70, 15);
		getContentPane().add(lblEquipo);
		
		lblPelculaMsFamosa = new JLabel("Película famosa");
		lblPelculaMsFamosa.setBounds(212, 19, 137, 15);
		getContentPane().add(lblPelculaMsFamosa);
		
		peliculaFamosa = new JTextField();
		peliculaFamosa.setBounds(212, 40, 114, 19);
		getContentPane().add(peliculaFamosa);
		peliculaFamosa.setColumns(10);
		
		OscarPanel = new JPanel();
		OscarPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Oscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		OscarPanel.setBounds(206, 80, 159, 72);
		getContentPane().add(OscarPanel);
		OscarPanel.setLayout(null);
		
		rdbtnS = new JRadioButton("Sí");
		buttonGroup.add(rdbtnS);
		rdbtnS.setBounds(5, 17, 149, 23);
		OscarPanel.add(rdbtnS);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(5, 44, 149, 23);
		OscarPanel.add(rdbtnNo);
		
		lblGoles = new JLabel("Goles");
		lblGoles.setBounds(212, 72, 48, 15);
		getContentPane().add(lblGoles);
		
		Goles = new JTextField();
		Goles.setBounds(267, 70, 48, 19);
		getContentPane().add(Goles);
		Goles.setColumns(10);
		
		lblPosicin = new JLabel("Posición");
		lblPosicin.setBounds(212, 101, 70, 15);
		getContentPane().add(lblPosicin);
		
		Posicion = new JComboBox();
		Posicion.setBounds(212, 128, 137, 24);
		getContentPane().add(Posicion);
		Posicion.setModel(new DefaultComboBoxModel(PosicionJugador.values()));
		
		lblCanal = new JLabel("Canal");
		lblCanal.setBounds(212, 99, 70, 15);
		getContentPane().add(lblCanal);
		
		Canales = new JComboBox();
		Canales.setBounds(212, 128, 142, 24);
		getContentPane().add(Canales);
		Canales.setModel(new DefaultComboBoxModel(CanalesTelevision.values()));
		
		lblTipoCantante = new JLabel("Tipo Cantante");
		lblTipoCantante.setBounds(212, 101, 153, 15);
		getContentPane().add(lblTipoCantante);
		
		tipoCantante = new JComboBox();
		tipoCantante.setBounds(212, 128, 149, 24);
		getContentPane().add(tipoCantante);
		tipoCantante.setModel(new DefaultComboBoxModel(TipoCantante.values()));
		
		lblPrgrama = new JLabel("Programa");
		lblPrgrama.setBounds(212, 19, 70, 15);
		getContentPane().add(lblPrgrama);
		
		Programa = new JTextField();
		Programa.setBounds(212, 40, 114, 19);
		getContentPane().add(Programa);
		Programa.setColumns(10);
		
		lblltimoDisco = new JLabel("Último disco");
		lblltimoDisco.setBounds(212, 19, 137, 15);
		getContentPane().add(lblltimoDisco);
		
		ultimoDisco = new JTextField();
		ultimoDisco.setBounds(212, 40, 114, 19);
		getContentPane().add(ultimoDisco);
		ultimoDisco.setColumns(10);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}
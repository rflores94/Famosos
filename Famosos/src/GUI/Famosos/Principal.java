package GUI.Famosos;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;

import Ficheros.Fichero;
import Estructura.Famosos.CanalesTelevision;
import Estructura.Famosos.Presentador;
import Estructura.Famosos.SalonFama;
import Estructura.Famosos.TipoFamoso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Principal {

	private About about = new About();
	private JFrame frame;
	private SalonFama salonFama = new SalonFama();
	private JFrame frmSalnDeLa;
	private AltaActor altaActor;
	private AltaFutbolista altaFutbolista;
	private AltaPresentador altaPresentador;
	private AltaCantante altaCantante;
	private final JPanel contentPanel = new JPanel();
	private VentanaPadre ventanaPadre;
	private MostrarFamosos mostrarFamoso;
	protected static final Component parent = null;
	private EliminarFamoso eliminarFamoso;
	private File file = new File("SinTitulo.obj");
	FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos.obj",  "obj");
	private boolean modificado;
	private boolean guardado;
	private int opcion;
	private int respuesta;
	private final String message = "Error, no se ha podido hacer la operación con el archivo";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmSalnDeLa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalnDeLa = new JFrame();
		frmSalnDeLa.setTitle("SalÃ³n de la Fama");
		frmSalnDeLa.setBounds(100, 100, 450, 300);
		frmSalnDeLa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSalnDeLa.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificado == true){
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?",
							"¿Deseas salir?", JOptionPane.YES_NO_CANCEL_OPTION);
					if(respuesta == JOptionPane.NO_OPTION){
						salonFama = new SalonFama();
					}
					if(respuesta == JOptionPane.YES_OPTION){
						if (guardado == true){
							guardar();
							setGuardado(true);
						}
						else
							guardarComo();
						salonFama = new SalonFama();
					}
				}else
					salonFama = new SalonFama();
			}
		});
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificado == true){
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?",
							"¿Deseas salir?", JOptionPane.YES_NO_CANCEL_OPTION);
					if(respuesta == JOptionPane.NO_OPTION){
						abrir();
					}
					if(respuesta == JOptionPane.YES_OPTION){
						if (guardado == true){
							guardar();
							setGuardado(true);
						}
						else
							guardarComo();
						abrir();
					}
				}else
					abrir();
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(guardado == false){
						guardarComo();
						setModificado(false);
					}else
						guardar();
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showInternalMessageDialog(parent, message);
				}
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
				setModificado(false);
				setGuardado(true);
			}
		});
		mnArchivo.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificado == true){
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?",
							"¿Deseas salir?", JOptionPane.YES_NO_CANCEL_OPTION);
					if(respuesta == JOptionPane.NO_OPTION){
						System.exit(0);
					}
					if(respuesta == JOptionPane.YES_OPTION){
						if (guardado == true){
							guardar();
							setGuardado(true);
						}
						else
							guardarComo();
						System.exit(0);
					}
				}else
					System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnNuevo = new JMenu("Famosos");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salonFama = new SalonFama();
			}
		});
		menuBar.add(mnNuevo);
		
		JMenuItem mntmActor = new JMenuItem("Nuevo Actor");
		mntmActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaActor = new AltaActor(salonFama);
				altaActor.setVisible(true);
			}
		});
		mnNuevo.add(mntmActor);
		
		JMenuItem mntmFutbolista = new JMenuItem("Nuevo Futbolista");
		mntmFutbolista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaFutbolista = new AltaFutbolista(salonFama);
				altaFutbolista.setVisible(true);
			}
		});
		mnNuevo.add(mntmFutbolista);
		
		JMenuItem mntmCantante = new JMenuItem("Nuevo Cantante");
		mntmCantante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaCantante = new AltaCantante(salonFama);
				altaCantante.setVisible(true);
			}
		});
		mnNuevo.add(mntmCantante);
		
		JMenuItem mntmPresentador = new JMenuItem("Nuevo Presentador");
		mntmPresentador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaPresentador = new AltaPresentador(salonFama);
				altaPresentador.setVisible(true);
			}
		});
		mnNuevo.add(mntmPresentador);
		
		JSeparator separator_3 = new JSeparator();
		mnNuevo.add(separator_3);
		
		JMenuItem mntmEliminarFamoso = new JMenuItem("Eliminar Famoso");
		mntmEliminarFamoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		mnNuevo.add(mntmEliminarFamoso);
		
		JMenu mnMostrar = new JMenu("Mostrar");
		menuBar.add(mnMostrar);
		
		JMenuItem mntmContarFamosos = new JMenuItem("Contar Famosos");
		mntmContarFamosos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPanel,
						"Hay "+salonFama.size()+" famosos.");
			}
		});
		mnMostrar.add(mntmContarFamosos);
		
		JSeparator separator_1 = new JSeparator();
		mnMostrar.add(separator_1);
		
		JMenuItem mntmMostrarActores = new JMenuItem("Mostrar Famosos");
		mntmMostrarActores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		mnMostrar.add(mntmMostrarActores);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
	}

	private void mostrar() {
		if (salonFama.size() == 0) {
			JOptionPane.showMessageDialog(contentPanel,
					"No hay famosos en el salon de la fama.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrarFamoso = new MostrarFamosos(salonFama);
		mostrarFamoso.setVisible(true);
	}

	private void eliminar() {
		if (salonFama.size() == 0) {
			JOptionPane.showMessageDialog(contentPanel,
					"No hay famosos en el salon de la fama.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		eliminarFamoso = new EliminarFamoso(salonFama);
		eliminarFamoso.setVisible(true);
	}
	
	private void setGuardado(boolean b) {
		this.guardado = b;
	}
	
	private void setModificado(boolean b){
		this.modificado=b;
	}

	private void guardar() {
		try{
			Fichero.guardar(file, salonFama);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		setModificado(false);
		setGuardado(true);
	}

	private void guardarComo() {
		file=null;
		JFileChooser guardar = new JFileChooser();
		guardar.setFileFilter(filtro);
		int opcion = guardar.showSaveDialog(frame);
		if(opcion==JFileChooser.APPROVE_OPTION){
			file = guardar.getSelectedFile();
			try{
				Fichero.guardarComo(file, salonFama);
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		setModificado(false);
		setGuardado(true);
	}

	private void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);
		int opcion = abrir.showOpenDialog(frame);
		if(opcion==JFileChooser.APPROVE_OPTION){
			file = abrir.getSelectedFile();
			try{
				salonFama = (SalonFama) Fichero.leer(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1){
				e1.printStackTrace();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		frame.setTitle(file.getName());
	}

}

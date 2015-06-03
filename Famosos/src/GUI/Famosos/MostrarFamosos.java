package GUI.Famosos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estructura.Famosos.Actor;
import Estructura.Famosos.Cantante;
import Estructura.Famosos.Famosos;
import Estructura.Famosos.Futbolista;
import Estructura.Famosos.Presentador;
import Estructura.Famosos.SalonFama;
import Estructura.Famosos.TipoFamoso;


public class MostrarFamosos extends VentanaPadre {

	private final JPanel contentPanel = new JPanel();
	private SalonFama salonFama;
	private int indice = -1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public MostrarFamosos(SalonFama salonFama) {
		lblPrgrama.setVisible(false);
		lblCanal.setVisible(false);
		lblltimoDisco.setVisible(false);
		lblTipoCantante.setVisible(false);
		lblEquipo.setVisible(false);
		lblGoles.setVisible(false);
		lblPosicin.setVisible(false);
		lblPelculaMsFamosa.setVisible(false);
		Programa.setVisible(false);
		Canales.setVisible(false);
		ultimoDisco.setVisible(false);
		tipoCantante.setVisible(false);
		cBEquipo.setVisible(false);
		Goles.setVisible(false);
		Posicion.setVisible(false);
		peliculaFamosa.setVisible(false);
		OscarPanel.setVisible(false);
		cBEquipo.setEnabled(false);
		tipoCantante.setEnabled(false);
		Posicion.setEnabled(false);
		Canales.setEnabled(false);
		AnnoNacimiento.setEditable(false);
		ultimoDisco.setEditable(false);
		Programa.setEditable(false);
		Goles.setEditable(false);
		Nombre.setEditable(false);
		peliculaFamosa.setEditable(false);
		
		this.salonFama=salonFama;
//		List<Famosos> names = Arrays.asList(Famosos);
//        Collections.sort(names);
//		Collections.sort(salonFama);
//		this.salonFama=salonFama;
		
		lblltimoDisco.setLocation(205, 19);
		ultimoDisco.setLocation(205, 40);
		tipoCantante.setLocation(205, 96);
		lblTipoCantante.setLocation(205, 72);
		Goles.setLocation(205, 40);
		lblGoles.setLocation(205, 19);
		buttonSiguiente.setLocation(282, 150);
		buttonAnterior.setLocation(225, 150);
		Canales.setLocation(205, 94);
		lblCanal.setLocation(209, 72);
		Posicion.setLocation(205, 80);
		lblPosicin.setLocation(205, 63);
		Programa.setLocation(205, 40);
		lblPrgrama.setLocation(205, 19);
		peliculaFamosa.setLocation(205, 40);
		lblPelculaMsFamosa.setLocation(199, 19);
		cBEquipo.setLocation(26, 150);
		lblEquipo.setLocation(26, 130);
		OscarPanel.setLocation(199, 63);
		annadir.setVisible(false);
		salir.setVisible(false);
		eliminar.setVisible(false);
		buscar.setVisible(false);
		
		setBounds(100, 100, 400, 243);
		
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
		
	}
	
	void actualizar() {
		if (salonFama.size() == 0) {
			return;
		}
		indice = 0;
		mostrarFamosos(salonFama.get(indice));
		comprobarBotones();		
	}
	
	private void mostrarSiguiente() {
		mostrarFamosos(salonFama.get(++indice));
		comprobarBotones();
	}

	private void mostrarAnterior() {
		mostrarFamosos(salonFama.get(--indice));
		comprobarBotones();
	}
	
	private void mostrarFamosos(Famosos famoso) {
		
		if (famoso.getTipoFamoso() == TipoFamoso.ACTOR)
			mostrarActor(famoso);
		if (famoso.getTipoFamoso() == TipoFamoso.FUTBOLISTA)
			mostrarFutbolista(famoso);
		if (famoso.getTipoFamoso() == TipoFamoso.CANTANTE)
			mostrarCantante(famoso);
		if (famoso.getTipoFamoso() == TipoFamoso.PRESENTADOR)
			mostrarPresentador(famoso);
		
		
	}
	
	private void mostrarPresentador(Famosos famoso) {
		// TODO Auto-generated method stub
		lblPrgrama.setVisible(true);
		lblCanal.setVisible(true);
		lblltimoDisco.setVisible(false);
		lblTipoCantante.setVisible(false);
		lblEquipo.setVisible(false);
		lblGoles.setVisible(false);
		lblPosicin.setVisible(false);
		lblPelculaMsFamosa.setVisible(false);
		Programa.setVisible(true);
		Canales.setVisible(true);
		ultimoDisco.setVisible(false);
		tipoCantante.setVisible(false);
		cBEquipo.setVisible(false);
		Goles.setVisible(false);
		Posicion.setVisible(false);
		peliculaFamosa.setVisible(false);
		OscarPanel.setVisible(false);
		
		Presentador presentador = (Presentador) famoso;
		
		Nombre.setText(presentador.getNombre());
		AnnoNacimiento.setText(String.valueOf(presentador.getAnoNacimiento()));
		Programa.setText(presentador.getPrograma());
		Canales.addItem(presentador.getCanal());
		Canales.setSelectedItem(presentador.getCanal());
		
	}

	private void mostrarCantante(Famosos famoso) {
		// TODO Auto-generated method stub
		lblPrgrama.setVisible(false);
		lblCanal.setVisible(false);
		lblltimoDisco.setVisible(true);
		lblTipoCantante.setVisible(true);
		lblEquipo.setVisible(false);
		lblGoles.setVisible(false);
		lblPosicin.setVisible(false);
		lblPelculaMsFamosa.setVisible(false);
		ultimoDisco.setVisible(true);
		tipoCantante.setVisible(true);
		Programa.setVisible(false);
		Canales.setVisible(false);
		cBEquipo.setVisible(false);
		Goles.setVisible(false);
		Posicion.setVisible(false);
		peliculaFamosa.setVisible(false);
		OscarPanel.setVisible(false);
		
		Cantante cantante = (Cantante) famoso;
		
		Nombre.setText(cantante.getNombre());
		AnnoNacimiento.setText(String.valueOf(cantante.getAnoNacimiento()));
		ultimoDisco.setText(cantante.getUltimoDisco());
		tipoCantante.addItem(cantante.getTipo());
		tipoCantante.setSelectedItem(cantante.getTipo());
	}

	private void mostrarFutbolista(Famosos famoso) {
		// TODO Auto-generated method stub
		lblPrgrama.setVisible(false);
		lblCanal.setVisible(false);
		lblltimoDisco.setVisible(false);
		lblTipoCantante.setVisible(false);
		lblEquipo.setVisible(true);
		lblGoles.setVisible(true);
		lblPosicin.setVisible(true);
		lblPelculaMsFamosa.setVisible(false);
		cBEquipo.setVisible(true);
		Goles.setVisible(true);
		Posicion.setVisible(true);
		ultimoDisco.setVisible(false);
		tipoCantante.setVisible(false);
		Programa.setVisible(false);
		Canales.setVisible(false);
		peliculaFamosa.setVisible(false);
		OscarPanel.setVisible(false);
		
		Futbolista futbolista = (Futbolista) famoso;
		Nombre.setText(futbolista.getNombre());
		AnnoNacimiento.setText(String.valueOf(futbolista.getAnoNacimiento()));
		
		cBEquipo.addItem(futbolista.getEquipo());
		cBEquipo.setSelectedItem(futbolista.getEquipo());
		Goles.setText(String.valueOf(futbolista.getNumeroGoles()));
		Posicion.addItem(futbolista.getPosicion());
		Posicion.setSelectedItem(futbolista.getPosicion());
	}

	private void mostrarActor(Famosos famoso) {
		// TODO Auto-generated method stub
		lblPrgrama.setVisible(false);
		lblCanal.setVisible(false);
		lblltimoDisco.setVisible(false);
		lblTipoCantante.setVisible(false);
		lblEquipo.setVisible(false);
		lblGoles.setVisible(false);
		lblPosicin.setVisible(false);
		lblPelculaMsFamosa.setVisible(true);
		peliculaFamosa.setVisible(true);
		OscarPanel.setVisible(true);
		ultimoDisco.setVisible(false);
		tipoCantante.setVisible(false);
		cBEquipo.setVisible(false);
		Goles.setVisible(false);
		Posicion.setVisible(false);
		Programa.setVisible(false);
		Canales.setVisible(false);
		
		Actor actor = (Actor) famoso;
		
		Nombre.setText(actor.getNombre());
		AnnoNacimiento.setText(String.valueOf(actor.getAnoNacimiento()));
		peliculaFamosa.setText(actor.getPeliculaFamosa());
		if(actor.isOscar())
			rdbtnS.setSelected(true);
		else
			rdbtnNo.setSelected(true);
	}

	private void comprobarBotones() {
		if (salonFama.get(indice + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);

		if (salonFama.get(indice - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
	}

}

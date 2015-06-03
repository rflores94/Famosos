package GUI.Famosos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estructura.Famosos.Equipos;
import Estructura.Famosos.Famosos;
import Estructura.Famosos.PosicionJugador;
import Estructura.Famosos.SalonFama;
import Estructura.Famosos.TipoFamoso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaFutbolista extends VentanaPadre {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * @param salonFama 
	 */
	public AltaFutbolista(final SalonFama salonFama) {
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadir(salonFama);
			}
		});
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		eliminar.setVisible(false);
		lblPelculaMsFamosa.setVisible(false);
		peliculaFamosa.setVisible(false);
		lblPrgrama.setVisible(false);
		Programa.setVisible(false);
		lblTipoCantante.setVisible(false);
		tipoCantante.setVisible(false);
		lblCanal.setVisible(false);
		Canales.setVisible(false);
		lblTipoCantante.setVisible(false);
		tipoCantante.setVisible(false);
		OscarPanel.setVisible(false);
		ultimoDisco.setVisible(false);
		lblltimoDisco.setVisible(false);
		
		setBounds(100, 100, 388, 232);
	}

	private void annadir(final SalonFama salonFama) {
		if (Nombre.getText().isEmpty() || AnnoNacimiento.getText().isEmpty() || Goles.getText().isEmpty()
				|| !Famosos.esValida(AnnoNacimiento.getText()))
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		if (salonFama.annadir(Nombre.getText(), AnnoNacimiento.getText(),TipoFamoso.FUTBOLISTA, Integer.parseInt(Goles.getText()),
				(Equipos) cBEquipo.getSelectedItem(), (PosicionJugador) Posicion.getSelectedItem()))
				JOptionPane.showMessageDialog(contentPanel,
						"Famoso añadido con éxito.");
			else
				JOptionPane.showMessageDialog(contentPanel,
						"El Famoso no se ha podido añadir.", "Error",
						JOptionPane.ERROR_MESSAGE);
	}

}

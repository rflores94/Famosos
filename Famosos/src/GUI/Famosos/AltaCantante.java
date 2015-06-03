package GUI.Famosos;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Estructura.Famosos.Famosos;
import Estructura.Famosos.SalonFama;
import Estructura.Famosos.TipoCantante;
import Estructura.Famosos.TipoFamoso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaCantante extends VentanaPadre {


	/**
	 * Create the dialog.
	 * @param salonFama 
	 */
	public AltaCantante(final SalonFama salonFama) {
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir(salonFama);
			}
		});
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		eliminar.setVisible(false);
		lblPelculaMsFamosa.setVisible(false);
		peliculaFamosa.setVisible(false);
		lblEquipo.setVisible(false);
		cBEquipo.setVisible(false);
		lblCanal.setVisible(false);
		Canales.setVisible(false);
		lblGoles.setVisible(false);
		Goles.setVisible(false);
		OscarPanel.setVisible(false);
		Programa.setVisible(false);
		lblPrgrama.setVisible(false);
		lblPosicin.setVisible(false);
		Posicion.setVisible(false);
		
		setBounds(100, 100, 388, 232);

	}

	private void annadir(final SalonFama salonFama) {
		if (Nombre.getText().isEmpty() || AnnoNacimiento.getText().isEmpty() || ultimoDisco.getText().isEmpty()
				|| !Famosos.esValida(AnnoNacimiento.getText()))
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		if (salonFama.annadir(Nombre.getText(), AnnoNacimiento.getText(),TipoFamoso.CANTANTE, ultimoDisco.getText(), (TipoCantante)tipoCantante.getSelectedItem()))
			JOptionPane.showMessageDialog(contentPanel,
					"Famoso añadido con éxito.");
		else
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
	}

}

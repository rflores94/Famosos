package GUI.Famosos;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Estructura.Famosos.Famosos;
import Estructura.Famosos.SalonFama;
import Estructura.Famosos.TipoFamoso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaActor extends VentanaPadre {


	/**
	 * Create the dialog.
	 */
	public AltaActor(final SalonFama salonFama) {
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir(salonFama);
			}
		});
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		eliminar.setVisible(false);
		lblEquipo.setVisible(false);
		cBEquipo.setVisible(false);
		lblPrgrama.setVisible(false);
		Programa.setVisible(false);
		lblTipoCantante.setVisible(false);
		tipoCantante.setVisible(false);
		lblCanal.setVisible(false);
		Canales.setVisible(false);
		lblTipoCantante.setVisible(false);
		tipoCantante.setVisible(false);
		lblGoles.setVisible(false);
		Goles.setVisible(false);
		lblPosicin.setVisible(false);
		Posicion.setVisible(false);
		ultimoDisco.setVisible(false);
		lblltimoDisco.setVisible(false);
		setBounds(100, 100, 388, 232);

	}
	private boolean getOscar() {
		if (rdbtnS.isSelected())
			return true;
		else
			return false;	
	}
	private void annadir(final SalonFama salonFama) {
		if (Nombre.getText().isEmpty() || AnnoNacimiento.getText().isEmpty() || peliculaFamosa.getText().isEmpty()
				|| !Famosos.esValida(AnnoNacimiento.getText()))
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		else if (salonFama.annadir(Nombre.getText(), AnnoNacimiento.getText(),TipoFamoso.ACTOR, peliculaFamosa.getText(), getOscar()))
			JOptionPane.showMessageDialog(contentPanel,
					"Famoso añadido con éxito.");
			else
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
	}

}

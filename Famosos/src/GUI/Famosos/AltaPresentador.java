package GUI.Famosos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Estructura.Famosos.CanalesTelevision;
import Estructura.Famosos.Famosos;
import Estructura.Famosos.SalonFama;
import Estructura.Famosos.TipoFamoso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPresentador extends VentanaPadre {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 * @param salonFama 
	 */
	public AltaPresentador(final SalonFama salonFama) {
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir(salonFama);
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		eliminar.setVisible(false);
		lblPelculaMsFamosa.setVisible(false);
		peliculaFamosa.setVisible(false);
		lblEquipo.setVisible(false);
		cBEquipo.setVisible(false);
		lblTipoCantante.setVisible(false);
		tipoCantante.setVisible(false);
		lblGoles.setVisible(false);
		Goles.setVisible(false);
		lblTipoCantante.setVisible(false);
		tipoCantante.setVisible(false);
		OscarPanel.setVisible(false);
		ultimoDisco.setVisible(false);
		lblltimoDisco.setVisible(false);
		lblPosicin.setVisible(false);
		Posicion.setVisible(false);
		
		setBounds(100, 100, 388, 232);
	
		
	}


	private void annadir(final SalonFama salonFama) {
		if (Nombre.getText().isEmpty() || AnnoNacimiento.getText().isEmpty() || Programa.getText().isEmpty()
				|| !Famosos.esValida(AnnoNacimiento.getText()))
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		if (salonFama.annadir(Nombre.getText(), AnnoNacimiento.getText(),TipoFamoso.PRESENTADOR, Programa.getText(), (CanalesTelevision)Canales.getSelectedItem()))
			JOptionPane.showMessageDialog(contentPanel,
					"Famoso añadido con éxito.");
		else
			JOptionPane.showMessageDialog(contentPanel,
					"El Famoso no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
	}

}

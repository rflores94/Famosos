package Estructura.Famosos;

/**
* 
* @author Roberto Carlos Flores Gomez
* @version 1.0
*
*/

public class Futbolista extends Famosos {

	int numeroGoles = 0;
	Equipos equipo;
	PosicionJugador posicion;
	
	public Futbolista(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, int numeroGoles, Equipos equipo, PosicionJugador posicion) {
		super(nombre, anoNacimiento, tipoFamoso);
		setNumeroGoles(numeroGoles);
		setEquipo(equipo);
		setPosicion(posicion);
	}
	
	/**
	 * Crea un Futbolista si sus parametros no son null
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param numeroGoles
	 * @param equipo
	 * @param posicion
	 * @return
	 */
	
	static Famosos instanciarFutbolista(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, int numeroGoles, Equipos equipo, PosicionJugador posicion){
		if (nombre != null && equipo != null && posicion != null)
			return new Futbolista(nombre, anoNacimiento,tipoFamoso, numeroGoles, equipo, posicion);
		return null;
			
	}

	public int getNumeroGoles() {
		return numeroGoles;
	}

	private void setNumeroGoles(int numeroGoles) {
		this.numeroGoles = numeroGoles;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	private void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public PosicionJugador getPosicion() {
		return posicion;
	}

	private void setPosicion(PosicionJugador posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return getNombre()+" "+getAnoNacimiento()+" "+equipo+" "+posicion+" "+numeroGoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + numeroGoles;
		result = prime * result
				+ ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Futbolista other = (Futbolista) obj;
		if (equipo != other.equipo)
			return false;
		if (numeroGoles != other.numeroGoles)
			return false;
		if (posicion != other.posicion)
			return false;
		return true;
	}
	
	
	
}

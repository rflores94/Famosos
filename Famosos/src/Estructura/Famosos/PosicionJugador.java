package Estructura.Famosos;

/**
 * 
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */

public enum PosicionJugador {
	/**
	 * Portero
	 */
	PORTERO,
	/**
	 * Defensa
	 */
	DEFENSA,
	/**
	 * Centrocampista
	 */
	CENTROCAMPISTA,
	/**
	 * Delantero
	 */
	DELANTERO;
	
	private static final PosicionJugador[] VALUES = PosicionJugador.values();
	
	public PosicionJugador[] getValues(){
		return VALUES;
	}
}

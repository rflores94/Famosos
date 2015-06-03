package Estructura.Famosos;


/**
 * 
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */

public enum Equipos {
	/**
	 * Equipo Real Madrid
	 */
	REALMADRID,
	/**
	 * Equipo Barcelona
	 */
	BARCELONA,
	/**
	 * Equipo Atletico de Madrid
	 */
	ATLETICOMADRID,
	/**
	 * Equipo Juventus
	 */
	JUVENTUS,
	/**
	 * Equipo Bayer de Munich
	 */
	BAYERMUNICH,
	/**
	 * Equipo Paris Sant Germain
	 */
	PSG,
	/**
	 * Equipo Manchester United
	 */
	MANCHESTERUNITED,
	/**
	 * Equipo Manchester City
	 */
	MANCHESTERCITY,
		/**
		 * Equipo Chelsea
		 */
	CHELSEA;
	
	/**
	 * Array que contiene el n�mero de equipos que tiene la enum
	 */
	private static final Equipos[] VALUES = Equipos.values();
	
	public Equipos[] getValues(){
		return VALUES;
	}
}

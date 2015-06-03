package Estructura.Famosos;

/**
 * 
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */

public enum CanalesTelevision {
	/**
	 * Tele5
	 */
	TELE5,
	/**
	 * Antena3
	 */
	ANTENA3,
	/**
	 * Cuatro
	 */
	CUATRO,
	/**
	 * La Sexta
	 */
	LASEXTA,
	/**
	 * Canal Sur
	 */
	CANALSUR,
	/**
	 * La 1
	 */
	TVE1,
	/**
	 * Discovery Max
	 */
	DISCOVERYMAX,
	/**
	 * Energy
	 */
	ENERGY;
	
	private static final CanalesTelevision[] VALUES = CanalesTelevision.values();
	
	public CanalesTelevision[] getValues(){
		return VALUES;
	}
}

package Estructura.Famosos;

public enum TipoCantante {
	/**
	 * Solista
	 */
	SOLISTA,
	/**
	 * Grupo
	 */
	GRUPO;
	
	private static final TipoCantante[] VALUES = TipoCantante.values();
	
	public TipoCantante[] getValues(){
		return VALUES;
	}

}

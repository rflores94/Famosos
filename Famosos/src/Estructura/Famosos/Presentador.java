package Estructura.Famosos;

import java.util.regex.Pattern;

/**
* 
* @author Roberto Carlos Flores Gomez
* @version 1.0
*
*/

public class Presentador extends Famosos {

	String programa;
	CanalesTelevision canal;
	
	static final private Pattern patternPrograma = Pattern
			.compile("^[\\w ]*$");
	
	public Presentador(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, String programa, CanalesTelevision canal) {
		super(nombre, anoNacimiento, tipoFamoso);
		setPrograma(programa);
		setCanal(canal);
	}
	
	/**
	 * Crea un Presentador si sus parametros no son null
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param programa
	 * @param canal
	 * @return
	 */
	
	static Famosos instanciarPresentador(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, String programa, CanalesTelevision canal){
		if (nombre != null && esValida(programa) && canal != null)
			return new Presentador(nombre, anoNacimiento, tipoFamoso, programa, canal);
		return null;
			
	}

	public String getPrograma() {
		return programa;
	}

	private void setPrograma(String programa) {
		this.programa = programa;
	}

	public CanalesTelevision getCanal() {
		return canal;
	}

	private void setCanal(CanalesTelevision canal) {
		this.canal = canal;
	}
	
	public static boolean esValida(String programa) {
		return patternPrograma.matcher(programa).matches();
	}

	@Override
	public String toString() {
		return nombre+" "+anoNacimiento+" "+programa+" "+canal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((canal == null) ? 0 : canal.hashCode());
		result = prime * result
				+ ((programa == null) ? 0 : programa.hashCode());
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
		Presentador other = (Presentador) obj;
		if (canal != other.canal)
			return false;
		if (programa == null) {
			if (other.programa != null)
				return false;
		} else if (!programa.equals(other.programa))
			return false;
		return true;
	}

	
	
	

}

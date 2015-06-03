package Estructura.Famosos;

import java.util.regex.Pattern;

/**
* 
* @author Roberto Carlos Flores Gomez
* @version 1.0
*
*/

public class Actor extends Famosos {

	String peliculaFamosa;
	boolean oscar;
	
	static final private Pattern patternPelicula = Pattern
			.compile("^[\\w ]*$");
	
	public Actor(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, String peliculaFamosa, boolean oscar) {
		super(nombre, anoNacimiento, tipoFamoso);
		setPeliculaFamosa(peliculaFamosa);
		setOscar(oscar);
		
	}
	
	/**
	 * Crea un Actor si sus parametros no son null
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param peliculaFamosa
	 * @param oscar
	 * @return
	 */
	
	static Famosos instanciarActor(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, String peliculaFamosa, boolean oscar){
		if (nombre != null && esValida(peliculaFamosa))
			return new Actor(nombre, anoNacimiento, tipoFamoso, peliculaFamosa, oscar);
		return null;
			
	}

	public String getPeliculaFamosa() {
		return peliculaFamosa;
	}

	private void setPeliculaFamosa(String peliculaFamosa) {
		this.peliculaFamosa = peliculaFamosa;
	}

	public boolean isOscar() {
		return oscar;
	}

	private void setOscar(boolean oscar) {
		this.oscar = oscar;
	}
	
	public static boolean esValida(String peliculaFamosa) {
		return patternPelicula.matcher(peliculaFamosa).matches();
	}

	@Override
	public String toString() {
		return getNombre()+" "+getAnoNacimiento()+" "+peliculaFamosa+" "+oscar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (oscar ? 1231 : 1237);
		result = prime * result
				+ ((peliculaFamosa == null) ? 0 : peliculaFamosa.hashCode());
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
		Actor other = (Actor) obj;
		if (oscar != other.oscar)
			return false;
		if (peliculaFamosa == null) {
			if (other.peliculaFamosa != null)
				return false;
		} else if (!peliculaFamosa.equals(other.peliculaFamosa))
			return false;
		return true;
	}
	
	
	
}

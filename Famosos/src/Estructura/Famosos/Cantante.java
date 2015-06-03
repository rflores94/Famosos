package Estructura.Famosos;

import java.util.regex.Pattern;

public class Cantante extends Famosos {

	String ultimoDisco;
	TipoCantante tipo;
	
	static final private Pattern patternDisco = Pattern
			.compile("^[\\w ]*$");
	
	public Cantante(String nombre, String anoNacimiento,TipoFamoso tipoFamoso, String ultimoDisco, TipoCantante tipoCantante) {
		super(nombre, anoNacimiento, tipoFamoso);
		setUltimoDisco(ultimoDisco);
		setTipo(tipoCantante);
	}
	
	/**
	 * Crea un Cantante si sus parametros no son null
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param ultimoDisco
	 * @param tipoCantante
	 * @return
	 */
	
	static Famosos instanciarCantante(String nombre, String anoNacimiento,TipoFamoso tipoFamoso,String ultimoDisco, TipoCantante tipoCantante){
		if (nombre != null && esValida(ultimoDisco) && tipoCantante != null)
			return new Cantante(nombre, anoNacimiento, tipoFamoso, ultimoDisco, tipoCantante);
		return null;
			
	}

	public String getUltimoDisco() {
		return ultimoDisco;
	}

	private void setUltimoDisco(String ultimoDisco) {
		this.ultimoDisco = ultimoDisco;
	}

	public TipoCantante getTipo() {
		return tipo;
	}

	private void setTipo(TipoCantante tipo) {
		this.tipo = tipo;
	}
	
	public static boolean esValida(String ultimoDisco) {
		return patternDisco.matcher(ultimoDisco).matches();
	}

	@Override
	public String toString() {
		return getNombre()+" "+getAnoNacimiento()+" "+ultimoDisco+" "+tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((ultimoDisco == null) ? 0 : ultimoDisco.hashCode());
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
		Cantante other = (Cantante) obj;
		if (tipo != other.tipo)
			return false;
		if (ultimoDisco == null) {
			if (other.ultimoDisco != null)
				return false;
		} else if (!ultimoDisco.equals(other.ultimoDisco))
			return false;
		return true;
	}
	
	

}

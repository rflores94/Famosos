package Estructura.Famosos;

import java.util.regex.Pattern;

public class Famosos implements Comparable<Famosos> {

	protected String nombre;
	protected String anoNacimiento;
	private TipoFamoso tipoFamoso;
	static final private Pattern patternAnno = Pattern
			.compile("^\\d{4}");
	
	public Famosos(String nombre, String anoNacimiento, TipoFamoso tipoFamoso) {
		setNombre(nombre);
		setAnoNacimiento(anoNacimiento);
		setTipoFamoso(tipoFamoso);
	}
	
	
	
	public TipoFamoso getTipoFamoso() {
		return tipoFamoso;
	}



	public void setTipoFamoso(TipoFamoso tipoFamoso) {
		this.tipoFamoso = tipoFamoso;
	}



	public Famosos(String nombre){
		setNombre(nombre);
	}
	

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnoNacimiento() {
		return anoNacimiento;
	}

	private void setAnoNacimiento(String anoNacimiento) {
		this.anoNacimiento = anoNacimiento;
	}
	
	public static boolean esValida(String string){
		return patternAnno.matcher(string).matches();
	}
	


	@Override
	public String toString() {
		return nombre +" "+ anoNacimiento;
	}

	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anoNacimiento == null) ? 0 : anoNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Famosos other = (Famosos) obj;
		if (anoNacimiento == null) {
			if (other.anoNacimiento != null)
				return false;
		} else if (!anoNacimiento.equals(other.anoNacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

//	public int compareTo(Famosos famoso) {
//	int resultado=0;
//	if(this.anoNacimiento.compareTo(famoso.anoNacimiento)<0)
//		resultado=-1;
//	return resultado;
//	}


	
	public int compareTo(Famosos n) {
        int lastCmp = anoNacimiento.compareTo(n.anoNacimiento);
        return (lastCmp != 0 ? lastCmp : anoNacimiento.compareTo(n.anoNacimiento));
    }


	
	
}

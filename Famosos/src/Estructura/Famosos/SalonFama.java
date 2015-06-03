package Estructura.Famosos;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * SalonFama que almacena famosos, que pueden ser Actores, Futbolistas, Cantante o Presentadores
 * 
 * @author Roberto Carlos Flores Gomez
 * @version 1.0
 *
 */

public class SalonFama implements Serializable{
	/**
	 * Coleccion de Famosos. No puede tener null
	 */
	private ArrayList<Famosos> salonFama = new ArrayList<Famosos>();
	private Famosos famoso;
	
	/**
	 * Nombre
	 */
	private static final String nombre = "Salón de la Fama";
	
	/**
	 * Añade un famoso de clase futbolista al salon de la fama siempre que 
	 * el famoso no sea null o no esté ya contenido en el salon de la fama
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param numeroGoles
	 * @param equipo
	 * @param posicion
	 * @return
	 */
	
	public boolean annadir(String nombre, String anoNacimiento, TipoFamoso tipoFamoso, int numeroGoles, Equipos equipo, PosicionJugador posicion){
		famoso = (Famosos) new Futbolista(nombre, anoNacimiento, tipoFamoso, numeroGoles, equipo, posicion);
		if (nombre==null || getNombre(nombre)){
			return false;
		}
		return salonFama.add(famoso);
	}
	
	/**
	 * Añade un famoso de clase presentador al salon de la fama siempre que 
	 * el famoso no sea null o no esté ya contenido en el salon de la fama
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param programa
	 * @param canal
	 * @return
	 */
	
	public boolean annadir(String nombre, String anoNacimiento, TipoFamoso tipoFamoso, String programa, CanalesTelevision canal){
		famoso = (Famosos)Presentador.instanciarPresentador(nombre, anoNacimiento, tipoFamoso, programa, canal);
		if (nombre==null || programa==null || getNombre(nombre))
			return false;
		return salonFama.add(famoso);
	}
	
	/**
	 * Añade un famoso de clase cantante al salon de la fama siempre que 
	 * el famoso no sea null o no esté ya contenido en el salon de la fama
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param ultimoDisco
	 * @param tipoCantante
	 * @return
	 */
	
	public boolean annadir(String nombre, String anoNacimiento, TipoFamoso tipoFamoso, String ultimoDisco, TipoCantante tipoCantante){
		famoso = (Famosos)Cantante.instanciarCantante(nombre, anoNacimiento, tipoFamoso, ultimoDisco, tipoCantante);
		if (nombre==null || ultimoDisco==null || getNombre(nombre))
			return false;
		return salonFama.add(famoso);
	}
	
	/**
	 * Añade un famoso de clase actor al salon de la fama siempre que 
	 * el famoso no sea null o no esté ya contenido en el salon de la fama
	 * 
	 * @param nombre
	 * @param anoNacimiento
	 * @param peliculaFamosa
	 * @param oscar
	 * @return
	 */
	
	public boolean annadir(String nombre, String anoNacimiento, TipoFamoso tipoFamoso, String peliculaFamosa, boolean oscar){
		famoso = (Famosos)Actor.instanciarActor(nombre, anoNacimiento, tipoFamoso, peliculaFamosa, oscar);
		if (nombre==null || peliculaFamosa==null ||getNombre(nombre))
			return false;
		return salonFama.add(famoso);
	}
	/**
	 * Aun no funciona. Elimina por el índice.
	 * @param id
	 * @return
	 * @throws FamosoNoExisteException
	 */
	public Famosos eliminar(int indice) throws FamosoNoExisteException{
		return salonFama.remove(indice);
	}
	
	public int size(){
		return salonFama.size();
	}
	
	public Famosos get(int index) {
		if(salonFama.isEmpty())
			return null;
		if(index < 0 | index > salonFama.size()-1)
			return null;
		return salonFama.get(index);
	}
	
	private boolean getNombre(String nombre){
		Famosos famoso = new Famosos(nombre);
		for(Famosos famosoAux : salonFama){
            if (famosoAux.getNombre().equals(nombre)){
                    famoso = famosoAux;
            }
    }
    if(salonFama.contains(famoso))
            return true;
    return false;
	}
	


	@Override
	public String toString() {
		return "SalonFama "+salonFama;
	}
	
	
}

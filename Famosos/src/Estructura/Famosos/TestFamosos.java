package Estructura.Famosos;

public class TestFamosos {
	public static void main(String[] args) throws FamosoNoExisteException {

		SalonFama sF = new SalonFama();
		
		sF.annadir("Morata", 1993, TipoFamoso.FUTBOLISTA, 19, Equipos.JUVENTUS, PosicionJugador.DELANTERO);
		System.out.println(sF);
		
		sF.annadir("Morata", 1993, TipoFamoso.FUTBOLISTA, 19, Equipos.JUVENTUS, PosicionJugador.DELANTERO);
		System.out.println(sF);
		
		sF.annadir("Morata", 1993, TipoFamoso.FUTBOLISTA, 19, Equipos.JUVENTUS, PosicionJugador.DELANTERO);
		System.out.println(sF);
		
		sF.annadir("Jordi Hurtado", 1900, TipoFamoso.FUTBOLISTA, "Saber y Ganar", CanalesTelevision.TVE1);
		System.out.println(sF);
		
		sF.annadir("Vin Diesel", 1952, TipoFamoso.FUTBOLISTA, "A todo gas", true);
		System.out.println(sF);
		
		sF.annadir("Melendi", 1980, TipoFamoso.FUTBOLISTA, "Un alumno mas", TipoCantante.SOLISTA);
		System.out.println(sF);
	
		sF.eliminar(1);
		System.out.println(sF);
		
		sF.eliminar(2);
		System.out.println(sF);
		
		

	}
}

package modulo2;

import java.util.*;



public class Robot {
	private int _modo;
	//private Incidencia _incidencia;
	private double _coordenada_x;
	private double _coordenada_y;
	//public Incidencias _unnamed_Incidencias_;
	private TipoSuelo obSuelo = new TipoSuelo();
	int tipo;
	
	Scanner sc = new Scanner (System.in);
	public Robot (){
	}
	public String modoLimpieza() {
		boolean seleccionado = true;
		String limpieza="";
		do{
		System.out.println("Seleccione una acci�n: \n"
				+ "1. Seleccionar acci�n autom�ticamente\n"
				+ "2. Seleccionar acci�n manualmente");
		int accion = sc.nextInt();
		
		switch (accion){
		case 1:
			limpieza = limpiezaAutomatica();
			break;
		case 2: 
			limpieza = limpiezaManual();
			break;
		default: 
			seleccionado = false;
			break;
		}
		}while (!seleccionado);
		return limpieza;
	}
	private String limpiezaAutomatica(){
		String limpieza="";
		int caso = (int) (Math.random()*2+1);
		switch (caso){
		case 1:
			limpieza = "Barrer y fregar";
			break;
		case 2: 
			limpieza = "Barrer";
			break;
			
		default:
			System.out.println("Fallo");
			break;
		}
		return limpieza;
	}
	private String limpiezaManual(){
		String limpieza ="";
		boolean seleccionado = true;
		do{
		System.out.println("Seleccione acci�n: \n"
				+ "1. Barrer y Fregar\n"
				+ "2. Barrer");
		int accion = sc.nextInt();
		switch(accion){
		case 1:
			limpieza = "Barrer y Fregar";
			break;
		case 2:
			limpieza = "Barrer";
			break;
		default:
			seleccionado = false;
			break;
		}
		}while (!seleccionado);
		return limpieza;
	}
	public void ComprobarTipoSuelo(int aTipoSuelo) {
		throw new UnsupportedOperationException();
	}
	public String IdentificarTipoSuelo(){
		tipo = (int) Math.random()*3+1;
		System.out.println(tipo);
		String tipoSuelo = obSuelo.getTipoSuelo(tipo);
		return tipoSuelo;
	}


}
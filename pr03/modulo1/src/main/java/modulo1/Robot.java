package modulo1;

import java.util.Scanner;



public class Robot {
	private int _modo;
	//private Incidencia _incidencia;
	private double _coordenada_x;
	private double _coordenada_y;
	//public Incidencias _unnamed_Incidencias_;
	private TipoSuelo obSuelo = new TipoSuelo();
	Scanner sc = new Scanner (System.in);
	int tipo;
	public Robot (){
	}
	public void modoLimpieza(int aModo) {
		throw new UnsupportedOperationException();
	}

	public void ComprobarTipoSuelo(int aTipoSuelo) {
		throw new UnsupportedOperationException();
	}
	public String IdentificarTipoSuelo(){
		tipo = (int) (Math.random()*3+1);
		String tipoSuelo = obSuelo.getTipoSuelo(tipo);
		return tipoSuelo;
	}

}
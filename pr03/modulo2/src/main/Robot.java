package modulo1;



public class Robot {
	private int _modo;
	//private Incidencia _incidencia;
	private double _coordenada_x;
	private double _coordenada_y;
	//public Incidencias _unnamed_Incidencias_;
	private TipoSuelo obSuelo = new TipoSuelo();
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
		tipo = (int) Math.random()*3+1;
		System.out.println(tipo);
		String tipoSuelo = obSuelo.getTipoSuelo(tipo);
		return tipoSuelo;
	}


/**	public boolean reportarIncidencia(Incidencia aIncidencia) {
		throw new UnsupportedOperationException();
	}**/
	public void cambiarDirección() {
		throw new UnsupportedOperationException();
	}

	public double cambiarx(double aCoordenadaX) {
		throw new UnsupportedOperationException();
	}

	public double cambiary(double aCoordenadaY) {
		throw new UnsupportedOperationException();
	}
}
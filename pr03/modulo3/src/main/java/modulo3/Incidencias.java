package modulo3;

public class Incidencias {
	private int _tipoIncidencia;
	public Robot _unnamed_Robot_;

	public Incidencias() {
		throw new UnsupportedOperationException();
	}
	
	public String reconocerIncidencia (int numIncidencia){
		String inc="";
		if (numIncidencia == 20)
			inc = cargarBateria();
		if (numIncidencia == 30)
			inc = cepilloGastado();
		if (numIncidencia == 40)
			depositoLleno();
		return inc;
	}
	private String cargarBateria(){
		return "Cargar bateria";
	}
	private String cepilloGastado(){
		return "Cambiar el cepillo";
	}
	private String depositoLleno(){
		return "Deposito lleno, por favor, vac�elo";
	}
}
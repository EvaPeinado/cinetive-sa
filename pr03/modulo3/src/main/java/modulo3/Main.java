package modulo3;

public class Main {
public static void main (String []args){
	Robot robot = new Robot();
	/** Obtenemos el tipo de suelo automaticamente**/
	String tipo = obtenerTipoSuelo(robot);
	System.out.println(tipo);

	System.out.println( robot.modoLimpieza());
}

public static String obtenerTipoSuelo(Robot robot){
	String tipo = robot.IdentificarTipoSuelo();
	return tipo;
}
}

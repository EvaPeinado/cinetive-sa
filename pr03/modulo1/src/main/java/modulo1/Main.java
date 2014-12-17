package modulo1;

public class Main {
	
public static void main (String []args){
	Robot robot = new Robot();
	/** Obtenemos el tipo de suelo automaticamente**/
	String tipo = obtenerTipoSuelo(robot);
}

public static String obtenerTipoSuelo(Robot robot){
	String tipo = robot.IdentificarTipoSuelo();
	return tipo;
}
}

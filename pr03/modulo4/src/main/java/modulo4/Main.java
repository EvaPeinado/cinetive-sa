package modulo4;

public class Main {
public static void main (String []args){
	Robot robot = new Robot();
	/** Obtenemos el tipo de suelo automaticamente**/
	String tipo = obtenerTipoSuelo(robot);
	System.out.println(tipo);
	/**Obtenemos el modo de limpieza que se va a emplear **/
	System.out.println( robot.modoLimpieza());
	/** El robot recorre la habitacion**/
	int [] []mHabitacion = new int [8][8];
	mHabitacion = robot.cambiarDirecciónMejorado(mHabitacion);
}

public static String obtenerTipoSuelo(Robot robot){
	String tipo = robot.IdentificarTipoSuelo();
	return tipo;
}

}

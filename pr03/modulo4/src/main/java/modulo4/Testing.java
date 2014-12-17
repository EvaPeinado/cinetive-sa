package modulo4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test() {
		Robot robot = new Robot();
		/** Obtenemos el tipo de suelo automaticamente**/
		String tipo = Main.obtenerTipoSuelo(robot);
		System.out.println(tipo);
		/**Obtenemos el modo de limpieza que se va a emplear **/
		System.out.println( robot.modoLimpieza());
		/** El robot recorre la habitacion**/
		int [] []mHabitacion = new int [8][8];
		mHabitacion = robot.cambiarDirección(mHabitacion);
	}

}

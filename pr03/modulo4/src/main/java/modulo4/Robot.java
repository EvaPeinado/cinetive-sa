package modulo4;

import java.util.*;



public class Robot {
	private int _modo;
	public Incidencias incidencia = new Incidencias();
	private TipoSuelo obSuelo = new TipoSuelo();
	int tipo;
	private int cX;
	private int cY;
	Scanner sc = new Scanner (System.in);
	public Robot (){
	}
	
	public String modoLimpieza() {
		boolean seleccionado = true;
		String limpieza="";
		do{
		System.out.println("Seleccione una acción: \n"
				+ "1. Seleccionar acción automáticamente\n"
				+ "2. Seleccionar acción manualmente");
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
		System.out.println("Seleccione acción: \n"
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
	
	public String reportarIncidencia(int numeroIncidencia) {
		return incidencia.reconocerIncidencia(numeroIncidencia);	
	}
	
	public int [][] cambiarDirección(int [][]mHabitacion) {
		/** Inicializamos el robot de limpieza, reconociendo
		 * en primer lugar el suelo de la habitación **/
		mHabitacion = iniciarReconocimiento (mHabitacion);
		boolean incidencia = false;
		int incAleatoria;
		String nomIncidencia="";
		for (int i = 0; i<mHabitacion.length && !incidencia; i++){
			for (int j = 0; j<mHabitacion[0].length && !incidencia; j++){
				incAleatoria = (int) (Math.random()*50+1);
				nomIncidencia = reportarIncidencia(incAleatoria);
				
				if (nomIncidencia != null){
					System.out.println("Incidencia detectada: "+nomIncidencia);
					incidencia = true;
				}else{
					if (j!=0)
					mHabitacion[i][j-1] = 0; /**El robot avanza una posición*/
					else if (i!=0)
					mHabitacion[i-1][mHabitacion.length-1]=0;
					mHabitacion[i][j] = 1;
					imprimir (mHabitacion);
					if (j == mHabitacion.length -1 && i == mHabitacion.length-1) System.out.println("¡Habitación limpia!");
				}
				
					
			}
		}
		return mHabitacion;
	}
	public int [][] cambiarDirecciónMejorado(int [][] mHabitacion){
		/** Inicializamos el robot de limpieza, reconociendo
		 * en primer lugar el suelo de la habitación **/
		mHabitacion = iniciarReconocimiento (mHabitacion);
		boolean incidencia = false;
		int incAleatoria;
		String nomIncidencia="";
		try {
		for (int i = 0; i<mHabitacion.length && !incidencia; i++){
			if (i%2 == 0 || i == 0){
				for (int j = 0; j<mHabitacion[0].length && !incidencia; j++){
					incAleatoria = (int) (Math.random()*50+1);
					nomIncidencia = reportarIncidencia(incAleatoria);
				
					if (nomIncidencia != null){
						System.out.println("Incidencia detectada: "+nomIncidencia);
						incidencia = true;
						mHabitacion = volverPrincipio (mHabitacion, incidencia);
					}else{
						if (j!=0)
							mHabitacion[i][j-1] = 0; /**El robot avanza una posición*/
						else if (i!=0)
							mHabitacion[i-1][j]=0;
						mHabitacion[i][j] = 1;
						imprimir (mHabitacion);
						cX = i;
						cY = j;
						if (j == mHabitacion.length -1 && i == mHabitacion.length-1){
							System.out.println("¡Habitación limpia!");
							mHabitacion = volverPrincipio (mHabitacion, incidencia);
						}
					}
				
					
				}
			}else if (i%2 !=0){
				for (int j = mHabitacion[0].length-1; j>=0 && !incidencia; j--){
					incAleatoria = (int) (Math.random()*50+1);
					nomIncidencia = reportarIncidencia(incAleatoria);
				
					if (nomIncidencia != null){
						System.out.println("Incidencia detectada: "+nomIncidencia);
						incidencia = true;
					}else{
						if (j!=mHabitacion[0].length -1)
							mHabitacion[i][j+1] = 0; /**El robot avanza una posición*/
						else if (i!=0)
							mHabitacion[i-1][j]=0;
						mHabitacion[i][j] = 1;
						cX = i;
						cY = j;
						imprimir (mHabitacion);
						if (j ==0 && i == mHabitacion.length-1){
							mHabitacion = volverPrincipio (mHabitacion, incidencia);
							System.out.println("¡Habitación limpia!");
						}
					}
				
					
				}
			}
		}
		}catch (IndexOutOfBoundsException e){
			System.out.println("Intentando avanzar a una posición fuera de la habitación");
		}catch (Exception e){
			System.out.println(e.toString());
		}
		return mHabitacion;
	}
	public int [][] iniciarReconocimiento (int [][] mHabitacion){
		/** La posicion que ocupe el robot será reconocida con el valor de 1 en la matriz. 
		 * Así, si salta alguna excepción, sabremos el lugar exacto donde el robot se ha detenido
		 * para la proxima vez que queramos usarlo
		 */for (int i= 0; i< mHabitacion.length; i++){
			for (int j = 0; j<mHabitacion[0].length; j++){
				mHabitacion [i][j] = 0;
			}
		 }
		mHabitacion [0][0] = 1;
		cX = 0;
		cY = 0;
		return mHabitacion;
	}
	private void imprimir (int [][]mHabitacion){
		for (int i = 0; i< mHabitacion.length; i++){
			for (int j = 0; j<mHabitacion[0].length; j++){
				System.out.print("| "+mHabitacion[i][j]+" ");
				if (j == mHabitacion[0].length -1)
					System.out.print("\n");
			}
		}
		System.out.println ("\n\n\n");
	}
	private int [][] volverPrincipio (int [][] mHabitacion, boolean incidencia){
		for (int i= 0; i< mHabitacion.length; i++){
			for (int j = 0; j<mHabitacion[0].length; j++){
				mHabitacion [i][j] = 0;
			}
		 }
		mHabitacion [0][0] = 1;
		if (!incidencia){
			cX =0;
			cY=0;
		}
	return mHabitacion;
	}
}
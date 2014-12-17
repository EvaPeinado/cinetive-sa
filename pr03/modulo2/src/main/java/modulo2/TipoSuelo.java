package modulo2;

import java.util.LinkedList;

public class TipoSuelo {
	private LinkedList _list;
	String [] tipo = new String[3];

	public TipoSuelo (){
		tipo = new String [3];
		tipo [0] = "Parqué";
		tipo [1] = "Moqueta";
		tipo [2] = "Baldosa";
	}
	public void setTipoSuelo(int aSuelo) {
		throw new UnsupportedOperationException();
	}
	public String getTipoSuelo(int i){
		return tipo[i-1];	
	}


}
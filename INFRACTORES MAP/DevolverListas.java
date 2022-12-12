package parcial;

import java.util.LinkedList;
import java.util.List;

public class DevolverListas{
	
	public <T> List<T> diferencia(List<T> l1, List<T> l2){
		List<T> listaDiferencia = new LinkedList<T>();
		for (T eL1 : l1)
			if(l2.contains(eL1))
				listaDiferencia.add(eL1);
		return listaDiferencia;
	}

}

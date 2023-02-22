package viajes;

import java.util.Comparator;

public class OrdenarClientesPorNombre implements Comparator<Cliente>{

	@Override
	public int compare(Cliente a1, Cliente a2) {
		return a1.getNombre().toUpperCase().compareTo(a2.getNombre().toUpperCase());
}
}

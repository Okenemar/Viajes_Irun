package viajes;

import java.util.Comparator;

public class OrdenarClientesPorApellido implements Comparator<Cliente>{

	@Override
	public int compare(Cliente a1, Cliente a2) {
		return a1.getApellidos().toUpperCase().compareTo(a2.getApellidos().toUpperCase());
}
}

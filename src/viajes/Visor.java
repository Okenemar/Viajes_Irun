package viajes;

import java.util.ArrayList;

public class Visor {
	
	public static void mostrarClientes(ArrayList<Cliente> cliente) {
		for (Cliente cliente2 : cliente) {
			System.out.println(cliente2);
		}
	}
	
	public static void mostrarCliente(Cliente cliente) {
		System.out.println(cliente);
	}
	
}

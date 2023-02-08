package viajes;

import java.util.Scanner;

public class Formularios extends GestorBBDD{
	public static Cliente pedirDatosCliente(Scanner scan) {
		Cliente cliente = new Cliente();
		String dni;
		String nombre;
		String apellido;
		String direccion;
		String localidad;
		
		
		System.out.println("Introduce el dni del cliente");
		dni = scan.nextLine();
		System.out.println("Introduce el nombre del cliente");
		nombre = scan.nextLine();
		System.out.println("Introduce el apellido del cliente");
		apellido = scan.nextLine();
		System.out.println("Introduce la direccion del cliente");
		direccion = scan.nextLine();
		System.out.println("Introduce la localidad del cliente");
		localidad = scan.nextLine();
		
		cliente.setDni(dni);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellido);
		cliente.setDireccion(direccion);
		cliente.setLocalidad(localidad);
		
		
		return cliente;
	}
	
	public static String pedirdniCliente(Scanner scan) {
		String dni;
		System.out.println("Introduce el dni del cliente que quieres");
		dni = scan.nextLine();
		
		return dni;
	}

	 
}

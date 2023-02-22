package viajes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Gestor_Cliente {
	static void run(Scanner scan) throws ClassNotFoundException, SQLException{
		
	int opcion;
	GestorBBDD gestorBBDD = new GestorBBDD();
	Cliente cliente = new Cliente();
	
	String dni;
	do {
		Menu.mostrarMenuClientes();
		opcion = Integer.parseInt(scan.nextLine());
		
		switch (opcion) {
		case Menu.CREAR_CLIENTE:
			
			cliente = Formularios.pedirDatosCliente(scan);
			gestorBBDD.conectar();
			gestorBBDD.insertarCliente(cliente);
			gestorBBDD.cerrar();
			
			break;
		
		case Menu.ELIMINAR_CLIENTE:
			
			dni = Formularios.pedirdniCliente(scan);
			gestorBBDD.conectar();
			gestorBBDD.eliminarCliente(dni);
			gestorBBDD.cerrar();
			
			break;
		
		case Menu.VER_CLIENTES:
			gestorBBDD.conectar();
			Visor.mostrarClientes(gestorBBDD.mostrarClientes());
			gestorBBDD.cerrar();
			
			break;
			
		case Menu.ORDENAR_POR_NOMBRE:
			gestorBBDD.conectar();
			Visor.mostrarClientes(ordenarClienteNombre(gestorBBDD.getClientes()));
			gestorBBDD.cerrar();
			break;
		case Menu.ORDENAR_POR_APELLIDO:
			gestorBBDD.conectar();
			Visor.mostrarClientes(ordenarClienteApellidos(gestorBBDD.getClientes()));
			gestorBBDD.cerrar();
			break;
		case Menu.CADENA:
			gestorBBDD.conectar();
			Visor.mostrarClientes(gestorBBDD.getClientesCadena(Formularios.devuelveCadena(scan).toUpperCase()));
			gestorBBDD.cerrar();
			break;
		}
		
	}while (opcion!=Menu.SALIR); 
		}
	private static ArrayList<Cliente> ordenarClienteNombre(ArrayList<Cliente> clientes) {
		OrdenarClientesPorNombre order= new OrdenarClientesPorNombre();
		clientes.sort(order);
		return clientes;
	}
	
	private static ArrayList<Cliente> ordenarClienteApellidos(ArrayList<Cliente> clientes) {
		OrdenarClientesPorApellido order= new OrdenarClientesPorApellido();
		clientes.sort(order);
		return clientes;
	}
	
	}


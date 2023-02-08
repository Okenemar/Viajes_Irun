package viajes;

import java.sql.SQLException;
import java.util.Scanner;

public class Gestor_Cliente {
	static void run(Scanner scan) throws SQLException{
		
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
		}
	}while (opcion!=Menu.SALIR); 
		}
	
	}


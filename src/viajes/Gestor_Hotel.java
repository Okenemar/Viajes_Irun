package viajes;

import java.sql.SQLException;
import java.util.Scanner;

public class Gestor_Hotel {
	static void run(Scanner scan) throws SQLException{
		
	int opcion;
	GestorBBDD gestorBBDD = new GestorBBDD();
	Hotel hotel = new Hotel();
	
	int id;
	do {
		Menu.mostrarMenuHoteles();
		opcion = Integer.parseInt(scan.nextLine());
		
		switch (opcion) {
		case Menu.CREAR_HOTEL:
			
			hotel = Formularios.pedirDatosHotel(scan);
			gestorBBDD.conectar();
			gestorBBDD.insertarHotel(hotel);
			gestorBBDD.cerrar();
			
			break;

		case Menu.ELIMINAR_HOTEL:
			
			id = Formularios.pediridHotel(scan);
			gestorBBDD.conectar();
			gestorBBDD.eliminarHotel(id);
			gestorBBDD.cerrar();
			
			break;
		
		case Menu.MOSTRAR_HOTEL:
			gestorBBDD.conectar();
			Visor.mostrarHoteles(gestorBBDD.mostrarHoteles());
			gestorBBDD.cerrar();
			
			break;
		}
	}while (opcion!=Menu.SALIR);
	}
}

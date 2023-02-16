package viajes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Gestor_Habitacion {
	static void run(Scanner scan) throws SQLException, ParseException{

	int opcion;
	GestorBBDD gestorBBDD = new GestorBBDD();
	Habitacion habitacion = new Habitacion();
	
	int id;
	do {
		Menu.mostrarMenuHabitacion();
		opcion = Integer.parseInt(scan.nextLine());
		
		switch (opcion) {
		case Menu.CREAR_HABITACION:
			
			habitacion = Formularios.pedirDatosHabitacion(scan);
			gestorBBDD.conectar();
			gestorBBDD.insertarHabitacion(habitacion);
			gestorBBDD.cerrar();
			
			break;

		case Menu.ELIMINAR_HABITACION:
			
			id = Formularios.pediridHabitacion(scan);
			gestorBBDD.conectar();
			gestorBBDD.eliminarHabitacion(id);
			gestorBBDD.cerrar();
			
			break;
		
		case Menu.MOSTRAR_HABITACION:
			gestorBBDD.conectar();
			Visor.mostrarHabitaciones(gestorBBDD.mostrarHabitacion());
			gestorBBDD.cerrar();
			
			break;
		}
	}while (opcion!=Menu.SALIR);
	}
}
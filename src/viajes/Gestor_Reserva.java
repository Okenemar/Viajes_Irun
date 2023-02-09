package viajes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Gestor_Reserva {
	static void run(Scanner scan) throws SQLException, ParseException{
		
	int opcion;
	GestorBBDD gestorBBDD = new GestorBBDD();
	Reserva reserva = new Reserva();
	
	int id;
	do {
		Menu.mostrarMenuReservas();
		opcion = Integer.parseInt(scan.nextLine());
		
		switch (opcion) {
		case Menu.CREAR_RESERVA:
			
			reserva = Formularios.pedirDatosReserva(scan);
			gestorBBDD.conectar();
			gestorBBDD.insertarReserva(reserva);
			gestorBBDD.cerrar();
			
			break;

		case Menu.ELIMINAR_RESERVA:
			
			id = Formularios.pediridReserva(scan);
			gestorBBDD.conectar();
			gestorBBDD.eliminarReserva(id);
			gestorBBDD.cerrar();
			
			break;
		}
	}while (opcion!=Menu.SALIR); 
	}
}

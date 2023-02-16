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
			gestorBBDD.conectar();
			int id_hotel=Formularios.pediridHotel(scan);
			gestorBBDD.insertarReserva(id_hotel,scan);			
			
			gestorBBDD.cerrar();
			

			break;

		case Menu.ELIMINAR_RESERVA:
			
			id = Formularios.pediridReserva(scan);
			gestorBBDD.conectar();
			gestorBBDD.eliminarReserva(id);
			gestorBBDD.cerrar();
			
			break;
		
		case Menu.VER_RESERVA:
			gestorBBDD.conectar();
			Visor.mostrarReservas(gestorBBDD.mostrarReserva());
			gestorBBDD.cerrar();
		}
	}while (opcion!=Menu.SALIR); 
	}
}

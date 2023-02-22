package viajes;

import java.sql.Date;
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
			String dni;
			gestorBBDD.conectar();
			dni = Formularios.pedirdniCliente(scan);
			int id_hotel=Formularios.pediridHotel(scan);
			Visor.mostrarHabitaciones(gestorBBDD.mostrarHabitacion());

			int resultado = gestorBBDD.insertarReserva(id_hotel, dni, scan);	
			switch (resultado) {
			case Menu.EXISTE: 
				System.out.println("Reserva realizada");
				break;
			
			case Menu.NO_EXISTE:
				System.out.println("No existe ese cliente");
				break;
				
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + resultado);
			}
			
									
			
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
		
		case Menu.CONSULTAR_FECHAS:
			gestorBBDD.conectar();
			Visor.mostrarReservas(gestorBBDD.getReservasFecha(new Date(Formularios.pedirDesde(scan).getTime()), new Date(Formularios.pedirHasta(scan).getTime())));
		
		}
		
		
	}while (opcion!=Menu.SALIR); 
	}
}

package viajes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;


public class GestorViajes {
	static Scanner scan = new Scanner(System.in);
	
	public static void run() throws SQLException, ParseException, ClassNotFoundException {
		int opcion;
		
		do {
			Menu.mostrarMenuPrincipal();
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.GESTIONAR_CLIENTES:
				Gestor_Cliente.run(scan);
				break;
			
			case Menu.GESTIONAR_RESERVAS:
				Gestor_Reserva.run(scan);
				break;
			
			case Menu.GESTIONAR_HOTELES:
				Gestor_Hotel.run(scan);
				break;
			
			case Menu.GESTIONAR_HABITACIONES:
				Gestor_Habitacion.run(scan);
			case Menu.SALIR:
				
			}
			
		}while (opcion != Menu.SALIR); 			
		
	}
}
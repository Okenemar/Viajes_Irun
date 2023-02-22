package viajes;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Formularios extends GestorBBDD{
	
	/*-------------------Clientes-------------------*/

	public static Cliente pedirDatosCliente(Scanner scan) {
		Cliente cliente = new Cliente();
		
		System.out.println("Introduce el dni del cliente");
		cliente.setDni(scan.nextLine()); 
		System.out.println("Introduce el nombre del cliente");
		cliente.setNombre(scan.nextLine());
		System.out.println("Introduce el apellido del cliente");
		cliente.setApellidos(scan.nextLine());
		System.out.println("Introduce la direccion del cliente");
		cliente.setDireccion(scan.nextLine()); 
		System.out.println("Introduce la localidad del cliente");
		cliente.setLocalidad(scan.nextLine()); 
		
		return cliente;
	}
	
	public static String pedirdniCliente(Scanner scan) {
		String dni;
		System.out.println("Introduce el dni del cliente que quieres");
		dni = scan.nextLine();
		
		return dni;
	}
	
	/*-------------------Hotel-------------------*/

	public static Hotel pedirDatosHotel(Scanner scan) {
		Hotel hotel = new Hotel();
		
		System.out.println("Introduce el cif del hotel");
		hotel.setCif(scan.nextLine());  
		System.out.println("Introduce el nombre del hotel");
		hotel.setNombre(scan.nextLine());  
		System.out.println("Introduce el gerente del hotel");
		hotel.setGerente(scan.nextLine()); 
		System.out.println("Introduce las estrellas del hotel");
		hotel.setEstrellas(Integer.parseInt(scan.nextLine())); 
		System.out.println("Introduce la compañia del hotel");
		hotel.setCompania(scan.nextLine());
		
		
		return hotel;
	}
	
	public static int pediridHotel(Scanner scan) {
		int id;
		System.out.println("Introduce el id del hotel que quieres");
		id = Integer.parseInt(scan.nextLine());
		
		return id;
	}
	
	/*-------------------Habitacion-------------------*/

	public static Habitacion pedirDatosHabitacion(Scanner scan) {
		Habitacion habitacion = new Habitacion();
		
		System.out.println("Introduce el id de la habitación");
		habitacion.setId(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduce el id del hotel al que pertenece");
		habitacion.setId_hotel(Integer.parseInt(scan.nextLine())); 
		System.out.println("Introduce el numero de la habitación");
		habitacion.setNumero(scan.nextLine());
		System.out.println("Introduce una descripción de la habitación");
		habitacion.setDescripcion(scan.nextLine());
		System.out.println("Introduce el precio de la habitación");
		habitacion.setPrecio(Double.parseDouble(scan.nextLine()));
		
		return habitacion;
	}
		public static int pediridHabitacion(Scanner scan) {
		int id;
		System.out.println("Introduce el id de la habitación que quieres");
		id = Integer.parseInt(scan.nextLine());
		
		return id;
	}
		/*-------------------Reserva-------------------*/

		public static Reserva pedirDatosReserva(Scanner scan) throws ParseException {
			Reserva reserva = new Reserva();
			
			SimpleDateFormat fechaDateFormat = new SimpleDateFormat("dd/mm/yyyy");
			
			System.out.println("Introduce el id de la habitacion");
			reserva.setId_habitacion(Integer.parseInt(scan.nextLine())); 
			System.out.println("Introduce el dni del cliente que ha realizado la reserva");
			reserva.setDni(scan.nextLine());
			System.out.println("Introduce desde cuando va a realizar la reserva");
			reserva.setDesde(fechaDateFormat.parse(scan.nextLine()));
			System.out.println("Introduce la fecha hasta que quieres realizar la reserva");
			reserva.setHasta(fechaDateFormat.parse(scan.nextLine()));
			
			return reserva;
		}
		
		public static int pediridReserva(Scanner scan) {
		int id;
		System.out.println("Introduce el id de la reserva que quieres");
		id = Integer.parseInt(scan.nextLine());
		
		return id;

		}
		
		
		public static String devuelveCadena(Scanner sc) {
			String cadena;
			System.out.println("Introduce la cadena que quieres buscar:");
			cadena=sc.nextLine();
			return cadena;
		}
		public static Date pedirDesde(Scanner sc) throws ParseException {
			SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
			Date date;
			System.out.println("Introduce la fecha desde la que quieres ver las reservas");
			date=fecha.parse(sc.nextLine());
			return date;
		}
		
		public static Date pedirHasta(Scanner sc) throws ParseException {
			SimpleDateFormat fecha=new SimpleDateFormat("dd/MM");
			Date date;
			System.out.println("Introduce la fecha de cuando quieres que acaben las reservas");
			date=fecha.parse(sc.nextLine());
			return date;
		}
	 
}

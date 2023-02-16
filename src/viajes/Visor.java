package viajes;

import java.util.ArrayList;

public class Visor {
	
	public static void mostrarClientes(ArrayList<Cliente> cliente) {
		for (Cliente cliente2 : cliente) {
			System.out.println(cliente2);
		}
	}
	
	public static void mostrarCliente(Cliente cliente) {
		System.out.println(cliente);
	}
	
	public static void mostrarHoteles(ArrayList<Hotel> hotel) {
		for (Hotel hotel2 : hotel) {
			System.out.println(hotel2);
		}
	}
	public static void mostrarHotel(Hotel hotel) {
		System.out.println(hotel);
	}
	public static void mostrarHabitaciones(ArrayList<Habitacion> habitacion) {
		for (Habitacion habitacion2 : habitacion) {
			System.out.println(habitacion2);
		}
	}
	public static void mostrarHabitacion(Habitacion habitacion) {
		System.out.println(habitacion);
	}
	
	public static void mostrarReservas(ArrayList<Reserva> reserva) {
		for (Reserva reserva2 : reserva) {
			System.out.println(reserva2);
		}
	}
	public static void mostrarReserva(Reserva reserva) {
		System.out.println(reserva);
	}
}

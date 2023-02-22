package viajes;

import java.nio.channels.GatheringByteChannel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_hotel extends Conector{
	
	PreparedStatement preparedSt;
	
	public static void main(String[] args) throws SQLException {
		String nombreHotel;
		int habitaciones;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nombre del hotel");
		nombreHotel = scan.nextLine();
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		gestorBBDD.conectar();
		Hotel hotel = gestorBBDD.gethotel(nombreHotel);
		
		ArrayList<Habitacion> habitaciones1 = gestorBBDD.getHabitacion(hotel.getId());
		gestorBBDD.cerrar();
		
		for (Habitacion habitacion : habitaciones1) {
			System.out.println(habitacion);
			
		}
	}
	
//	public void altaHabitacion(Habitacion habitacion) throws SQLException{
//		preparedSt = con.prepareStatement("INSERT INTO habitaciones VALUES (?,?,?,?,?)");
//		
//		preparedSt.setInt(1, habitacion.getId());
//		preparedSt.setInt(2, habitacion.getId_hotel());
//		preparedSt.setString(3, habitacion.getNumero());
//		preparedSt.setString(4, habitacion.getDescripcion());
//		preparedSt.setDouble(5, habitacion.getPrecio());
//		
//		preparedSt.execute();
//	}

	
	
	
}

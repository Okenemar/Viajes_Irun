package viajes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorBBDD extends Conector {
	PreparedStatement preparedSt;
	
	/*-------------------Clientes-------------------*/
	
	public void insertarCliente(Cliente cliente) throws SQLException {
		preparedSt = con.prepareStatement("INSERT INTO clientes VALUES (null, ?,?,?,?,?)");
		
		preparedSt.setString(1, cliente.getDni());
		preparedSt.setString(2, cliente.getNombre());
		preparedSt.setString(3, cliente.getApellidos());
		preparedSt.setString(4, cliente.getDireccion());
		preparedSt.setString(5, cliente.getLocalidad());
		
		preparedSt.execute();
	}
	
	public void eliminarCliente(String dni) throws SQLException{
		
		preparedSt = con.prepareStatement("DELETE FROM clientes WHERE dni = ?");
		
		preparedSt.setString(1, dni);

		preparedSt.execute();
	}
	
	public Cliente getCliente (String dni) {
		return null;
	}
	
	public ArrayList<Cliente> mostrarClientes() throws SQLException{
		Statement st = con.createStatement();
		
		String sentenciaSelect = "SELECT * FROM clientes";
		ResultSet resultado = st.executeQuery(sentenciaSelect);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		while (resultado.next()) {
			Cliente cliente = new Cliente();
			cliente.setDni(resultado.getString("dni"));
			cliente.setNombre(resultado.getString("nombre"));
			cliente.setApellidos(resultado.getString("apellidos"));
			cliente.setDireccion(resultado.getString("direccion"));
			cliente.setLocalidad(resultado.getString("localidad"));
			
			clientes.add(cliente);
			
		}
		return clientes;
	}
	
	/*-------------------Hoteles-------------------*/

	
	public int maxId() throws SQLException {
		int id;
		preparedSt = con.prepareStatement("SELECT MAX(id) FROM hoteles");
		
		ResultSet resultado = preparedSt.executeQuery();
		
		resultado.next();
		
		id = resultado.getInt(1);
		
		return id;
		
	}
	public void insertarHotel(Hotel hotel, Scanner scan) throws SQLException {
		preparedSt = con.prepareStatement("INSERT INTO hoteles (cif,nombre,gerente,estrellas,compania) VALUES (?,?,?,?,?)");
		String respuesta = "";

		preparedSt.setString(1, hotel.getCif());
		preparedSt.setString(2, hotel.getNombre());
		preparedSt.setString(3, hotel.getGerente());
		preparedSt.setInt(4, hotel.getEstrellas());
		preparedSt.setString(5, hotel.getCompania());
		
		preparedSt.execute();
		
		do {
	
			System.out.println("En caso de querer introducir una habitación escriba 'si' en caso contrario 'no'");
			respuesta = scan.nextLine();
			
			if (respuesta.equals("si")) {
				Habitacion habitacion = Formularios.pedirDatosHabitacion(scan);	
				habitacion.setId_hotel(maxId());
				insertarHabitacion(habitacion);
				}
		} while (respuesta.equals("no"));
		
	}
	
	public void eliminarHotel(int id) throws SQLException{
		preparedSt = con.prepareStatement("DELETE FROM hoteles WHERE id = ?");
		
		preparedSt.setInt(1, id);

		preparedSt.execute();
	}
	
	public Hotel gethotel (String id) {
		return null;
	}
	
	public ArrayList<Hotel> mostrarHoteles() throws SQLException{
		Statement st = con.createStatement();
		
		String sentenciaSelect = "SELECT * FROM hoteles";
		ResultSet resultado = st.executeQuery(sentenciaSelect);
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		while (resultado.next()) {
			Hotel hotel = new Hotel();
			hotel.setId(resultado.getInt("id"));
			hotel.setCif(resultado.getString("cif"));
			hotel.setNombre(resultado.getString("nombre"));
			hotel.setGerente(resultado.getString("gerente"));
			hotel.setEstrellas(resultado.getInt("estrellas"));
			hotel.setCompania(resultado.getString("compania"));
			
			hoteles.add(hotel);
		}
		return hoteles;
	}
	
	/*-------------------Habitaciones-------------------*/

	public void insertarHabitacion(Habitacion habitacion) throws SQLException{
		preparedSt = con.prepareStatement("INSERT INTO habitaciones VALUES (?,?,?,?,?)");
		
		preparedSt.setInt(1, habitacion.getId());
		preparedSt.setInt(2, habitacion.getId_hotel());
		preparedSt.setString(3, habitacion.getNumero());
		preparedSt.setString(4, habitacion.getDescripcion());
		preparedSt.setDouble(5, habitacion.getPrecio());
		
		preparedSt.execute();
	}
	public void eliminarHabitacion(int id) throws SQLException{
		preparedSt = con.prepareStatement("DELETE FROM habitaciones WHERE id = ?");
		
		preparedSt.setInt(1, id);

		preparedSt.execute();
	}
	public Habitacion getHabitacion (String id) {
		return null;
	}
	
	public ArrayList<Habitacion> mostrarHabitacion() throws SQLException{
		Statement st = con.createStatement();
		
		String sentenciaSelect = "SELECT * FROM habitaciones";
		ResultSet resultado = st.executeQuery(sentenciaSelect);
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		while (resultado.next()) {
			Habitacion habitacion = new Habitacion();
			habitacion.setId(resultado.getInt("id"));
			habitacion.setId_hotel(resultado.getInt("id_hotel"));
			habitacion.setNumero(resultado.getString("numero"));
			habitacion.setDescripcion(resultado.getString("descripcion"));
			habitacion.setPrecio(resultado.getDouble("precio"));			
			
			habitaciones.add(habitacion);
		}
		return habitaciones;
	}
	public ArrayList<Habitacion> mostrarHabitacionPorHotel(int id_hotel) throws SQLException{
		
		
		String sentenciaSelect = "SELECT * FROM habitaciones WHERE id_hotel = ?";
		PreparedStatement pt = con.prepareStatement(sentenciaSelect);
		
		pt.setInt(1, id_hotel);

		ResultSet resultado = pt.executeQuery();
		
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		while (resultado.next()) {
			Habitacion habitacion = new Habitacion();
			habitacion.setId(resultado.getInt("id"));
			habitacion.setId_hotel(resultado.getInt("id_hotel"));
			habitacion.setNumero(resultado.getString("numero"));
			habitacion.setDescripcion(resultado.getString("descripcion"));
			habitacion.setPrecio(resultado.getDouble("precio"));			
			
			habitaciones.add(habitacion);
		}
		return habitaciones;
	}
	/*-------------------Reserva-------------------*/
	
	public void insertarReserva(int id_hotel, Scanner scan) throws SQLException, ParseException{
		Reserva reserva = new Reserva();
		Visor.mostrarHabitaciones(mostrarHabitacionPorHotel(id_hotel));
		reserva=Formularios.pedirDatosReserva(scan);
		
		preparedSt = con.prepareStatement("INSERT INTO reservas (id,id_habitacion,dni,desde,hasta) VALUES (?,?,?,?,?)");
		
		preparedSt.setInt(1, reserva.getId());
		preparedSt.setInt(2, reserva.getId_habitacion());
		preparedSt.setString(3, reserva.getDni());
		preparedSt.setDate(4, new Date(reserva.getDesde().getTime()));
		preparedSt.setDate(5, new Date(reserva.getHasta().getTime()));
		
		preparedSt.execute();
	
	}
	
	public void eliminarReserva(int id) throws SQLException{
		preparedSt = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
		
		preparedSt.setInt(1, id);
		
		preparedSt.execute();
	}
	public ArrayList<Reserva> mostrarReserva() throws SQLException{
		Statement st = con.createStatement();
		
		String sentenciaSelect = "SELECT * FROM reservas";
		ResultSet resultado = st.executeQuery(sentenciaSelect);
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		while (resultado.next()) {
			Reserva reserva = new Reserva();
			reserva.setId(resultado.getInt("id"));
			reserva.setId_habitacion(resultado.getInt("id_habitacion"));
			reserva.setDni(resultado.getString("dni"));
			reserva.setDesde(resultado.getDate("desde"));
			reserva.setHasta(resultado.getDate("hasta"));
			
			reservas.add(reserva);
		}
		return reservas;
	}
}

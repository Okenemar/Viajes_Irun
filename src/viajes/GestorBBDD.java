package viajes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public void insertarHotel(Hotel hotel) throws SQLException {
		preparedSt = con.prepareStatement("INSERT INTO hoteles VALUES (null, ?,?,?,?,?)");
		
		
		preparedSt.setString(2, hotel.getCif());
		preparedSt.setString(3, hotel.getNombre());
		preparedSt.setString(4, hotel.getGerente());
		preparedSt.setInt(5, hotel.getEstrellas());
		preparedSt.setString(6, hotel.getCompania());
		
		preparedSt.execute();
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
		preparedSt = con.prepareStatement("INSERT INTO habitaciones VALUES (null,?,?,?,?)");
		
		preparedSt.setInt(1, habitacion.getId_hotel());
		preparedSt.setString(2, habitacion.getNumero());
		preparedSt.setString(3, habitacion.getDescripcion());
		preparedSt.setDouble(4, habitacion.getPrecio());
		
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
	/*-------------------Reserva-------------------*/
	
	public void insertarReserva(Reserva reserva) throws SQLException{
		preparedSt = con.prepareStatement("INSERT INTO reservas VALUES (null,?,?,?,?)");
		
		preparedSt.setInt(1, reserva.getId_habitacion());
		preparedSt.setString(2, reserva.getDni());
		preparedSt.setDate(3, new Date(reserva.getDesde().getTime()));
		preparedSt.setDate(4, new Date(reserva.getHasta().getTime()));
		
		preparedSt.execute();
	}
	
	public void eliminarReserva(int id) throws SQLException{
		preparedSt = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
		
		preparedSt.setInt(1, id);
		
		preparedSt.execute();
	}
}

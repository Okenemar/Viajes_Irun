package viajes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBBDD extends Conector {
	PreparedStatement preparedSt;
	
	/*-------------------Clientes-------------------*/
	
	public void insertarCliente(Cliente cliente) throws SQLException {
		preparedSt = con.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?)");
		
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
}

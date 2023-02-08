package viajes;

import java.sql.SQLException;
import java.util.Scanner;

import viajes.GestorViajes;

public class ViajesAPP {
	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		Scanner scan = new Scanner(System.in);
		Gestor_Cliente.run(scan);
	}
}

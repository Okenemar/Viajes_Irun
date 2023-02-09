package viajes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;


public class ViajesAPP {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException  {
		Scanner scan = new Scanner(System.in);
		Gestor_Reserva.run(scan);
	}
}

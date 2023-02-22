package viajes;

public class Menu {
	
	public static final int EXISTE = 1;
	public static final int NO_EXISTE = 2;
	
	/*-------------MENU PRINCIPAL-------------*/
	
	public static final int GESTIONAR_CLIENTES = 1;
	public static final int GESTIONAR_RESERVAS = 2;
	public static final int GESTIONAR_HABITACIONES = 3;
	public static final int GESTIONAR_HOTELES = 4;
	public static final int SALIR = 0;
	
	/*-------------MENU CLIENTES-------------*/

	public static final int CREAR_CLIENTE = 1;
	public static final int ELIMINAR_CLIENTE = 2;
	public static final int VER_CLIENTES = 3;
	public static final int ORDENAR_POR_NOMBRE = 4;
	public static final int ORDENAR_POR_APELLIDO = 5;
	public static final int CADENA = 6;
	
	/*-------------MENU RESERVAS-------------*/

	public static final int CREAR_RESERVA = 1;
	public static final int ELIMINAR_RESERVA = 2;
	public static final int VER_RESERVA = 3;
	public static final int CONSULTAR_FECHAS = 4;
	
	/*-------------MENU HOTELES-------------*/

	public static final int CREAR_HOTEL = 1;
	public static final int ELIMINAR_HOTEL = 2;
	public static final int MOSTRAR_HOTEL = 3;
	
	/*-------------MENU HABITACIONES-------------*/
	public static final int CREAR_HABITACION = 1;
	public static final int ELIMINAR_HABITACION = 2;
	public static final int MOSTRAR_HABITACION = 3;
	
	
	static void mostrarMenuPrincipal() {
		System.out.println("-----MENU-----");
		System.out.println(GESTIONAR_CLIENTES + ". Gestionar clientes");
		System.out.println(GESTIONAR_RESERVAS + ". Gestionar reservas");
		System.out.println(GESTIONAR_HABITACIONES + ". Gestionar habitaciones");
		System.out.println(GESTIONAR_HOTELES + ". Gestionar hoteles");
		System.out.println(SALIR + ". Salir");
	}
	static void mostrarMenuClientes() {
		System.out.println("-----MENU-----");
		System.out.println(CREAR_CLIENTE + ". Crear cliente");
		System.out.println(ELIMINAR_CLIENTE + ". Eliminar cliente");
		System.out.println(VER_CLIENTES + ". Ver clientes");
		System.out.println(ORDENAR_POR_NOMBRE + ". Ordenar los clientes por nombre");
		System.out.println(ORDENAR_POR_APELLIDO + ". Ordenar por apellido");
		System.out.println(CADENA + ". Introducir una cadena y ver los clientes que la contengan");
		System.out.println(SALIR + ". Salir");
	}
	
	static void mostrarMenuReservas() {
		System.out.println("-----MENU-----");
		System.out.println(CREAR_RESERVA + ". Crear reserva");
		System.out.println(ELIMINAR_RESERVA + ". Eliminar reserva");
		System.out.println(VER_RESERVA + ". Ver reservas");
		System.out.println(CONSULTAR_FECHAS + ". Consultar reservas entre fechas");
		System.out.println(SALIR + ". Salir");
	}
	
	static void mostrarMenuHoteles() {
		System.out.println("-----MENU-----");
		System.out.println(CREAR_HOTEL + ". Registrar hotel");
		System.out.println(ELIMINAR_HOTEL + ". Eliminar hotel");
		System.out.println(MOSTRAR_HOTEL + ". Mostrar hoteles");
		System.out.println(SALIR + ". Salir");
	}
	
	static void mostrarMenuHabitacion() {
		System.out.println("-----MENU-----");
		System.out.println(CREAR_HABITACION + ". Crear habitación");
		System.out.println(ELIMINAR_HABITACION + ". Eliminar habitación");
		System.out.println(MOSTRAR_HABITACION + ". Mostrar habitaciones");
	}
	}


package examenMarzo.concesionarioCoches;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */
public enum Modelo {

	SERIE1(Marca.BMW),

	SERIE2(Marca.BMW),

	SERIE3(Marca.BMW),

	SERIE5(Marca.BMW),

	CORDOBA(Marca.SEAT),

	IBIZA(Marca.SEAT),

	TOLEDO(Marca.SEAT);
	/**
	 * Marca del coche
	 */
	private Marca marca;
	/**
	 * Constructor del modelo
	 * @param marca Marca del vehiculo
	 */
	private Modelo(Marca marca) {
		this.marca = marca;
	}
	/**
	 * Metodo para obtener la marca
	 * @return Marca
	 */
	public Marca getMarca() {
		return marca;
	}
	/**
	 * Muestra el modelo y la marca
	 */
	public String toString() {
		return name() + ", " + getMarca();

	}

	// Para el menú-------------------------------------------------
	/**
	 * Lista de modelos
	 */
	private static final Modelo[] VALUES = Modelo.values();
	/**
	 * Metodo para generar las opciones del menu
	 * @return Array de String
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Devuelve la lista de modelos
	 * @return Array de Modelos
	 */
	public static Modelo[] getValues() {
		return VALUES;
	}
	// -------------------------------------------------

}

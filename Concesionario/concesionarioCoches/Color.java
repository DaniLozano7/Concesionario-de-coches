package examenMarzo.concesionarioCoches;

//import pgn.examenMarzo.utiles.Menu;

/**
 * Se limitarán los colores a tres: plata, rojo y azul. Para solicitar el color
 * al dar de alta al coche podrá implementarse un método pedirColor que mediante
 * la gestión de un menú, devolverá el color indicado
 * 
 * @author Daniel Lozano Torrico
 * 
 */
public enum Color {
	PLATA, ROJO, AZUL;

	/**
	 * Lista de colores
	 */
	private static final Color[] VALUES = Color.values();

	/**
	 * Metodo para generar las opciones del menu
	 * 
	 * @return String[]
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve un array de colores
	 * 
	 * @return Color[]
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}

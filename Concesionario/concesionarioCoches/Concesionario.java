package examenMarzo.concesionarioCoches;

import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matrícula en el almacén del concesinario
 * no puede añadirse un coche al concecionario con alguno de sus atributos inválidos. Han de conocerse todas sus características 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * El nombre del concesionario es "IES Gran Capitán".
 * 
 * Lógicamente, no podrá añadirse un coche inválido glmacén del concesinario)
 * 
 * Han de conocerse todas sus características Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Daniel Lozano Torrico
 * 
 */
public class Concesionario {
	/**
	 * Colección de coches
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capitán";

	/**
	 * Metodo para añadir coche con tres parametros
	 * 
	 * @param matricula Matricula indicada
	 * @param color Color indicado
	 * @param modelo Modelo indicado
	 * @return boolean
	 */
	boolean annadir(String matricula, Color color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}

	/**
	 * Metodo para eliminar coche
	 * 
	 * @param matricula Matricula indicada
	 * @return boolean
	 */
	boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
	}

	/**
	 * Metodo que devuelve el tamaño del almacen
	 * 
	 * @return Tamaño del almacen (int)
	 */
	int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el Coche del almacén indicado por la matrícula
	 * 
	 * @param matricula
	 *            Matrícula a buscar
	 * @return Coche contenido en el almacén. Null si no existe
	 */
	Coche get(String matricula) {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	/**
	 * Muestra coches por color
	 * 
	 * @param color Color indicado
	 * @return ArrayList de coches
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}

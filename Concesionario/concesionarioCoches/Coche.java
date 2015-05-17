package examenMarzo.concesionarioCoches;

import java.util.regex.Pattern;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */

public class Coche {
	/**
	 * Matricula del coche
	 */
	private String matricula;
	/**
	 * Color del coche
	 */
	private Color color;
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	/**
	 * Patron para verificar la matricula
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Constructor de coche con tres parametros
	 * 
	 * @param matricula Matricula indicada
	 * @param color Color indicado
	 * @param modelo Modelo indicado
	 */
	private Coche(String matricula, Color color, Modelo modelo) {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Constructor de coche con un parametro
	 * 
	 * @param matricula Matricula indicada
	 */
	private Coche(String matricula) {
		setMatricula(matricula);
	}

	/**
	 * Metodo para crear coche con tres parametros
	 * 
	 * @param matricula Matricula indicada
	 * @param color Color indicado
	 * @param modelo Modelo indicado
	 * @return Coche Coche indicado
	 */
	static Coche instanciarCoche(String matricula, Color color, Modelo modelo) {
		if (esValida(matricula) && color != null && modelo != null)
			return new Coche(matricula, color, modelo);
		return null;
	}

	/**
	 * Metodo para crear coche con un parametro
	 * 
	 * @param matricula Matricula indicada
	 * @return Coche
	 */
	static Coche instanciarCoche(String matricula) {
		if (esValida(matricula))
			return new Coche(matricula);
		return null;
	}

	/**
	 * Metodo que usa el patron de matricula para indicar si es valida o no
	 * 
	 * @param matricula Matricula indicada
	 * @return boolean
	 */
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Establece la matricula
	 * 
	 * @param matricula Matricula indicada
	 */
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Devuelve el color
	 * 
	 * @return Color
	 */
	Color getColor() {
		return color;
	}

	/**
	 * Establece el color
	 * 
	 * @param color Color indicado
	 */
	private void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Establece el modelo
	 * 
	 * @param modelo Modelo indicado
	 */
	private void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}

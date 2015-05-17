package EntornoGrafico;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



import concesionarioCoches.Concesionario;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 *
 */

public class Fichero {
	
		public static void guardar(File archivo, Concesionario concesionario)
				throws IOException {
			archivo = annadirExtension(archivo);
			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(archivo, false)))) {
				objectOutputStream.writeObject(concesionario);
				General.concesionario.setModificado(false);
			}
		}
		

	static Object abrir(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				archivo))) {
			return (Object) ois.readObject();
		}
	}

	static File annadirExtension(File fichero) {
		String nombre = Principal.archivo.getPath();
		if (!nombre.endsWith(".obj"))
			return new File(Principal.archivo + ".obj");
		return Principal.archivo;
	}

}

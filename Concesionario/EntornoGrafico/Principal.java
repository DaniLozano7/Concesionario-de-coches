package EntornoGrafico;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionarioCoches.Concesionario;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.1
 */

public class Principal {

	static JFrame frame;
	static File archivo = new File("Sin_titulo.obj");
	static File aux = null;
	private static FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"Archivos .obj", "obj");
	private Annadir annadir = new Annadir();
	private Eliminar eliminar = new Eliminar();
	private MostrarConcesionario concesionario = new MostrarConcesionario();
	private MostrarCoche coche = new MostrarCoche();
	private MostrarPorColor cochesColor = new MostrarPorColor();
	private VerAyuda verAyuda = new VerAyuda();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					new Principal();
					frame.setTitle(archivo.getName());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Barra de menus
		 */
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		/**
		 * Menu Archivo
		 */
		JMenu Archivo = new JMenu("Archivo");
		Archivo.setMnemonic('f');
		menuBar.add(Archivo);

		/**
		 * Archivo>Abrir
		 */
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrir();

			}

		});

		/**
		 * Archivo>Nuevo
		 */
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}

		});
		Archivo.add(mntmNuevo);
		Archivo.add(mntmAbrir);

		/**
		 * Archivo>Guardar
		 */
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (archivo.getName() == "Sin_titulo.obj") {
					guardarComo();
					frame.setTitle(archivo.getName());
				} else {
					try {
						Fichero.guardar(archivo, General.concesionario);
						frame.setTitle(archivo.getName());
					} catch (IOException e) {
						JOptionPane.showMessageDialog(frame,
								"No se ha podido guardar el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		});
		Archivo.add(mntmGuardar);

		/**
		 * Archivo>Guardar como
		 */

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.CTRL_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarComo();
				frame.setTitle(archivo.getName());
			}

		});
		Archivo.add(mntmGuardarComo);
		JSeparator separator = new JSeparator();
		Archivo.add(separator);

		/**
		 * Archivo>Salir
		 */
		JMenuItem mntmS = new JMenuItem("Salir");
		mntmS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,
				InputEvent.CTRL_MASK));
		Archivo.add(mntmS);

		/**
		 * Menu Coches
		 */
		JMenu mnCoches = new JMenu("Coches");
		mnCoches.setMnemonic('c');
		menuBar.add(mnCoches);

		/**
		 * Coches>A�adir
		 */
		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir.setVisible(true);
			}
		});
		mnCoches.add(mntmAadir);

		/**
		 * Coches>Eliminar
		 */
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.CTRL_MASK));
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar.setVisible(true);
			}
		});
		mnCoches.add(mntmEliminar);

		/**
		 * Coches>Mostrar Concesionario
		 */
		JMenuItem mntmMostrarConcesionario = new JMenuItem(
				"Mostrar concesionario");
		mntmMostrarConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_Z, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concesionario.setVisible(true);
			}
		});

		/**
		 * Separador entre JMenuItems
		 */
		JSeparator separator_3 = new JSeparator();
		mnCoches.add(separator_3);

		/**
		 * Coches>Mostrar total de coches
		 */
		JMenuItem mntmMostrarTotalDe = new JMenuItem("Mostrar total de coches");
		mntmMostrarTotalDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(
						frame,
						"Numero total de vehiculos: "
								+ General.concesionario.size());
			}
		});
		mntmMostrarTotalDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnCoches.add(mntmMostrarTotalDe);
		mnCoches.add(mntmMostrarConcesionario);

		/**
		 * Coches>Mostrar por matricula
		 */
		JMenuItem mntmMostrarPorMatricula = new JMenuItem(
				"Mostrar por matricula");
		mntmMostrarPorMatricula.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMostrarPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setVisible(true);
			}
		});
		mnCoches.add(mntmMostrarPorMatricula);

		/**
		 * Coches>Mostrar por color
		 */
		JMenuItem mntmMostrarPorColor = new JMenuItem("Mostrar por color");
		mntmMostrarPorColor.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmMostrarPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cochesColor.setVisible(true);
			}
		});
		mnCoches.add(mntmMostrarPorColor);

		/**
		 * Menu Ayuda
		 */
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('h');
		menuBar.add(mnAyuda);

		/**
		 * Ayuda>Ver Ayuda
		 */
		JMenuItem mntmNewMenuItem = new JMenuItem("Ver Ayuda");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.ALT_MASK));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verAyuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmNewMenuItem);

		/**
		 * Ayuda>Acerca de
		 */
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Acerca de...");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.ALT_MASK));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								frame,
								"Programa realizado por Daniel Lozano Torrico, alumno del IES Gran Capitan v1.1");
			}
		});
		mnAyuda.add(mntmNewMenuItem_1);
		frame.getContentPane().setLayout(null);

		/**
		 * A�adir imagen a la ventana principal
		 */
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass()
				.getResource("/img/inicio.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(29, 21, 216, 203);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("Concesionario");
		lblNewLabel.setFont(new Font("Narkisim", Font.BOLD, 18));
		lblNewLabel.setBounds(233, 59, 138, 50);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("IES Gran Capitan");
		lblNewLabel_1.setFont(new Font("Narkisim", Font.BOLD, 18));
		lblNewLabel_1.setBounds(220, 105, 200, 50);
		frame.getContentPane().add(lblNewLabel_1);
	}

	static void abrir() {
		if (General.concesionario.isModificado()) {
			int opcionAbrir = JOptionPane.showConfirmDialog(frame,
					"�Deseas guardar el concesionario?");
			if (opcionAbrir == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcionAbrir = guardar.showSaveDialog(frame);
				if (opcionAbrir == 0) {
					archivo = guardar.getSelectedFile();
					try {
						Fichero.guardar(archivo, General.concesionario);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(frame,
								"No se ha podido guardar el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (opcionAbrir == 2) {
				frame.setVisible(false);
			} else {
				JFileChooser abrir = new JFileChooser();
				abrir.setFileFilter(filtro);
				int opcion = abrir.showOpenDialog(frame);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					archivo = abrir.getSelectedFile();

					try {
						General.concesionario = (concesionarioCoches.Concesionario) Fichero
								.abrir(archivo);
						frame.setTitle(archivo.getName());
						General.concesionario.setModificado(false);

					} catch (ClassNotFoundException | IOException e) {
						JOptionPane.showMessageDialog(frame,
								"No se ha encontrado el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} else {
			JFileChooser abrir = new JFileChooser();
			abrir.setFileFilter(filtro);
			int opcion = abrir.showOpenDialog(frame);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				archivo = abrir.getSelectedFile();

				try {
					General.concesionario = (concesionarioCoches.Concesionario) Fichero
							.abrir(archivo);
					frame.setTitle(archivo.getName());
					General.concesionario.setModificado(false);

				} catch (ClassNotFoundException | IOException e) {
					JOptionPane.showMessageDialog(frame,
							"No se ha encontrado el archivo", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public static void guardarComo() {
		JFileChooser guardarComo = new JFileChooser();
		guardarComo.setFileFilter(filtro);

		if (JFileChooser.APPROVE_OPTION == guardarComo.showSaveDialog(frame)) {
			archivo = guardarComo.getSelectedFile();
			archivo = Fichero.annadirExtension(archivo);
			if (archivo.exists()) {
				int opcionGuardar = JOptionPane.showConfirmDialog(guardarComo,
						"�Desea sobreescribir el archivo?");
				if (opcionGuardar == 0) {
					try {
						Fichero.guardar(archivo, General.concesionario);
						frame.setTitle(archivo.getName());
					} catch (IOException e) {
						JOptionPane.showMessageDialog(frame,
								"No se ha podido guardar el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					guardarComo.setVisible(false);
				}
			} else {
				try {
					Fichero.guardar(archivo, General.concesionario);
					frame.setTitle(archivo.getName());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame,
							"No se ha podido guardar el archivo", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	static void nuevo() {
		if (General.concesionario.isModificado()) {
			int opcionNuevo = JOptionPane.showConfirmDialog(frame,
					"�Deseas guardar el concesionario?");
			if (opcionNuevo == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcionNuevo = guardar.showSaveDialog(frame);
				if (opcionNuevo == 0) {
					archivo = guardar.getSelectedFile();
					try {
						Fichero.guardar(archivo, General.concesionario);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(frame,
								"No se ha podido guardar el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				General.concesionario = new Concesionario();
				frame.setTitle("Sin_titulo.obj");
			} else if (opcionNuevo == 2)
				frame.setVisible(false);
			else {
				General.concesionario = new Concesionario();
				frame.setTitle("Sin_titulo.obj");
			}
		} else {
			General.concesionario = new Concesionario();
			frame.setTitle("Sin_titulo.obj");
		}
	}

}

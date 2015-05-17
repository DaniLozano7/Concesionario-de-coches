package EntornoGrafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */

public class VerAyuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VerAyuda() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 218);
		contentPanel.add(scrollPane);
		
		JEditorPane dtrpnHola = new JEditorPane();
		dtrpnHola.setEditable(false);
		scrollPane.setViewportView(dtrpnHola);
		dtrpnHola.setContentType("text/html");
		dtrpnHola.setText("<html>\r\n<body>\r\n<DIV ALIGN=center>\r<h1><u>Ayuda</u></h1><br></DIV>\r\n<h2>Ficheros</h2>\r\n<ul>\r\n<li><u>Nuevo:</u> (Ctrl+N) Inicia un nuevo concesionario en un nuevo fichero. Pregunta de antemano si se desea guardar el concesionario existente en ese momento.</li>\r\n<li><u>Abrir:</u> (Ctrl+O) Abre un concesionario ya existente en un fichero. Pregunta de antemano si se desea guardar el concesionario existente en ese momento.</li>\r\n<li><u>Guardar:</u> (Ctrl+S) Guarda el concesionario actual en un fichero. Si el concesionario no ha sido guardado anteriormente, pedira un nombre y una ubicacion para guardar el archivo. Si ya ha sido creado, guardara los cambios en el mismo fichero seleccionado.</li>\r\n<li><u>Guardar como:</u> (Ctrl+D) Guarda el concesionario actual en un fichero. Pregunta que nombre deseamos darle y la ubicacion donde se guardar\u00E1.</li>\r\n</ul>\r\n<br>\r\n<h2>Coches</h2>\r\n<ul>\r\n<li><u>A\u00F1adir:</u> (Ctrl+A) Agrega un coche nuevo al concesionario. Pide la matricula, el color, la marca y el modelo. Si la matricula no es valida, no permitira a\u00F1adirlo a la lista.</li>\r\n<li><u>Eliminar:</u> (Ctrl+D) Elimina un coche del concesionario. Pide la matricula, muestra los datos del vehiculo y pregunta si deseamos eliminarlo.</li>\r\n<li><u>Mostrar total de coches:</u> (Ctrl+Mayus+V) Muestra el numero total de vehiculos registrados en el concesionario.</li>\r\n<li><u>Mostrar concesionario:</u> (Ctrl+Mayus+Z) Muestra todos los coches del concesionario, uno a uno. Podemos ver la matricula, el color, la marca y el modelo de cada uno de los vehiculos de forma individual.</li>\r\n<li><u>Mostrar por matricula:</u> (Ctrl+Mayus+X) Muestra los datos de un coche determinado, segun la matricula introducida.</li>\r\n<li><u>Mostrar por color:</u> (Ctrl+Mayus+C) Muestra todos los vehiculos del concesionario que coinciden con el color seleccionado. Podemos ver todos sus datos de forma individual, uno a uno.</li>\r\n</ul>\r\n<br>\r\n<h2>Ayuda</h2>\r\n<ul>\r\n<li><u>Ver ayuda:</u> (Alt+A) Muestra la descripcion de cada opcion del menu con todas sus caracteristicas. Ayuda general.</li>\r\n<li><u>Acerca de:</u> (Alt+S) Datos del programa y version</li>\r\n</ul>\r\n</body>\r\n</html>");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonSalir = new JButton("Salir");
				botonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(botonSalir);
			}
		}
	}
}

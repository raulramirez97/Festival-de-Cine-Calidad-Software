package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Filtrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFiltroNumero;
	private JComboBox listafiltrosGenerales;
	private JComboBox listafiltrosEspecificos;
	private boolean flag = false;
	private JFrame ventana;

	public Filtrar(UsuarioDTO aux)
	{
		ventana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Filtrado de Películas");
		
		JLabel lblFiltrar = new JLabel("Filtra las películas");
		lblFiltrar.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFiltrar.setBounds(40, 40, 350, 90);
		contentPane.add(lblFiltrar);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(46, 123, 101, 37);
		contentPane.add(lblCategoria);

		//TODO: Paso 1: Recoger Categoría de Filtro general.

		//TODO: Paso 2: Usar Categoría de Filtro general para hacer un filtro de segundo nivel.
		//TODO: El problema con esta aproximación es que solo me vale para aquellas cosas de tipo "cualitativo" donde
		//TODO: puedo hacer un match exacto con un String y ya. No me vale para filtrados numéricos; tendré que pensarlo
		//TODO: de otra manera para esos casos. (if-else tratando de inferir el tipo del textfield? Ojo cuidado, puede ser
		//TODO: que un número me interese reflejarlo como un String y que por tanto a nivel de comparativa vaya a otro lado.)

		ArrayList<String> filtrosGenerales = new ArrayList<String>();
		//TODO: Test realizado. Eliminar después (o no!).
		//filtrosGenerales = FestivalCineController.getInstance().getFiltros();
		filtrosGenerales.add("Opciones:");
		filtrosGenerales.add("Género");
		filtrosGenerales.add("Sección del Festival");
		filtrosGenerales.add("Año");
		filtrosGenerales.add("Valoración");
		filtrosGenerales.add("Duración");
		String[] filtrosGeneralesStrings = new String [filtrosGenerales.size()];
		for (int i = 0; i < filtrosGeneralesStrings.length; i++){
			filtrosGeneralesStrings[i] = filtrosGenerales.get(i);
		}

		//TODO: Filtros Específicos.
		listafiltrosEspecificos = new JComboBox();
		listafiltrosEspecificos.setBounds(46, 220, 146, 26);
		contentPane.add(listafiltrosEspecificos);
		listafiltrosEspecificos.setVisible(false);

		textFieldFiltroNumero = new JTextField();
		textFieldFiltroNumero.setBounds(46, 220, 146, 26);
		contentPane.add(textFieldFiltroNumero);
		textFieldFiltroNumero.setVisible(false);

		//ArrayList<String> filtrosEspecificos = new ArrayList<String>();
		listafiltrosGenerales = new JComboBox(filtrosGeneralesStrings);
		listafiltrosGenerales.setBounds(46, 172, 146, 26);
		contentPane.add(listafiltrosGenerales);
		listafiltrosGenerales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Es decir, si se selecciona el Género.
				if (listafiltrosGenerales.getSelectedIndex()==0)
				{
					listafiltrosEspecificos.setVisible(false);
				}
				else if (listafiltrosGenerales.getSelectedIndex()==1)
				{
					textFieldFiltroNumero.setVisible(false);
					ArrayList<String> filtrosEspecificos = new ArrayList<String>();
					filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(1));
					String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
					for (int i = 0; i < filtrosEspecificosStrings.length; i++){
						filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
					}

					DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
					listafiltrosEspecificos.setModel( model );
					listafiltrosEspecificos.setVisible(true);

				} //TODO: Es decir, si se selecciona otra opción.
				else if (listafiltrosGenerales.getSelectedIndex()==2) {
					textFieldFiltroNumero.setVisible(false);
					ArrayList<String> filtrosEspecificos = new ArrayList<String>();
					filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(2));
					String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
					for (int i = 0; i < filtrosEspecificosStrings.length; i++){
						filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
					}

					DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
					listafiltrosEspecificos.setModel( model );
					listafiltrosEspecificos.setVisible(true);
				}
				else if (listafiltrosGenerales.getSelectedIndex()==3) {
					textFieldFiltroNumero.setVisible(false);
					ArrayList<String> filtrosEspecificos = new ArrayList<String>();
					filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(3));
					String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
					for (int i = 0; i < filtrosEspecificosStrings.length; i++){
						filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
					}

					DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
					listafiltrosEspecificos.setModel( model );
					listafiltrosEspecificos.setVisible(true);
				}
				else if (listafiltrosGenerales.getSelectedIndex()==4) {
					listafiltrosEspecificos.setVisible(false);
					textFieldFiltroNumero.setVisible(true);
				}
				else if (listafiltrosGenerales.getSelectedIndex()==5) {
					listafiltrosEspecificos.setVisible(false);
					textFieldFiltroNumero.setVisible(true);
				}
			}
		});



		//TODO: POR SI SE QUIERE ELEGIR CANTIDAD DE PELICULAS A OBSERVAR.
//		JLabel lblPwd = new JLabel("Puntuacion");
//		lblPwd.setBounds(46, 220, 101, 37);
//		contentPane.add(lblPwd);
//
//
//		textField = new JTextField();
//		textField.setBounds(46, 270, 146, 26);
//		contentPane.add(textField);
//		textField.setColumns(10);

		JButton btnPeliculas = new JButton("Ver listado de peliculas filtradas");
		btnPeliculas.setBounds(46, 270, 175, 29);
		contentPane.add(btnPeliculas);

		btnPeliculas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (FILTRADOS.JAVA).
				//TODO: Aquí hay que configurar diferentes casos de filtros; porque el de "matcheo perfecto" no valdrá solamente.
				//TODO: Se puede mirar el index de la lista general para redirigir unos casos u otros.
				if (listafiltrosGenerales.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(ventana,"Selecciona una opción, por favor!","ERR-A01 - Selección errónea de filtro",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						PeliculaList peliculaList = null;
						if (listafiltrosGenerales.getSelectedIndex() == 1 || listafiltrosGenerales.getSelectedIndex() == 2 || listafiltrosGenerales.getSelectedIndex() == 3) {
							peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((String) (listafiltrosEspecificos.getSelectedItem()), (String) listafiltrosGenerales.getSelectedItem());
						} else if (listafiltrosGenerales.getSelectedIndex() == 4) {
							Double.parseDouble(textFieldFiltroNumero.getText());
							peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((textFieldFiltroNumero.getText()), (String) listafiltrosGenerales.getSelectedItem());
						}
						else if (listafiltrosGenerales.getSelectedIndex() == 5) {
							Integer.parseInt(textFieldFiltroNumero.getText());
							peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((textFieldFiltroNumero.getText()), (String) listafiltrosGenerales.getSelectedItem());
						}
						for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
							System.out.println(aux.toString());
						}
						Menu m = new Menu(aux);
						m.setVisible(true);
						dispose();
					}
					catch (NumberFormatException e1){
						JOptionPane.showMessageDialog(ventana, "¡No has insertado un valor numérico correcto!", "ERR-A02 - Inserción errónea de valor numérico", JOptionPane.ERROR_MESSAGE);
					}
				}
//            	Filtrados filtrados = new Filtrados(aux);
//            	filtrados.setVisible(true);
//            	dispose();
			}
		});
	}
}
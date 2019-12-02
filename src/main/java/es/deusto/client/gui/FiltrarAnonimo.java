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

public class FiltrarAnonimo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldFiltroNumero;
    private JComboBox listafiltrosGenerales;
    private JComboBox listafiltrosEspecificos;
    private JFrame ventana;

    public FiltrarAnonimo()
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

        ArrayList<String> filtrosGenerales = new ArrayList<String>();
        filtrosGenerales.add("Opciones:"); // CODE: 0
        filtrosGenerales.add("Género"); // CODE: 1
        filtrosGenerales.add("Sección del Festival"); //CODE: 2
        filtrosGenerales.add("Año"); //CODE: 3
        filtrosGenerales.add("Valoración"); //CODE: 4
        filtrosGenerales.add("Duración"); //CODE: 5
        filtrosGenerales.add("Director"); //CODE: 6
        filtrosGenerales.add("Actor"); //CODE: 7
        filtrosGenerales.add("Premio"); //CODE: 8
        filtrosGenerales.add("Película"); //CODE: 9
        String[] filtrosGeneralesStrings = new String [filtrosGenerales.size()];
        for (int i = 0; i < filtrosGeneralesStrings.length; i++){
            filtrosGeneralesStrings[i] = filtrosGenerales.get(i);
        }

        //Filtros Específicos.
        listafiltrosEspecificos = new JComboBox();
        listafiltrosEspecificos.setBounds(46, 220, 146, 26);
        contentPane.add(listafiltrosEspecificos);
        listafiltrosEspecificos.setVisible(false);

        textFieldFiltroNumero = new JTextField();
        textFieldFiltroNumero.setBounds(46, 220, 146, 26);
        contentPane.add(textFieldFiltroNumero);
        textFieldFiltroNumero.setVisible(false);

        listafiltrosGenerales = new JComboBox(filtrosGeneralesStrings);
        listafiltrosGenerales.setBounds(46, 172, 146, 26);
        contentPane.add(listafiltrosGenerales);
        listafiltrosGenerales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                }
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
                else if (listafiltrosGenerales.getSelectedIndex()==6) {
                    textFieldFiltroNumero.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(6));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    listafiltrosEspecificos.setModel( model );
                    listafiltrosEspecificos.setVisible(true);
                }
                else if (listafiltrosGenerales.getSelectedIndex()==7) {
                    listafiltrosEspecificos.setVisible(false);
                    textFieldFiltroNumero.setVisible(true);
                }
                else if (listafiltrosGenerales.getSelectedIndex()==8) {
                    textFieldFiltroNumero.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(8));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    listafiltrosEspecificos.setModel( model );
                    listafiltrosEspecificos.setVisible(true);
                }
                else if (listafiltrosGenerales.getSelectedIndex()==9) {
                    textFieldFiltroNumero.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(9));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    listafiltrosEspecificos.setModel( model );
                    listafiltrosEspecificos.setVisible(true);
                }
            }
        });



        //TODO (EXTRA): POR SI SE QUIERE ELEGIR CANTIDAD DE PELICULAS A OBSERVAR, SE PODRÍA AÑADIR ALGÚN NÚMERO QUE HAGA DE UMBRAL.

        JButton btnPeliculas = new JButton("Ver listado de peliculas filtradas");
        btnPeliculas.setBounds(46, 270, 175, 29);
        contentPane.add(btnPeliculas);

        btnPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (FILTRADOS.JAVA).
                if (listafiltrosGenerales.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(ventana,"Selecciona una opción, por favor!","ERR-A01 - Selección errónea de filtro",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        PeliculaList peliculaList = null;
                        if (listafiltrosGenerales.getSelectedIndex() == 1 || listafiltrosGenerales.getSelectedIndex() == 2 || listafiltrosGenerales.getSelectedIndex() == 3 || listafiltrosGenerales.getSelectedIndex() == 6 || listafiltrosGenerales.getSelectedIndex() == 8 || listafiltrosGenerales.getSelectedIndex() == 9) {
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((String) (listafiltrosEspecificos.getSelectedItem()), (String) listafiltrosGenerales.getSelectedItem());
                        }
                        else if (listafiltrosGenerales.getSelectedIndex() == 4) {
                            Double.parseDouble(textFieldFiltroNumero.getText());
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((textFieldFiltroNumero.getText()), (String) listafiltrosGenerales.getSelectedItem());
                        }
                        else if (listafiltrosGenerales.getSelectedIndex() == 5) {
                            Integer.parseInt(textFieldFiltroNumero.getText());
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((textFieldFiltroNumero.getText()), (String) listafiltrosGenerales.getSelectedItem());
                        }
                        else if ( listafiltrosGenerales.getSelectedIndex() == 7) {
                            String actorInput = textFieldFiltroNumero.getText();
                            if (actorInput.length()==0){
                                throw new NullPointerException();
                            }
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((textFieldFiltroNumero.getText()), (String) listafiltrosGenerales.getSelectedItem());
                        }
                        for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
                            System.out.println(aux.toString());
                        }
                        MenuAnonimo m = new MenuAnonimo();
                        m.setVisible(true);
                        dispose();
                    }
                    catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(ventana, "¡No has insertado un valor numérico correcto!", "ERR-A02 - Inserción errónea de valor numérico", JOptionPane.ERROR_MESSAGE);
                    }
                    catch (NullPointerException e1){
                        JOptionPane.showMessageDialog(ventana, "¡Has dejado en blanco el campo de búsqueda del actor!", "ERR-A03 - Inserción errónea de nombre o apellido de actor", JOptionPane.ERROR_MESSAGE);
                    }
                }
//            	Filtrados filtrados = new Filtrados(aux);
//            	filtrados.setVisible(true);
//            	dispose();
            }
        });
    }
}
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
    private JTextField textField;
    private JTextField textField2;
    private JComboBox listafiltros;
    private boolean flag = false;
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
        setTitle("Proceso de LogIn");

        JLabel lblFiltrar = new JLabel("Filtra las peliculas");
        lblFiltrar.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        lblFiltrar.setBounds(40, 40, 350, 73);
        contentPane.add(lblFiltrar);

        JLabel lblCategoria = new JLabel("Categoria");
        lblCategoria.setBounds(46, 123, 101, 37);
        contentPane.add(lblCategoria);

//        ArrayList<String> filtros = new ArrayList<String>();
//        filtros = FestivalCineController.getInstance().getFiltros();
//        String[] filtrosStrings = new String [filtros.size()];
//        for (int i = 0; i < filtrosStrings.length; i++){
//            filtrosStrings[i] = filtros.get(i);
//        }
//
//        //Create the combo box, select item at index 4.
//        //Indices start at 0, so 4 specifies the pig.
//        listafiltros = new JComboBox(filtrosStrings);
//        listafiltros.setBounds(46, 172, 146, 26);
//        contentPane.add(listafiltros);
//        //listafiltros.setSelectedIndex(4);
//        //listafiltros.addActionListener(this);

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
        btnPeliculas.setBounds(46, 220, 175, 29);
        contentPane.add(btnPeliculas);

        btnPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (FILTRADOS.JAVA).
//                PeliculaList peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((String)(listafiltros.getSelectedItem()));
//                for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
//                    System.out.println(aux.toString());
//                }
//                MenuAnonimo m = new MenuAnonimo();
//                m.setVisible(true);
//                dispose();
//            	Filtrados filtrados = new Filtrados(aux);
//            	filtrados.setVisible(true);
//            	dispose();
            }
        });
    }
}
package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.ActorList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class MenuAnonimo extends JFrame {

    static Logger logger = Logger.getLogger(MenuAnonimo.class.getName());
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public MenuAnonimo() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Festival de Cine");

        JLabel label = new JLabel("Festival de Cine");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        label.setBounds(40, 30, 287, 37);
        contentPane.add(label);

        JButton btnActores = new JButton("Ver Listado de Actores");
        btnActores.setBounds(150, 130, 175, 29);
        contentPane.add(btnActores);

        btnActores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (ACTORES.JAVA)
                ActorList actorList = FestivalCineController.getInstance().getActorList();
                for (ActorDTO aux : actorList.getActorsDTO()) {
                    logger.info(aux.toString());
                }
//            	Actores actores = new Actores(aux);
//            	actores.setVisible(true);
//            	dispose();
            }
        });

        JButton btnPeliculas = new JButton("Ver Listado de PelÍculas");
        btnPeliculas.setBounds(150, 180, 175, 29);
        contentPane.add(btnPeliculas);

        btnPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (INFORME.JAVA).
                PeliculaList peliculaList = FestivalCineController.getInstance().getPeliculaList();
                for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
                    System.out.println(aux.toString());
                }
//            	Informe informe = new Informe(aux);
//            	informe.setVisible(true);
//            	dispose();
            }
        });

//        JButton btnValorar = new JButton("Valorar pelicula");
//        btnValorar.setBounds(150, 230, 175, 29);
//        contentPane.add(btnValorar);
//
//        btnValorar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (VALORAR.JAVA).
//                PeliculaList peliculaList = FestivalCineController.getInstance().getPeliculaList();
//                for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
//                    System.out.println(aux.toString());
//                }
//                Valorar valorar = new Valorar(aux);
//                valorar.setVisible(true);
//                dispose();
//            }
//        });

        JButton btnFiltrar = new JButton("Filtrar Peliíula");
        btnFiltrar.setBounds(150, 280, 175, 29);
        contentPane.add(btnFiltrar);

        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltrarAnonimo filtrar = new FiltrarAnonimo();
                filtrar.setVisible(true);
                dispose();
            }
        });

        JButton btnInicio = new JButton("Login");
        btnInicio.setBounds(450, 50, 175, 29);
        contentPane.add(btnInicio);

        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio frame = new Inicio();
                frame.setVisible(true);
                dispose();
            }
        });
    }
}

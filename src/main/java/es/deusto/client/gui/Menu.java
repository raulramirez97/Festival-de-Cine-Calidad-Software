package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Menu(UsuarioDTO aux) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Reserva de vuelos");
		
		JLabel label = new JLabel("Bienvenido, " + aux.getLogin().toUpperCase());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		label.setBounds(40, 30, 287, 37);
		contentPane.add(label);
		
		JButton btnActores = new JButton("Ver listado de actores");
		btnActores.setBounds(150, 130, 175, 29);
		contentPane.add(btnActores);
		
		btnActores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI.
				ActorList actorList = FestivalCineController.getInstance().getActorList();
				for (ActorDTO aux : actorList.getActorsDTO()) {
					System.out.println(aux.toString());
				}
//            	Vuelos vuelos = new Vuelos(aux);
//            	vuelos.setVisible(true);
//            	dispose();
            }
        });

		JButton btnPeliculas = new JButton("Ver listado de peliculas");
		btnPeliculas.setBounds(150, 180, 175, 29);
		contentPane.add(btnPeliculas);

		btnPeliculas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI.
				PeliculaList peliculaList = FestivalCineController.getInstance().getPeliculaList();
				for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
					System.out.println(aux.toString());
				}
//            	Vuelos vuelos = new Vuelos(aux);
//            	vuelos.setVisible(true);
//            	dispose();
			}
		});
	}
}

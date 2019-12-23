package es.deusto.client.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame ventana;
	
	public Inicio() 
	{
		ventana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Menú Principal - Festival de Cine");

		
		JLabel lblFestivalCine = new JLabel("Bienvenido al Festival de Cine");
		lblFestivalCine.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblFestivalCine.setBounds(58, 50, 418, 81);
		contentPane.add(lblFestivalCine);
		
		JButton btnDarseDeAlta = new JButton("Darse de alta");
		btnDarseDeAlta.setBounds(175, 186, 191, 46);
		contentPane.add(btnDarseDeAlta);
		btnDarseDeAlta.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Alta f = new Alta();
				f.setVisible(true);
				dispose();
		    }
		});
		
		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setBounds(175, 248, 191, 46);
		contentPane.add(btnIniciarSesion);
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	Login f1 = new Login();
				f1.setVisible(true);
				dispose();
		    }
		});
		JButton btnNoUsuario = new JButton("Seguir sin usuario");
		btnNoUsuario.setBounds(175, 300, 191, 46);
		contentPane.add(btnNoUsuario);
		btnNoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MenuAnonimo frame = new MenuAnonimo();
				frame.setVisible(true);
				dispose();
			}
		});
	}
}

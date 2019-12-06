package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Valorar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private boolean flag = false;
	private JFrame ventana;

	public Valorar(UsuarioDTO aux)
	{
		ventana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Valoración de Película");
		
		JLabel lblFacebookgoogle = new JLabel("Valora la película:");
		lblFacebookgoogle.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFacebookgoogle.setBounds(40, 40, 350, 73);
		contentPane.add(lblFacebookgoogle);
		
		JLabel lblUsuario = new JLabel("Nombre de pelicula:");
		lblUsuario.setBounds(46, 123, 101, 37);
		contentPane.add(lblUsuario);
		
		
		textField = new JTextField();
		textField.setBounds(46, 172, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPwd = new JLabel("Puntuación:");
		lblPwd.setBounds(46, 220, 101, 37);
		contentPane.add(lblPwd);


		textField2 = new JTextField();
		textField2.setBounds(46, 270, 146, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnValoracion = new JButton("Valorar");
		btnValoracion.setBounds(132, 232, 155, 29);
		contentPane.add(btnValoracion);
		btnValoracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				try {
					FestivalCineController.getInstance().valorarPelicula(textField.getText(),
							Float.parseFloat(textField2.getText()));
					System.out.println("La pelicula se ha valorado correctamente.");
					JOptionPane.showConfirmDialog(ventana, "La pelicula se ha valorado correctamente.",
							"CONF-A01 - Confirmación de película valorada",JOptionPane.DEFAULT_OPTION);
					Menu m = new Menu(aux);
					m.setVisible(true);
					dispose();
				}
				catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(ventana, "Inserte un valor numérico en el campo " +
							"de la puntuacion, por favor.");
				}
				//TODO: NO LLEGA AQUI LA EXCEPCION CON LAS PETICIONES REST...
				catch (NullPointerException exc) {
					JOptionPane.showMessageDialog(ventana, "La pelicula que se ha querido valorar no está" +
							" entre las peliculas disponibles.");
				}
			}
        });
	}
}
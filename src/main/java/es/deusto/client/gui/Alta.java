package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JFrame alta;
	
	UsuarioDTO myUser=null;

	public Alta() 
	{
		alta = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Proceso de Alta");
		
		JLabel lblAlta = new JLabel("Alta de Usuario");
		lblAlta.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblAlta.setBounds(166, 70, 280, 72);
		contentPane.add(lblAlta);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(75, 121, 101, 37);
		contentPane.add(lblUsuario);

		textField = new JTextField();
		textField.setBounds(75, 150, 346, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(75, 188, 101, 37);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(75, 228, 346, 26);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnRegistrarseGoogle = new JButton("Registrarse");
		btnRegistrarseGoogle.setBounds(85, 271, 175, 29);
		contentPane.add(btnRegistrarseGoogle);
		btnRegistrarseGoogle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				FestivalCineController.getInstance().registerUser(textField.getText(), passwordField.getText());
				myUser = new UsuarioDTO(textField.getText(),passwordField.getText());
				Menu m = new Menu(myUser);
	            m.setVisible(true);
	            dispose();
            }
        });
		
		JLabel lblFestivalDeCine = new JLabel("Festival de Cine");
		lblFestivalDeCine.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFestivalDeCine.setBounds(156, 11, 280, 72);
		contentPane.add(lblFestivalDeCine);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(285, 274, 136, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Inicio i = new Inicio();
				i.setVisible(true);
				dispose();
		    }
		});
		
		
	}
}

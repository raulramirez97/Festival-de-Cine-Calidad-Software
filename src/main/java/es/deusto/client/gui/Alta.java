package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Alta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
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
		lblAlta.setBounds(40, 40, 280, 72);
		contentPane.add(lblAlta);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(46, 173, 101, 37);
		contentPane.add(lblUsuario);

		textField = new JTextField();
		textField.setBounds(46, 202, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(46, 240, 101, 37);
		contentPane.add(lblPassword);

		textField2 = new JTextField();
		textField2.setBounds(46, 280, 146, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnRegistrarseGoogle = new JButton("Registrarse");
		btnRegistrarseGoogle.setBounds(230, 214, 175, 29);
		contentPane.add(btnRegistrarseGoogle);
		btnRegistrarseGoogle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				FestivalCineController.getInstance().registerUser(textField.getText(), textField2.getText());
				myUser = new UsuarioDTO(textField.getText(),textField2.getText());
				Menu m = new Menu(myUser);
	            m.setVisible(true);
	            dispose();
            }
        });
	}
}

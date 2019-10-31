package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private boolean flag = false;
	private JFrame ventana;
	
	//private List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();
	
	public Login() 
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
		
		JLabel lblFacebookgoogle = new JLabel("Introduce tus credenciales");
		lblFacebookgoogle.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFacebookgoogle.setBounds(40, 40, 350, 73);
		contentPane.add(lblFacebookgoogle);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(46, 123, 101, 37);
		contentPane.add(lblUsuario);
		
		
		textField = new JTextField();
		textField.setBounds(46, 172, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPwd = new JLabel("Contrasena");
		lblPwd.setBounds(46, 220, 101, 37);
		contentPane.add(lblPwd);


		textField2 = new JTextField();
		textField2.setBounds(46, 270, 146, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Entrar");
		btnRegistrarse.setBounds(132, 232, 155, 29);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	try
				{
					flag = comprobarUsuario(FestivalCineController.getInstance().getUser(textField.getText(),textField2.getText()),textField.getText(),textField2.getText());
					if (!flag)
					{
						JOptionPane.showMessageDialog(ventana, "No hay usuarios que concuerden con esas credenciales. Intentelo otra vez.");
					}
				}
            	catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(ventana, "No hay usuarios que concuerden con esas credenciales. Intentelo otra vez.");
				}

            }
        });
	}
	//TODO: SI ESO MOVER ESTO FUERA DE GUI, A LOGICA DE NEGOCIO.
	private boolean comprobarUsuario(UsuarioDTO usu, String login, String pwd)
	{
		if ((usu == null))
		{
			return false;
		}
		else if ((usu.getLogin().compareTo(login)==0) && (usu.getPassword().compareTo(pwd)==0))
		{
			Menu m = new Menu(usu);
			m.setVisible(true);
			dispose();
			return true;
		}
		else {
			return false;
		}
	}
}
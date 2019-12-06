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
		lblFacebookgoogle.setBounds(40, 69, 350, 73);
		contentPane.add(lblFacebookgoogle);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(50, 134, 101, 37);
		contentPane.add(lblUsuario);
		
		
		textField = new JTextField();
		textField.setBounds(50, 170, 340, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPwd = new JLabel("Contraseña");
		lblPwd.setBounds(50, 196, 101, 37);
		contentPane.add(lblPwd);


		textField2 = new JTextField();
		textField2.setBounds(48, 232, 342, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Entrar");
		btnRegistrarse.setBounds(58, 269, 155, 29);
		contentPane.add(btnRegistrarse);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(254, 272, 136, 23);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Inicio i = new Inicio();
				i.setVisible(true);
				dispose();
		    }
		});
		
		
		JLabel lblFestivalDeCine = new JLabel("Festival de Cine");
		lblFestivalDeCine.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFestivalDeCine.setBounds(108, 0, 214, 73);
		contentPane.add(lblFestivalDeCine);
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
			menuTest m = new menuTest(usu);
			m.setVisible(true);
			dispose();
			return true;
		}
		else {
			return false;
		}
	}
}
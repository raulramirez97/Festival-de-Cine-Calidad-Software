package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class Login extends JFrame {

	static Logger logger = Logger.getLogger(Login.class.getName());
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private boolean flag = false;
	private JFrame ventana;
	
	public Login() 
	{
		ventana = this;
		String myPath = System.getProperty("user.dir");
		this.setIconImage(new ImageIcon(myPath+"/src/main/resources/img/filmicon.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Proceso de Login");
		
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

		passwordField = new JPasswordField();
		passwordField.setBounds(50, 232, 342, 26);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
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
					UsuarioDTO user = FestivalCineController.getInstance().getUser(textField.getText(),
							passwordField.getText());
					logger.info("Nombre de usuario encontrado: " + user.getLogin());
					logger.info("Contrasena de usuario encontrado: " + user.getPassword());
					flag = comprobarUsuario(user,textField.getText(),passwordField.getText());
					if (!flag)
					{
						JOptionPane.showMessageDialog(ventana, "No hay usuarios que concuerden con esas" +
								" credenciales. Intentelo otra vez.");
					}
				}
            	catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(ventana, "No hay usuarios que concuerden con esas " +
							"credenciales. Intentelo otra vez.");
				}

            }
        });
	}
	private boolean comprobarUsuario(UsuarioDTO usu, String login, String pwd)
	{
		if ((usu == null))
		{
			logger.info("El usuario se detecta como nulo.");
			return false;
		}
		else if ((usu.getLogin().compareTo(login)==0) && (usu.getPassword().compareTo(pwd)==0))
		{
			logger.info("Paso 1.");
			Menu m = new Menu(usu);
			logger.info("Paso 2.");
			m.setVisible(true);
			logger.info("Paso 3.");
			dispose();
			logger.info("Paso 4.");
			return true;
		}
		else {
			logger.info("Las credenciales no coinciden.");
			return false;
		}
	}
}
package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.UsuarioDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Implementación de la ventana para que un Usuario pueda comentar
 * sobre una Película.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */
public class ComentarPelicula extends JFrame {

    static Logger logger = Logger.getLogger(ComentarPelicula.class.getName());

    public ComentarPelicula(UsuarioDTO aux, PeliculaDTO pelicula) {
        initComponents(aux, pelicula);
    }

    private void initComponents(UsuarioDTO aux, PeliculaDTO pelicula) {
        ventana = this;
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath
                +"/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //======== this ========
        setTitle("Comentar Pelicula: "+pelicula.getTitulo());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Festival de Cine");
        label1.setFont(label1.getFont().deriveFont(label1.getFont()
                .getSize() + 12f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(390, 45, 200, 50);

        //---- label2 ----
        label2.setText("Comentario - "+pelicula.getTitulo());
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(label2.getFont()
                .getSize() + 10f));
        contentPane.add(label2);
        label2.setBounds(235, 145, 510, 65);

        //---- label3 ----
        label3.setText("Tu comentario:");
        contentPane.add(label3);
        label3.setBounds(100, 240, 215, 20);
        contentPane.add(textField1);
        textField1.setBounds(100, 290, 815, 185);

        //---- button1 ----
        button1.setText("Comentar");
        contentPane.add(button1);
        button1.setBounds(270, 525, 165, 65);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FestivalCineController.getInstance().comentarPelicula(
                            pelicula.getTitulo(), aux.getLogin(),
                            textField1.getText());
                    logger.info("La pelicula se ha comentado"
                            + " correctamente");
                    InformePelicula m = new InformePelicula (pelicula,aux);
                    m.setVisible(true);
                    dispose();
                }
                //NO LLEGA AQUI LA EXCEPCION CON LAS PETICIONES REST...
                catch (NullPointerException exc) {
                    JOptionPane.showMessageDialog(ventana,
                            "La pelicula que se ha querido"
                                    + " comentar no está " +
                            "entre las peliculas disponibles.");
                }
            }
        });

        //---- button2 ----
        button2.setText("Volver");
        contentPane.add(button2);
        button2.setBounds(550, 525, 165, 65);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformePelicula m = new InformePelicula (pelicula,aux);
                m.setVisible(true);
                dispose();
            }
        });

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x
                        + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y
                        + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        Rectangle r = ventana.getBounds();
        r.grow(45,45);
        ventana.setBounds(r);
    }

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JFrame ventana;
}

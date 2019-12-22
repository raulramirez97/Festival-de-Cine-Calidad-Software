/*
 * Created by JFormDesigner on Fri Dec 06 15:27:37 CET 2019
 */

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
 * @author Beñat
 */
public class ComentarPeliculaTest extends JFrame {

    static Logger logger = Logger.getLogger(ComentarPeliculaTest.class.getName());

    public ComentarPeliculaTest(UsuarioDTO aux, PeliculaDTO pelicula) {
        initComponents(aux, pelicula);
    }

    private void initComponents(UsuarioDTO aux, PeliculaDTO pelicula) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Beñat
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Comentar Pelicula: <NOMBRE_PELICULA>");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Festival de Cine");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(390, 45, 200, 50);

        //---- label2 ----
        label2.setText("Comentario - <NOMBRE_PELICULA>");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));
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

        //---- button2 ----
        button2.setText("Volver");
        contentPane.add(button2);
        button2.setBounds(550, 525, 165, 65);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Beñat
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

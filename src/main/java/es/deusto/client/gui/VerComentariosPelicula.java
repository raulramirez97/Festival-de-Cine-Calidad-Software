/*
 * Created by JFormDesigner on Fri Dec 06 15:21:40 CET 2019
 */

package es.deusto.client.gui;

import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.UsuarioDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * @author Beñat
 */
public class VerComentariosPelicula extends JFrame {
    public VerComentariosPelicula(UsuarioDTO usuario, PeliculaDTO pelicula) {
        initComponents(usuario, pelicula);
    }

    private void initComponents(UsuarioDTO usuario, PeliculaDTO pelicula) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Beñat
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label4 = new JLabel();
        label5 = new JLabel();
        textArea2 = new JTextArea();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        textArea3 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath+"/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //======== this ========
        setTitle("Comentarios: "+pelicula.getTitulo());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Comentarios: "+pelicula.getTitulo());
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(200, 70, 610, 75);

        if (pelicula.getComentarios() == null) {
            //---- label8 ----
            label8.setText("Esta pel\u00edcula no tiene comentarios registrados.");
            contentPane.add(label8);
            label8.setBounds(345, 305, 300, 25);
        }
        else {
            int tam = pelicula.getComentarios().size();
            if (tam > 0) {
                //---- label2 ----
                label2.setText(pelicula.getComentarios().get(0).getUsuario());
                contentPane.add(label2);
                label2.setBounds(90, 185, 145, 20);

                //---- label3 ----
                label3.setText((new Date(pelicula.getComentarios().get(0).getTimestamp())).toString());
                contentPane.add(label3);
                label3.setBounds(270, 185, 195, 20);

                //======== scrollPane1 ========
                {
                    //---- textArea1 ----
                    textArea1.setText(pelicula.getComentarios().get(0).getContenido());
                    scrollPane1.setViewportView(textArea1);
                    textArea1.setEditable(false);
                }
                contentPane.add(scrollPane1);
                scrollPane1.setBounds(90, 225, 815, 60);

                if (tam > 1) {
                    //---- label4 ----
                    label4.setText(pelicula.getComentarios().get(1).getUsuario());
                    contentPane.add(label4);
                    label4.setBounds(90, 325, 145, 20);

                    //---- label5 ----
                    label5.setText((new Date(pelicula.getComentarios().get(1).getTimestamp())).toString());
                    contentPane.add(label5);
                    label5.setBounds(270, 325, 195, 20);

                    //---- textArea2 ----
                    textArea2.setText(pelicula.getComentarios().get(1).getContenido());
                    contentPane.add(textArea2);
                    textArea2.setBounds(90, 365, 813, 58);
                    textArea2.setEditable(false);
                }

                if (tam > 2) {
                    //---- label6 ----
                    label6.setText(pelicula.getComentarios().get(2).getUsuario());
                    contentPane.add(label6);
                    label6.setBounds(90, 460, 145, 20);

                    //---- label7 ----
                    label7.setText((new Date(pelicula.getComentarios().get(2).getTimestamp())).toString());
                    contentPane.add(label7);
                    label7.setBounds(270, 460, 195, 20);

                    //---- textArea3 ----
                    textArea3.setText(pelicula.getComentarios().get(2).getContenido());
                    contentPane.add(textArea3);
                    textArea3.setBounds(90, 500, 813, 58);
                    textArea3.setEditable(false);

                }
            }
        }

        //---- button1 ----
        button1.setText("Comentar");
        contentPane.add(button1);
        button1.setBounds(235, 595, 205, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComentarPeliculaTest m = new ComentarPeliculaTest (usuario,pelicula);
                m.setVisible(true);
                dispose();
            }
        });

        //---- button2 ----
        button2.setText("Volver");
        contentPane.add(button2);
        button2.setBounds(575, 595, 205, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformePelicula m = new InformePelicula(pelicula,usuario);
                m.setVisible(true);
                dispose();
            }
        });

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
        Rectangle r = this.getBounds();
        r.grow(45,45);
        this.setBounds(r);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Beñat
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label4;
    private JLabel label5;
    private JTextArea textArea2;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextArea textArea3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
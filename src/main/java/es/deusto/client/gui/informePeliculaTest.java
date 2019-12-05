/*
 * Created by JFormDesigner on Thu Dec 05 09:53:02 CET 2019
 */

package es.deusto.client.gui;

import java.awt.*;
import javax.swing.*;

/**
 * @author Beñat
 */
public class informePeliculaTest extends JFrame {
    public informePeliculaTest() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Beñat
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        label14 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("Informe: <Nombre_Pelicula> - Usuario");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("<NOMBRE_PELICULA>");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(120, 85, 720, 40);

        //---- label2 ----
        label2.setText("A\u00f1o");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label2);
        label2.setBounds(105, 165, 75, 20);

        //---- label3 ----
        label3.setText("Duraci\u00f3n");
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label3);
        label3.setBounds(105, 205, 75, 20);

        //---- label4 ----
        label4.setText("G\u00e9nero");
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label4);
        label4.setBounds(105, 245, 75, 20);

        //---- label5 ----
        label5.setText("Reparto");
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label5);
        label5.setBounds(105, 285, 75, 20);

        //---- label6 ----
        label6.setText("Sinopsis");
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label6);
        label6.setBounds(105, 325, 75, 20);

        //---- label7 ----
        label7.setText("Premios");
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label7);
        label7.setBounds(105, 440, 75, 20);

        //---- label8 ----
        label8.setText("Valoraci\u00f3n");
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label8);
        label8.setBounds(105, 495, 75, 20);

        //---- label9 ----
        label9.setText("Tr\u00e1iler");
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label9);
        label9.setBounds(105, 535, 75, 20);

        //---- label10 ----
        label10.setText("<INSERTAR_A\u00d1O>");
        contentPane.add(label10);
        label10.setBounds(230, 170, 130, 15);

        //---- label11 ----
        label11.setText("<INSERTAR_DURACI\u00d3N>");
        contentPane.add(label11);
        label11.setBounds(230, 210, 140, 15);

        //---- label12 ----
        label12.setText("<INSERTAR_G\u00c9NERO>");
        contentPane.add(label12);
        label12.setBounds(230, 250, 225, 15);

        //---- label13 ----
        label13.setText("<INSERTAR_REPARTO>");
        contentPane.add(label13);
        label13.setBounds(230, 290, 265, 15);

        //---- label16 ----
        label16.setText("<INSERTAR_VALORACION>");
        contentPane.add(label16);
        label16.setBounds(230, 500, 265, 15);

        //---- label17 ----
        label17.setText("<INSERTAR_TRAILER>");
        contentPane.add(label17);
        label17.setBounds(230, 540, 265, 15);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setText("<INSERTAR_SINOPSIS>");
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(230, 330, 270, 90);

        //---- textArea2 ----
        textArea2.setText("<INSERTAR_PREMIOS>");
        contentPane.add(textArea2);
        textArea2.setBounds(230, 440, 270, 45);

        //---- label14 ----
        label14.setText("<INSERTAR_IMAGEN_PELICULA>");
        label14.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label14);
        label14.setBounds(580, 165, 270, 160);

        //---- button1 ----
        button1.setText("Mira los Comentarios");
        contentPane.add(button1);
        button1.setBounds(90, 605, 190, 40);

        //---- button2 ----
        button2.setText("\u00a1Comenta!");
        contentPane.add(button2);
        button2.setBounds(390, 605, 190, 40);

        //---- button3 ----
        button3.setText("Vuelve al Men\u00fa Principal");
        contentPane.add(button3);
        button3.setBounds(680, 605, 190, 40);

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
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label16;
    private JLabel label17;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel label14;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

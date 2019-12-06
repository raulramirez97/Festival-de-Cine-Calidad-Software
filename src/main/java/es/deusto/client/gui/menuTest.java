/*
 * Created by JFormDesigner on Thu Dec 05 09:35:06 CET 2019
 */

package es.deusto.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.UsuarioDTO;

/**
 * @author unknown
 */
public class menuTest extends JFrame {
    public menuTest(UsuarioDTO aux) {
    	PeliculaList peliculaList = FestivalCineController.getInstance().getPeliculaList();
        initComponents(peliculaList,aux);
        
        
    }

    private void initComponents(PeliculaList peliculaList,UsuarioDTO aux) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Beñat
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        comboBox1 = new JComboBox();
        label10 = new JLabel();
        label11 = new JLabel();
        
        //======== this ========
        setTitle("Men\u00fa Principal - "+aux.getLogin());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Salir");
        contentPane.add(button1);
        button1.setBounds(750, 145, 160, 30);
        button1.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				menuAnonimoTest m = new menuAnonimoTest();
 				m.setVisible(true);
 				dispose();
 			}
 		});

        //---- label1 ----
        label1.setText("Festival Cine");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
        contentPane.add(label1);
        label1.setBounds(355, 95, 170, 30);

        //---- label2 ----
        label2.setText("<INSERTAR_IMAGEN_1>");
        contentPane.add(label2);
        label2.setBounds(220, 215, 130, 90);

        //---- label3 ----
        label3.setText("<INSERTAR_IMAGEN_2>");
        contentPane.add(label3);
        label3.setBounds(500, 215, 130, 90);

        //---- label4 ----
        label4.setText("<INSERTAR_IMAGEN_3>");
        contentPane.add(label4);
        label4.setBounds(215, 425, 130, 90);

        //---- label5 ----
        label5.setText("<INSERTAR_IMAGEN_4>");
        contentPane.add(label5);
        label5.setBounds(500, 425, 130, 90);

        //---- label6 ----
        label6.setText(peliculaList.getPeliculasDTO().get(0).getSinopsis());
        contentPane.add(label6);
        label6.setBounds(225, 320, 125, 20);

        //---- label7 ----
        //label7.setText(peliculaList.getPeliculasDTO().get(3).getSinopsis());
        contentPane.add(label7);
        label7.setBounds(225, 535, 125, 20);

        //---- label8 ----
        label8.setText(peliculaList.getPeliculasDTO().get(2).getSinopsis());
        contentPane.add(label8);
        label8.setBounds(510, 540, 125, 20);

        //---- label9 ----
        label9.setText(peliculaList.getPeliculasDTO().get(1).getSinopsis());
        contentPane.add(label9);
        label9.setBounds(505, 320, 125, 20);

        //---- button2 ----
        button2.setText("+ Info");
        contentPane.add(button2);
        button2.setBounds(220, 375, 110, 30);
        button2.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				informePeliculaTest i = new informePeliculaTest(peliculaList.getPeliculasDTO().get(0), aux);
 				i.setVisible(true);
 				dispose();
 			}
 		});
        

        //---- button3 ----
        button3.setText("+ Info");
        contentPane.add(button3);
        button3.setBounds(510, 375, 110, 30);
        button3.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				informePeliculaTest i = new informePeliculaTest(peliculaList.getPeliculasDTO().get(1), aux);
 				i.setVisible(true);
 				dispose();
 			}
 		});
        

        //---- button4 ----
        button4.setText("+ Info");
        contentPane.add(button4);
        button4.setBounds(220, 580, 110, 30);
        button4.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				informePeliculaTest i = new informePeliculaTest(peliculaList.getPeliculasDTO().get(2), aux);
 				i.setVisible(true);
 				dispose();
 			}
 		});
        

        //---- button5 ----
        button5.setText("+ Info");
        contentPane.add(button5);
        button5.setBounds(510, 580, 110, 30);
        button5.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				informePeliculaTest i = new informePeliculaTest(peliculaList.getPeliculasDTO().get(3), aux);
 				i.setVisible(true);
 				dispose();
 			}
 		});
        

        //---- button6 ----
        button6.setText("Buscar");
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(830, 200), button6.getPreferredSize()));
        contentPane.add(comboBox1);
        button6.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				Filtrar f = new Filtrar(aux);
 				f.setVisible(true);
 				dispose();
 			}
 		});
        
        comboBox1.setBounds(700, 200, 110, comboBox1.getPreferredSize().height);
        
        //---- label10 ----
        label10.setText(aux.getLogin());
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label10);
        label10.setBounds(750, 110, 155, 20);

        //---- label11 ----
        label11.setText("<ICONO_USUARIO>");
        label11.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label11);
        label11.setBounds(770, 50, 120, 55);

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
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JComboBox comboBox1;
    private JLabel label10;
    private JLabel label11;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

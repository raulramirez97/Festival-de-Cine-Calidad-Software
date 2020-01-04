/*
 * Created by JFormDesigner on Thu Dec 05 09:53:02 CET 2019
 */

package es.deusto.client.gui;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Logger;

/**
 * @author Beñat
 */
public class CreacionActor extends JFrame {

    static Logger logger = Logger.getLogger(CreacionActor.class.getName());

    public CreacionActor(UsuarioDTO aux) {
        initComponents(aux);
    }

    private void initComponents(UsuarioDTO aux) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Beñat
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        label8 = new JLabel();
        textFieldIDActor = new JTextField();
        textFieldNomActor = new JTextField();
        textFieldApeActor = new JTextField();
        textFieldEdadActor = new JTextField();

        ventana = this;

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath+"/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //======== this ========
        setTitle("Creación de nuevo actor");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Inserta a continuaci\u00f3n los datos del nuevo actor");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(225, 55, 489, 35);

        //---- label8 ----
        label8.setText("ID");
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label8);
        label8.setBounds(105, 135, 75, 20);

        //---- label2 ----
        label2.setText("Nombre");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label2);
        label2.setBounds(105, 200, 75, 20);

        //---- label3 ----
        label3.setText("Apellido");
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label3);
        label3.setBounds(105, 275, 75, 20);

        //---- label4 ----
        label4.setText("Edad");
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label4);
        label4.setBounds(105, 345, 75, 20);

        contentPane.add(textFieldIDActor);
        textFieldIDActor.setBounds(225, 130, 275, textFieldNomActor.getPreferredSize().height);
        textFieldIDActor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldIDActor.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro de los actores, " +
                            "por favor.");
                }
            }
        });

        contentPane.add(textFieldNomActor);
        textFieldNomActor.setBounds(225, 195, 275, 30);
        textFieldNomActor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldNomActor.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro de los actores, " +
                            "por favor.");
                }
            }
        });

        contentPane.add(textFieldApeActor);
        textFieldApeActor.setBounds(225, 270, 275, 30);
        textFieldApeActor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldApeActor.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro de los actores," +
                            "por favor.");
                }
            }
        });

        contentPane.add(textFieldEdadActor);
        textFieldEdadActor.setBounds(225, 340, 275, 30);
        textFieldEdadActor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Integer.parseInt(textFieldEdadActor.getText());
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(ventana, "Inserte un valor numérico en el campo," +
                            " por favor.");
                }
            }
        });
        //---- button3 ----
        button3.setText("Vuelve al Men\u00fa Principal");
        contentPane.add(button3);
        button3.setBounds(570, 445, 190, 40);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu m = new Menu(aux);
                m.setVisible(true);
                dispose();
            }
        });

        //---- button4 ----
        button4.setText("Inserta el Actor");
        contentPane.add(button4);
        button4.setBounds(205, 445, 190, 40);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FestivalCineController.getInstance().registerActor(textFieldIDActor.getText(),
                            textFieldNomActor.getText(),textFieldApeActor.getText(),
                            Integer.parseInt(textFieldEdadActor.getText()));
                    logger.info("Actor generated successfully by the admin.");
                    Menu m = new Menu(aux);
                    m.setVisible(true);
                    dispose();
                }
                catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(ventana, "Inserte un valor numérico en el campo de edad" +
                            "numéricos, por favor.");
                }
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
        Rectangle r = ventana.getBounds();
        r.grow(45,45);
        ventana.setBounds(r);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Beñat
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button3;
    private JButton button4;
    private JLabel label8;
    private JTextField textFieldIDActor;
    private JTextField textFieldNomActor;
    private JTextField textFieldApeActor;
    private JTextField textFieldEdadActor;
    private JFrame ventana;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
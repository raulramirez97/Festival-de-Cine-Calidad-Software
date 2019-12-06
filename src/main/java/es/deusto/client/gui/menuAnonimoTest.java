/*
 * Created by JFormDesigner on Thu Dec 05 09:35:06 CET 2019
 */

package es.deusto.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.PeliculaList;

/**
 * @author unknown
 */
public class menuAnonimoTest extends JFrame {
    public menuAnonimoTest() {
    	PeliculaList peliculaList = FestivalCineController.getInstance().getPeliculaList();
        initComponents(peliculaList);
    }

    private void initComponents(PeliculaList peliculaList) {
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
        comboBox2 = new JComboBox();
        textField1 = new JTextField();

        ventana = this;

        //======== this ========
        setTitle("Men\u00fa Principal");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        int tam = peliculaList.getPeliculasDTO().size();

        //---- button1 ----
        button1.setText("Login");
        contentPane.add(button1);
        button1.setBounds(730, 115, 180, 30);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio i = new Inicio();
                i.setVisible(true);
                dispose();
            }
        });

        //---- label1 ----
        label1.setText("Festival Cine");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(290, 95, 275, 30);

        if (tam > 0 ) {
            //---- label2 ----
            label2.setText("<INSERTAR_IMAGEN_1>");
            contentPane.add(label2);
            label2.setBounds(220, 215, 130, 90);

            //---- label6 ----
            label6.setText(peliculaList.getPeliculasDTO().get(0).getTitulo());
            contentPane.add(label6);
            label6.setBounds(225, 320, 125, 20);

            //---- button2 ----
            button2.setText("+ Info");
            contentPane.add(button2);
            button2.setBounds(220, 375, 110, 30);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    informePeliculaAnonimoTest m = new informePeliculaAnonimoTest (peliculaList.getPeliculasDTO().get(0));
                    m.setVisible(true);
                    dispose();
                }
            });

            if (tam > 1) {
                //---- label3 ----
                label3.setText("<INSERTAR_IMAGEN_2>");
                contentPane.add(label3);
                label3.setBounds(500, 215, 130, 90);

                //---- label9 ----
                label9.setText(peliculaList.getPeliculasDTO().get(1).getTitulo());
                contentPane.add(label9);
                label9.setBounds(505, 320, 125, 20);

                //---- button3 ----
                button3.setText("+ Info");
                contentPane.add(button3);
                button3.setBounds(510, 375, 110, 30);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        informePeliculaAnonimoTest m = new informePeliculaAnonimoTest (peliculaList.getPeliculasDTO().get(1));
                        m.setVisible(true);
                        dispose();
                    }
                });

                if (tam > 2) {
                    //---- label4 ----
                    label4.setText("<INSERTAR_IMAGEN_3>");
                    contentPane.add(label4);
                    label4.setBounds(215, 425, 130, 90);

                    //---- label7 ----
                    label7.setText(peliculaList.getPeliculasDTO().get(2).getTitulo());
                    contentPane.add(label7);
                    label7.setBounds(225, 535, 125, 20);

                    //---- button4 ----
                    button4.setText("+ Info");
                    contentPane.add(button4);
                    button4.setBounds(220, 580, 110, 30);
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            informePeliculaAnonimoTest m = new informePeliculaAnonimoTest (peliculaList.getPeliculasDTO().get(2));
                            m.setVisible(true);
                            dispose();
                        }
                    });

                    if (tam > 3) {
                        //---- label5 ----
                        label5.setText("<INSERTAR_IMAGEN_4>");
                        contentPane.add(label5);
                        label5.setBounds(500, 425, 130, 90);

                        //---- label8 ----
                        label8.setText(peliculaList.getPeliculasDTO().get(3).getTitulo());
                        contentPane.add(label8);
                        label8.setBounds(510, 540, 125, 20);

                        //---- button5 ----
                        button5.setText("+ Info");
                        contentPane.add(button5);
                        button5.setBounds(510, 580, 110, 30);
                        button5.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                informePeliculaAnonimoTest m = new informePeliculaAnonimoTest (peliculaList.getPeliculasDTO().get(3));
                                m.setVisible(true);
                                dispose();
                            }
                        });
                    }
                }
            }
        }

        ArrayList<String> filtrosGenerales = new ArrayList<String>();
        filtrosGenerales.add("Opciones:"); // CODE: 0
        filtrosGenerales.add("Género"); // CODE: 1
        filtrosGenerales.add("Sección del Festival"); //CODE: 2
        filtrosGenerales.add("Año"); //CODE: 3
        filtrosGenerales.add("Valoración"); //CODE: 4
        filtrosGenerales.add("Duración"); //CODE: 5
        filtrosGenerales.add("Director"); //CODE: 6
        filtrosGenerales.add("Actor"); //CODE: 7
        filtrosGenerales.add("Premio"); //CODE: 8
        String[] filtrosGeneralesStrings = new String [filtrosGenerales.size()];
        for (int i = 0; i < filtrosGeneralesStrings.length; i++){
            filtrosGeneralesStrings[i] = filtrosGenerales.get(i);
        }

        contentPane.add(comboBox2);
        comboBox2.setBounds(760, 225, 110, 30);
        comboBox2.setVisible(false);

        contentPane.add(textField1);
        textField1.setBounds(715, 265, 210, 35);
        textField1.setVisible(false);

        comboBox1 = new JComboBox(filtrosGeneralesStrings);
        contentPane.add(comboBox1);
        comboBox1.setBounds(760, 185, 110, comboBox1.getPreferredSize().height);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedIndex()==0)
                {
                    comboBox2.setVisible(false);
                }
                else if (comboBox1.getSelectedIndex()==1)
                {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(1));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    comboBox2.setModel( model );
                    comboBox2.setVisible(true);

                } //TODO: Es decir, si se selecciona otra opción.
                else if (comboBox1.getSelectedIndex()==2) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(2));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    comboBox2.setModel( model );
                    comboBox2.setVisible(true);
                }
                else if (comboBox1.getSelectedIndex()==3) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(3));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    comboBox2.setModel( model );
                    comboBox2.setVisible(true);
                }
                else if (comboBox1.getSelectedIndex()==4) {
                    comboBox2.setVisible(false);
                    textField1.setVisible(true);
                }
                else if (comboBox1.getSelectedIndex()==5) {
                    comboBox2.setVisible(false);
                    textField1.setVisible(true);
                }
                else if (comboBox1.getSelectedIndex()==6) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(6));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    comboBox2.setModel( model );
                    comboBox2.setVisible(true);
                }
                else if (comboBox1.getSelectedIndex()==7) {
                    comboBox2.setVisible(false);
                    textField1.setVisible(true);
                }
                else if (comboBox1.getSelectedIndex()==8) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<String>();
                    filtrosEspecificos = FestivalCineController.getInstance().getFiltros(filtrosGenerales.get(8));
                    String[] filtrosEspecificosStrings = new String [filtrosEspecificos.size()];
                    for (int i = 0; i < filtrosEspecificosStrings.length; i++){
                        filtrosEspecificosStrings[i] = filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model = new DefaultComboBoxModel( filtrosEspecificosStrings );
                    comboBox2.setModel( model );
                    comboBox2.setVisible(true);
                }
            }
        });

        //---- button6 ----
        button6.setText("Buscar");
        contentPane.add(button6);
        button6.setBounds(730, 315, 180, 30);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (FILTRADOS.JAVA).
                if (comboBox1.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(ventana,"Selecciona una opción, por favor!",
                            "ERR-A01 - Selección errónea de filtro",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        PeliculaList peliculaList = null;
                        if (comboBox1.getSelectedIndex() == 1 || comboBox1.getSelectedIndex() == 2 ||
                                comboBox1.getSelectedIndex() == 3 || comboBox1.getSelectedIndex() == 6 ||
                                comboBox1.getSelectedIndex() == 8) {
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList(
                                    (String) (comboBox2.getSelectedItem()), (String) comboBox1.getSelectedItem());
                        }
                        else if (comboBox1.getSelectedIndex() == 4) {
                            Double.parseDouble(textField1.getText());
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList(
                                    (textField1.getText()), (String) comboBox1.getSelectedItem());
                        }
                        else if (comboBox1.getSelectedIndex() == 5) {
                            Integer.parseInt(textField1.getText());
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList(
                                    (textField1.getText()), (String) comboBox1.getSelectedItem());
                        }
                        else if ( comboBox1.getSelectedIndex() == 7) {
                            String actorInput = textField1.getText();
                            if (actorInput.length()==0){
                                throw new NullPointerException();
                            }
                            peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList(
                                    (textField1.getText()), (String) comboBox1.getSelectedItem());
                        }
                        for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
                            System.out.println(aux.toString());
                        }
                        //TODO: Se debería mostrar el listado de películas filtradas, en formato búsqueda.
                        //Menu m = new Menu(aux);
                        //m.setVisible(true);
                        //dispose();
                    }
                    catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(ventana, "¡No has insertado un valor numérico correcto!",
                                "ERR-A02 - Inserción errónea de valor numérico", JOptionPane.ERROR_MESSAGE);
                    }
                    catch (NullPointerException e1){
                        JOptionPane.showMessageDialog(ventana, "¡Has dejado en blanco el campo de búsqueda " +
                                "del actor!", "ERR-A03 - Inserción errónea de nombre o apellido de actor",
                                JOptionPane.ERROR_MESSAGE);
                    }
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
    private JComboBox comboBox2;
    private JTextField textField1;
    private JFrame ventana;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Thu Dec 05 09:35:06 CET 2019
 */

package es.deusto.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.*;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.UsuarioDTO;

/**
 * @author unknown
 */
public class Menu extends JFrame {

    static Logger logger = Logger.getLogger(Menu.class.getName());
    public Menu(UsuarioDTO aux) {
        PeliculaList peliculaList = FestivalCineController.getInstance().getPeliculaList();
        initComponents(peliculaList,aux);
    }
    /**
     * Constructor generado para su uso en GeneracionVentanasTest.java.
     * @param peliculaList
     * @param aux
     */
    public Menu(PeliculaList peliculaList, UsuarioDTO aux) {
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
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        textField1 = new JTextField();


        ventana = this;

        //======== this ========
        setTitle("Men\u00fa Principal - "+aux.getLogin());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath+"/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 960);

        int tam = peliculaList.getPeliculasDTO().size();
        logger.info("Tamaño de películas disponibles obtenido: "+ tam);

        //---- button1 ----
        button1.setText("Salir");
        contentPane.add(button1);
        button1.setBounds(750, 145, 160, 30);
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
        label1.setBounds(265, 95, 315, 30);

        //---- label10 ----
        label10.setText(aux.getLogin());
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label10);
        label10.setBounds(750, 110, 155, 20);

        //---- label11 ----
        label11.setBounds(770, 50, 120, 55);
        label11.setIcon(ResizeImage(myPath+"/src/main/resources/img/avataricon.jpg", label11));
        contentPane.add(label11);

        if (tam > 0 ) {
            //---- label2 ----
            label2.setBounds(220, 215, 130, 90);
            label2.setIcon(ResizeImage(myPath+peliculaList.getPeliculasDTO().get(0).getURIimagen(), label2));
            contentPane.add(label2);

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
                    InformePelicula m = new InformePelicula(peliculaList.getPeliculasDTO().get(0), aux);
                    m.setVisible(true);
                    dispose();
                }
            });

            if (tam > 1) {
                //---- label3 ----
                label3.setBounds(500, 215, 130, 90);
                label3.setIcon(ResizeImage(myPath+peliculaList.getPeliculasDTO().get(1).getURIimagen(),
                        label3));
                contentPane.add(label3);

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
                        InformePelicula m = new InformePelicula(peliculaList.getPeliculasDTO().get(1), aux);
                        m.setVisible(true);
                        dispose();
                    }
                });

                if (tam > 2) {
                    //---- label4 ----
                    label4.setBounds(215, 425, 130, 90);
                    label4.setIcon(ResizeImage(myPath+peliculaList.getPeliculasDTO().get(2).getURIimagen(),
                            label4));
                    contentPane.add(label4);

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
                            InformePelicula m = new InformePelicula(peliculaList.getPeliculasDTO().get(2), aux);
                            m.setVisible(true);
                            dispose();
                        }
                    });

                    if (tam > 3) {
                        //---- label5 ----
                        //label5.setText(peliculaList.getPeliculasDTO().get(3).getURIimagen());
                        contentPane.add(label5);
                        label5.setBounds(500, 425, 130, 90);
                        label5.setIcon(ResizeImage(myPath+peliculaList.getPeliculasDTO().get(3).
                                getURIimagen(), label5));

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
                                InformePelicula m = new InformePelicula(peliculaList.getPeliculasDTO().get(3), aux);
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

        //---- label12 ----
        label12.setText("Filtrar B\u00fasqueda");
        label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 4f));
        label12.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label12);
        label12.setBounds(750, 200, 130, label10.getPreferredSize().height);

        logger.info("Strings de Filtros cargados");
        contentPane.add(comboBox2);
        comboBox2.setBounds(760, 290, 110, 30);
        comboBox2.setVisible(false);

        contentPane.add(textField1);
        textField1.setBounds(715, 330, 210, 35);
        textField1.setVisible(false);

        comboBox1 = new JComboBox(filtrosGeneralesStrings);
        contentPane.add(comboBox1);
        comboBox1.setBounds(760, 250, 110, comboBox1.getPreferredSize().height);

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

                }
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
        logger.info("Filtros cargados");

        //---- button6 ----
        button6.setText("Buscar");
        contentPane.add(button6);
        button6.setBounds(730, 380, 180, 30);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(ventana,"¡Selecciona una opción, por favor!",
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
                        if (peliculaList.getPeliculasDTO().size() == 0)
                        {
                            JOptionPane.showMessageDialog(ventana,
                                    "No hay películas que cumplan este filtro.",
                                    "ERR-A04 - No hay películas que cumplan este filtro.",
                                    JOptionPane.ERROR_MESSAGE);
                            logger.info("ERR-A04 - No hay películas que cumplan este filtro.");
                        }
                        else {
                            ResultadoFiltrados m = new ResultadoFiltrados(peliculaList,aux);
                            m.setVisible(true);
                            dispose();
                        }
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
        logger.info("Botón de búsqueda con Filtros cargado.");
        if (aux.getLogin().compareTo("admin")==0){
            //---- button7 ----

            //---- label13 ----
            label13.setText("Funciones de Admin:");
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 4f));
            label13.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(label13);
            label13.setBounds(750, 450, 175, label10.getPreferredSize().height);

            button7.setText("Crear Actor");
            contentPane.add(button7);
            button7.setBounds(730, 500, 180, 30);
            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreacionActor ca = new CreacionActor(aux);
                    ca.setVisible(true);
                    dispose();
                }
            });
            //---- button7 ----
            button8.setText("Crear Película");
            contentPane.add(button8);
            button8.setBounds(730, 550, 180, 30);
            button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreacionPelicula cp = new CreacionPelicula(aux);
                    cp.setVisible(true);
                    dispose();
                }
            });
            logger.info("Botones de generación cargados con usuario admin.");
        }
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
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JFrame ventana;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * Método para redimensionar un ImageIcon al mismo tamaño que un JLabel.
     */
    public ImageIcon ResizeImage(String ImagePath, JLabel label)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}

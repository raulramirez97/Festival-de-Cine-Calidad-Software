package es.deusto.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.*;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaList;

/**
 * Implementación de la ventana para que un Usuario no registrado pueda
 * interactuar con la aplicación de Festival de Cine.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */
public class MenuAnonimo extends JFrame {

    static Logger logger = Logger.getLogger(MenuAnonimo.class.getName());

    /**
     * Constructor generado para su uso en producción.
     */
    public MenuAnonimo() {
        PeliculaList peliculaList = FestivalCineController.getInstance()
                .getPeliculaList();
        initComponents(peliculaList);
    }

    /**
     * Constructor generado para su uso en GeneracionVentanasTest.java.
     * @param peliculaList Listado de películas disponibles.
     */
    public MenuAnonimo(PeliculaList peliculaList) {
        initComponents(peliculaList);
    }

    private void initComponents(PeliculaList peliculaList) {
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
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        textField1 = new JTextField();

        ventana = this;

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath
                + "/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //======== this ========
        setTitle("Men\u00fa Principal");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        int tam = peliculaList.getPeliculasDTO().size();
        logger.info("Tamaño de películas disponibles obtenido: "
                + tam);

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
        label1.setFont(label1.getFont().deriveFont(label1.getFont()
                .getSize() + 18f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(290, 95, 275, 30);

        if (tam > 0) {
            //---- label2 ----
            label2.setBounds(220, 215, 130, 90);
            label2.setIcon(ResizeImage(myPath
                    + peliculaList.getPeliculasDTO().get(0)
                    .getURIimagen(), label2));
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
                    InformePeliculaAnonimo m = new InformePeliculaAnonimo(
                            peliculaList.getPeliculasDTO().get(0));
                    m.setVisible(true);
                    dispose();
                }
            });

            if (tam > 1) {
                //---- label3 ----
                label3.setBounds(500, 215, 130, 90);
                label3.setIcon(ResizeImage(myPath
                                + peliculaList.getPeliculasDTO().get(1)
                                .getURIimagen(),
                        label3));
                contentPane.add(label3);

                //---- label9 ----
                label9.setText(peliculaList.getPeliculasDTO()
                        .get(1).getTitulo());
                contentPane.add(label9);
                label9.setBounds(505, 320, 125, 20);

                //---- button3 ----
                button3.setText("+ Info");
                contentPane.add(button3);
                button3.setBounds(510, 375, 110, 30);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InformePeliculaAnonimo m = new InformePeliculaAnonimo(
                                peliculaList.getPeliculasDTO().get(1));
                        m.setVisible(true);
                        dispose();
                    }
                });

                if (tam > 2) {
                    //---- label4 ----
                    label4.setBounds(215, 425, 130, 90);
                    label4.setIcon(ResizeImage(myPath
                                    + peliculaList.getPeliculasDTO()
                                    .get(2).getURIimagen(),
                            label4));
                    contentPane.add(label4);

                    //---- label7 ----
                    label7.setText(peliculaList.getPeliculasDTO()
                            .get(2).getTitulo());
                    contentPane.add(label7);
                    label7.setBounds(225, 535, 125, 20);

                    //---- button4 ----
                    button4.setText("+ Info");
                    contentPane.add(button4);
                    button4.setBounds(220, 580, 110, 30);
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            InformePeliculaAnonimo m =
                                    new InformePeliculaAnonimo(
                                            peliculaList
                                                    .getPeliculasDTO().get(2));
                            m.setVisible(true);
                            dispose();
                        }
                    });

                    if (tam > 3) {
                        //---- label5 ----
                        label5.setBounds(500, 425,
                                130, 90);
                        label5.setIcon(ResizeImage(myPath
                                + peliculaList.getPeliculasDTO().get(3)
                                .getURIimagen(), label5));
                        contentPane.add(label5);

                        //---- label8 ----
                        label8.setText(peliculaList.getPeliculasDTO()
                                .get(3).getTitulo());
                        contentPane.add(label8);
                        label8.setBounds(510, 540,
                                125, 20);

                        //---- button5 ----
                        button5.setText("+ Info");
                        contentPane.add(button5);
                        button5.setBounds(510, 580,
                                110, 30);
                        button5.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                InformePeliculaAnonimo m = new
                                        InformePeliculaAnonimo(
                                                peliculaList
                                                        .getPeliculasDTO()
                                                        .get(3));
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
        String[] filtrosGeneralesStrings =
                new String[filtrosGenerales.size()];
        for (int i = 0; i < filtrosGeneralesStrings.length; i++) {
            filtrosGeneralesStrings[i] = filtrosGenerales.get(i);
        }

        //---- label10 ----
        label10.setText("Filtrar B\u00fasqueda");
        label10.setFont(label10.getFont().deriveFont(label10.getFont()
                .getSize() + 4f));
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label10);
        label10.setBounds(750, 200, 130, label10
                .getPreferredSize().height);

        logger.info("Strings de Filtros cargados");
        contentPane.add(comboBox2);
        comboBox2.setBounds(760, 290, 110, 30);
        comboBox2.setVisible(false);

        contentPane.add(textField1);
        textField1.setBounds(715, 330, 210, 35);
        textField1.setVisible(false);

        comboBox1 = new JComboBox(filtrosGeneralesStrings);
        contentPane.add(comboBox1);
        comboBox1.setBounds(760, 250, 110, comboBox1
                .getPreferredSize().height);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedIndex() == 0) {
                    comboBox2.setVisible(false);
                } else if (comboBox1.getSelectedIndex() == 1) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<>();
                    filtrosEspecificos = FestivalCineController.getInstance()
                            .getFiltros(filtrosGenerales.get(1));
                    String[] filtrosEspecificosStrings =
                            new String[filtrosEspecificos.size()];
                    for (int i = 0; i
                            < filtrosEspecificosStrings.length; i++) {
                        filtrosEspecificosStrings[i] =
                                filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model =
                            new DefaultComboBoxModel(
                                    filtrosEspecificosStrings);
                    comboBox2.setModel(model);
                    comboBox2.setVisible(true);

                } else if (comboBox1.getSelectedIndex() == 2) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<>();
                    filtrosEspecificos = FestivalCineController.getInstance()
                            .getFiltros(filtrosGenerales.get(2));
                    String[] filtrosEspecificosStrings =
                            new String[filtrosEspecificos.size()];
                    for (int i = 0; i
                            < filtrosEspecificosStrings.length; i++) {
                        filtrosEspecificosStrings[i] =
                                filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model =
                            new DefaultComboBoxModel(
                                    filtrosEspecificosStrings);
                    comboBox2.setModel(model);
                    comboBox2.setVisible(true);
                } else if (comboBox1.getSelectedIndex() == 3) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<>();
                    filtrosEspecificos = FestivalCineController.getInstance()
                            .getFiltros(filtrosGenerales.get(3));
                    String[] filtrosEspecificosStrings =
                            new String[filtrosEspecificos.size()];
                    for (int i = 0; i
                            < filtrosEspecificosStrings.length; i++) {
                        filtrosEspecificosStrings[i] =
                                filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model =
                            new DefaultComboBoxModel(
                                    filtrosEspecificosStrings);
                    comboBox2.setModel(model);
                    comboBox2.setVisible(true);
                } else if (comboBox1.getSelectedIndex() == 4) {
                    comboBox2.setVisible(false);
                    textField1.setVisible(true);
                } else if (comboBox1.getSelectedIndex() == 5) {
                    comboBox2.setVisible(false);
                    textField1.setVisible(true);
                } else if (comboBox1.getSelectedIndex() == 6) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<>();
                    filtrosEspecificos = FestivalCineController.getInstance()
                            .getFiltros(filtrosGenerales.get(6));
                    String[] filtrosEspecificosStrings =
                            new String[filtrosEspecificos.size()];
                    for (int i = 0; i
                            < filtrosEspecificosStrings.length; i++) {
                        filtrosEspecificosStrings[i] =
                                filtrosEspecificos.get(i);
                    }

                    DefaultComboBoxModel model =
                            new DefaultComboBoxModel(
                                    filtrosEspecificosStrings);
                    comboBox2.setModel(model);
                    comboBox2.setVisible(true);
                } else if (comboBox1.getSelectedIndex() == 7) {
                    comboBox2.setVisible(false);
                    textField1.setVisible(true);
                } else if (comboBox1.getSelectedIndex() == 8) {
                    textField1.setVisible(false);
                    ArrayList<String> filtrosEspecificos = new ArrayList<>();
                    filtrosEspecificos = FestivalCineController.getInstance()
                            .getFiltros(filtrosGenerales.get(8));
                    String[] filtrosEspecificosStrings =
                            new String[filtrosEspecificos.size()];
                    for (int i = 0; i
                            < filtrosEspecificosStrings.length; i++) {
                        filtrosEspecificosStrings[i] =
                                filtrosEspecificos.get(i);
                    }
                    DefaultComboBoxModel model =
                            new DefaultComboBoxModel(
                                    filtrosEspecificosStrings);
                    comboBox2.setModel(model);
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
                    JOptionPane.showMessageDialog(ventana,
                            "¡Selecciona una opción, por favor!",
                            "ERR-A01 - Selección errónea de filtro",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        PeliculaList peliculaList = null;
                        if (comboBox1.getSelectedIndex() == 1
                                || comboBox1.getSelectedIndex() == 2
                                || comboBox1.getSelectedIndex() == 3
                                || comboBox1.getSelectedIndex() == 6
                                || comboBox1.getSelectedIndex() == 8) {
                            peliculaList = FestivalCineController.
                                    getInstance().getFilteredPeliculaList(
                                    (String) (comboBox2.getSelectedItem()),
                                    (String) comboBox1.getSelectedItem());
                        } else if (comboBox1.getSelectedIndex() == 4) {
                            Double.parseDouble(textField1.getText());
                            peliculaList = FestivalCineController.
                                    getInstance().getFilteredPeliculaList(
                                    (textField1.getText()),
                                    (String) comboBox1.getSelectedItem());
                        } else if (comboBox1.getSelectedIndex() == 5) {
                            Integer.parseInt(textField1.getText());
                            peliculaList = FestivalCineController
                                    .getInstance().getFilteredPeliculaList(
                                    (textField1.getText()),
                                            (String) comboBox1
                                                    .getSelectedItem());
                        } else if (comboBox1.getSelectedIndex() == 7) {
                            String actorInput = textField1.getText();
                            if (actorInput.length() == 0) {
                                throw new NullPointerException();
                            }
                            peliculaList = FestivalCineController.
                                    getInstance().getFilteredPeliculaList(
                                    (textField1.getText()),
                                    (String) comboBox1.getSelectedItem());
                        }
                        if (peliculaList.getPeliculasDTO().size() == 0) {
                            JOptionPane.showMessageDialog(ventana,
                                    "No hay películas que "
                                            + "cumplan este filtro.",
                                    "ERR-A04 - No hay películas que"
                                            + " cumplan este filtro.",
                                    JOptionPane.ERROR_MESSAGE);
                            logger.info("ERR-A04 - No hay películas "
                                    + "que cumplan este filtro.");
                        } else {
                            ResultadoFiltradosAnonimo m =
                                    new ResultadoFiltradosAnonimo(
                                            peliculaList);
                            m.setVisible(true);
                            dispose();
                        }
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(ventana,
                                "¡No has insertado un valor"
                                        + " numérico correcto!",
                                "ERR-A02 - Inserción errónea de "
                                        + "valor numérico",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (NullPointerException e1) {
                        JOptionPane.showMessageDialog(ventana,
                                "¡Has dejado en blanco el "
                                        + "campo de búsqueda "
                                        + "del actor!",
                                "ERR-A03 - Inserción errónea de nombre"
                                        +  " o apellido de actor",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        logger.info("Botón de búsqueda con Filtros cargado.");

        // compute preferred size
        Dimension preferredSize = new Dimension();
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
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

        pack();
        setLocationRelativeTo(getOwner());
        Rectangle r = ventana.getBounds();
        r.grow(45, 45);
        ventana.setBounds(r);
    }

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
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JFrame ventana;

    /**
     * Método para redimensionar un ImageIcon al mismo tamaño que un JLabel.
     * @param ImagePath Ruta de la imagen a modificar.
     * @param label Jlabel sobre el cual se hará el ajuste de la imagen.
     * @return Icono de Imagen con el tamaño ajustado.
     */
    public ImageIcon ResizeImage(String ImagePath, JLabel label) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}

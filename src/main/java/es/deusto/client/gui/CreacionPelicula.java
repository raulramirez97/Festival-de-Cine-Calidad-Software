/*
 * Created by JFormDesigner on Thu Dec 05 09:53:02 CET 2019
 */

package es.deusto.client.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.UsuarioDTO;

/**
 * @author Beñat
 * Inspiración para JFileChooser tomada de: http://1bestcsharp.blogspot.com/2015/04/java-how-to-browse-image-file-and-And-Display-It-Using-JFileChooser-In-Java.html
 * Inspiración para tomar working directory: https://stackoverflow.com/questions/4871051/getting-the-current-working-directory-in-java
 * Inspiración para recoger imagen: https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
 */
public class CreacionPelicula extends JFrame {

    static Logger logger = Logger.getLogger(CreacionPelicula.class.getName());

    public CreacionPelicula(UsuarioDTO aux) {
        initComponents(aux);
    }

    private void initComponents(UsuarioDTO aux) {
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
        label14 = new JLabel();
        label15 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        textFieldNomPeli = new JTextField();
        textFieldAnyoPeli = new JTextField();
        textFieldDurPeli = new JTextField();
        textFieldGenPeli = new JTextField();
        textFieldDirPeli = new JTextField();
        textFieldActoresPeli = new JTextField();
        textFieldURLTrailer = new JTextField();
        scrollPane1 = new JScrollPane();
        textAreaSinopsisPeli = new JTextArea();
        textAreaPremiosPeli = new JTextArea();

        ventana = this;

        //======== this ========
        setTitle("Creación de nueva película");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Inserta a continuaci\u00f3n los datos de la nueva pel\u00edcula");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(225, 55, 489, 35);

        //---- label2 ----
        label2.setText("A\u00f1o");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label2);
        label2.setBounds(105, 165, 75, 20);

        //---- label3 ----
        label3.setText("Duraci\u00f3n");
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label3);
        label3.setBounds(105, 200, 75, 20);

        //---- label4 ----
        label4.setText("G\u00e9nero");
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label4);
        label4.setBounds(105, 240, 75, 20);

        //---- label5 ----
        label5.setText("Reparto");
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label5);
        label5.setBounds(105, 315, 75, 20);

        //---- label6 ----
        label6.setText("Sinopsis");
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label6);
        label6.setBounds(105, 355, 75, 20);

        //---- label7 ----
        label7.setText("Premios");
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label7);
        label7.setBounds(105, 470, 75, 20);

        //---- label9 ----
        label9.setText("Tr\u00e1iler");
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label9);
        label9.setBounds(105, 535, 75, 20);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textAreaSinopsisPeli);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(230, 360, 270, 90);

        contentPane.add(textAreaPremiosPeli);
        textAreaPremiosPeli.setBounds(230, 470, 270, 45);
        textAreaPremiosPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textAreaPremiosPeli.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro de premios, o N/A" +
                            "si no tiene, por favor.");
                }
            }
        });

        //---- label14 ----
        label14.setText("<INSERTAR_IMAGEN_PELICULA>");
        label14.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label14);
        label14.setBounds(580, 165, 270, 160);

        //---- label15 ----
        label15.setText("Director");
        label15.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label15);
        label15.setBounds(115, 280, 65, label15.getPreferredSize().height);

        //---- label8 ----
        label8.setText("Nombre");
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label8);
        label8.setBounds(105, 130, 75, 20);

        contentPane.add(textFieldNomPeli);
        textFieldNomPeli.setBounds(225, 130, 275, textFieldNomPeli.getPreferredSize().height);
        textFieldNomPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldNomPeli.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro del nombre de la "+
                            "película, por favor.");
                }
            }
        });

        contentPane.add(textFieldAnyoPeli);
        textFieldAnyoPeli.setBounds(225, 165, 275, 30);
        textFieldAnyoPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Integer.parseInt(textFieldAnyoPeli.getText());
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(ventana, "Inserte un valor numérico en el campo," +
                            " por favor.");
                }
            }
        });

        contentPane.add(textFieldDurPeli);
        textFieldDurPeli.setBounds(225, 205, 275, 30);
        textFieldDurPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Integer.parseInt(textFieldDurPeli.getText());
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(ventana, "Inserte un valor numérico en el campo," +
                            " por favor.");
                }
            }
        });

        contentPane.add(textFieldGenPeli);
        textFieldGenPeli.setBounds(225, 245, 275, 30);
        textFieldGenPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldGenPeli.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro del género, " +
                            "por favor.");
                }
            }
        });

        contentPane.add(textFieldDirPeli);
        textFieldDirPeli.setBounds(225, 285, 275, 30);
        textFieldDirPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldDirPeli.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro del director, " +
                            "por favor.");
                }
            }
        });

        contentPane.add(textFieldActoresPeli);
        textFieldActoresPeli.setBounds(225, 320, 275, 30);
        textFieldActoresPeli.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldActoresPeli.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro de los actores, " +
                            "por favor.");
                }
            }
        });

        contentPane.add(textFieldURLTrailer);
        textFieldURLTrailer.setBounds(225, 535, 275, 30);
        textFieldURLTrailer.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldURLTrailer.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ventana, "Inserte contenido en el cuadro de la URL, " +
                            "por favor.");
                }
            }
        });

        //---- button3 ----
        button3.setText("Vuelve al Men\u00fa Principal");
        contentPane.add(button3);
        button3.setBounds(620, 625, 190, 40);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu m = new Menu(aux);
                m.setVisible(true);
                dispose();
            }
        });

        //---- button4 ----
        button4.setText("Inserta la Pelicula");
        contentPane.add(button4);
        button4.setBounds(160, 625, 190, 40);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ActorDTO> allActors = FestivalCineController.getInstance().getActorList().getActorsDTO();
                List<ActorDTO> selectedActors = new ArrayList<>();
                String[] actorsStringList = textFieldActoresPeli.getText().split("\\s*,\\s*");
                for (ActorDTO myActor: allActors) {
                    String check = myActor.getNombre() + " " + myActor.getApellido();
                    for (int i = 0; i < actorsStringList.length; i++){
                        if (check.toUpperCase().compareTo(actorsStringList[i].toUpperCase())==0){
                            selectedActors.add(myActor);
                        }
                    }
                }
                if (selectedActors.size() == 0) {
                    JOptionPane.showMessageDialog(ventana, "Inserta nombre y apellido de actores, separados" +
                            " con comas que existan actualmente en el sistema.");
                }
                else {
                    try {
                        FestivalCineController.getInstance().registerPelicula(textFieldNomPeli.getText(),
                                textAreaSinopsisPeli.getText(), textFieldGenPeli.getText(),
                                Integer.parseInt(textFieldDurPeli.getText()),
                                Integer.parseInt(textFieldAnyoPeli.getText()),
                                textFieldDirPeli.getText(),textFieldURLTrailer.getText(),
                                textAreaPremiosPeli.getText(), "novedades", selectedActors, URIImage);
                        logger.info("Pelicula generated successfully by the admin.");
                        Menu m = new Menu(aux);
                        m.setVisible(true);
                        dispose();
                    }
                    catch (NumberFormatException exc) {
                        JOptionPane.showMessageDialog(ventana, "Inserte un valor numérico en los campos" +
                                "numéricos, por favor.");
                    }
                }
            }
        });
        //---- button5 ----
        button5.setText("Selecciona la Imagen");
        contentPane.add(button5);
        button5.setBounds(625, 380, 190, 40);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images",
                        "jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                //if the user click on save in Jfilechooser
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    label14.setIcon(ResizeImage(path));
                    //Store image in resources/img folder:
                    String store = System.getProperty("user.dir")+"/src/main/resources/img";
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(selectedFile);
                        ImageIO.write(img,"png",new File(store+"/"+selectedFile.getName()));
                        URIImage = "/src/main/resources/img/"+selectedFile.getName();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ventana, "Se ha seleeccionado un tipo de fichero" +
                                " distinto a una imagen");
                        logger.info("Se ha seleeccionado un tipo de fichero distinto a una imagen.");
                    }
                }
                //if the user click on cancel in Jfilechooser
                else if(result == JFileChooser.CANCEL_OPTION){
                    logger.info("No se ha seleccionado ninguna imagen");
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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label14;
    private JLabel label15;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textFieldNomPeli;
    private JTextField textFieldAnyoPeli;
    private JTextField textFieldDurPeli;
    private JTextField textFieldGenPeli;
    private JTextField textFieldDirPeli;
    private JTextField textFieldActoresPeli;
    private JTextField textFieldURLTrailer;
    private JScrollPane scrollPane1;
    private JTextArea textAreaSinopsisPeli;
    private JTextArea textAreaPremiosPeli;
    private JFrame ventana;
    private String URIImage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * Método para redimensionar un ImageIcon al mismo tamaño que un JLabel.
     */
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label14.getWidth(), label14.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
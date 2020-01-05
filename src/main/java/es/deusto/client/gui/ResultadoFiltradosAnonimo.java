package es.deusto.client.gui;

import es.deusto.server.data.PeliculaList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Implementación de la ventana para que se muestre el listado de películas
 * filtrado por un usuario anónimo/no-registrado.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */
public class ResultadoFiltradosAnonimo extends JFrame {

    static Logger logger = Logger.getLogger(ResultadoFiltradosAnonimo
            .class.getName());

    public ResultadoFiltradosAnonimo(PeliculaList peliculaList) {
        initComponents(peliculaList);
    }

    private void initComponents(PeliculaList peliculaList) {
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea2 = new JTextArea();
        button2 = new JButton();
        label2 = new JLabel();
        textArea4 = new JTextArea();
        textArea1 = new JTextArea();
        label3 = new JLabel();
        button3 = new JButton();
        buttonMenu = new JButton();
        label4 = new JLabel();
        textArea3 = new JTextArea();
        button4 = new JButton();

        ventana = this;

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath
                + "/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 960);

        //======== this ========
        int tam = peliculaList.getPeliculasDTO().size();

        setTitle("Resultado Filtrados");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        if (tam > 0) {
            //---- label1 ----
            label1.setText(peliculaList.getPeliculasDTO().get(0)
                    .getTitulo());
            contentPane.add(label1);
            label1.setBounds(20, 155, 200, 35);

            contentPane.add(textArea1);
            textArea1.setText(peliculaList.getPeliculasDTO().get(0)
                    .getSinopsis());
            textArea1.setBounds(235, 135, 443, 83);
            textArea1.setEditable(false);

            //---- button1 ----
            button1.setText("+ Info");
            contentPane.add(button1);
            button1.setBounds(new Rectangle(new Point(785, 155),
                    button1.getPreferredSize()));
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InformePeliculaAnonimo m = new InformePeliculaAnonimo(
                            peliculaList.getPeliculasDTO().get(0));
                    m.setVisible(true);
                    dispose();
                }
            });

            if (tam > 1) {
                //---- label2 ----
                label2.setText(peliculaList.getPeliculasDTO().get(1)
                        .getTitulo());
                contentPane.add(label2);
                label2.setBounds(20, 275, 195, 35);

                //======== scrollPane1 ========
                scrollPane1.setViewportView(textArea2);
                textArea2.setText(peliculaList.getPeliculasDTO().get(1)
                        .getSinopsis());
                textArea2.setEditable(false);

                contentPane.add(scrollPane1);
                scrollPane1.setBounds(235, 250, 445, 85);

                //---- button2 ----
                button2.setText("+ Info");
                contentPane.add(button2);
                button2.setBounds(new Rectangle(new Point(785, 270),
                        button2.getPreferredSize()));
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InformePeliculaAnonimo m = new InformePeliculaAnonimo(
                                peliculaList.getPeliculasDTO().get(1));
                        m.setVisible(true);
                        dispose();
                    }
                });

                if (tam > 2) {
                    //---- label3 ----
                    label3.setText(peliculaList.getPeliculasDTO().get(2)
                            .getTitulo());
                    contentPane.add(label3);
                    label3.setBounds(20, 390, 200, 40);

                    contentPane.add(textArea3);
                    textArea3.setBounds(235, 365, 443, 83);
                    textArea3.setText(peliculaList.getPeliculasDTO().get(2)
                            .getSinopsis());
                    textArea3.setEditable(false);

                    //---- button3 ----
                    button3.setText("+ Info");
                    contentPane.add(button3);
                    button3.setBounds(785, 385, 78, 30);
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            InformePeliculaAnonimo m =
                                    new InformePeliculaAnonimo(
                                            peliculaList
                                                    .getPeliculasDTO()
                                                    .get(2));
                            m.setVisible(true);
                            dispose();
                        }
                    });

                    if (tam > 3) {
                        //---- label4 ----
                        label4.setText(peliculaList.getPeliculasDTO()
                                .get(3).getTitulo());
                        contentPane.add(label4);
                        label4.setBounds(20, 495,
                                200, 40);

                        contentPane.add(textArea4);
                        textArea4.setBounds(235, 475,
                                443, 83);
                        textArea4.setText(peliculaList.getPeliculasDTO()
                                .get(3).getSinopsis());
                        textArea4.setEditable(false);

                        //---- button4 ----
                        button4.setText("+ Info");
                        contentPane.add(button4);
                        button4.setBounds(785, 495,
                                78, 30);
                        button4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                InformePeliculaAnonimo m =
                                        new InformePeliculaAnonimo(
                                                peliculaList.
                                        getPeliculasDTO().get(3));
                                m.setVisible(true);
                                dispose();
                            }
                        });
                    }
                }
            }
            //---- buttonMenu ----
            buttonMenu.setText("Volver al Men\u00fa Principal");
            contentPane.add(buttonMenu);
            buttonMenu.setBounds(375, 595, 190, 50);
            buttonMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MenuAnonimo m = new MenuAnonimo();
                    m.setVisible(true);
                    dispose();
                }
            });
        }

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

    private JLabel label1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea2;
    private JButton button2;
    private JLabel label2;
    private JTextArea textArea4;
    private JTextArea textArea1;
    private JLabel label3;
    private JButton button3;
    private JButton buttonMenu;
    private JLabel label4;
    private JTextArea textArea3;
    private JButton button4;
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

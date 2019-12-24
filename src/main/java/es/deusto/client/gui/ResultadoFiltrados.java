package es.deusto.client.gui;

import es.deusto.server.data.UsuarioDTO;
import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.PeliculaDTO;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

//TODO: Esto debería cambiarse por una ventana medio bien hecha que muestre la información como en el prototipo.
//TODO: Es decir: https://marvelapp.com/d2h27dh/screen/63129721
public class ResultadoFiltrados extends JFrame {

    static Logger logger = Logger.getLogger(ResultadoFiltrados.class.getName());

    public ResultadoFiltrados(PeliculaList pelicula) {
        initComponents(pelicula);
    }

    private void initComponents(PeliculaList pelicula) {

   /* private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField2;
    private JComboBox listafiltros;
    private JComboBox criterios;
    private boolean flag = false;
    private JFrame ventana;*/

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
        button3 = new JButton();
        button4 = new JButton();
        label15 = new JLabel();
        label18 = new JLabel();

        ventana = this;

        //this//

        String myPath = System.getProperty("user.dir");

        // setTitle("Películas filtradas: "+pelicula.getTitulo());
        setTitle("Películas filtradas: ");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);


       /* setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 367);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Películas filtradas");*/

        //---- label1 ----
        label1.setText("Festival Cine");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(290, 95, 275, 30);

       /* btnPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (FILTRADOS.JAVA).
//                PeliculaList peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((String)(listafiltros.getSelectedItem()));
//                for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
//                    System.out.println(aux.toString());
//                }
//                Menu m = new Menu(aux);
//                m.setVisible(true);
//                dispose();
//            	Filtrados filtrados = new Filtrados(aux);
//            	filtrados.setVisible(true);
//            	dispose();

                *//*PeliculaList peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((String)(listafiltros.getSelectedItem()),(String)(criterios.getSelectedItem()));
                for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
                    System.out.println(aux.toString());
                }
                Menu m = new Menu(aux);
                m.setVisible(true);
                dispose();*//*
            	//Filtrados filtrados = new Filtrados(aux);
            	//filtrados.setVisible(true);
           //	dispose();
            }
        });*/
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
    private JButton button3;
    private JButton button4;
    private JLabel label15;
    private JLabel label18;
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

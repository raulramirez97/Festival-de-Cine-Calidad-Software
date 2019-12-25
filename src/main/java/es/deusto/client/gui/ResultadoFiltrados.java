package es.deusto.client.gui;

import es.deusto.server.data.UsuarioDTO;
import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.PeliculaDTO;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.util.ArrayList;


//TODO: Esto debería cambiarse por una ventana medio bien hecha que muestre la información como en el prototipo.
//TODO: Es decir: https://marvelapp.com/d2h27dh/screen/63129721
public class ResultadoFiltrados extends JFrame {

    static Logger logger = Logger.getLogger(ResultadoFiltrados.class.getName());

    public ResultadoFiltrados(PeliculaList peliculaList) {
        initComponents(peliculaList);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents(PeliculaList peliculaList) {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        button1 = new JButton();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("Peliculas Filtradas ");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
            logger.info(aux.toString());
        label1.setText(aux.getTitulo());
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 55), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("+info");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(265, 55), button1.getPreferredSize()));
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InformePeliculaAnonimo m = new InformePeliculaAnonimo(peliculaList.getPeliculasDTO().get(0));
                    m.setVisible(true);
                    dispose();
                }
            });

        textArea1.setText(aux.getSinopsis());
        contentPane.add(textArea1);
        textArea1.setBounds(75, 55, 170, 50);}

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
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JButton button1;
    private JTextArea textArea1;
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
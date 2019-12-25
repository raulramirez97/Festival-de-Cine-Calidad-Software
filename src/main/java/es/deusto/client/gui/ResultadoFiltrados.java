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

    public ResultadoFiltrados(String pelicula) {
        initComponents(pelicula);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents(String pelicula) {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 55), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(65, 55, 160, 25);

        //---- button1 ----
        button1.setText("+info");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(255, 55), button1.getPreferredSize()));

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
    private JTextField textField1;
    private JButton button1;
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

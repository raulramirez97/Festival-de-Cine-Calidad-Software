package es.deusto.client.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ProgressBar extends JFrame {

    MiRunnable miHilo = null;
    JProgressBar progressBar;
    int v1;
    int v2;
    int v3;
    int v4;
    int v5;

    int e1;
    int e2;
    int e3;
    int e4;
    int e5;

    public ProgressBar(String titulo) {

        setBounds(450, 300, 400, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath+"/src/main/resources/img/filmicon.png").getImage());
        getContentPane().setLayout(null);

        setTitle(titulo);
        progressBar = new JProgressBar();
        progressBar.setBounds(50, 30, 300, 35);
        getContentPane().add(progressBar);

        Random rnd_v=new Random();
        v1=rnd_v.nextInt(100);
        v2=rnd_v.nextInt(100);
        v3=rnd_v.nextInt(100);
        v4=rnd_v.nextInt(100);
        v5=rnd_v.nextInt(100);

        e1=rnd_v.nextInt(4000);
        e2=rnd_v.nextInt(4000);
        e3=rnd_v.nextInt(4000);
        e4=rnd_v.nextInt(4000);
        e5=rnd_v.nextInt(4000);

        progressBar.setBackground(Color.black);
        progressBar.setForeground(Color.blue);

        miHilo = new MiRunnable();
        Thread nuevoHilo = new Thread(miHilo );
        nuevoHilo.start();
    }
    public void cerrar()
    {
        this.dispose();
        MenuAnonimo frame = new MenuAnonimo();
        frame.setVisible(true);
    }

    class MiRunnable implements Runnable {
        boolean sigo = true;
        @Override
        public void run() {
            while (sigo) {

                for(int i=0;i<=100;i++)
                {
                    progressBar.setStringPainted(true);
                    progressBar.setString(i + "%");
                    progressBar.setValue(i);

                    if(i==v1)
                        try { Thread.sleep(e1); } catch (InterruptedException e1) { e1.printStackTrace(); }
                    if(i==v2)
                        try { Thread.sleep(e2); } catch (InterruptedException e1) { e1.printStackTrace(); }
                    if(i==v3)
                        try { Thread.sleep(e3); } catch (InterruptedException e1) { e1.printStackTrace(); }
                    if(i==v4)
                        try { Thread.sleep(e4); } catch (InterruptedException e1) { e1.printStackTrace(); }
                    if(i==v5)
                        try { Thread.sleep(e5); } catch (InterruptedException e1) { e1.printStackTrace(); }
                    try { Thread.sleep(15); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                sigo=false;
                cerrar();
            }
        }
    }
}
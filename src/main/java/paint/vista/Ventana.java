package paint.vista;

import paint.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private Imagen modelo;
    private Panel panel;

    public Ventana() {
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(400,400);
        panel = new Panel(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btnHacer = new JButton("Hacer");
        btnHacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnHacer_clicked();
            }
        });

        this.getContentPane().add(btnHacer, BorderLayout.SOUTH);

        JButton btnGris = new JButton("Gris");
        btnGris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGris_clicked();
            }
        });

        this.getContentPane().add(btnGris, BorderLayout.EAST);

        this.pack();
    }

    private void btnGris_clicked() {
        Transformar tonosDeGris = new TransformarBYN(modelo);
        tonosDeGris.transformar();
        /*Transformar tonosDeGris = new FlipImagenHorizontal(modelo);
        tonosDeGris.transformar();*/
    }

    private void btnHacer_clicked() {
        //modelo.leerDeArchivo("c:/temp/edd1.jpg");
        modelo.leerDeArchivo("D:/WOMic/dijo.jpg");
    }
}

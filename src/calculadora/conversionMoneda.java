/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.border.*;

/**
 *
 * @author 80023
 */
public class conversionMoneda extends JFrame {

    JLabel texto;
    JButton back, dolar, euro, limpiar;
    JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    JPanel abajo, botones, numeros, arriba, panel;

    float num1, resultado;
    float valorDolar = 0.049f, valorEuro = 0.041f;

    public conversionMoneda() {
        frame();
        numeros();
        contenido();
        accionBotones();
        botones();
    }

    public void frame() {
        this.setTitle("Moneda");
        this.setSize(new Dimension(100, 100));
        this.setMinimumSize(new Dimension(300, 300));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void numeros() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4)); //tamaño botones 
        panel.setBorder(new EmptyBorder(3, 3, 3, 3)); //espaciogoo 
        bt1 = new JButton("1");
        bt2 = new JButton("2");
        bt3 = new JButton("3");
        bt4 = new JButton("4");
        bt5 = new JButton("5");
        bt6 = new JButton("6");
        bt7 = new JButton("7");
        bt8 = new JButton("8");
        bt9 = new JButton("9");
        bt0 = new JButton("0");
        panel.add(bt7);
        panel.add(bt8);
        panel.add(bt9);
        panel.add(bt6);
        panel.add(bt5);
        panel.add(bt4);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(bt0);
        this.add(panel);

    }

    public void contenido() {
        arriba = new JPanel();
        texto = new JLabel("Inserte valor en pesos mexicanos");
        texto.setBorder(new EmptyBorder(15, 15, 15, 15));
        Border linea = BorderFactory.createLineBorder(Color.RED, 1);
        arriba.setBorder(linea);
        arriba.add(texto);

        this.add(arriba, BorderLayout.NORTH);
        //atras
        abajo = new JPanel();
        back = new JButton("<--");
        abajo.add(back);
        abajo.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.add(abajo, BorderLayout.SOUTH);

        //botones
        botones = new JPanel();
        botones.setLayout(new GridLayout(4, 4)); //tamaño botones 
        botones.setBorder(new EmptyBorder(3, 3, 3, 3)); //espaciogoo 
        dolar = new JButton("Dolar");
        euro = new JButton("Euro");
        limpiar = new JButton("C");
        botones.add(dolar);
        botones.add(euro);
        botones.add(limpiar);
        this.add(botones, BorderLayout.WEST);

    }

    public void accionBotones() {
        ActionListener calcu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculadora cal = new Calculadora();
                cal.setVisible(true);
                dispose();
            }
        };
        back.addActionListener(calcu);
        ActionListener dolarcon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num1 = Float.parseFloat(texto.getText());
                    resultado = num1 * valorDolar;
                    texto.setText(Float.toString(resultado));
                }
            }
        };
        dolar.addActionListener(dolarcon);
        ActionListener eurocon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num1 = Float.parseFloat(texto.getText());
                    resultado = num1 * valorEuro;
                    texto.setText(Float.toString(resultado));
                }
            }
        };
        euro.addActionListener(eurocon);
    }

    public void botones() {
        ActionListener limpia = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
            }
        };
        limpiar.addActionListener(limpia);
        ActionListener cero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "0");
            }
        };
        bt0.addActionListener(cero);
        ActionListener uno = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "1");
            }
        };
        bt1.addActionListener(uno);
        ActionListener dos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "2");
            }
        };
        bt2.addActionListener(dos);
        ActionListener tres = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "3");
            }
        };
        bt3.addActionListener(tres);
        ActionListener cuatro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "4");
            }
        };
        bt4.addActionListener(cuatro);
        ActionListener cinco = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "5");
            }
        };
        bt5.addActionListener(cinco);
        ActionListener seis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "6");
            }
        };
        bt6.addActionListener(seis);
        ActionListener siete = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "7");
            }
        };
        bt7.addActionListener(siete);
        ActionListener ocho = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "8");
            }
        };
        bt8.addActionListener(ocho);
        ActionListener nueve = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "9");
            }
        };
        bt9.addActionListener(nueve);

    }
}

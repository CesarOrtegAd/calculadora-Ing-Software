/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class conversionSistemasNumericos extends JFrame {

    JLabel texto;
    JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, back, binario, hex, octal, limpiar;
    JPanel panel, arriba, abajo, botones;
    int num1;

    public conversionSistemasNumericos() {
        frame();
        numeros();
        contenido();
        acciones();
        botones();
    }

    public void frame() {
        this.setTitle("Conversion de Sistemas Numericos");
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
        texto = new JLabel("Numero a convertir");
        texto.setBorder(new EmptyBorder(15, 15, 15, 15));
        Border linea = BorderFactory.createLineBorder(Color.RED, 1);
        arriba.setBorder(linea);
        arriba.add(texto);
        this.add(arriba, BorderLayout.NORTH);

        abajo = new JPanel();
        back = new JButton("<--");
        abajo.add(back);
        abajo.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.add(abajo, BorderLayout.SOUTH);

        botones = new JPanel();
        botones.setLayout(new GridLayout(4, 4)); //tamaño botones 
        botones.setBorder(new EmptyBorder(3, 3, 3, 3)); //espaciogoo 
        binario = new JButton("Binario");
        hex = new JButton("Hexadecimal");
        octal = new JButton("Octal");
        limpiar = new JButton("C");
        botones.add(binario);
        botones.add(hex);
        botones.add(octal);
        botones.add(limpiar);
        this.add(botones, BorderLayout.WEST);

    }

    public void acciones() {
        ActionListener calcu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculadora cal = new Calculadora();
                cal.setVisible(true);
                dispose();
            }
        };
        back.addActionListener(calcu);
        ActionListener bin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    String binario = "";
                    num1 = Integer.parseInt(texto.getText());
                    while (num1 > 0) {
                        binario = num1 % 2 + binario;
                        num1 = num1 / 2;
                    }
                    texto.setText(binario);
                }
            }
        };
        binario.addActionListener(bin);
        ActionListener octa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    int residuo;
                    String octal = "";
                    char[] caracteresOctales = {'0', '1', '2', '3', '4', '5', '6', '7'};
                    num1 = Integer.parseInt(texto.getText());
                    while (num1 > 0) {
                        residuo = num1 % 8;
                        char caracterer = caracteresOctales[residuo];
                        octal = caracterer + octal;
                        num1 = num1 / 8;
                    }
                    texto.setText(octal);
                }
            }
        };
        octal.addActionListener(octa);
        ActionListener hexa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    int residuo;
                    String hexadecimal = "";
                    char[] caracterHexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    num1 = Integer.parseInt(texto.getText());
                    while (num1 > 0) {
                        residuo = num1 % 16;
                        char caracterHexade = caracterHexa[residuo];
                        hexadecimal = caracterHexade + hexadecimal;
                        num1 = num1 / 16;
                    }
                    texto.setText(hexadecimal);
                }
            }
        };
        hex.addActionListener(hexa);

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

package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Calculadora extends JFrame {

    JLabel texto;
    JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btdiv, btpor, btmenos, btmas, btpunto, btigual, bt16, btlimpiar, conMoneda, conNumericos;
    JPanel panel, derecha, arriba;
    //PARA OPERACIONES
    double num1, num2, resultado;
    char signo;

    public Calculadora() {
        frame();
        paneles();
        numeros();
        botones();
        operaciones();
        otrosFrames();
    }

    public void frame() {
        this.setTitle("Calculadora");
        this.setSize(new Dimension(100, 100));
        this.setMinimumSize(new Dimension(300, 300));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paneles() {
        arriba = new JPanel();
        texto = new JLabel("0");
        texto.setBorder(new EmptyBorder(15, 15, 15, 15));
        Border linea = BorderFactory.createLineBorder(Color.RED, 1);
        arriba.setBorder(linea);
        arriba.add(texto);

        this.add(arriba, BorderLayout.NORTH);

        derecha = new JPanel();
        derecha.setLayout(new GridLayout(4, 1));
        btlimpiar = new JButton("C");
        derecha.add(btlimpiar);
        conMoneda = new JButton("Moneda");
        conNumericos = new JButton("Conversión");
        derecha.add(conMoneda);
        derecha.add(conNumericos);
        derecha.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.add(derecha, BorderLayout.EAST);

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
        btdiv = new JButton("/");
        btpor = new JButton("*");
        btmenos = new JButton("-");
        btmas = new JButton("+");
        btpunto = new JButton(".");
        btigual = new JButton("=");
        bt16 = new JButton("0");

        panel.add(bt7);
        panel.add(bt8);
        panel.add(bt9);
        panel.add(btdiv);
        panel.add(bt4);
        panel.add(bt5);
        panel.add(bt6);
        panel.add(btpor);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(btmas);
        panel.add(bt16);
        panel.add(btigual);
        panel.add(btpunto);
        panel.add(btmenos);

        this.add(panel);

    }

    public void botones() {
        ActionListener limpiar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
            }
        };
        btlimpiar.addActionListener(limpiar);
        ActionListener cero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(texto.getText() + "0");
            }
        };
        bt16.addActionListener(cero);
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
        ActionListener punto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean punto = false;
                for (int i = 0; i < texto.getText().length(); i++) {
                    if (texto.getText().charAt(i) == '.') {
                        punto = true;
                        break;
                    }
                }
                if (!punto) {
                    texto.setText(texto.getText() + ".");
                }
            }
        };
        btpunto.addActionListener(punto);
    }

    public void operaciones() {
        ActionListener suma = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num1 = Double.parseDouble(texto.getText());
                    signo = '+';
                    texto.setText("");
                }
            }
        };
        btmas.addActionListener(suma);
        ActionListener resta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num1 = Double.parseDouble(texto.getText());
                    signo = '-';
                    texto.setText("");
                }
            }
        };
        btmenos.addActionListener(suma);
        ActionListener multiplicacion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num1 = Double.parseDouble(texto.getText());
                    signo = '*';
                    texto.setText("");

                }
            }
        };
        btpor.addActionListener(multiplicacion);
        ActionListener div = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num1 = Double.parseDouble(texto.getText());
                    signo = '/';
                    texto.setText("");
                }
            }
        };
        btdiv.addActionListener(div);
        ActionListener igual = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.getText().length() > 0) {
                    num2 = Double.parseDouble(texto.getText());
                    switch (signo) {
                        case '+':
                            resultado = num1 + num2;
                            texto.setText(Double.toString(resultado));
                            break;
                        case '-':
                            resultado = num1 - num2;
                            texto.setText(Double.toString(resultado));
                            break;
                        case '*':
                            resultado = num1 * num2;
                            texto.setText(Double.toString(resultado));
                            break;
                        case '/':
                            resultado = num1 / num2;
                            texto.setText(Double.toString(resultado));
                            break;
                    }
                }
            }
        };
        btigual.addActionListener(igual);
    }

    public void otrosFrames() {
        ActionListener moneda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conversionMoneda con = new conversionMoneda();
                con.setVisible(true);
                dispose();
            }
        };
        conMoneda.addActionListener(moneda);
        ActionListener sistemas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conversionSistemasNumericos con = new conversionSistemasNumericos();
                con.setVisible(true);
                dispose();
            }
        };
        conNumericos.addActionListener(sistemas);
    }

    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        cal.setVisible(true);
    }

}

package com.password;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class Main {
    private static String createdPassword = "";
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(null);
        frame.setTitle("Password Creator");


        PasswordCreator creator = new PasswordCreator();

         String[] opcoes = {"easy", "medium", "hard"};
        JComboBox<String> selectDificuldade = new JComboBox<>(opcoes);
        selectDificuldade.setBounds(50, 10, 200, 25);
        frame.add(selectDificuldade);

        JButton criarBt = new JButton("criar senha");
        criarBt.setBounds(90,40,100,30);
        frame.add(criarBt);

        JTextField label = new JTextField();
        label.setBorder(null);
        label.setBounds(55  ,80,170,20);
        frame.add(label);

        JButton copyBt = new JButton("Copiar");
        copyBt.setBounds(90,110,100,30);
        frame.add(copyBt);

        JLabel label2 = new JLabel();
        label2.setBounds(55,145,100,20);
        frame.add(label2);

        criarBt.addActionListener(e->{
            creator.setDificult((String) selectDificuldade.getSelectedItem());
            String senha = creator.create();
            createdPassword = senha;
            label.setText(senha);
            label2.setText(" ");
        });

        copyBt.addActionListener(e->{
            StringSelection seleção = new StringSelection(createdPassword);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleção, null);

            label2.setText("Senha Copiada!");
        });

        frame.setVisible(true);
    }
}
package com.password;

import java.util.Random;

public class PasswordCreator {
    private String dificult = "hard";
    private Random ramdom = new Random();
    private  String caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}<>?/|";
    private String caracteresValidos2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private int tamanho = caracteresValidos.length();
    private int tamanho2 = caracteresValidos2.length();
    private String[] words = {"mecha","friend","best","house","table","switch","warrior","three","whiteDog","blackBox","box","gray","random","bee","honey","milk","blue","white","orange","fish","black","person","monkey","plant","mouse","work","shark","dog","cat","bean"};

    public String create(){
        String password = "";
        switch (dificult) {
            case "easy":
                password = words[ramdom.nextInt(words.length)];
                if (password.length() < 8) {
                    while (password.length() < 8) {
                        password += ""+ramdom.nextInt(10);
                    }
                }else{
                    for(int i=0;i<3;i++){
                        password += ""+ramdom.nextInt(10);
                    }
                }
                break;
            case "medium":
                password = ""+ramdom.nextInt(10);
                password += capitalize(words[ramdom.nextInt(words.length)]);
                if (password.length() < 12) {
                    while (password.length() < 12) {
                        char novoCaractere = caracteresValidos2.charAt(ramdom.nextInt(tamanho2));
                        System.out.println(novoCaractere);
                        password += novoCaractere;
                    }
                }else{
                    for(int i=0;i<5;i++){
                        password += caracteresValidos2.charAt(ramdom.nextInt(tamanho2));
                    }
                }
                break;
            case "hard":
                for(int i=0;i<16;i++){
                    char novoCaractere = caracteresValidos.charAt(ramdom.nextInt(tamanho));
                    password += novoCaractere;    
                }
                break;
            default:
                break;
            }
        return password;
    }

    public void setDificult(String dificult) {
        this.dificult = dificult;
    }

    private String capitalize(String texto){
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        return texto.substring(0,1).toUpperCase()+ texto.substring(1);
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//class result {
//    String results = new String();
//    void display(){
//        JFrame frame = new JFrame();
//        JPanel panel = new JPanel();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500,500);
//        frame.setVisible(true);
//        frame.setLayout(null);
//        JLabel heading = new JLabel("Result");
//        heading.setBounds(20,20,50,50);
//        panel.add(heading);
//        JLabel res = new JLabel();
//        res.setText(results);
//        res.setBounds(20,25,500,500);
//        panel.add(res);
//        System.out.println("////////////////Results////////////////////////");
//        System.out.println("a" + results);
//    }
//}

class frontend<count> implements ActionListener {
    static JTextArea input = new JTextArea();
    static JTextArea t = new JTextArea();
//    static String results = new String();
    void display() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1300, 1000);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel heading = new JLabel("Scanner");
        heading.setFont(new Font("Serif", Font.PLAIN, 40));
        heading.setBounds(370, 70, 300, 40);
        JLabel name = new JLabel("Haris Mehboob");
        JLabel name2 = new JLabel("Muhammad Shoaib");
        JLabel name3 = new JLabel("Tanzeel Abbas");
        JLabel name4 = new JLabel("Sheryar Ahmed");
        name.setBounds(20, 10, 300, 20);
        name2.setBounds(20, 30, 300, 20);
        name3.setBounds(20, 50, 300, 20);
        name4.setBounds(20,70,300,20);
        panel.add(name);
        panel.add(name2);
        panel.add(name3);
        panel.add(name4);
        panel.add(heading);

        input.setBounds(20, 170, 700, 400);
        input.setFont(new Font("Serif", Font.PLAIN, 20));

        panel.add(input);
        JButton submit = new JButton("Get Tokens");
        submit.setBounds(250, 600, 200, 50);
        panel.add(submit);

        t.setBounds(825,170,400,2000);
        panel.add(t);
        JScrollBar bar = new JScrollBar();
        t.add(bar);

        t.setFont(new Font("Serif", Font.PLAIN, 20));

        JLabel r = new JLabel("Results");
        r.setFont(new Font("Serif", Font.PLAIN, 30));

        panel.add(r);
        r.setBounds(870,70,200,50);
//        frame.getDefaultCloseOperation()
        submit.addActionListener(new frontend());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String tokens = new String();
        System.out.println("Button clicked");
        String data = new String();
        data = input.getText();
        String all = null;
        for (int i = 0; i < data.length(); i++) {
            all = data.strip();

        }
        String[] words = null;
//        System.out.println("Inputed Text is : " + all);
        for (int i = 0; i < all.length(); i++) {
            words = all.split("\\s");
        }int token = 0;
        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
            switch (words[i]){
                case "int", "string", "char" ,"long", "float", "double", "boolean":{
                    token++;
//                    System.out.println("<<Data Type : " + words[i] + " >>");
                    tokens = tokens.concat("<<Data Type>>                   "+words[i]+"\n");


                    break;
                }
                case "1", "2", "3", "4", "5", "6", "7", "8", "9","10":{
                    token++;
//                    System.out.println("<<Number : " + words[i] + " >>");
                    tokens = tokens.concat("<<Number>>                       " +words[i]+"\n");

                    break;
                }
                case "a", "b", "c", "d","e","f","g","h","i","j","k","l","m", "n","o","p","q","r","s","t","u","v","w","x", "y", "z":{
                    token++;
//                    System.out.println("<<identifier : " + words[i] + " >>");
                    tokens = tokens.concat("<<Identifier>>                     " + words[i] + "\n");
                    break;
                }
                case ",", ".", "(", ")", "+", "-", "*", "/", "||", "&&", "!", "?", "=":{
                    token++;
//                    System.out.println("<<Symbol : " + words[i] + " >>");
                    tokens = tokens.concat("<<Symbol>>                        " + words[i] + "\n");
                    break;
                }
                case ";":{
                    token++;
                    tokens = tokens.concat("<<Terminator>>                    " + words[i] + "\n");
                    break;
                }
                case "while", "for", "do":{
                    token++;
                    tokens = tokens.concat("<<Loop>>                        " + words[i] + "\n");
                    break;
                }
                case "if", "else", "goto":{
                    token++;
                    tokens = tokens.concat("<<Conditional Statement>>      " + words[i] + "\n");
                    break;
                }
                default:{
                    token++;
                    tokens = tokens.concat("<<Unidentified token>>         " + words[i] + "\n");
                    break;
                }

            }

            System.out.println(tokens);

        }
        tokens = tokens.concat("\n\nTotal tokens are : " + token);
        t.setText(tokens);
        try {
            FileWriter f2 = new FileWriter("Results.txt",true);
            BufferedWriter b = new BufferedWriter(f2);
            b.write("\n\n\n///////////////////Original code//////////////////\n\n\n\n");
            b.write(data);
            b.write("\n\n\n//////////////////Tokens//////////////////////////\n\n\n\n");
            b.write(tokens);
            b.close();
            f2.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total tokens detected : " + token);
        System.out.println("Results are : "+tokens);
//        System.out.println();
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    frontend f = new frontend();
    f.display();


    }
}

package Automat;

import javax.swing.JOptionPane;

public class Automat {

    static char[] car;
    boolean acept;
    int con;
    static String r;
    String var1 = "String";
    String var2 = "double";
    String var3 = "int";
    String var4 = "char";
    String var5 = "boolean";
    static char[] a;
    String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
    String n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
    String equal = "=";

    public static void main(String[] args) {
        Automat automata = new Automat();
        String w = JOptionPane.showInputDialog("Write");
        r = w.replaceAll("\\s+", "");
        System.out.println(r);
        car = r.toCharArray();
        automata.Ini();
    }

    public void Ini() {
        con = 0;
        Q0();
    }
    public void Q0() {

        acept = false;
        if (r.contains(var1) || r.contains(var2) || r.contains(var3)
           || r.contains(var4) || r.contains(var5)) {
            System.out.println("In q1");
            Q1();

        } else {
            error();
        }
    }

    public void Q1() {
        acept = false;
        if (r.contains(var1)) {
            con = 5;
            if (c.contains(String.valueOf(car[con + 1]))) {
                con++;
                System.out.println("in q2");
                Q2();
            } else {
                error();
            }

        } else if (r.contains(var2)) {
            con = 5;
            if (c.contains(String.valueOf(car[con + 1]))) {
                con++;
                System.out.println("In q2");
                Q2();
            } else {
                error();
            }
        } else if (r.contains(var3)) {
            con = 2;
            if (c.contains(String.valueOf(car[con + 1]))) {
                con++;
                Q2();
            } else {
                error();
            }
        } else if (r.contains(var4)) {
            con = 3;
            if (c.contains(String.valueOf(car[con + 1]))) {
                con++;
                Q2();
            } else {
                error();
            }
        } else if (r.contains(var5)) {
            con = 6;
            if (c.contains(String.valueOf(car[con + 1]))) {
                con++;
                Q2();
            } else {
                error();
            }
        }
        con++;

    }

    public void Q2() {
        try {
          acept = false;
        if (n.contains(String.valueOf(car[con]))) {
            System.out.println("In q2");
            con++;

            Q2();
        } else if(car[con]=='='){
            System.out.println("In q3");
           
            con++;
             Q3();
        } else {
            error();
        } 
        } 
        
        catch (Exception e) {
        }

    }

    public void Q3() {

        acept = true;
        System.out.println("Aceptation");
    }

    public void error() {

        acept = false;
        System.out.println("Error");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcypher;

import java.util.Scanner;

/**
 *
 * @author Ramon Sanchez (chenteuni@gmail.com)
 */
public class CaesarCypher {

    /**
     * @param args the command line arguments
     */
    
    private static String cypherMyString(String msg, int n){
        String cipherString = "";
        
        char a;
        int auxValue;
        int valueLowerA = 97;
        int valueUpperA = 65;
        for(int i=0;i<msg.length();i++){
            // no necesario porque al comprobar si es letra mauscula o miniscula, ya es una letra
                if(Character.isLowerCase(msg.charAt(i))){
                    // Lo pongo para que vaya de 0 a 25 el valor
                    auxValue = msg.charAt(i) - valueLowerA;
                    // Le sumo el valor n y calculo el modulo
                    auxValue = (auxValue + n)%26;
                    // Vuelvo a sumarle lo substraido
                    auxValue = auxValue + valueLowerA;
                    // Lo convierto a char
                    a = (char) (auxValue);
                    cipherString+=a;
                }else if(Character.isUpperCase(msg.charAt(i))){
                    // Lo pongo para que vaya de 0 a 25 el valor
                    auxValue = msg.charAt(i) - valueUpperA;
                    // Le sumo el valor n y calculo el modulo
                    auxValue = (auxValue + n)%26;
                    // Vuelvo a sumarle lo substraido
                    auxValue = auxValue + valueUpperA;
                    // Lo convierto a char
                    a = (char) (auxValue);
                    cipherString+=a;
                }else{
                    cipherString+=msg.charAt(i);
                }
        }
        return cipherString;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce la frase a cifrar: ");
        String msg = sc.nextLine();
        
        System.out.println("Introduce el valor con el que se cifrara la frase: ");
        int n = Integer.parseInt(sc.nextLine());
               
        msg = cypherMyString(msg,n);
        System.out.println(msg);
    }
    
}

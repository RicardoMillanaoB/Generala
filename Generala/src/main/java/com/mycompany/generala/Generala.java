package com.mycompany.generala;

import java.util.Arrays;
import java.util.stream.IntStream;
/**
 *
 * @author Marcelo
 */
public class Generala {

    private static  int[] dice;

    public Generala(int...dice){
        this.dice = dice;
    }

    public static int chance(int...dice) {
        int total = IntStream.of(dice).
                    reduce(0, Integer::sum);
        return total;
    }

    public static int generala(int...dice) {
        int numero = dice[0];

        if(numero * dice.length == chance(dice))
            return 50;

        return 0;
    }

    public static int ones(int...dice) {
        return sumDices(1,dice);
    }

    public static int twos(int...dice) {
        return sumDices(2,dice);
    }

    public static int threes(int...dice) {
        return sumDices(3,dice);
    }

    public int fours() {
        return  sumDices(4);
    }

    public int fives() {
        return sumDices(5);
    }

    public int sixes() {
        return sumDices(6);
    }

    public static int score_pair(int...dice) {
        Arrays.sort(dice);
        int mayor1,mayor2;
        for(int i = dice.length-1; i > 0; i--){
            mayor1 = dice[i];
            mayor2 = dice[i-1];

            if(mayor1 == mayor2)
                return mayor1+mayor2;
        }

        return  0;
    }


    public static int two_pair(int...dice) {
        Arrays.sort(dice);
        int score = 0;
        int parA1, parA2;

        for(int i = 0; i < dice.length-1; i++){
            parA1 = dice[i];
            parA2 = dice[i+1];
            if(parA1 == parA2){
                score+= parA1+parA2;
                i++;
            }
        }
        return  score;
    }

    public static int three_of_a_kind(int...dice) {
        for(int numero : dice)
            if(existen3(numero,dice))
                return numero * 3;

        return 0;
    }

    public static int four_of_a_kind(int...dice) {
        for(int numero : dice)
            if(existen4(numero,dice))
                return numero*4;

        return 0;
    }

    public static int smallStraight(int...dice) {
        Arrays.sort(dice);
        int cont = 0;

        for(int i = 0; i < dice.length;i++){
            cont += dice[i] == (i+1) ? 1 : 0;
        }

        if(cont == 5)
            return 15;
        else
            return 0;
    }

    public static int largeStraight(int...dice) {
        Arrays.sort(dice);
        int cont = 0;

        for(int i = 0; i < dice.length;i++){
            cont += dice[i] == (i+2) ? 1 : 0;
        }

        if(cont == 5)
            return 20;
        else
            return 0;
    }

    public static int fullHouse(int...dice) {
        boolean isTwoOK = two_pair(dice) != 0;
        boolean isThreeOK= three_of_a_kind(dice) != 0;

        if(isTwoOK && isThreeOK){
            return chance(dice);
        }else{
            return 0;
        }
    }
    public static int sumDices(int valor,int...dice){
        int sum = 0;
        for (int numero:dice)
            sum += (numero==valor) ? valor: 0;

        return sum;
    }
    public static int sumDices(int valor){
        int sum = 0;
        for (int numero:dice)
            sum += (numero==valor) ? valor: 0;

        return sum;
    }
    public static boolean existen3(int valor, int...dice){
        int cont = 0;
        for(int numero : dice)
            cont += (numero == valor) ? 1 : 0;

        return cont >= 3;
    }
    public static boolean existen4(int valor, int...dice){
        int cont = 0;
        for(int numero : dice)
            cont += (numero == valor) ? 1 : 0;

        return cont >= 4;
    }

}


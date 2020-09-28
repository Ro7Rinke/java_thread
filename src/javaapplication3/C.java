/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Ro7Rinke
 */
public class C {
    private static int[][] c;
    public static int N;//tamanho da matriz

    public static void setC(int[][] c) {
        C.c = c;
    }
    
    public static synchronized void setSingle(int value, int i, int j){
        C.c[i][j] = value;
    }
    
    public static synchronized int getSingle(int i, int j){
        return C.c[i][j];
    }
    
    public static void print(){
        for(int i = 0; i < C.N; i++){//percoree as linhas da matriz C
            for (int j = 0; j < C.N; j++){//percorre as colunas da matriz C
                System.out.print(C.c[i][j]);//imprime o valor na matriz C correspondente á sua posicao
                System.out.print(" - ");//melhorar a visualizacao no console
            }
            System.out.print("\n");//melhorar a visualizacao no console
        }
    }
}

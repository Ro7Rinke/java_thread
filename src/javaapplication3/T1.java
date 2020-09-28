/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;

/**
 *
 * @author Ro7Rinke
 */
public class T1 implements Runnable {
    
    /*
    essa thread é responsável por calcular o valor da produto e somar 
    com o ja existente na C, ja possui os valores de i, j e k provenientes das 
    threads T2 e T4
    */
    
    ThreadsList tl;
    int[][] A;
    int[][] B;
    int[][]C;
    int k;
    int i;
    int j;

    public T1(ThreadsList tl,int[][] A, int[][] B, int[][] C, int i, int j, int k) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.C = C;
        this.k = k;
        this.i = i;
        this.j = j;
    }
    
    
    @Override
    public void run(){
        C[i][j] = C[i][j] + A[i][k] * B[k][j];
    }
}

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
public class T4 implements Runnable {
    
    /*
    essa thread vai efetivamente popular as matrizes com seus valore inicias
    ja possuindo o valor da coluna e da linha provenientes da thread T5
    */

    ThreadsList tl;
    int[][] A;
    int[][] B;
    int[][] C;
    int i;
    int j;
    int N;

    public T4(ThreadsList tl, int[][] A, int[][] B, int[][] C, int i, int j, int N) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.C = C;
        this.i = i;
        this.j = j;
        this.N = N;
    }

    @Override
    public void run() {
        A[i][j] = i + j;
        B[i][j] = i + j;//popula as matrizes
        C[i][j] = 0;
    }
}

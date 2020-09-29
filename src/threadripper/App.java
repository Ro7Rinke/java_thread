/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadripper;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ro7Rinke
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        o java 64 bits suporta ate 32072 threads 
        caso a thread com Runnable T1 seja eliminada e mantido sua tarefa sincrona o maximo para N sobe
        para um N maior é nescessario alterar o tamnho do espaço para endereçamento ou trabalhar com mais processos java
        */
        boolean autoLoad = true;//para facilitar os testes, esta variavel controla 
        //se os valores das matrizes A e B serao lidos manualmente ou calculados de forma automatica
        
        Scanner sysin = new Scanner(System.in);//ler o tamanho da matrix
        C.N = sysin.nextInt();
        C.setC(new int[C.N][C.N]);
        int[][] A = new int[C.N][C.N];
        int[][] B = new int[C.N][C.N]; //aloca memoria para 3 matrizes com o tamnho lido anteriormente
        
        ThreadsList tl = new ThreadsList(); //instancia do objeto q controla o sincronismo na lista de threads
        //mais explicacoes no classe
        
        if(autoLoad){
            //para popular de forma automatica, é possivel deixar assincrono
            for(int i = 0; i < C.N; i++){//para cada linha cria uma thread responsavel por criar threads para cada posicao, mais explicacoes na classe T5
                Thread localt5 = new Thread(new T5(tl, A, B, i)); //inicia uma thread com uma classe runnable
                localt5.start();//inicia a thread
                tl.add(localt5);//add a thread em uma lista para posteriormente verificar qnts threads ainda estao vivas
            }
            while(tl.verifyAlive()){//metodo q retorna se na lista de trheads possui alguma viva
                //prcurando uma idea mlr de como esperar a conclusao de todas as threads
            }
            tl.setThreads(new ArrayList());//limpa a lista de threads
        }else{
            //para ler valor por valor das matrizes A e B é nescessario ser sincrono
            load(A);
            load(B);
        }
        
        for (int i = 0 ; i < C.N ; i++) {//para cada linha cria uma thread responsavel por criar threads para cada coluna, mais explicacoes na classe T3
            Thread localt3 = new Thread(new T3(tl, A, B, i));//inicia uma thread com uma classe runnable
            localt3.start();//inicia a thread
            tl.add(localt3);//add a thread em uma lista para posteriormente verificar qnts threads ainda estao vivas
//            App.maxThreads++;
//            System.out.println(App.maxThreads);
        } // for-i
        
        while(tl.verifyAlive()){//metodo q retorna se na lista de trheads possui alguma viva
            //prcurando uma idea mlr de como esperar a conclusao de todas as threads
        }
        
        C.print();//imprime a matriz C
        
    }
    
//    public static int maxThreads = 0;
    
    public static boolean performanceMode = true;
    //caso habilitado as threads com Runnable T1 serao desativadas, mantendo o processo delas sincrono
    //o ganho de performance sobe e é possivel q N seja maior
    
    public static void load(int[][] m){
        for(int i = 0; i < C.N; i++){
            for (int j = 0; j < C.N; j++){
                Scanner sysin = new Scanner(System.in);
                m[i][j] = sysin.nextInt();
            }
        }
    }
}

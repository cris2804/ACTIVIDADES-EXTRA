package org.example;
import java.lang.Math;
public class Dado {
    private int numeroCaras;
    public Dado(){
        this.numeroCaras = 6;
    }
    public Dado(int numeroCaras){
        this.numeroCaras = numeroCaras;
    }

//    public int  tirarDado(){
//        return this.generarNumeroAleatorio(1,this.numeroCaras);
//    }
//
//    public int[] tirarDadoNveces(int n){
//       int[]valores = new int[n];
//       for(int valor=0;valor<n;valor++){
//           valores[valor] = generarNumeroAleatorio(1,numeroCaras);
//       }
//       return valores;
//    }
//    private int generarNumeroAleatorio(int minimo,int maximo){
//        return (int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
//    }

}

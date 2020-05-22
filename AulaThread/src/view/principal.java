package view;

import controller.ThreadCalc;

public class principal {
     public static void main(String[] args) {
    //	int a=10;
    //	int b=5;
    //	int op=2;
    	
   // 	ThreadCalc thread=new ThreadCalc(a,b,op)
    	for(int op =0;op <4;op++){
    	int a= (int) (Math.random()*101);
    	int b= (int) (Math.random()*11);
    	
    	Thread thread =new ThreadCalc(a ,b, op);
    	thread.start();
    	}
     }
}

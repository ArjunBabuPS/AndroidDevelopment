package com.example.newnaveen.sudoku;

import java.util.ArrayList;
public class Denomination
{
				
	public static ArrayList findcoins(int c[][],int n,int v,Integer[] d,ArrayList a){
				if(v==0)
					return a;
				else{
					int k=v-d[n];
						if(k>=0&&c[n][v]==1+c[n][k]){
							a.add(d[n]);
							findcoins(c,n,k,d,a);
						}	
					else{
						findcoins(c,n-1,v,d,a);
					}
				}
				return a;
					
	}
  public ArrayList<Integer> Dencalc(Integer d[],int v,int n){
		ArrayList<Integer> a = new ArrayList<Integer>();



		int i,j;
		int[][] c = new int[n][v+1]; 
		for(i=1;i<n;i++){
			c[i][0]=0;
		}
		for(i=0;i<=v;i++){
			c[0][i]=32000;
		}
		for(j=1;j<=v;j++){
			for(i=1;i<n;i++){
				if(i==1&&j<d[i]){
					c[i][j]=32000;
				}else 
					if(i==1){
					   c[i][j]=1+c[i][j-d[i]];
					}else
						if(j<d[i]){
							c[i][j]=c[i-1][j];
						}else{
							c[i][j]=Math.min(c[i-1][j],1+c[i][j-d[i]]);
						}
			}
		}
	  a=findcoins(c,n-1,v,d,a);
	  return a;
  }
}  
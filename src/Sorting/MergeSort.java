package Sorting;

public class MergeSort {
	public void mergeSort(int[] A,int p,int r){
		if(p<r){
			int q = (p+r)/2;
			mergeSort(A,p,q);
			mergeSort(A,q+1,r);
			merge(A,p,q,r);
		}
	}
	public void merge(int[] A,int p,int q,int r){
		int[] B = new int[A.length];
		int i=p,j=q+1,k=0;
		for(;i<=q&&j<=r;){
			if(A[i]<A[j]){
				B[k++] = A[i];
				i++;
			}else{
				B[k++] = A[j];
				j++;
			}
		}
		for(;i<=q;i++)
			B[k++] = A[i];
		for(;j<=r;j++)
			B[k++] = A[j];
		k=0;
		for(int t=p;t<=r;t++)
			A[t] = B[k++];
	}
	public static void main(String[] args){
		int[] test = new int[15];
		for(int i=0;i<15;i++)
			test[i] = (int)(Math.random()*100+1);
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
		System.out.println(" ");
		MergeSort is = new MergeSort();
		is.mergeSort(test,0,test.length-1);
		
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
	}
}

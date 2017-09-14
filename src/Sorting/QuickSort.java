package Sorting;

public class QuickSort {
	public void quickSort(int[] A,int p,int r){
		if(p<r){
			int q = partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q,r);
		}
	}
	public int partition(int[] A,int p,int r){
		int x = A[r];
		int i = p-1;
		for(int j=p;j<r;j++){
			if(A[j]<=x){
				i = i+1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		return i+1;
	}
	public static void main(String[] args){
		int[] test = new int[15];
		for(int i=0;i<15;i++)
			test[i] = (int)(Math.random()*100+1);
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
		System.out.println(" ");
		QuickSort is = new QuickSort();
		is.quickSort(test,0,test.length-1);
		
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
	}
}

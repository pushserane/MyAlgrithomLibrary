package Sorting;
//≤Â»Î≈≈–ÚÀ„∑®
public class InsertionSort {
	public void insertionSort(int[] A){
		int n = A.length;
		int key = A[0];
		for(int j = 1,i = 0;j < n;j++){
			key = A[j];
			i = j - 1;
			while(i >= 0 && A[i] > key){
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key;
		}
	}
	public static void main(String[] args){
		int[] test = new int[15];
		for(int i=0;i<15;i++)
			test[i] = (int)(Math.random()*100+1);
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
		System.out.println(" ");
		InsertionSort is = new InsertionSort();
		is.insertionSort(test);
		
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
	}
}

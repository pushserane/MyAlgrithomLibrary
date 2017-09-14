package Sorting;

public class HeapSort {
	int heap_size;
	/*int MaxLength;
	int[] heapBody;
	
	HeapSort(){
		heapBody = new int[MaxLength];
	}*/
	
	public void heapSort(int[] A){
		buildMaxHeap(A);
	}
	public void buildMaxHeap(int[] A){
		
		heap_size = A.length;
		for(int i = A.length/2;i>=0;i--)
			max_heapify(A,i);
	}
	public void max_heapify(int[] A,int i){
		int l = i*2+1;
		int r = i*2+2;
		int largest = l;
		if(l<heap_size&&A[l]>A[i])
			largest = l;
		else largest = i;
		if(r<heap_size&&A[r]>A[largest])
			largest = r;
		if(largest!=i){
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			max_heapify(A,largest);
		}
	}
	public void getOrder(int[] A){
		int[] B = A;
		int tempHeapSize = heap_size;
		for(int i=0;i<A.length;i++){
			System.out.print(B[0]+",");
			B[0] = B[heap_size-1];
			heap_size--;
			max_heapify(B,0);
		}
		heap_size = tempHeapSize;
	}
	public static void main(String[] args){
		int[] test = new int[15];
		for(int i=0;i<15;i++)
			test[i] = (int)(Math.random()*100+1);
			//test[i]=i+1;
		for(int i=0;i<15;i++)
			System.out.print(test[i]+",");
		System.out.println(" ");
		HeapSort is = new HeapSort();
		is.heapSort(test);
		is.getOrder(test);
	}
}

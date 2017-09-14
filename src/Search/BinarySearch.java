package Search;

public class BinarySearch {
	public int recusionBinarySearch(int[] body,int start,int end,int k){
		if(k>body[end]||k<body[start])return -1;
		if(start > end) return -1;
		int mid = start + (end - start)/2;
		if(body[mid] == k)return mid;
		else if(body[mid] < k){
			start = mid + 1;
		}else{
			end = mid - 1;
		}
		return recusionBinarySearch(body,start,end,k);
	}
	public int binarySearch(int[] body,int k){
		if(k>body[body.length-1]||k<body[0])return -1;
		int start = 0;
		int end = body.length - 1;
		int mid = 0;
		while(start <= end){
			mid = start + (end - start)/2;
			if(body[mid] == k)break;
			else if(body[mid] < k){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		if(body[mid]!=k)return -1;
		return mid;
	}
	public int recusionBinarySearchPosition(int[] body,int start,int end,int k){
		if(start > end) return start;
		int mid = start + (end - start)/2;
		if(body[mid] == k)return mid;
		else if(body[mid] < k){
			start = mid + 1;
		}else{
			end = mid - 1;
		}
		//System.out.println("k="+k+"--start="+start+"--end="+end+"--mid="+mid+"--body[mid]="+body[mid]);
		return recusionBinarySearchPosition(body,start,end,k);
	}
	public int binarySearchPosition(int[] body,int k){
		int start = 0;
		int end = body.length - 1;
		int mid = 0;
		while(start <= end){
			mid = start + (end - start)/2;
			if(body[mid] == k)return mid;
			else if(body[mid] < k){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return start;
	}
	public static void main(String[] args){
		int[] body = new int[100];
		int i=0;
		for(i=0;i<50;i++)
			body[i]=1;
		for(;i<100;i++)
			body[i]=2;
		int k = 2;
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.recusionBinarySearchPosition(body,0,99,k));
		System.out.println(bs.binarySearchPosition(body, k));
	}
}

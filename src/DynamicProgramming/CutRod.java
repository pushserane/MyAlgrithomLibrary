package DynamicProgramming;

public class CutRod {
	public static int minFlag = -10000;
	public static void main(String[] args){
		int[] p = {0,1,5,8,9,10,17,17,20,24,30,31,32,33,34,35};
		for(int i=0;i<=4;i++)
			System.out.println("i="+i+":"+p[i]);
		System.out.println(cutRod(p,10));
		System.out.println(memoizedCutRod(p,10));
		System.out.println(bottomUpCutRod(p,10));
		System.out.println(bottomUpCutRodExtended(p,10));
	}
	//此为钢条切割的递归版本
	public static int cutRod(int[] p,int n){
		if(n == 0)
			return 0;
		int q = minFlag;
		for(int i=1;i<=n;i++){
			q = Math.max(q,p[i]+cutRod(p,n-i));
		}
		return q;
	}
	//带备忘的自顶向下法（top-down with memoization）
	public static int memoizedCutRod(int[] p,int n){
		int[] r = new int[n+1];
		for(int i=0;i<=n;i++)
			r[i]=minFlag;
		return memoizedCutRodAux(p,n,r);
	}
	public static int memoizedCutRodAux(int[] p,int n,int[] r){
		if(r[n]>=0)
			return r[n];
		int q;
		if(n == 0)
			q = 0;
		else{
			q = minFlag;
			for(int i=1;i<=n;i++)
				q = Math.max(q, p[i]+memoizedCutRodAux(p,n-i,r));
		}
		r[n]=q;
		return q;
	}
	//自底向上版本
	public static int bottomUpCutRod(int[] p,int n){
		int[] r = new int[n+1];
		r[0] = 0;
		for(int j=1;j<=n;j++){
			int q = minFlag;
			for(int i=1;i<=j;i++)
				q = Math.max(q, p[i]+r[j-i]);
			r[j] = q;
		}
		return r[n];
	}
	//自底向上带方案版本
	public static int bottomUpCutRodExtended(int[] p,int n){
		int[] r = new int[n+1];
		r[0] = 0;
		int[] s = new int[n+1];
		for(int j=1;j<=n;j++){
			int q = minFlag;
			for(int i=1;i<=j;i++){
				if(q<(p[i]+r[j-i])){
					q = p[i]+r[j-i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		for(int i:s)System.out.print(i+"|");
		System.out.println("");
		return r[n];
	}
}

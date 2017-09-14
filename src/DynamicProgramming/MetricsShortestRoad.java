package DynamicProgramming;

import java.util.Scanner;

public class MetricsShortestRoad {
	public static int[][] juZheng;
	public static int[][] tempJuZheng;
	public static boolean[][] flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hang = sc.nextInt();
        int lie = sc.nextInt();
        juZheng = new int[hang][lie];
        tempJuZheng = new int[hang][lie];
        flag = new boolean[hang][lie];
        for(int i=0,j=0;i<hang;i++)
        	for(j=0;j<lie;j++){
        		juZheng[i][j] =-(i*j+1);//sc.nextInt();
        		tempJuZheng[i][j] = 0;
        		flag[i][j] = false;
        	}
        sc.close();
        long startTime = System.nanoTime();
        System.out.println(0 - getMin(hang-1,lie-1));
        System.out.println(0 - getMinTwo(hang-1,lie-1));
        System.out.println(System.nanoTime() - startTime);
    }
    public static int getMin(int hang,int lie){
    	if(hang == 0&& lie == 0)return juZheng[0][0];
    	if(hang == 0)return getMin(hang,lie-1)+juZheng[hang][lie];
    	else if(lie == 0)return getMin(hang-1,lie)+juZheng[hang][lie];
    	return Math.max(getMin(hang-1,lie)+juZheng[hang][lie],getMin(hang,lie-1)+juZheng[hang][lie]);
    }
    public static int getMinTwo(int hang,int lie){
    	if(!flag[hang][lie]){
    		if(hang == 0&&lie == 0){
        		tempJuZheng[hang][lie] = juZheng[0][0];
        		flag[hang][lie] = true;
        		return tempJuZheng[hang][lie];
        	}
    		if(hang == 0){
        		tempJuZheng[hang][lie] = getMinTwo(hang,lie-1) + juZheng[hang][lie];
        		flag[hang][lie] = true;
        		return tempJuZheng[hang][lie];
        	}else if(lie == 0){
        		tempJuZheng[hang][lie] = getMinTwo(hang-1,lie) + juZheng[hang][lie];
        		flag[hang][lie] = true;
        		return tempJuZheng[hang][lie];
        	}
        	tempJuZheng[hang][lie] = Math.max(getMinTwo(hang-1,lie)+juZheng[hang][lie],getMinTwo(hang,lie-1)+juZheng[hang][lie]);
        	flag[hang][lie] = true;
		}
    	return tempJuZheng[hang][lie];
    }
}
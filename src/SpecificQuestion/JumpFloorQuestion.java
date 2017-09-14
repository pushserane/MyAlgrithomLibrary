package SpecificQuestion;

public class JumpFloorQuestion {
	
	public long JumpFloor(int target){
		long[][] jumpTable = new long[target+1][2];
		return jumpFloor1(target,jumpTable) + jumpFloor2(target,jumpTable);
	}
	public static long jumpFloor1(int target,long[][] jumpTable){
		if(target == 1){
			jumpTable[target][0] = 1;
			return 1;
		}
		if(jumpTable[target][0]==0){
			jumpTable[target][0] = jumpFloor1(target-1,jumpTable) + jumpFloor2(target-1,jumpTable);
		}
		return jumpTable[target][0];
	}
	public static long jumpFloor2(int target,long[][] jumpTable){
		if(target == 1){
			jumpTable[target][1] = 0;
			return 0;
		}
		if(jumpTable[target][1]==0){
			jumpTable[target][1] = jumpFloor1(target-1,jumpTable);
		}
		return jumpTable[target][1];
	}
	public int JumpFloor2(int target){
		int a1 = 1;
		int a2 = 0;
		int temp = a2;
		while(target > 1){
			a2 = a1;
			a1 = a1 + temp;
			temp = a2;
			target--;
			//System.out.println("a1="+a1+" a2="+a2+" target="+target);
		}
		return a1+a2;
	}
	public static void main(String[] args){
		long start1 = System.nanoTime();
		int target = 44;
		JumpFloorQuestion jq = new JumpFloorQuestion();
		System.out.println(jq.JumpFloor(target));
		long start2 = System.nanoTime();
		System.out.println("start1 = " + (start2 - start1));
		System.out.println(jq.JumpFloor2(target));
		System.out.println("start2 = " + (System.nanoTime() - start2));
	}
}

package SpecificQuestion;

public class MonkeyKing {
	static int MonkeyNum = 100000;
	public static void main(String[] args){
		long startTime = System.nanoTime();
		///通过数组计算
		int[] monkeys = new int[MonkeyNum];
		for(int i=0;i<MonkeyNum;i++){
			monkeys[i]=0;
		}
		
		System.out.println("Array:"+getLeftByArray(monkeys));
		long midTime = System.nanoTime();
		System.out.println((midTime-startTime)/1000000.0);
		///通过链表计算
		int monkeyId = 1;
		MonkeyNode head = new MonkeyNode(monkeyId);
		MonkeyNode temp = head;
		for(int i=1;i<MonkeyNum;i++){
			monkeyId++;
			MonkeyNode next = new MonkeyNode(monkeyId);
			temp.nextMonkey = next;
			temp = next;
		}
		temp.nextMonkey = head;
		System.out.println("Link:"+getLeftByLink(head));
		System.out.println((System.nanoTime()-midTime)/1000000.0);
	}
	public static int getLeftByArray(int[] monkeys){
		int count = MonkeyNum;
		int index = 0;
		int tempCount = 0;
		while(count > 1){
			if(monkeys[index]==0){
				tempCount++;
				if(tempCount==3){
					monkeys[index]=1;
					count --;
					//System.out.println("Count:"+count);
					tempCount=0;
				}
				index += 1;
				index=index%MonkeyNum;
			}else{
				index += 1;
				index=index%MonkeyNum;
			}
		}
		for(int i=0;i<MonkeyNum;i++){
			if(monkeys[i]==0){
				return i+1;
			}
		}
		return 0;
	}
	public static int getLeftByLink(MonkeyNode head){
		MonkeyNode temp = head.nextMonkey;
		
		int tempCount = 2;
		while(head!=temp){
			if(tempCount==3){
				head.nextMonkey = temp.nextMonkey;
				temp = head.nextMonkey;
				tempCount = 1;
			}else{
				head = head.nextMonkey;
				temp = temp.nextMonkey;
				tempCount++;
			}
		}
		return head.monkeyId;
	}
}
class MonkeyNode{
	int monkeyId;
	MonkeyNode nextMonkey;
	MonkeyNode(int id){
		this.monkeyId = id;
	}
	MonkeyNode(){
		
	}
}
package HeapStack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	
	public List<T> stackBody;
	
	Stack(){
		stackBody = new ArrayList<T>();
	}
	
	public T pop(){
		return (T) stackBody.remove(stackBody.size()-1);
	}
	public void push(T elem){
		stackBody.add(elem);
	}
	public void showAll(){
		for(T elem:stackBody)
			System.out.print(elem+",");
	}
	public int size(){
		return stackBody.size();
	}
	public void clear(){
		stackBody.removeAll(stackBody);
	}
	public T peek(){
		return stackBody.get(stackBody.size()-1);
	}
	public static void main(String[] args){
		int length = 100;
		Stack<Integer> test = new Stack<Integer>();
		for(int i=0;i<length;i++){
			test.push((int)(Math.random()*1000));
		}
		test.showAll();
	}
}

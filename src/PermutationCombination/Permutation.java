package PermutationCombination;

public class Permutation {
	static int totalN = 3;
	
	public static void main(String[] args){
		DivideTreeNode[] head = new DivideTreeNode[totalN];
		int[] elements = new int[totalN];
		for(int i=0;i<totalN;i++)
			elements[i]=i+1;
		for(int i=0;i<totalN;i++){
			head[i] = new DivideTreeNode(elements[i],elements);
		}
		for(int i=0;i<totalN;i++)
			head[i].printNode("");
		
	}
}
class DivideTreeNode{
	int value;
	DivideTreeNode[] childNode;
	int[] leftSet;
	DivideTreeNode(){}
	DivideTreeNode(int value,int[] set){
		this.value = value;
		this.leftSet = getLeftSet(value,set);
		this.childNode = new DivideTreeNode[set.length-1];
		for(int i=0;i<set.length-1;i++){
			childNode[i] = new DivideTreeNode(leftSet[i],leftSet);
		}
	}
	public static int[] getLeftSet(int value,int[] set){
		int[] leftSet = new int[set.length-1];
		int k = 0;
		for(int i=0;i<set.length;i++){
			if(set[i]!=value)leftSet[k++]=set[i];
		}
		return leftSet;
	}
	public void printNode(String temp){
		System.out.println(temp+this.value);
		temp += "  ";
		if(childNode.length!=0)
			for(DivideTreeNode i:childNode){
				i.printNode(temp);
			}
	}
}
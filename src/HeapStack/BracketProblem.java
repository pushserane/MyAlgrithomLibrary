package HeapStack;

import java.util.ArrayList;

public class BracketProblem {
	
	public String questionString;
	public TreeNode root;
	public Stack<String> stackS;
	public ArrayList<String> questionStringList = new ArrayList<String>();
	int[] flag;
	//符号设置
	public final char CPlus = '+';
	public final char CMinus = '-';
	public final char CMultiply = '*';
	public final char CDivide = '/';
	
	public final String SPlus = "+";
	public final String SMinus = "-";
	public final String SMultiply = "*";
	public final String SDivide = "/";
	
	BracketProblem(String questionString){
		this.questionString = questionString;
		stackS = new Stack<String>();
		if(!this.getStringList(this.questionString))System.out.println("illegal element error");
		//for(int i=0;i<questionStringList.size();i++)
			//System.out.print(questionStringList.get(i)+"   ");
		flag = new int[this.questionStringList.size()];
	}
	
	public boolean isLegal(){
		stackS.clear();
		int stackHigh = 0;;
		int index = 0;
		for(String elem : questionStringList){
			String outElem;
			switch(elem){
			case SPlus:flag[index++]=stackHigh;break;
			case SMinus:flag[index++]=stackHigh;break;
			case SMultiply:flag[index++]=stackHigh;break;
			case SDivide:flag[index++]=stackHigh;break;
			case "{":
			case "[":
			case "(":
				stackHigh++;
				flag[index++]=stackHigh;
				stackS.push(elem);
				break;
			case "}":
				if(stackS.size()==0)return false;
				outElem = stackS.pop();
				if(outElem.equals("{")){
				flag[index++]=stackHigh;stackHigh--;break;}
				else return false;
			case "]":
				if(stackS.size()==0)return false;
				outElem = stackS.pop();
				if(outElem.equals("[")){
				flag[index++]=stackHigh;stackHigh--;break;}
				else return false;
			case ")":
				if(stackS.size()==0)return false;
				outElem = stackS.pop();
				if(outElem.equals("(")){
				flag[index++]=stackHigh;stackHigh--;break;}
				else return false;
			default:
				if(!Character.isDigit(elem.charAt(0)))return false;
				flag[index++]=stackHigh;
				break;
			}
		}
		if(stackS.size()!=0)return false;
		for(int i=0;i<questionStringList.size();i++)
			switch(questionStringList.get(i)){
				case "{":
				case "[":questionStringList.set(i, "(");break;
				case "}":
				case "]":questionStringList.set(i, ")");break;
			}
		return true;
	}
	public boolean getStringList(String questionString){
		boolean ifDigit = false;
		for(char elem:questionString.toCharArray()){
			//System.out.println(elem);
			//System.out.println(questionStringList);
			if(Character.isDigit(elem)){
				if(ifDigit){
					int temp = Integer.parseInt(questionStringList.remove(questionStringList.size()-1));
					questionStringList.add(String.valueOf(temp*10+elem-48));
				}else{
					questionStringList.add(String.valueOf(elem));
					ifDigit = true;
				}
			}else{
				ifDigit = false;
				if(elem!='+'&&elem!='-'&&elem!='*'&&elem!='/'&&elem!='{'&&elem!='}'&&elem!='['&&elem!=']'&&elem!='('&&elem!=')')return false;
				questionStringList.add(String.valueOf(elem));
			}
		}
		return true;
	}
	public boolean getStringList2(String questionString){
		boolean isSign = true;
		for(int i=0;i<questionString.length();i++){
			if(elemIsSign(questionString.charAt(i))){
				if(isSign){
					if(questionString.charAt(i)=='-'){
						
					}else{
						return false;
					}
				}
				isSign = true;
			}else{
				isSign = false;
			}
		}
		
		return true;
	}
	public boolean elemIsSign(char elem){
		if(elem=='+'||elem=='-'||elem=='*'||elem=='/'||elem=='{'||elem=='}'||elem=='['||elem==']'&&elem=='('&&elem==')')
			return true;
		else if(elem=='.'||Character.isDigit(elem))
			return false;
		else System.out.println("input error");
		return false;
	}

	//四则运算算法
	public double getValue(){
		ArrayList<String> postList = getPostList();
		System.out.println(postList);
		ArrayList<Double> outList = new ArrayList<Double>();
		double d1 = 0,d2 =0,d = 0;
		for(String temp : postList){
			if(Character.isDigit(temp.charAt(0))){
				outList.add(Double.valueOf(temp));
			}else{
				d1 = outList.remove(outList.size()-1);
				d2 = outList.remove(outList.size()-1);
				switch(temp){
					case SPlus:
						outList.add(d1+d2);
						break;
					case SMinus:
						outList.add(d2-d1);
						break;
					case SMultiply:
						outList.add(d1*d2);
						break;
					case SDivide:
						outList.add(d2/d1);
						break;
					default:
						System.out.println("error");break;
				}
			}
		}
		if(outList.size()!=1){
			System.out.println("error");
			return 0;
		}
		return outList.get(0);
	}
	public ArrayList<String> getPostList(){
		ArrayList<String> inList = questionStringList;
		ArrayList<String> postList = new ArrayList<String>();
		Stack tempStack = new Stack<String>();
		tempStack.push("#");
		inList.add("#");
		String topSign = null;
		String sign = null;
		while(tempStack.size()!=0&&inList.size()!=0){
			topSign = (String)tempStack.peek();
			if(Character.isDigit(inList.get(0).charAt(0))){
				postList.add(inList.remove(0));
			}else{
				sign = inList.get(0);
				if(">".equals(getPriority(topSign, sign))) {
					postList.add((String) tempStack.pop());
                } else if("<".equals(getPriority(topSign, sign))) {  
                    tempStack.push(sign);  
                    inList.remove(0);  
                } else if("=".equals(getPriority(topSign, sign))&& topSign.equals("#")) {  
                    break;  
                } else if(sign.equals(")")) {  
                    if("=".equals(getPriority(topSign, sign)) && topSign.equals("(")) {  
                        tempStack.pop();  
                        inList.remove(0);  
                    } else {  
                        while(">".equals(getPriority(topSign, sign))) {  
                        	postList.add((String) tempStack.pop());
                            topSign = (String)tempStack.peek();  
                        }  
                    }  
                } else {  
                    try {  
                        throw new Exception("算术表达式错误！");  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                }
			}
				
		}
		return postList;
	}
	public String getPriority(String op1,String op2){
		String[][] signMap = new String[][]{{">",">","<","<","<",">",">"},
				{">",">","<","<","<",">",">"},
				{">",">",">",">","<",">",">"},
				{">",">",">",">","<",">",">"},
				{"<","<","<","<","<","=","$"},
				{">",">",">",">","$",">",">"},
				{"<","<","<","<","<","$","="}};
		int op1Num = 0,op2Num = 0;
		switch(op1){
			case "+":op1Num = 0;break;
			case "-":op1Num = 1;break;
			case "*":op1Num = 2;break;
			case "/":op1Num = 3;break;
			case "(":op1Num = 4;break;
			case ")":op1Num = 5;break;
			case "#":op1Num = 6;break;
		}
		switch(op2){
		case "+":op2Num = 0;break;
		case "-":op2Num = 1;break;
		case "*":op2Num = 2;break;
		case "/":op2Num = 3;break;
		case "(":op2Num = 4;break;
		case ")":op2Num = 5;break;
		case "#":op2Num = 6;break;
		}
		return signMap[op1Num][op2Num];
	}
	
	public static void main(String[] args){
		String questionString = "{(1+2*5)*(2/4)+56}/5";
		//String questionString = "11+12*5";
		BracketProblem question1 = new BracketProblem(questionString);
		if(question1.isLegal()){
			//question1.setTree(question1.root,0,question1.questionStringList.size()-1);
			System.out.println(question1.questionStringList);
			for(int i:question1.flag)
				System.out.print(i+",");
			System.out.println("");
			System.out.println(question1.getValue());
		}else{
			System.out.println("Error!");
		}
	}
}
class TreeNode {
	String key;
	TreeNode left;
	TreeNode right;
}

package StringCalculation;

public class StringHuiWen {
	public static boolean isHuiWen(String str){
    	StringBuffer sb = new StringBuffer(str);  
    	sb.reverse();// ½«StrÖÐµÄ×Ö·û´®µ¹ÖÃ  
    	int count = 0;  
    	for (int i = 0; i < str.length(); i++) {  
    		if (str.charAt(i) == sb.charAt(i)) {  
    	            count++;  
    	        }  
    	    }  
    	    if (count == str.length()) {  
    	        return true;
    	    } else {  
    	        return false;
    	    }  
    }
}

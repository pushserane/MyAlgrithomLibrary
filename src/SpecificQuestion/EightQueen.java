package SpecificQuestion;
/***
 * @author Serane
 * d1d2¡­¡­d8 is a sequence
 * d1 is column position the first queen 
 * A < B : A(d1d2...d8) < B(d1d2...d8)
 */
public class EightQueen {
	static int[][] queenPlaces = new int[92][8];
	static int[][] board = new int[8][8];
	static int count = 0;
	public static void main(String[] args){
		//initiation
		for(int i=0,j=0;i<8;i++){
			for(j=0;j<8;j++)
				board[i][j] = -1;
			for(j=0;j<92;j++)
				queenPlaces[j][i] = 0;
		}
		putQueen(0);
		for(int i=0;i<92;i++){
			for(int j=0;j<8;j++)
				System.out.print(queenPlaces[i][j]);
			System.out.println("");
		}
	}
	public static void putQueen(int ithQueen){
		if(ithQueen == 8){
			count ++;
			return;
		}
		for(int i=0;i<8;i++){
			if(board[i][ithQueen] == -1){
				board[i][ithQueen] = ithQueen;
			
				for(int k=count;k<92;k++){
					queenPlaces[k][ithQueen]=i+1;
				}
				setLimit(i,ithQueen);
				putQueen(ithQueen+1);
				unsetLimit(ithQueen);
			}
		}
	}
	public static void setLimit(int i,int ithQueen){
		for(int k=0;k<8;k++)
			for(int r=0;r<8;r++)
				if(board[k][r]==-1&&(k==i||r==ithQueen||Math.abs(k-i)==Math.abs(r-ithQueen)))
					board[k][r] = ithQueen;
	}
	public static void unsetLimit(int ithQueen){
		for(int k=0;k<8;k++)
			for(int r=0;r<8;r++)
				if(board[k][r]==ithQueen)
					board[k][r] = -1;
	}
}

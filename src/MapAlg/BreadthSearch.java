package MapAlg;

import java.util.ArrayList;

public class BreadthSearch {
	AdjacencyTable adjacencyTable;
	BreadthSearch(AdjacencyTable testTable1){
		this.adjacencyTable = testTable1;
	}
	
	
	
	public static void main(String[] args){
		ArrayList<Character> pointList = new ArrayList<Character>();
		int pointNum = 6;
		for(int i=0;i<pointNum;i++)
			pointList.add((char)('a'+i));
		int[][] mapTable = new int[pointNum][pointNum];
		for(int i=0,j=0;i<pointNum;i++)
			for(j=0;j<pointNum;j++)
				mapTable[i][j]=AdjacencyTable.INFINITY;
		mapTable[0][1]=1;
		mapTable[0][3]=1;
		mapTable[0][5]=1;
		mapTable[1][2]=1;
		mapTable[1][4]=1;
		AdjacencyTable testTable1 = new AdjacencyTable(pointList,mapTable);
		BreadthSearch bs = new BreadthSearch(testTable1);
	}
}

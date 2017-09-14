package MapAlg;

import java.util.ArrayList;

public class AdjacencyTable<T> {
	public static int INFINITY = 100000;
	
	ArrayList<T> pointList;
	int[][] mapTable;
	AdjacencyTable(){
		
	}
	AdjacencyTable(ArrayList<T> pointList,int[][] mapTable){
		this.pointList = pointList;
		//int size = pointList.size();
		this.mapTable = mapTable;
	}
	public T getPoint(int index){
		if(index>=pointList.size()) return null;
		return pointList.get(index);
	}
	public void setPointList(ArrayList<T> pointList){
		this.pointList = pointList;
	}
	public boolean setPoint(int index,T point){
		if(index>=pointList.size()) return false;
		pointList.set(index, point);
		return true;
	}
	public boolean haveEdge(int start,int end){
		return !(mapTable[start][end]==INFINITY);
	}
	public boolean haveEdge(T startPoint,T endPoint){
		return !(mapTable[getIndex(startPoint)][getIndex(endPoint)]==INFINITY);
	}
	public int getIndex(T point){
		if(isExist(point)){
			for(int i=0;i<pointList.size();i++)
				if(pointList.get(i).equals(point))
					return i;
		}
		return -1;
	}
	public boolean isExist(T point){
		return pointList.contains(point);
	}
}

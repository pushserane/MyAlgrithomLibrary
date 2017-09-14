package Tree;

public class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	public TreeNode(){
		
	}
	public TreeNode(int value){
		this.key = value;
	}
	public void preorderSearch(){
		preorderSearch(this);
	}
	public void preorderSearch(TreeNode x){
		if(x!=null){
			System.out.print(x.key+"|");
			preorderSearch(x.left);
			preorderSearch(x.right);
		}
	}
	public void inorderSearch(){
		inorderSearch(this);
	}
	public void inorderSearch(TreeNode x){
		if(x!=null){
			inorderSearch(x.left);
			System.out.print(x.key+"|");
			inorderSearch(x.right);
		}
	}
	public void postorderSearch(){
		postorderSearch(this);
	}
	public void postorderSearch(TreeNode x){
		if(x!=null){
			postorderSearch(x.left);
			postorderSearch(x.right);
			System.out.print(x.key+"|");
		}
	}
	
	public void insertNode(TreeNode root,TreeNode point){
		root.insertNode(point);
	}
	public TreeNode findNode(TreeNode root,int key){
		TreeNode result = root;
		if(root == null || root.key==key)
			return result;
		if(key<root.key)return findNode(root.left,key);
		return findNode(root.right,key);
	}
	public void insertNode(TreeNode point){
		if(this.key == point.key)return;
		TreeNode y = null;
		TreeNode x = this;
		while(x!=null){
			y = x;
			if(point.key == x.key)return;
			else if(point.key < x.key) x = x.left;
			else x = x.right;
		}
		point.parent = y;
		if(point.key < y.key)y.left = point;
		else y.right = point;
	}
	public void deleteNode(TreeNode root,TreeNode point){
		if(point.left == null)
			Transplant(root,point,point.right);
		else if(point.right == null)
			Transplant(root,point,point.left);
		else {
			TreeNode y = null;
			y = Minimum(point.right);
			if(y.parent != point){
				Transplant(root,y,y.right);
				y.right = point.right;
				y.right.parent = y;
			}
			Transplant(root,point,y);
			y.left = point.left;
			y.left.parent = y;
		}
		
	}
	public void Transplant(TreeNode root,TreeNode u,TreeNode v){
		if(u.parent == null)
			root = v;
		else if(u==u.parent.left)
			u.parent.left = v;
		else u.parent.right = v;
		if(v!=null)
			v.parent = u.parent;
	}
	
	public TreeNode Minimum(TreeNode x){
		while(x.left != null)
			x= x.left;
		return x;
	}
	public TreeNode Maximum(TreeNode x){
		while(x.right != null)
			x = x.right;
		return x;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		for(int i=0;i<10;i++){
			root.insertNode(new TreeNode((int)(Math.random()*100)));
		}
		root.preorderSearch();
		System.out.println("");
		//root.inorderSearch();
		//System.out.println("");
		//root.postorderSearch();
		int temp = (int)(Math.random()*80);
		System.out.println(temp);
		root.insertNode(new TreeNode(temp));
		root.preorderSearch();
		System.out.println("");
		TreeNode tempNode = root.findNode(root,temp);
		System.out.println("finded"+tempNode.key);
		root.deleteNode(root,tempNode);
		root.preorderSearch();
		System.out.println("");
	}
}

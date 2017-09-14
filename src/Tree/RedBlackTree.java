package Tree;

public class RedBlackTree {
	private static final RBNode NIL = new RBNode();
	RedBlackTree(){
		NIL.color = RBNode.myColor.BLACK;
		//NIL.key = -1;
	}
	
	RBNode root;
	public static void main(String[] args){
		RedBlackTree T = new RedBlackTree();
		T.root = NIL;
		
		/*for(int i=0;i<10;i++){
			RBNode temp = new RBNode((int)(Math.random()*100));
			System.out.println(temp.key+"|"+temp.color); 
			T.insertNode(T,temp);
			
			T.preorderSearch();
			System.out.println("");
		}*/
		RBNode temp = new RBNode(4);
		System.out.println(temp.key+"|"+temp.color); 
		T.insertNode(T,temp);
		T.preorderSearch();
		System.out.println("");
		
		temp = new RBNode(8);
		System.out.println(temp.key+"|"+temp.color); 
		T.insertNode(T,temp);
		T.preorderSearch();
		System.out.println("");
		
		temp = new RBNode(77);
		System.out.println(temp.key+"|"+temp.color); 
		T.insertNode(T,temp);
		T.preorderSearch();
		System.out.println("");
		
		temp = new RBNode(15);
		System.out.println(temp.key+"|"+temp.color); 
		T.insertNode(T,temp);
		T.preorderSearch();
		System.out.println("");
		
		temp = T.findNode(T.root,0);
		System.out.println(temp.key+"|"+temp.color); 
		T.RBDelete(T, temp);
		T.preorderSearch();
		System.out.println("");
		
		T.preorderSearch();
		System.out.println("");
		
	}
	public RBNode findNode(RBNode root,int key){
		RBNode result = root;
		if(root == NIL || root.key == key)
			return result;
		if(key<root.key)return findNode(root.left,key);
		return findNode(root.right,key);
	}
	//先序搜索：父、左、右
	public void preorderSearch(){
		preorderSearch(this.root);
	}
	public void preorderSearch(RBNode x){
		if(x!=null){
			System.out.print(x.key+"|"+x.color+"|"); 
			preorderSearch(x.left);
			preorderSearch(x.right);
		}
	}
	//中序搜索：左、父、右
	public void inorderSearch(){
		inorderSearch(this.root);
	}
	public void inorderSearch(RBNode x){
		if(x!=null){
			inorderSearch(x.left);
			System.out.print(x.key+"|");
			inorderSearch(x.right);
		}
	}
	//后序搜索：左、右、父、
	public void postorderSearch(){
		postorderSearch(this.root);
	}
	public void postorderSearch(RBNode x){
		if(x!=null){
			postorderSearch(x.left);
			postorderSearch(x.right);
			System.out.print(x.key+"|");
		}
	}
	//插入节点
	public void insertNode(RedBlackTree T,RBNode z){
		RBNode y = NIL;
		RBNode x = T.root;
		while(x != NIL){
			y = x;
			if(z.key == x.key)return;
			else if(z.key < x.key)
				x = x.left;
			else x = x.right;
		}
		z.parent = y;
		if(y == NIL)
			T.root = z;
		else if(z.key < y.key)
			y.left = z;
		else y.right = z;
		z.left = NIL;
		z.right = NIL;
		z.color = RBNode.myColor.RED;
		insertFixup(T,z);
	}
	public void insertFixup(RedBlackTree T,RBNode z){//没有考虑为空情况，需要重新实现
		//System.out.println(z.parent.color);
		//T.preorderSearch();
		//System.out.println("");
		while(z.parent.color == RBNode.myColor.RED){
			if(z.parent == z.parent.parent.left){
				RBNode y = z.parent.parent.right;
				if(y.color == RBNode.myColor.RED){
					z.parent.color = RBNode.myColor.BLACK;
					y.color = RBNode.myColor.BLACK;
					z.parent.parent.color = RBNode.myColor.RED;
					z = z.parent.parent;
					continue;
				}else if(z == z.parent.right){
					z = z.parent;
					leftRotate(T,z);
					continue;
				}
				z.parent.color = RBNode.myColor.BLACK;
				z.parent.parent.color = RBNode.myColor.RED;
				//T.preorderSearch();
				//System.out.println("1"+"||"+z.key);
				rightRotate(T,z.parent.parent);
				//T.preorderSearch();
				//System.out.println("2");
			}else{
				RBNode y = z.parent.parent.left;
				if(y.color == RBNode.myColor.RED){
					z.parent.color = RBNode.myColor.BLACK;
					y.color = RBNode.myColor.BLACK;
					z.parent.parent.color = RBNode.myColor.RED;
					z = z.parent.parent;
					continue;
				}else if(z == z.parent.left){
					z = z.parent;
					rightRotate(T,z);
					continue;
				}
				z.parent.color = RBNode.myColor.BLACK;
				z.parent.parent.color = RBNode.myColor.RED;
				leftRotate(T,z.parent.parent);	
			}
		}
		T.root.color = RBNode.myColor.BLACK;
		//T.preorderSearch();
		//System.out.println("");
	}
	
	//左右旋转
	public void leftRotate(RedBlackTree T,RBNode x){
		RBNode y = x.right;
		x.right = y.left;
		if(y.left != NIL)
			y.left.parent = x;
		y.parent = x.parent;
		if(x.parent == NIL)
			T.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else x.parent.right = y;
		y.left = x;
		x.parent = y;
	}
	public void rightRotate(RedBlackTree T,RBNode x){
		//T.preorderSearch();
		//T.inorderSearch();
		//System.out.println("3"+"||"+x.key);
		RBNode y = x.left;
		x.left = y.right;
		if(y.right != NIL)
			y.right.parent = x;
		y.parent = x.parent;
		if(x.parent == NIL)
			T.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else x.parent.right = y;
		y.right = x;
		x.parent = y;
		//T.preorderSearch();
		//T.inorderSearch();
		//System.out.println("4");
	}
	//删除节点
	public RBNode Minimum(RBNode x){
		while(x.left != null)
			x= x.left;
		return x;
	}
	public RBNode Maximum(RBNode x){
		while(x.right != null)
			x = x.right;
		return x;
	}
	public void RBTransplant(RedBlackTree T,RBNode u,RBNode v){
		if(u.parent == NIL)
			T.root = v;
		else if(u == u.parent.left)
			u.parent.left = v;
		else u.parent.right = v;
		v.parent = u.parent;
	}
	public void RBDelete(RedBlackTree T,RBNode z){
		if(z==NIL)return;
		RBNode y = z;
		RBNode.myColor yOriginalColor = y.color;
		RBNode x;
		if(z.left == NIL){
			x = z.right;
			RBTransplant(T,z,z.right);
		}else if(z.right == NIL){
			x = z.left;
			RBTransplant(T,z,z.left);
		}else{
			y = Minimum(z.right);
			yOriginalColor = y.color;
			x = y.right;
			if(y.parent == z){
				x.parent = y;
			}else{
				RBTransplant(T,y,y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			RBTransplant(T,z,y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if(yOriginalColor == RBNode.myColor.BLACK)
			RBDeleteFixup(T,x);
	}
	public void RBDeleteFixup(RedBlackTree T,RBNode x){
		while(x!=T.root && x.color == RBNode.myColor.BLACK){
			if(x == x.parent.left){
				RBNode w = x.parent.right;
				if(w.color == RBNode.myColor.RED){
					w.color = RBNode.myColor.BLACK;
					x.parent.color = RBNode.myColor.RED;
					leftRotate(T,x.parent);
					w = x.parent.right;
				}
				if(w.left.color == RBNode.myColor.BLACK && w.right.color == RBNode.myColor.BLACK){
					w.color = RBNode.myColor.RED;
					x = x.parent;
				}else if(w.right.color == RBNode.myColor.BLACK){
					w.left.color = RBNode.myColor.BLACK;
					w.color = RBNode.myColor.RED;
					rightRotate(T,w);
					w = x.parent.right;
				}
				w.color = x.parent.color;
				x.parent.color = RBNode.myColor.BLACK;
				w.right.color =RBNode.myColor.BLACK;
				leftRotate(T,x.parent);
				x = T.root;
			}else{
				RBNode w = x.parent.left;
				if(w.color == RBNode.myColor.RED){
					w.color = RBNode.myColor.BLACK;
					x.parent.color = RBNode.myColor.RED;
					rightRotate(T,x.parent);
					w = x.parent.left;
				}
				if(w.left.color == RBNode.myColor.BLACK && w.right.color == RBNode.myColor.BLACK){
					w.color = RBNode.myColor.RED;
					x = x.parent;
				}else if(w.left.color == RBNode.myColor.BLACK){
					w.right.color = RBNode.myColor.BLACK;
					w.color = RBNode.myColor.RED;
					leftRotate(T,w);
					w = x.parent.left;
				}
				w.color = x.parent.color;
				x.parent.color = RBNode.myColor.BLACK;
				w.left.color =RBNode.myColor.BLACK;
				rightRotate(T,x.parent);
				x = T.root;
			}
		}
		x.color = RBNode.myColor.BLACK;
	}
}
class RBNode{
	RBNode left;
	RBNode right;
	RBNode parent;
	myColor color;
	int key;
	RBNode(int key){
		this.key = key;
	}
	RBNode(){}
	enum myColor{RED,BLACK;}
}

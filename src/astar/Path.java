package astar;

import java.util.ArrayList;

public class Path {

	private ArrayList<Node> pathNodes = new ArrayList<Node>();
	
	public void addNodeToPath(Node node){
		pathNodes.add(node);
	}
	
	 public void addNodeToFirstIndexPath(Node n) {
		 pathNodes.add(0, n);
	 }

	public Node getPathNode(int i) {
		return pathNodes.get(i);
	}
	
	public boolean contains(int x, int y){
		for(Node node: pathNodes){
			if(node.getX() == x && node.getY() ==y)
				return true;
		}
		
		return false;
	}
	
	public int getX(int i) {
        return getPathNode(i).getX();
	}


	 
}

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
	
	public boolean contains(float f, float g){
		for(Node node: pathNodes){
			if(node.getX() == f && node.getY() ==g)
				return true;
		}
		
		return false;
	}

	public ArrayList<Node> getPathNodes() {
		return pathNodes;
	}

	public void setPathNodes(ArrayList<Node> pathNodes) {
		this.pathNodes = pathNodes;
	}

	

	 
}

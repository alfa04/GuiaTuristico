package aStar;

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
	
	public int getSize(){
		return this.pathNodes.size();
	}
	

	public void printPath() {
		
		ArrayList<Node> pathNodes = new ArrayList<Node>();
		pathNodes = this.getPathNodes();
		
		for(int i = 0; i < pathNodes.size(); i++){
			
			System.out.print(pathNodes.get(i).getName());
			if(i != this.getPathNodes().size()-1)
				System.out.print(" --> ");
			else
				System.out.print("\n\n");
		}

    }


	 
}

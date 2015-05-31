package astar;

public class Distance {

	
	public Distance(){
		
	}
	
	public float distanceBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getY()-currentNode.getY())+
				(targetNode.getX()-currentNode.getX())*(targetNode.getY()-currentNode.getY()));
		return toReturn;
	}
	
}

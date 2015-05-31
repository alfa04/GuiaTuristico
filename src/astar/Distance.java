package astar;

public class Distance {

	
	public Distance(){
		
	}
	
	public float distanceBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX())+
				(targetNode.getY()-currentNode.getY())*(targetNode.getY()-currentNode.getY()));
		return toReturn;
	}
	
	public float timeBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX())+
				(targetNode.getY()-currentNode.getY())*(targetNode.getY()-currentNode.getY()));
		return (float) ((toReturn/1.4)/60.0);
	}
	
}

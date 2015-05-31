package astar;

public class Node implements Comparable<Node> {
	
	private String name;
	private int visitDuration;
	private int importance;
	protected boolean visited;
	protected Node parent;
	protected float x;
	protected float y;
	private float gCost;
	private float hCost;
	private float totalTime;
	Node tmp;
	
	public Node(String name, int visitDuration, int importance) {
		
		this.name = name;
		this.visitDuration = visitDuration;
		this.importance = -importance;
		this.parent = null;
		this.gCost = 0;
		this.hCost = 0;
		this.totalTime = 0;
		this.visited = false;
		this.x = 0;
		this.y = 0;
	}

	public int compareTo(Node node2) {
		if(this.name.equals(node2.getName())){
			return 1;
		}
		
		else{
		
		if(this.getFCost() < node2.getFCost()){
			return -1;
		}
		
		else if(this.getFCost() > node2.getFCost()){
			return 1;
		}
		
		else{
			
			if(this.getImportance() < node2.getImportance()){
				return -1;
			}
			
			else if(this.getImportance() > node2.getImportance()){
				return 1;
			}
			
			else{
				
				return 0;
				
			}
			
		}

		}
		
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public float getGCost() {
		return gCost;
	}

	public void setGCost(float gCost) {
		this.gCost = gCost;
	}

	public float getHCost() {
		return hCost;
	}
	
	public float getFCost() {
		return hCost + gCost;
	}

	public void setHCost(float hCost) {
		this.hCost = hCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public float getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(float totalTime) {
		this.totalTime = totalTime;
	}

	public int getVisitDuration() {
		return visitDuration;
	}

	public void setVisitDuration(int visitDuration) {
		this.visitDuration = visitDuration;
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
	
	


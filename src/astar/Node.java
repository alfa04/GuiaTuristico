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
	
	public Node(String name, int visitDuration, int importance) {
		
		this.name = name;
		this.visitDuration = visitDuration;
		this.importance = -importance;
		this.parent = null;
		this.gCost = 0;
		this.hCost = 0;
		this.totalTime = 0;
		this.visited = false;
	}

	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
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

	
	
	
	
	
}
	
	


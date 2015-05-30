package astar;

public class Node implements Comparable<Node> {
	
	private String name;
	private int visitingTime;
	private int importance;
	protected boolean visited;
	protected Node parent;
	protected float x;
	protected float y;
	private float fCost;//H
	private float gCost;//G
	private float timeSpent;

	@Override
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

	
}

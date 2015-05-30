package astar;

public class Node implements Comparable<Node> {
	
	private String name;
	private int visitingTime;
	private int importance;
	protected boolean visited;
	protected Node parent;
	protected double x;
	protected double y;
	private float fCost;//H
	private float gCost;//G
	private float timeSpent;

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}

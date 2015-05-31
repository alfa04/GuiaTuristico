package aStar;

import java.util.ArrayList;
import java.util.Collections;



public class AStar {
	
	private static Graph graph;
	public static Graph getGraph() {
		return graph;
	}

	public static void setGraph(Graph graph) {
		AStar.graph = graph;
	}

	private Node startNode;
	private ArrayList<Node> closed = new ArrayList<Node>();
	private ArrayList<Node> open = new ArrayList<Node>();
	private int timeLeft;
	private Path path;
	
	

	public AStar(Graph g, Node startNode, int timeLeft){
		graph = g;
		this.startNode = startNode;
		this.timeLeft = timeLeft;
		
	}
	
	public Path runAStar(Node targetNode){
		graph.clearAll();
		closed.clear();
		open.clear();
		open.add(startNode);
		Node currentNode = null;
		
		while(open.size() != 0){
			currentNode = open.get(0);
			
			open.remove(currentNode);
			closed.add(currentNode);
			
			ArrayList<Node> neighbours = getNeighbours(currentNode, targetNode); //talvez tambem target como atributo
			
			
			if(neighbours.size() > 0){
				for(Node neighbour : neighbours){
					boolean neighbourIsBetter = false;
					
					if(closed.contains(neighbour)){
						continue;
					}
					
					float neighbourCostSinceStart = neighbourCostSinceStart(currentNode, targetNode); 

					if(!open.contains(neighbour)){
						open.add(neighbour);
						neighbourIsBetter = true;
						
					}
					
					else if(neighbourCostSinceStart < neighbour.getGCost()){		
						neighbourIsBetter = true;
					}
					
					else neighbourIsBetter = false;
					
					if (neighbourIsBetter) {
	                    neighbour.setParent(currentNode);
	                    neighbour.setGCost(neighbourCostSinceStart);
	                    float heuristicCost = heuristicCost(currentNode, neighbour);
	                    neighbour.setHCost(heuristicCost);
	                    neighbour.setTotalTime(neighbour.getParent().getTotalTime() +
	                    		neighbour.getVisitDuration() +
                                timeBetweenNodes(currentNode, neighbour));
	                }
	
					
				}
			}
			
			else if(neighbours.size() == 0){
				targetNode.setParent(currentNode);
				return reconstructPath(targetNode, graph, targetNode);
			}
			
			Collections.sort(open);
			
			
		}
		
		targetNode.setParent(currentNode);
		return reconstructPath(targetNode, graph, targetNode);
			
	}

	private float heuristicCost(Node currentNode, Node neighbour) {
		float heuristicCost=(float) (-(neighbour.getImportance()*neighbour.getImportance())/distanceBetweenNodes(currentNode, neighbour));
		return heuristicCost;
	}

	private float neighbourCostSinceStart(Node currentNode, Node targetNode) {
		float neighbourCost=(float) (-distanceBetweenNodes(currentNode, targetNode)) + currentNode.getGCost();

		return neighbourCost;
	}
	
	private Path reconstructPath(Node node, Graph graph, Node target){
		Path path = new Path();
		boolean var = true;
		while(var){
			path.addNodeToFirstIndexPath(node);
			node.setVisited(true);
			node = node.getParent();
			if(node.equals(target)){
				path.addNodeToFirstIndexPath(target);
				var = false;
			}

		}
		this.path = path;
		return path;
	}

	
	private ArrayList<Node> getNeighbours(Node currentNode, Node targetNode) {
		ArrayList<Node> toReturn = new ArrayList<Node>();
		for(Node n : graph.getNodes()){
			if(!closed.contains(n) && !n.isVisited()){
				float pathCost = currentNode.getTotalTime() + n.getVisitDuration() +
						timeBetweenNodes(n, targetNode) + timeBetweenNodes(currentNode, n);
				if(pathCost < timeLeft){ 
					toReturn.add(n);
				} 
			}
		}
		return toReturn;
	}
	
	
	public float distanceBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX())+
				(targetNode.getY()-currentNode.getY())*(targetNode.getY()-currentNode.getY()));
		return toReturn;
		
	}
	
	public float timeBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX())+
				(targetNode.getY()-currentNode.getY())*(targetNode.getY()-currentNode.getY()));
		return (float) ((toReturn/2)/60.0);
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	
	
}

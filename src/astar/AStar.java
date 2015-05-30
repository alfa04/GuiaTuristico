package astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class AStar {
	
	private Graph graph;
	private Node startNode;
	private ArrayList<Node> closed = new ArrayList<Node>();
	private ArrayList<Node> open = new ArrayList<Node>();
	private int timeLeft;
	private Path path;
	
	

	public AStar(Graph graph, Node startNode, int timeLeft){
		this.graph = graph;
		this.startNode = startNode;
		this.timeLeft = timeLeft;
		
	}
	
	public Path runAStar(Node targetNode){
		graph.clearAll(); //implement clearAll
		closed.clear();
		open.clear();
		open.add(startNode);
		Node currentNode = null;
		//parent currentNode is null
		
		
		//implementar custo g e f no Node
		
		while(open.size() != 0){
			currentNode = open.get(0); //having the lowest f cost
			
			if(currentNode == targetNode){
				
				return reconstructPath(currentNode); //nao tenho a certeza se e preciso --> nao tenho a certeza se os atributos estao bem
				
			}
			
			open.remove(currentNode);
			closed.add(currentNode);
			
			ArrayList<Node> neighbours = getNeighbours(currentNode, targetNode); //talvez tambem target como atributo
			
			
			if(neighbours.size() > 0){
				for(Node neighbour : neighbours){
					boolean neighbourIsBetter;
					
					if(closed.contains(neighbour)){
						continue;
					}
					
					float neighbourCostSinceStart = neighbourCostSinceStart(currentNode, targetNode); // implementar
					
					if(!open.contains(neighbour)){
						open.add(neighbour);
						neighbourIsBetter = true;
						
					}
					
					else if(neighbourCostSinceStart < currentNode.getGCost()){					
						neighbourIsBetter = true;
					}
					
					else neighbourIsBetter = false;
					
					if (neighbourIsBetter) {
	                    neighbour.setParent(currentNode);
	                    neighbour.setGCost(neighbourCostSinceStart);
	                    float heuristicCost = heuristicCost(currentNode, neighbour);
	                    neighbour.setHCost(heuristicCost);
	                }
	
					
				}
			}
			
			else if(neighbours.size() == 0){
				targetNode.setParent(currentNode);
				return reconstructPath(targetNode);
			}
			
			Collections.sort(open);
			
		}
		targetNode.setParent(currentNode);
		return reconstructPath(targetNode);
			
	}

	private float heuristicCost(Node currentNode, Node neighbour) {
		float heuristicCost=(float) (-(neighbour.getImportance()*neighbour.getImportance())/distanceBetweenNodes(currentNode, neighbour));
		return heuristicCost;
	}

	private float neighbourCostSinceStart(Node currentNode, Node targetNode) {
		float neighbourCost=(float) (-distanceBetweenNodes(currentNode, targetNode)) + currentNode.getGCost();

		return neighbourCost;
	}

	private Path reconstructPath(Node node) {
		
		Path totalPath = new Path();
		
		while(!(node.getParent() == null)){
			totalPath.addNodeToFirstIndexPath(node);
			node.setVisited(true);
			node = node.getParent();
		}
		
		this.path = totalPath;
		return totalPath; //nao tenho a certeza se esta tudo bem
		
	}

	public float distanceBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX())-
				(targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX()));
		return toReturn;
	}
	
	private ArrayList<Node> getNeighbours(Node currentNode, Node targetNode) {
		ArrayList<Node> toReturn = new ArrayList<Node>();
		for(Node n : graph.getNodes()){
			if(!closed.contains(n) && !n.isVisited()){
				float pathCost = currentNode.getTotalTime() + n.getVisitDuration() +
						distanceBetweenNodes(n, targetNode) + distanceBetweenNodes(currentNode, n);
				if(pathCost < timeLeft){ //Adiciona nó à lista se ainda tem tempo para regressar ao hotel
					toReturn.add(n);
				} 
			}
		}
		return toReturn;
	}
	
	
	
	
	

}

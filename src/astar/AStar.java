package astar;

import java.util.ArrayList;

public class AStar {
	
	private Graph graph;
	private Node startNode;
	private ArrayList<Node> visited = new ArrayList<Node>();
	private ArrayList<Node> toVisit = new ArrayList<Node>();
	private int timeLeft;
	//private Path path;
	
	

	public AStar(Graph graph, Node startNode, int timeLeft){
		this.graph = graph;
		this.startNode = startNode;
		this.timeLeft = timeLeft;
		
	}
	
	public Path runAStar(Node targetNode){
		graph.eraseNodes(); //implement eraseNodes
		visited.clear();
		toVisit.clear();
		toVisit.add(startNode);
		Node currentNode;
		//parent currentNode is null
		
		
		//implementar custo g e f no Node
		
		while(toVisit.size() != 0){
			currentNode = toVisit.get(0); //having the lowest f cost
			
			if(currentNode == targetNode){
				
				return reconstruct_path(currentNode.getParent(), targetNode); //implementar --> nao tenho a certeza se os atributos estao bem
				
			}
			
			toVisit.remove(currentNode);
			visited.add(currentNode);
			
			ArrayList<Node> neighbours = getNeighbours(currentNode); //talvez tambem target como atributo
			
			for(Node neighbour : neighbours){
				
				if(visited.contains(neighbour)){
					continue;
				}
				
				float tentativeNeighbourCost = neighbourCost(neighbour, currentNode); // implementar
				
				if(!toVisit.contains(neighbour) || tentativeNeighbourCost < neighbour.getGCost() /* implementar em Node*/){
					
					neighbour.setParent(currentNode);
					neighbour.setGCost(tentativeNeighbourCost);
					float fCost = fCost(neighbour, targetNode);
					if(!toVisit.contains(neighbour)){
						toVisit.add(neighbour);
					}
					
				}
				
				
				//faltam coisas
			}
			
			
		}
			
	}

	private float neighbourCost(Node neighbour, Node currentNode) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Path reconstruct_path(Node node, Node currentNode) {
		
		Path totalPath = new Path();
		
		while(){
			
			currentNode = currentNode.getParent();
			totalPath.append(currentNode);
		}
		
		return totalPath;
		
	}

	private ArrayList<Node> getNeighbours(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private float fCost(Node neighbour, Node currentNode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}

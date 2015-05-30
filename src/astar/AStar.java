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
	
	public void runAStar(Node targetNode){
		graph.clearNodes(); //implement clearNodes
		visited.clear();
		toVisit.clear();
		toVisit.add(startNode);
		Node currentNode;
		
		//implementar custo g e f no Node
		
		while(toVisit.size() != 0){
			currentNode = toVisit.get(0); //having the lowest f cost
			
			if(currentNode == targetNode){
				
				reconstruct_path(visited, targetNode); //implementar --> nao tenho a certeza se os atributos estao bem
				
			}
			
			toVisit.remove(currentNode);
			visited.add(currentNode);
			
			ArrayList<Node> neighbours = getNeighbours(currentNode); //talvez tambem target como atributo
			
			for(Node neighbour : neighbours){
				
				if(visited.contains(neighbour)){
					continue;
				}
				
				float neighbourCost = neighbourCost(neighbour, currentNode); // implementar
				
				if(!toVisit.contains(neighbour) || neighbourCost < neighbour.getGCost() /* implementar em Node*/){
					//continuar aqui
				}
				
				
				
			}
			
			
		}
		
		
		
		
		
		
	}
	
	
	

}

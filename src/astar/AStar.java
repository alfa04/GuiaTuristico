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
	//private Path path;
	
	

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
		Node currentNode;
		//parent currentNode is null
		
		
		//implementar custo g e f no Node
		
		while(open.size() != 0){
			currentNode = open.get(0); //having the lowest f cost
			
			if(currentNode == targetNode){
				
				return reconstruct_path(currentNode); //implementar --> nao tenho a certeza se os atributos estao bem
				
			}
			
			open.remove(currentNode);
			closed.add(currentNode);
			
			ArrayList<Node> neighbours = getNeighbours(currentNode); //talvez tambem target como atributo
			
			for(Node neighbour : neighbours){
				boolean neighbourIsBetter;
				
				if(closed.contains(neighbour)){
					continue;
				}
				
				float NeighbourCostSinceStart = neighbourCost(neighbour, currentNode); // implementar
				
				if(!open.contains(neighbour)){
					open.add(neighbour);
					neighbourIsBetter = true;
					
				}
				
				else if(NeighbourCostSinceStart < currentNode.getG()){					
					neighbourIsBetter = true;
				}
				
				else neighbourIsBetter = false;
				
				if (neighbourIsBetter) {
                    neighbour.setParent(currentNode);
                    neighbour.setG(NeighbourCostSinceStart);
                    float heuristicCost = heuristicCost(neighbour, targetNode);
                    neighbour.setH(heuristicCost);
                }

				
			}
			
			Collections.sort(open);
			
		}
			
	}

	private float heuristicCost(Node neighbour, Node targetNode) {
		
		return 0;
	}

	private float neighbourCost(Node neighbour, Node currentNode) {
		float neighbourCost = currentNode.getG() + distance(current, neighbour);

		return neighbourCost;
	}

	private Path reconstruct_path(Node node) {
		
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
	
	private float gCost(Node neighbour, Node currentNode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

}

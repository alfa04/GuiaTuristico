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
				
				float neighbourCostSinceStart = neighbourCostSinceStart(currentNode, targetNode); // implementar
				
				if(!open.contains(neighbour)){
					open.add(neighbour);
					neighbourIsBetter = true;
					
				}
				
				else if(neighbourCostSinceStart < currentNode.getG()){					
					neighbourIsBetter = true;
				}
				
				else neighbourIsBetter = false;
				
				if (neighbourIsBetter) {
                    neighbour.setParent(currentNode);
                    neighbour.setG(neighbourCostSinceStart);
                    float heuristicCost = heuristicCost(neighbour, neighbor);
                    neighbour.setH(heuristicCost);
                }

				
			}
			
			Collections.sort(open);
			
		}
			
	}

	private float heuristicCost(Node neighbour, Node targetNode) {
		float heuristicCost=(float) (-(neighbour.getImportance()*neighbour.getImportance())/Distance.distanceToTarget(current, neighbor));
		return 0;
	}

	private float neighbourCostSinceStart(Node currentNode, Node targetNode) {
		float neighbourCost=(float) (-distanceBetweenNodes(currentNode, targetNode)) + current.getG();

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

	public float distanceBetweenNodes(Node currentNode, Node targetNode){
		float toReturn = (float) Math.sqrt((targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX())-
				(targetNode.getX()-currentNode.getX())*(targetNode.getX()-currentNode.getX()));
		return toReturn;
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

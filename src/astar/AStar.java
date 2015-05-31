package astar;

import java.util.ArrayList;
import java.util.Collections;



public class AStar {
	
	private static Graph graph;
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
		graph.clearAll(); //implement clearAll
		closed.clear();
		open.clear();
		open.add(startNode);
		Node currentNode = null;
		//parent currentNode is null
		
		
		//implementar custo g e f no Node
		
		while(open.size() != 0){
			currentNode = open.get(0); //having the lowest f cost
			
			/*if(currentNode == targetNode){
				
				return reconstructPath(currentNode); //nao tenho a certeza se e preciso --> nao tenho a certeza se os atributos estao bem
				
			}*/
			
			open.remove(currentNode);
			closed.add(currentNode);
			
			ArrayList<Node> neighbours = getNeighbours(currentNode, targetNode); //talvez tambem target como atributo
			
			
			if(neighbours.size() > 0){
				for(Node neighbour : neighbours){
					boolean neighbourIsBetter = false;
					
					if(closed.contains(neighbour)){
						continue;
					}
					
					float neighbourCostSinceStart = neighbourCostSinceStart(currentNode, targetNode); // mudei de current e target para neighbour e current
					
					if(!open.contains(neighbour)){
						open.add(neighbour);
						neighbourIsBetter = true;
						
					}
					
					else if(neighbourCostSinceStart < neighbour.getGCost()){		//mudei de current para neighbour			
						neighbourIsBetter = true;
					}
					
					else neighbourIsBetter = false;
					
					if (neighbourIsBetter) {
	                    neighbour.setParent(currentNode);
	                    neighbour.setGCost(neighbourCostSinceStart);
	                    float heuristicCost = heuristicCost(currentNode, neighbour); //mudei de current e neighbour para neighbour e target
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
			
			//for(Node n: open)
			//	System.out.println(n.getName());
			Collections.sort(open);
			
			/*System.out.print("aaa");
			for(Node n: open)
				System.out.println(n.getName());
			System.out.println('\n');
			for(Node no: closed)
				System.out.println(no.getName());
			System.out.println("\n\n");*/
			
			
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
			
		//	System.out.println(node.getName());

		}
		this.path = path;
		return path;
	}

	/*private Path reconstructPath(Node node) {
		
		Path totalPath = new Path();
		
		while(!(node.getParent() == null)){
			totalPath.addNodeToFirstIndexPath(node);
			node.setVisited(true);
			System.out.println(node.getName());
			node = node.getParent();
		}
		
		this.path = totalPath;
		return totalPath; //nao tenho a certeza se esta tudo bem
		
	}*/
	
	private ArrayList<Node> getNeighbours(Node currentNode, Node targetNode) {
		ArrayList<Node> toReturn = new ArrayList<Node>();
		for(Node n : graph.getNodes()){
			if(!closed.contains(n) && !n.isVisited() /*n != currentNode*/){
				float pathCost = currentNode.getTotalTime() + n.getVisitDuration() +
						timeBetweenNodes(n, targetNode) + timeBetweenNodes(currentNode, n);
				if(pathCost < timeLeft){ //Adiciona nó à lista se ainda tem tempo para regressar ao hotel
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
	
}

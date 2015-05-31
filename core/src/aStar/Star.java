package aStar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import aStar.AStar;
import aStar.CityBuild;
import aStar.Graph;
import aStar.Path;

public class Star {
	
	public static Graph graph;
	protected static CityBuild city;
	protected static AStar astar;
	static int nDays = 1;
	
	
	public Star() throws FileNotFoundException, IOException {
		File file = new File("mapCity/city1.txt");
		Scanner scan = new Scanner(System.in);
		
		graph = new Graph(file);
		city = new CityBuild();
		city.cityBuild(graph.getNodes());
		astar = new AStar(graph, graph.getNodes().get(0), 600);
		for(int i = 0; i < nDays; i++){
			Path path = astar.runAStar(graph.getNodes().get(0));
			if(path.getSize() > 2){
				System.out.println("Dia " + (i+1) + ":");
				path.printPath();
			}
				
			
		}
		
	}



	public static AStar getAstar() {
		return astar;
	}



	public static void setAstar(AStar astar) {
		Star.astar = astar;
	}



	public static Graph getGraph() {
		return graph;
	}



	public static void setGraph(Graph graph) {
		Star.graph = graph;
	}

	public static void increaseDay() {
		boolean notAllVisited = false;
		for(Node node: graph.getNodes()){
			if(!node.isVisited()){
				notAllVisited = true;
			}
		}
		
		if(notAllVisited){	
			nDays++;
		}
	}
	public static void decreaseDay() {
		if(nDays>1)
		nDays--;
		else nDays=1;
	}



	public static int getnDays() {
		return nDays;
	}



	public static void setnDays(int nDays) {
		Star.nDays = nDays;
	}






}

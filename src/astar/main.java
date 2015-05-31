package astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	protected static Graph graph;
	protected static CityBuild city;
	protected static AStar astar;
	protected static int nDays = 0;
	
	
	
	public static void main (String[] arg) throws FileNotFoundException, IOException {
		
		File file = new File("mapCity/city1.txt");
		Scanner scan = new Scanner(System.in);
		System.out.println("Quantos dias vai viajar?\n");
		nDays = scan.nextInt();
		scan.close();
		
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

}

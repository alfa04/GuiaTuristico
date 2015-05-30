package astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	protected static Graph graph;
	protected static CityBuild city;
	AStar astar;
	
	
	
	public static void main (String[] arg) throws FileNotFoundException, IOException {
		
		File file = new File("mapCity/city1.txt");
		graph = new Graph(file);
		city = new CityBuild();
		city.cityBuild(graph.getNodes());
		
	}

}

package astar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import astar.Node;

/*Classe responsável por fazer a leitura do ficheiro com os dados
  relativos aos interesses do turista, tempos de visita etc*/
public class Graph {

	protected ArrayList<Node> nodes = new ArrayList<Node>();
	
	public Graph (File file) throws FileNotFoundException, IOException{
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			for(String line; (line = reader.readLine()) != null; ){
				String[] parameter = line.split(Pattern.quote(";"));
				if(parameter.length == 3){
					Node n = new Node(parameter[0].trim(),Integer.parseInt(parameter[1].trim()),Integer.parseInt(parameter[2].trim()));
					this.nodes.add(n);
				} else {
					System.err.println("Error parsing line : " + line);
				}
			}
			System.out.println("Node Size : " + this.nodes.size());
		}
	}
}

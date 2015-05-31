package astar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class CityBuild {
	
	public CityBuild(){
		
	}
	
	protected void cityBuild(ArrayList<Node> mapList){
		File file = new File("mapCity/mapCity1.txt");
		for(Node node : mapList){
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
				for(String line; (line = reader.readLine()) != null; ){
					String info[] = line.split(Pattern.quote(";"));
					if((info[0].trim()).equals(node.getName())){
						float x = Float.parseFloat(info[1].trim());
						float y = Float.parseFloat(info[2].trim());
						//System.out.print(info[0].trim());
						//System.out.print(Integer.parseInt(info[1].trim()));
						//System.out.println(Integer.parseInt(info[2].trim()));
						node.setX(x);
						node.setY(y);
						break;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

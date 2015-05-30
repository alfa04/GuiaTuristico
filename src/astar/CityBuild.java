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
	
	private static void cityBuild(ArrayList<Node> mapList){
		File file = new File("resources/latlongDB.txt");
		for(Node n : mapList){
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
				for(String line; (line = reader.readLine()) != null; ){
					String info[] = line.split(Pattern.quote(";"));
					if((info[0].trim()).equals(n.getName())){
						float x = Float.parseFloat(info[1].trim());
						float y = Float.parseFloat(info[2].trim());
						n.setX(x);
						n.setY(y);
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

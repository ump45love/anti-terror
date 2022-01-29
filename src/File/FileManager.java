package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Material;

import Type.*;
public class FileManager {
	static public String dir = "./plugins/banBlock/banBlockList.txt";
	public static void writeFile() throws IOException {
		File file = new File(dir);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
		BanBlock.banBlock.forEach(item -> {
			try {
				write(item,writer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		writer.close();
	}
	
	static void write(BanBlockType banBlock,BufferedWriter writer) throws IOException {
		writer.write(banBlock.getBanBlockName()+":"+banBlock.getExp()+"\n");
	}
	
	public static void readFile() {
		File file = new File(dir);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] content = line.split(":");
		   	 if(content[1].matches("[+-]?\\d*(\\.\\d+)?") && (Material.getMaterial(content[0]) != null))
		    	BanBlock.insertBanBlock(content[0],content[1],null);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

}

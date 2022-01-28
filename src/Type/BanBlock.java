package Type;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import Type.*;

public class BanBlock {
 static public ArrayList<BanBlockType> banBlock = new ArrayList<BanBlockType>();
 
 public static void insertBanBlock(String name,int number) {
	 
	 if(Material.getMaterial(name) != null)
		 banBlock.add(new BanBlockType(name,number));
 }
 
 public static boolean checkBanBlock(BanBlockType data) {
	 	return banBlock.contains(data);
 }
}

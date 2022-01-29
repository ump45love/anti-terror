package Type;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import File.FileManager;

public class BanBlock {
 static public ArrayList<BanBlockType> banBlock = new ArrayList<BanBlockType>();
 
 public static void insertBanBlock(String name,String number,Player player) throws IOException {
	 if(!number.matches("[+-]?\\d*(\\.\\d+)?")) {
		 player.sendMessage(ChatColor.RED + "숫자를 입력해주세요");
		 return;
	 }
	 int exp = Integer.parseInt(number);
	 if(Material.getMaterial(name) != null) {
		 int index = banBlock.indexOf(new BanBlockType(name,0));
		 if(index != -1) {
			 player.sendMessage(ChatColor.RED + "중복된 블럭입니다.");
			 return;
		 }
		 banBlock.add(new BanBlockType(name,exp));
		 FileManager.writeFile();
	 }
	 else {
		 player.sendMessage(ChatColor.RED + "없는 블럭입니다 (대문자인지 확인)");
	 }
 }
 
 public static boolean checkBanBlock(BanBlockType data) {
	 	return banBlock.contains(data);
 }
 
 public static void listBanBlock(Player player) {
		BanBlock.banBlock.forEach(item -> {
			player.sendMessage(ChatColor.BLUE + item.getBanBlockName() +":" + item.getExp());
		});
 }
 
 public static void deleteBanBlock(String name,Player player) throws IOException {
	 int index = banBlock.indexOf(new BanBlockType(name,0));
	 if(index == -1) {
		 player.sendMessage(ChatColor.RED + "존재하지 않는 항목입니다.");
		 return;
	 }
	 banBlock.remove(index);
	 FileManager.writeFile();
 }
 public static void setBanBlock(String name,String number,Player player) throws IOException {
	 if(!number.matches("[+-]?\\d*(\\.\\d+)?")) {
		 player.sendMessage(ChatColor.RED + "숫자를 입력해주세요");
		 return;
	 }
	 int exp = Integer.parseInt(number);
	 int index = banBlock.indexOf(new BanBlockType(name,0));
	 if(index == -1) {
		 player.sendMessage(ChatColor.RED + "존재하지 않는 항목입니다.");
		 return;
	 }
	 banBlock.get(index).setExp(exp);
	 FileManager.writeFile();
 }
}

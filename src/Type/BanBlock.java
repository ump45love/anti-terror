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
		 player.sendMessage(ChatColor.RED + "���ڸ� �Է����ּ���");
		 return;
	 }
	 int exp = Integer.parseInt(number);
	 if(Material.getMaterial(name) != null) {
		 int index = banBlock.indexOf(new BanBlockType(name,0));
		 if(index != -1) {
			 player.sendMessage(ChatColor.RED + "�ߺ��� ���Դϴ�.");
			 return;
		 }
		 banBlock.add(new BanBlockType(name,exp));
		 FileManager.writeFile();
	 }
	 else {
		 player.sendMessage(ChatColor.RED + "���� ���Դϴ� (�빮������ Ȯ��)");
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
		 player.sendMessage(ChatColor.RED + "�������� �ʴ� �׸��Դϴ�.");
		 return;
	 }
	 banBlock.remove(index);
	 FileManager.writeFile();
 }
 public static void setBanBlock(String name,String number,Player player) throws IOException {
	 if(!number.matches("[+-]?\\d*(\\.\\d+)?")) {
		 player.sendMessage(ChatColor.RED + "���ڸ� �Է����ּ���");
		 return;
	 }
	 int exp = Integer.parseInt(number);
	 int index = banBlock.indexOf(new BanBlockType(name,0));
	 if(index == -1) {
		 player.sendMessage(ChatColor.RED + "�������� �ʴ� �׸��Դϴ�.");
		 return;
	 }
	 banBlock.get(index).setExp(exp);
	 FileManager.writeFile();
 }
}

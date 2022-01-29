package Main;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Type.BanBlock;

public class getcommand implements CommandExecutor {
	  @Override
	    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		  Player player = (Player)sender;
		  if(checkLength(args.length,1)) {
			  return false;
		  }
		  if(player.isOp()) {
			  try {
				  switch (args[0]) {
				  case "insert":
					  if(checkLength(args.length,3)) {
						  return false;
					  }
					  BanBlock.insertBanBlock(args[1], args[2],player);
					  break;
				  case "delete":
					  if(checkLength(args.length,2)) {
						  return false;
					  }
					  BanBlock.deleteBanBlock(args[1],player);
					  break;
				  case "list":
					  BanBlock.listBanBlock(player);
					  break;
				  case "set":
					  if(checkLength(args.length,3)) {
						  return false;
					  }
					  BanBlock.setBanBlock(args[1], args[2],player);
					  break;
				  case "help":
					  helpMssage(player);
					  break;
				  }
			  }
			  catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		  
		  return false;
	   }
	  void helpMssage(Player player) {
		  player.sendMessage(ChatColor.BLUE+ "block_name - ��ġ������ ���̸�");
		  player.sendMessage(ChatColor.BLUE+ "exp limit - ��ġ�� �㰡�� ���� ����ġ��");
		  player.sendMessage(ChatColor.BLUE+ "/banblock insert [block_name] [exp limit] - ���߰�");
		  player.sendMessage(ChatColor.BLUE+ "/banblock delete [block_name] - ������");
		  player.sendMessage(ChatColor.BLUE+ "/banblock list - ������Ʈ");
		  player.sendMessage(ChatColor.BLUE+ "/banblock set [block_name] [exp limit] - �� ����ġ �䱸�� ����");
	  }
	  boolean checkLength(int length,int chk) {
		  if(chk <= length)
			  return false;
		  return true;
	  }
	  void errorMessage(String content,Player player) {
		  player.sendMessage(ChatColor.BLUE+ content);
	  }
}
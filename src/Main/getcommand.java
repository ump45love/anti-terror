package Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getcommand implements CommandExecutor {
	  @Override
	    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		  Player player = (Player)sender;
		  if(checkLength(args.length,1)) return false;
		  player.sendMessage(player.getExpToLevel()+"");
		  if(player.isOp()) {
			  switch (args[0]) {
			  case "insert":
				  break;
			  case "delete":
				  break;
			  case "list":
				  break;
			  }
		  }
		  
		  return false;
	   }
	  
	  boolean checkLength(int length,int chk) {
		  if(chk <= length)
			  return true;
		  return false;
	  }
	  void errorMessage(String content,Player player,ChatColor color) {
		  player.sendMessage(ChatColor.BLUE+ content);
	  }
}
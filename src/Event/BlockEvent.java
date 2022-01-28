package Event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import Type.BanBlock;
import Type.BanBlockType;

public class BlockEvent implements Listener {
	 @EventHandler
	    public void onItemPlace(BlockPlaceEvent e){
	       Player player = e.getPlayer();
	       if(BanBlock.checkBanBlock(new BanBlockType(e.getBlock().getType(),player.getExp())))
	    	   e.setCancelled(true);
	      
	    }
   
}

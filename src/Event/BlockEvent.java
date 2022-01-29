package Event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import Type.BanBlock;
import Type.BanBlockType;

public class BlockEvent implements Listener {
	 @EventHandler
	    public void onItemPlace(BlockPlaceEvent e){
	       Player player = e.getPlayer();
	       if(BanBlock.checkBanBlock(new BanBlockType(e.getBlock().getType(),player.getTotalExperience()))) {
	    	   e.setCancelled(true);
	    	   BanBlock.expLimit((new BanBlockType(e.getBlock().getType(),0)),player);
	       }
	    }
	 
	 @EventHandler
	    public void onItemPlace(PlayerBucketEmptyEvent e){
	       Player player = e.getPlayer();
	       if(BanBlock.checkBanBlock(new BanBlockType(e.getBucket(),player.getTotalExperience()))) {
	    	   e.setCancelled(true);
	       	   BanBlock.expLimit((new BanBlockType(e.getBlock().getType(),0)),player);
	       }
	    }
   
}

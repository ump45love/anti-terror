package Main;



import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import Event.*;
import File.FileManager;



public class main extends JavaPlugin{
	@Override
	public void onEnable(){
		File cfile = new File(getDataFolder(),"config.yml");
		if(cfile.length() == 0) {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "start");
		FileManager.readFile();
		getServer().getPluginManager().registerEvents(new BlockEvent(),this);
		getCommand("banblock").setTabCompleter(new TabComplete());
		getCommand("banblock").setExecutor(new getcommand());
	}
	
	     
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "end");
	}
   
}
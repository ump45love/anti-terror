package Event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;


public class TabComplete implements TabCompleter{
	@Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("banblock") && args.length == 2) {
            if(!args[1].equals(""))
            {
                List<String> result = new ArrayList<String>();
                for(Material material : Material.values())
                {
                    if(material.toString().startsWith(args[1].toUpperCase()))
                    {
                        result.add(material.toString());
                    }
                }
                return result;
            } else {
                return Stream.of(Material.values()).map(Material::name).collect(Collectors.toList());  
            }
           
        }
        return null;
    }
}

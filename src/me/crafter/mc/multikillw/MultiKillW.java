package me.crafter.mc.multikillw;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiKillW extends JavaPlugin {

	public final KillListener pl = new KillListener();

	public void onEnable(){
		// First check
		this.saveDefaultConfig();
		Initiator.check(getDataFolder());
		// Load config
		Storage.loadData(getDataFolder());
		Storage.loadConfig(this.getConfig());
		Storage.setupChat();
		// Start plugin
    	getServer().getPluginManager().registerEvents(this.pl, this);
    }
	
	
    public void onDisable(){
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, final String[] args){
    	
    	return true;
    }
	
}

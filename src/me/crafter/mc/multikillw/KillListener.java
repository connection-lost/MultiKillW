package me.crafter.mc.multikillw;

import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {


	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		// Debug only
		if (Storage.debug){
			DeathInfo.debug(event);
		}
		
		// Start
		final Map<String, String> info = DeathInfo.getDeathInfo(event);
		if (Storage.deathmessages){
			event.setDeathMessage(Storage.getDeathMessage(info));
		}
		
		if (Storage.combomessages){
			Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("MultiKillW"), new Runnable(){

				@Override
				public void run() {
					List<String> mkdmessages = MkdMessages.getMkdMessages(Bukkit.getPlayer(info.get("killername")), Bukkit.getPlayer(info.get("deadplayername")));
					Storage.broadcastMessages(mkdmessages);
				}
				
			});
			
		}
		
	}

}



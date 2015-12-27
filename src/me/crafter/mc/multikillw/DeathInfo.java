package me.crafter.mc.multikillw;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Tameable;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DeathInfo {

	public static void debug(PlayerDeathEvent event){
		Bukkit.getLogger().info("MultiKillW debug message");
		Map<String, String> info = getDeathInfo(event);
		for (String item : info.keySet()){
			Bukkit.getLogger().info(item + ": " + info.get(item));
		}
	}
	
	public static Map<String, String> getDeathInfo(PlayerDeathEvent event){
		Map<String, String> info = new HashMap<String, String>();
		Player deadplayer = event.getEntity();
		String deadplayername = deadplayer.getName();
		
		EntityDamageEvent lastdamage = deadplayer.getLastDamageCause();
		DamageCause damagecause = lastdamage.getCause();
		String damagecausename = damagecause.name();
		String killertypename = ChatColor.GRAY + "null";
		String killername = ChatColor.GRAY + "null";		
		String reason = damagecausename;
		
		if (lastdamage instanceof EntityDamageByEntityEvent){ // Entity caused death
			Entity killer = ((EntityDamageByEntityEvent)lastdamage).getDamager();
			killertypename = killer.getType().name();
			reason = killertypename;
			if (killer instanceof Player){
				killername = ((Player)killer).getName();
				reason = "PVP";
			} else if (killer.getCustomName() != null){
				killername = killer.getCustomName();
			}
			if (killer instanceof Projectile){
				ProjectileSource shooter = ((Projectile)killer).getShooter();
				if (shooter instanceof Entity){
					killertypename = ((Entity)shooter).getType().name();
					reason = killertypename;
					if (shooter instanceof Player){
						killername = ((Player)shooter).getName();
						reason = "PVPARROW";
					} else if (((Entity)shooter).getCustomName() != null){
						killername = ((Entity)shooter).getCustomName();
					}
				} else if (shooter instanceof BlockProjectileSource){
					killertypename = "DISPENSER";
					reason = "DISPENSER";
				}
			}
			if (killer instanceof Tameable){
				if (((Tameable)killer).getOwner() != null){
					killername = ((Tameable)killer).getOwner().getName();
					reason = "PLAYER" + killertypename;
				}
			}
			if (killername.equals("connection_lost")) reason = "FUZHU";
			if (killername.equals(deadplayername)) reason = "KILL";	
			if (reason.equals("FIRE_TICK")) reason = "FIRE";	
		}
		
		info.put("deadplayername", deadplayername); // %d
		info.put("damagecausename", damagecausename); // %k
		info.put("killertypename", killertypename); // %t
		info.put("killername", killername); // %n
		info.put("reason", reason); // %r
		
		return info;
	}
	
	
}

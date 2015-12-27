package me.crafter.mc.multikillw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class MkdMessages {
	
	public static Map<String, Integer> deathspree = new HashMap<String, Integer>();
	public static Map<String, Integer> killspree = new HashMap<String, Integer>();
	
	public static List<String> getMkdMessages(Player killer, Player dier){
		// init
		if (dier != null && !deathspree.containsKey(dier.getName())) deathspree.put(dier.getName(), 0);
		if (dier != null && !killspree.containsKey(dier.getName())) killspree.put(dier.getName(), 0);
		if (killer != null && !killspree.containsKey(killer.getName())) killspree.put(killer.getName(), 0);
		if (killer != null && !deathspree.containsKey(killer.getName())) deathspree.put(killer.getName(), 0);
		List<String> ret = new ArrayList<String>();
		if (killer == dier) return ret;
		// break
		if (dier != null && killer != null){ 
			// break killer's die spree
			int kd = deathspree.get(killer.getName());
			if (kd > 10) kd = 10;
			if (Storage.getComboMessages("breakdeath").containsKey(kd)){
				ret.add(ChatColor.translateAlternateColorCodes('&', Storage.getComboMessages("breakdeath").get(kd).replace("%k", Storage.getPlayerName(killer)).replace("%d", Storage.getPlayerName(dier))));
			}
			deathspree.put(killer.getName(), 0);
			
			// break dier's kill spree
			int dk = killspree.get(dier.getName());
			if (dk > 10) dk = 10;
			if (Storage.getComboMessages("breakkill").containsKey(dk)){
				ret.add(ChatColor.translateAlternateColorCodes('&', Storage.getComboMessages("breakkill").get(dk).replace("%k", Storage.getPlayerName(killer)).replace("%d", Storage.getPlayerName(dier))));
			}
			killspree.put(dier.getName(), 0);
		}

		// spree
		// killing spree
		if (killer != null){
			int ks = killspree.get(killer.getName()) + 1;
			if (ks > 10) ks = 10;
			killspree.put(killer.getName(), ks);
			if (Storage.getComboMessages("kill").containsKey(ks)){
				ret.add(ChatColor.translateAlternateColorCodes('&', Storage.getComboMessages("kill").get(ks).replace("%k", Storage.getPlayerName(killer)).replace("%d", Storage.getPlayerName(dier))));
			}
		}
		// die spree
		if (dier != null){ // it is not actually needed
			int ds = deathspree.get(dier.getName()) + 1;
			if (ds > 10) ds = 10;
			deathspree.put(dier.getName(), ds);
			if (Storage.getComboMessages("death").containsKey(ds)){
				ret.add(ChatColor.translateAlternateColorCodes('&', Storage.getComboMessages("death").get(ds).replace("%d", Storage.getPlayerName(dier))));
			}
		}
		return ret;
	}

}

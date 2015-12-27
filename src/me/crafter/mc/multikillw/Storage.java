package me.crafter.mc.multikillw;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.chat.Chat;

public class Storage {
	
	public static Chat chat;
	
	public static boolean deathmessages = true;
	public static boolean combomessages = true;
	public static boolean useitemname = true;
	public static boolean debug = false;
	public static String playernameformat = "%name%";
	public static Random random = new Random();
	
	private static Map<String, List<String>> messages = new HashMap<String, List<String>>();
	private static Map<String, Map<Integer, String>> combo = new HashMap<String, Map<Integer, String>>();
	private static Map<String, Integer> combomax = new HashMap<String, Integer>();
	private static Map<String, String> items = new HashMap<String, String>();
	
	public static boolean setupChat() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
        	return false;
        }
        RegisteredServiceProvider<Chat> rsp = Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
        if (rsp == null) {
        	return false;
        }
        chat = rsp.getProvider();
        return chat != null;
    }
	
	public static void loadConfig(FileConfiguration config){
		deathmessages = config.getBoolean("deathmessages", true);
		combomessages = config.getBoolean("combomessages", true);
		useitemname = config.getBoolean("useitemname", true);
		debug = config.getBoolean("debug", false);
		playernameformat = config.getString("playernameformat", "%name%");
	}
	
	public static void loadData(File folder){
		setupChat();
		// Death Messages
		FileConfiguration messagesyml = YamlConfiguration.loadConfiguration(new File(folder, "messages.yml"));
		for (String key : messagesyml.getKeys(false)){
			List<String> dmessages = messagesyml.getStringList(key);
			messages.put(key, dmessages);
		}
		// Combo Messages
		FileConfiguration comboyml = YamlConfiguration.loadConfiguration(new File(folder, "combo.yml"));
		for (String key : comboyml.getKeys(false)){
			MemorySection currtype = (MemorySection)comboyml.get(key);
			for (String key2 : currtype.getKeys(false)){
				if (!combo.containsKey(key)) combo.put(key, new HashMap<Integer, String>());
				combo.get(key).put(Integer.parseInt(key2), currtype.getString(key2));
				combomax.put(key, Integer.parseInt(key2));
			}
		}
		// Item Names
		FileConfiguration itemyml = YamlConfiguration.loadConfiguration(new File(folder, "item.yml"));
		for (String key : itemyml.getKeys(false)){
			String itemname = itemyml.getString(key);
			items.put(key, itemname);
		}
	}
	
	public static String getPlayerPrefix(Player p){
		if (chat != null){
			return chat.getPlayerPrefix(p);
		} else {
			return "";
		}
	}
	
	public static String getPlayerSuffix(Player p){
		if (chat != null){
			return chat.getPlayerSuffix(p);
		} else {
			return "";
		}
	}
	
	public static String getPlayerName(Player p){
		return playernameformat.replace("%pre%", getPlayerPrefix(p)).replace("%suf%", getPlayerSuffix(p)).
				replace("%name%", p.getName()).replace("%disp%", p.getDisplayName());
	}
	
	public static String getDeathMessageByInfo(String reason){
		if (!messages.containsKey(reason.toLowerCase())) reason = "other";
		List<String> messagelist = messages.get(reason.toLowerCase());
		return messagelist.get(random.nextInt(messagelist.size()));
	}
	
	public static String getDeathMessage(Map<String, String> info){
		String message = getDeathMessageByInfo(info.get("reason"));
		if (message.contains("%d")){
			String dstr = info.get("deadplayername");
			Player dead = Bukkit.getPlayer(dstr);
			if (dead != null) dstr = getPlayerName(dead);
			message = message.replace("%d", dstr);
		}
		if (message.contains("%k")){
			String kstr = info.get("killername");
			Player kill = Bukkit.getPlayer(kstr);
			if (kill != null) kstr = getPlayerName(kill);
			message = message.replace("%k", kstr);
		}
		if (message.contains("%w")){
			String kstr = info.get("killername");
			Player kill = Bukkit.getPlayer(kstr);
			if (kill != null){
				String istr = "AIR";
				ItemStack item = kill.getItemInHand();
				if (item != null) {
					istr = item.getType().name();
				}
				if (Storage.useitemname && item != null && item.getItemMeta().getDisplayName() != null){
					istr = item.getItemMeta().getDisplayName();
				} else if (Storage.items.containsKey(istr)){
					istr = Storage.items.get(istr);
				}
				message = message.replace("%w", istr);
			} else {
				message = message.replace("%w", "???");
			}
		}
		message = ChatColor.translateAlternateColorCodes('&', message);
		return message;
	}
	
	public static List<String> getMkdMessage(){
		return null;
	}
	
	public static void broadcastMessages(List<String> msgs){
		if (msgs != null){
			for (String msg : msgs){
				Bukkit.broadcastMessage(msg);
			}
		}
	}
	
	public static Map<Integer, String> getComboMessages(String method){
		return combo.get(method);
	}
	
}

package me.crafter.mc.multikillw;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Initiator {
	
	public static void check(File folder){
		// Death messages
		File messages = new File(folder, "messages.yml");
		if (!messages.exists()){
			Bukkit.getLogger().info("[MultiKillW] Creating messages.yml");
			FileConfiguration messagesyml = YamlConfiguration.loadConfiguration(messages);
			try {
				messagesyml.loadFromString("anvil:\n- '&c%d&6 被铁砧砸死了。'\nblaze:\n- '&c%d&6 招惹了一只烈焰人。'\n- '&c%d&6 调戏了一只烈焰人，烈焰人反杀。'\ncactus:\n- '&c%d&6 捅了一下仙人掌，仙人掌也捅了一下他。'\n- '&c%d&6 拥抱了仙人掌。'\n- '&c%d&6 被仙人掌扎死了！'\ncavespider:\n- '&c%d&6 被洞穴蜘蛛吃掉了。'\ncreeper:\n- '&c%d&6 嘶嘶嘶~BOOM！'\n- '&c%d&6 被JJ炸死了。'\ndispenser:\n- '&c%d&6 被射箭机射了一脸！'\n- '&c%d&6 被射箭机射死了。'\ndrowning:\n- '&c%d&6 淹死了。'\n- '&c%d&6 貌似不会游泳。'\nenderman:\n- '&c%d&6 被愤怒的黑基佬杀害！'\nfall:\n- '&c%d&6 天使下凡，脸先着地。'\n- '&c%d&6 拥抱了大地母亲。'\nfire:\n- '&c%d&6 鸡肉味，咯嘣脆！'\nghast:\n- '&c%d&6 来了一发怨魂火球。'\ngiant:\n- '&c%d&6 被进击的巨人吃掉了。'\nguardian:\n- '&c%d&6 被海底守卫者吞了进去。'\nhunger:\n- '&c%d&6 画饼充饥！'\n- '&c%d&6 忘记吃东西了。'\nirongolem:\n- '&c%d&6 在非礼村民时被铁傀儡拍死。'\nkill:\n- '&c%d&6 自杀了！'\n- '&c%d&6 向这个世界说，再见了。'\n- '&c%d&6 放弃了治疗！'\nlava:\n- '&c%d&6 在岩浆中翻滚。'\n- '&c%d&6 泡了一下3000度的温泉。'\nlightning:\n- '&c%d&6 变身猪人！'\nmagmacube:\n- '&c%d&6 被烈焰史莱姆砸死了。'\nother:\n- '&c%d&6 被HIM杀死了。'\npigzombie:\n- '&c%d&6 手贱招惹了猪人。'\npoison:\n- '&c%d&6 竟然真能毒死啊！'\npotion:\n- '&c%d&6 被药水熏死。'\npvp:\n- '&a%k&6 用 &b%w&6 杀死了 &c%d&6！'\npvparrow:\n- '&a%k&6 用 &b%w&6 射死了 &c%d&6！'\nrabbit:\n- '&6兔子: 见鬼去吧&c%d&6！'\nsilverfish:\n- '&c%d&6 被毛毛虫吃掉了。'\nskeleton:\n- '&c%d&6 被骷髅射了一脸！'\nslime:\n- '&c%d&6 被史莱姆砸死了。'\nsnowman:\n- '&c%d&6 被5渣雪人杀害。'\nspider:\n- '&c%d&6 被蜘蛛吃了。'\nsuicide:\n- '&c%d&6 使用了/kill命令！'\nsuffocation:\n- '&c%d&6 卡在了墙中。'\nthorns:\n- '&a%k&6 使用了荆棘护甲阴死了 &c%d&6！'\n- '&a%k&6 使用刃甲杀死了 &c%d&6！'\n- '&c%d&6 攻击了 &a%k&6，但是他的盔甲太硬了。'\ntnt:\n- '&c%d&6 被TNT炸死了。'\nvoid:\n- '&c%d&6 遨游在虚空~'\n- '&c%d&6 进入了幻想乡。'\n- '&c%d&6 成为了阿卡林！'\nwither:\n- '&c%d&6 被凋零炸死。'\nwithereffect:\n- '&c%d&6 凋零了。'\nwitherskeleton:\n- '&c%d&6 被凋零骷髅追杀。'\nwolf:\n- '&c%d&6 被 &a%k&6 的狼吃了！'\nzombie:\n- '&c%d&6 变身僵尸！'");
			} catch (InvalidConfigurationException e1) {}
			try {
				messagesyml.save(messages);
			} catch (IOException e) {}
		}
		
		// combo messages
		File combo = new File(folder, "combo.yml");
		if (!combo.exists()){
			Bukkit.getLogger().info("[MultiKillW] Creating combo.yml");
			FileConfiguration comboyml = YamlConfiguration.loadConfiguration(combo);
			try {
				comboyml.loadFromString("breakkill:\n  3: '&a%k&6 终结了 &c%d&6 的大杀特杀！'\n  4: '&a%k&6 终结了 &c%d&6 的主宰服务器！'\n  5: '&a%k&6 终结了 &c%d&6 的杀人如麻！'\n  6: '&a%k&6 终结了 &c%d&6 的无人能挡！'\n  7: '&a%k&6 终结了 &c%d&6 的杀得变态了！'\n  8: '&a%k&6 终结了 &c%d&6 的妖怪般杀戮！'\n  9: '&a%k&6 终结了 &c%d&6 的如同神一般！'\n  10: '&a%k&6 终结了 &c%d&6 的超越神！'\nkill:\n  3: '&a%k&6 正在大杀特杀！'\n  4: '&a%k&6 主宰服务器！'\n  5: '&a%k&6 杀人如麻！'\n  6: '&a%k&6 无人能挡！'\n  7: '&a%k&6 杀得变态了！'\n  8: '&a%k&6 正在像妖怪般杀戮！'\n  9: '&a%k&6 如同神一般！'\n  10: '&a%k&6 已经超越神了！拜托谁去杀了他吧！'\nbreakdeath:\n  3: '&a%k&6 杀死了 &c%d&6 从而终结了他的大死特死！'\n  4: '&a%k&6 杀死了 &c%d&6 从而终结了他的被主宰了！'\n  5: '&a%k&6 杀死了 &c%d&6 从而终结了他的被杀得入魔了！'\n  6: '&a%k&6 杀死了 &c%d&6 从而终结了他的无可救药！'\n  7: '&a%k&6 杀死了 &c%d&6 从而终结了他被杀得变态了！'\n  8: '&a%k&6 杀死了 &c%d&6 从而终结了他的像逗比一样！'\n  9: '&a%k&6 杀死了 &c%d&6 从而终结了他被杀的像鬼一样了！'\n  10: '&a%k&6 杀死了 &c%d&6 从而终结了他超越鬼的被杀！终于有人送他了啊！'\ndeath:\n  3: '&c%d&6 正在大死特死！'\n  4: '&c%d&6 被主宰了！'\n  5: '&c%d&6 被杀得入魔了！'\n  6: '&c%d&6 无可救药了！'\n  7: '&c%d&6 被杀得变态了！'\n  8: '&c%d&6 简直像一个逗比一样！'\n  9: '&c%d&6 已经被杀的像鬼一样了！'\n  10: '&c%d&6 已经超越鬼的被杀！拜托谁去送他吧！'\n");
			} catch (InvalidConfigurationException e1) {}
			try {
				comboyml.save(combo);
			} catch (IOException e) {}
		}
		
		// item messages
		File item = new File(folder, "item.yml");
		if (!item.exists()){
			Bukkit.getLogger().info("[MultiKillW] Creating item.yml");
			FileConfiguration itemyml = YamlConfiguration.loadConfiguration(item);
			try {
				itemyml.loadFromString("AIR: 空气\nSTONE: 石头\nGRASS: 草\nDIRT: 泥土\nCOBBLESTONE: 碎石\nWOOD: 木板\nSAPLING: 树苗\nBEDROCK: 地基石\nWATER: 水\nSTATIONARY_WATER: 水\nLAVA: 岩浆\nSTATIONARY_LAVA: 岩浆\nSAND: 沙子\nGRAVEL: 沙砾\nGOLD_ORE: 金矿\nIRON_ORE: 铁矿\nCOAL_ORE: 煤矿\nLOG: 木头\nLEAVES: 树叶\nSPONGE: 海绵\nGLASS: 玻璃\nLAPIS_ORE: 青金石矿\nLAPIS_BLOCK: 青金石块\nDISPENSER: 射箭机\nSANDSTONE: 沙石\nNOTE_BLOCK: 音乐盒\nBED_BLOCK: 床\nPOWERED_RAIL: 动力铁轨\nDETECTOR_RAIL: 压力铁轨\nPISTON_STICKY_BASE: 粘性活塞\nWEB: 蜘蛛网\nLONG_GRASS: 草\nDEAD_BUSH: 枯树\nPISTON_BASE: 活塞\nPISTON_EXTENSION: 活塞\nWOOL: 羊毛\nPISTON_MOVING_PIECE: 36号方块\nYELLOW_FLOWER: 花\nRED_ROSE: 花\nBROWN_MUSHROOM: 蘑菇\nRED_MUSHROOM: 蘑菇\nGOLD_BLOCK: 金块\nIRON_BLOCK: 铁块\nDOUBLE_STEP: 两块半砖\nSTEP: 半砖\nBRICK: 砖块\nTNT: TNT\nBOOKSHELF: 书架\nMOSSY_COBBLESTONE: 苔石\nOBSIDIAN: 黑曜石\nTORCH: 火把\nFIRE: 火\nMOB_SPAWNER: 刷怪笼\nWOOD_STAIRS: 楼梯\nCHEST: 箱子\nREDSTONE_WIRE: 红石\nDIAMOND_ORE: 钻石矿\nDIAMOND_BLOCK: 钻石块\nWORKBENCH: 工作台\nCROPS: 作物\nSOIL: 耕地\nFURNACE: 壁炉\nBURNING_FURNACE: 壁炉\nSIGN_POST: 牌子\nWOODEN_DOOR: 木门\nLADDER: 梯子\nRAILS: 铁轨\nCOBBLESTONE_STAIRS: 碎石楼梯\nWALL_SIGN: 牌子\nLEVER: 拉杆\nSTONE_PLATE: 石头踏板\nIRON_DOOR_BLOCK: 铁门\nWOOD_PLATE: 木头踏板\nREDSTONE_ORE: 红石矿\nGLOWING_REDSTONE_ORE: 红石矿\nREDSTONE_TORCH_OFF: 红石火把\nREDSTONE_TORCH_ON: 红石火把\nSTONE_BUTTON: 木制按钮\nSNOW: 雪\nICE: 冰\nSNOW_BLOCK: 雪块\nCACTUS: 仙人掌\nCLAY: 粘土\nSUGAR_CANE_BLOCK: 甘蔗\nJUKEBOX: 唱片机\nFENCE: 栅栏\nPUMPKIN: 南瓜\nNETHERRACK: 地狱岩\nSOUL_SAND: 灵魂沙\nGLOWSTONE: 萤石\nPORTAL: 传送门\nJACK_O_LANTERN: 南瓜灯\nCAKE_BLOCK: 蛋糕\nDIODE_BLOCK_OFF: 中继器\nDIODE_BLOCK_ON: 中继器\nSTAINED_GLASS: 染色玻璃\nTRAP_DOOR: 陷阱门\nMONSTER_EGGS: 刷怪砖块\nSMOOTH_BRICK: 石砖\nHUGE_MUSHROOM_1: 蘑菇块\nHUGE_MUSHROOM_2: 蘑菇块\nIRON_FENCE: 铁栅栏\nTHIN_GLASS: 薄玻璃\nMELON_BLOCK: 西瓜\nPUMPKIN_STEM: 南瓜苗\nMELON_STEM: 西瓜苗\nVINE: 106\n 蔓藤\nFENCE_GATE: 栅栏门\nBRICK_STAIRS: 砖块楼梯\nSMOOTH_STAIRS: 石砖楼梯\nMYCEL: 菌丝\nWATER_LILY: 荷叶\nNETHER_BRICK: 地狱砖\nNETHER_FENCE: 地狱栅栏\nNETHER_BRICK_STAIRS: 地狱楼梯\nNETHER_WARTS: 地狱疣\nENCHANTMENT_TABLE: 附魔台\nBREWING_STAND: 炼药台\nCAULDRON: 炼药桶\nENDER_PORTAL: 传送门\nENDER_PORTAL_FRAME: 传送门框\nENDER_STONE: 末地石\nDRAGON_EGG: 龙蛋\nREDSTONE_LAMP_OFF: 红石灯\nREDSTONE_LAMP_ON: 红石灯\nWOOD_DOUBLE_STEP: 双半砖\nWOOD_STEP: 木头半砖\nCOCOA: 可可豆\nSANDSTONE_STAIRS: 沙石楼梯\nEMERALD_ORE: 绿宝石\nENDER_CHEST: 末影箱\nTRIPWIRE_HOOK: 绊线勾\nTRIPWIRE: 绊线\nEMERALD_BLOCK: 绿宝石块\nSPRUCE_WOOD_STAIRS: 木制楼梯\nBIRCH_WOOD_STAIRS: 木制楼梯\nJUNGLE_WOOD_STAIRS: 木制楼梯\nCOMMAND: 指令方块\nBEACON: 信标\nCOBBLE_WALL: 石头栅栏\nFLOWER_POT: 花盆\nCARROT: 萝卜\nPOTATO: 土豆\nWOOD_BUTTON: 木制按钮\nSKULL: 头\nANVIL: 铁砧\nTRAPPED_CHEST: 陷阱箱\nGOLD_PLATE: 金踏板\nIRON_PLATE: 铁踏板\nREDSTONE_COMPARATOR_OFF: 红石比较器\nREDSTONE_COMPARATOR_ON: 红石比较器\nDAYLIGHT_DETECTOR: 光感器\nREDSTONE_BLOCK: 红石块\nQUARTZ_ORE: 石英矿\nHOPPER: 漏斗\nQUARTZ_BLOCK: 石英块\nQUARTZ_STAIRS: 石英楼梯\nACTIVATOR_RAIL: 激活铁轨\nDROPPER: 投掷器\nSTAINED_CLAY: 染色粘土\nSTAINED_GLASS_PANE: 染色薄玻璃\nLEAVES_2: 树叶\nLOG_2: 木头\nACACIA_STAIRS: 木制楼梯\nDARK_OAK_STAIRS: 木制楼梯\nSLIME_BLOCK: 史莱姆方块\nBARRIER: 屏障\nIRON_TRAPDOOR: 铁陷阱门\nPRISMARINE: 海晶石\nSEA_LANTERN: 海晶灯\nHAY_BLOCK: 稻草\nCARPET: 地毯\nHARD_CLAY: 粘土\nCOAL_BLOCK: 煤块\nPACKED_ICE: 蓝冰\nDOUBLE_PLANT: 花\nSTANDING_BANNER: 旗帜\nWALL_BANNER: 旗帜\nDAYLIGHT_DETECTOR_INVERTED: 光感器\nRED_SANDSTONE: 红色沙石\nRED_SANDSTONE_STAIRS: 沙石楼梯\nDOUBLE_STONE_SLAB2: 双半砖\nSTONE_SLAB2: 半砖\nSPRUCE_FENCE_GATE: 栅栏门\nBIRCH_FENCE_GATE: 栅栏门\nJUNGLE_FENCE_GATE: 栅栏门\nDARK_OAK_FENCE_GATE: 栅栏门\nACACIA_FENCE_GATE: 栅栏门\nSPRUCE_FENCE: 栅栏\nBIRCH_FENCE: 栅栏\nJUNGLE_FENCE: 栅栏\nDARK_OAK_FENCE: 栅栏\nACACIA_FENCE: 栅栏\nSPRUCE_DOOR: 木门\nBIRCH_DOOR: 木门\nJUNGLE_DOOR: 木门\nACACIA_DOOR: 木门\nDARK_OAK_DOOR: 木门\nIRON_SPADE: 铁铲\nIRON_PICKAXE: 铁镐\nIRON_AXE: 铁斧\nFLINT_AND_STEEL: 打火机\nAPPLE: 苹果\nBOW: 弓\nARROW: 箭\nCOAL: 煤\nDIAMOND: 钻石\nIRON_INGOT: 铁锭\nGOLD_INGOT: 金锭\nIRON_SWORD: 铁剑\nWOOD_SWORD: 木剑\nWOOD_SPADE: 木铲\nWOOD_PICKAXE: 木镐\nWOOD_AXE: 木斧\nSTONE_SWORD: 石剑\nSTONE_SPADE: 石铲\nSTONE_PICKAXE: 石镐\nSTONE_AXE: 石斧\nDIAMOND_SWORD: 钻石剑\nDIAMOND_SPADE: 钻石铲\nDIAMOND_PICKAXE: 钻石镐\nDIAMOND_AXE: 钻石斧\nSTICK: 木棍\nBOWL: 碗\nMUSHROOM_SOUP: 蘑菇汤\nGOLD_SWORD: 金剑\nGOLD_SPADE: 金铲\nGOLD_PICKAXE: 金镐\nGOLD_AXE: 金斧\nSTRING: 线\nFEATHER: 羽毛\nSULPHUR: 火药\nWOOD_HOE: 木锄\nSTONE_HOE: 石锄\nIRON_HOE: 铁锄\nDIAMOND_HOE: 钻石锄\nGOLD_HOE: 金锄\nSEEDS: 种子\nWHEAT: 小麦\nBREAD: 面包\nLEATHER_HELMET: 皮帽\nLEATHER_CHESTPLATE: 皮衣\nLEATHER_LEGGINGS: 皮裤\nLEATHER_BOOTS: 皮鞋\nCHAINMAIL_HELMET: 铁链盔\nCHAINMAIL_CHESTPLATE: 铁链胸甲\nCHAINMAIL_LEGGINGS: 铁链腿甲\nCHAINMAIL_BOOTS: 铁链靴\nIRON_HELMET: 铁盔\nIRON_CHESTPLATE: 铁胸甲\nIRON_LEGGINGS: 铁腿甲\nIRON_BOOTS: 铁靴\nDIAMOND_HELMET: 钻石盔\nDIAMOND_CHESTPLATE: 钻石胸甲\nDIAMOND_LEGGINGS: 钻石腿甲\nDIAMOND_BOOTS: 钻石靴\nGOLD_HELMET: 金盔\nGOLD_CHESTPLATE: 金胸甲\nGOLD_LEGGINGS: 金腿甲\nGOLD_BOOTS: 金靴\nFLINT: 燧石\nPORK: 生猪肉\nGRILLED_PORK: 熟猪肉\nPAINTING: 挂画\nGOLDEN_APPLE: 金苹果\nSIGN: 牌子\nWOOD_DOOR: 木门\nBUCKET: 铁桶\nWATER_BUCKET: 水桶\nLAVA_BUCKET: 岩浆桶\nMINECART: 矿车\nSADDLE: 马鞍\nIRON_DOOR: 铁门\nREDSTONE: 红石\nSNOW_BALL: 雪球\nBOAT: 船\nLEATHER: 皮革\nMILK_BUCKET: 牛奶\nCLAY_BRICK: 砖头\nCLAY_BALL: 粘土球\nSUGAR_CANE: 甘蔗\nPAPER: 纸\nBOOK: 书\nSLIME_BALL: 史莱姆球\nSTORAGE_MINECART: 储物矿车\nPOWERED_MINECART: 动力矿车\nEGG: 鸡蛋\nCOMPASS: 指南针\nFISHING_ROD: 鱼竿\nWATCH: 表\nGLOWSTONE_DUST: 萤石粉\nRAW_FISH: 生鱼\nCOOKED_FISH: 熟鱼\nINK_SACK: 染料\nBONE: 骨头\nSUGAR: 糖\nCAKE: 蛋糕\nBED: 床\nDIODE: 红石中继器\nCOOKIE: 饼干\nMAP: 地图\nSHEARS: 剪刀\nMELON: 西瓜\nPUMPKIN_SEEDS: 南瓜种子\nMELON_SEEDS: 西瓜种子\nRAW_BEEF: 生牛肉\nCOOKED_BEEF: 熟牛肉\nRAW_CHICKEN: 生鸡肉\nCOOKED_CHICKEN: 熟鸡肉\nROTTEN_FLESH: 腐肉\nENDER_PEARL: 末影珍珠\nBLAZE_ROD: 烈焰棒\nGHAST_TEAR: 恶魂之泪\nGOLD_NUGGET: 金粒\nNETHER_STALK: 地狱疣\nPOTION: 药水\nGLASS_BOTTLE: 瓶子\nSPIDER_EYE: 蜘蛛眼\nFERMENTED_SPIDER_EYE: 发酵蜘蛛眼\nBLAZE_POWDER: 烈焰粉\nMAGMA_CREAM: 岩浆膏\nBREWING_STAND_ITEM: 炼药台\nCAULDRON_ITEM: 炼药锅\nEYE_OF_ENDER: 末影眼\nSPECKLED_MELON: 西瓜\nMONSTER_EGG: 刷怪蛋\nEXP_BOTTLE: 附魔瓶\nFIREBALL: 火焰弹\nBOOK_AND_QUILL: 书与笔\nWRITTEN_BOOK: 成书\nEMERALD: 绿宝石\nITEM_FRAME: 展示框\nFLOWER_POT_ITEM: 花盆\nCARROT_ITEM: 萝卜\nPOTATO_ITEM: 土豆\nBAKED_POTATO: 烤土豆\nPOISONOUS_POTATO: 毒土豆\nEMPTY_MAP: 地图\nGOLDEN_CARROT: 金萝卜\nSKULL_ITEM: 头\nCARROT_STICK: 鱼竿和萝卜\nNETHER_STAR: 下界之星\nPUMPKIN_PIE: 南瓜派\nFIREWORK: 烟花\nFIREWORK_CHARGE: 火药球\nENCHANTED_BOOK: 附魔书\nREDSTONE_COMPARATOR: 红石比较器\nNETHER_BRICK_ITEM: 地狱砖块\nQUARTZ: 石英\nEXPLOSIVE_MINECART: TNT矿车\nHOPPER_MINECART: 漏斗矿车\nPRISMARINE_SHARD: 海晶碎片\nPRISMARINE_CRYSTALS: 海晶水晶\nRABBIT: 生兔肉\nCOOKED_RABBIT: 熟兔肉\nRABBIT_STEW: 兔子汤\nRABBIT_FOOT: 兔子腿\nRABBIT_HIDE: 兔子皮\nARMOR_STAND: 盔甲架\nIRON_BARDING: 铁马凯\nGOLD_BARDING: 金马凯\nDIAMOND_BARDING: 钻石马凯\nLEASH: 拴绳\nNAME_TAG: 命名牌\nCOMMAND_MINECART: 指令矿车\nMUTTON: 生羊肉\nCOOKED_MUTTON: 熟羊肉\nBANNER: 旗帜\nSPRUCE_DOOR_ITEM: 木门\nBIRCH_DOOR_ITEM: 木门\nJUNGLE_DOOR_ITEM: 木门\nACACIA_DOOR_ITEM: 木门\nDARK_OAK_DOOR_ITEM: 木门\nGOLD_RECORD: 唱片\nGREEN_RECORD: 唱片\nRECORD_3: 唱片\nRECORD_4: 唱片\nRECORD_5: 唱片\nRECORD_6: 唱片\nRECORD_7: 唱片\nRECORD_8: 唱片\nRECORD_9: 唱片\nRECORD_10: 唱片\nRECORD_11: 唱片\nRECORD_12: 唱片\n");
			} catch (InvalidConfigurationException e1) {}
			try {
				itemyml.save(item);
			} catch (IOException e) {}
		}
		
	}
	
}

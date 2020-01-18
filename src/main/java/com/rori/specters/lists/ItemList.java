package com.rori.specters.lists;

import net.minecraft.item.Item;

/* HOW TO ADD ITEMS:
 * Add a new public static Item with the slug name here.
 * Register the Item inside of the registerItems function.
 * Add an entry inside of the langfiles in lang.
 * Add an item model inside of models/item
 * Add the texture inside of textures/item
 * 
 * As a basis, silver_ingot can be used as an example for all items. For tools and armour use silver_sword and silver_chestplate respectively
 * Simply copypaste any .json files or respective code lines and replace any silver_ingot entries with the new item's slug.
 */

public class ItemList {
	//Items
	public static Item silver_ingot;
	
	//Tools
	public static Item silver_axe;
	public static Item silver_hoe;
	public static Item silver_pickaxe;
	public static Item silver_shovel;
	public static Item silver_sword;
	
	//Armour
	public static Item silver_helmet;
	public static Item silver_chestplate;
	public static Item silver_leggings;
	public static Item silver_boots;
	
	//Blocks
	public static Item silver_block;
	public static Item silver_ore;
}

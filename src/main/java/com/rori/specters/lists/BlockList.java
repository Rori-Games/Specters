package com.rori.specters.lists;

import net.minecraft.block.Block;

/* HOW TO ADD BLOCKS:
 * Add a new public static Block with the slug name here.
 * Register the Block itself in the main file's registerBlocks function
 * Register the Item of the Block (inventory item/block) inside of the registerItems function.
 * Add a blockstate inside of blockstates
 * Add an entry inside of the langfiles in lang.
 * Add a block model inside of models/block
 * Add an item model inside of models/item
 * Add the texture inside of textures/block
 * 
 * As a basis, silver_block can be used as an example for all "basic" blocks.
 * Simply copypaste any .json files or respective code lines and replace any silver_block entries with the new block's slug.
 */

public class BlockList {
	public static Block silver_block;
	public static Block silver_ore;
}

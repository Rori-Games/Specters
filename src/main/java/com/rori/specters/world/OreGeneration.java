package com.rori.specters.world;

import com.rori.specters.config.OregenConfig;
import com.rori.specters.lists.BlockList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	public static void setupOreGeneration() {
		//Flag if overworld generation is enabled
		if (OregenConfig.generate_overworld.get()) {
			//Loop through all existing biomes.
			for (Biome biome : ForgeRegistries.BIOMES) {
				/*Create Ore probability configuration. 
				 *CountRangeConfig Params:
				 *Orecount: number of ores per vein
				 *minOffset: lowest y coordinate for the ore to spawn at
				 *maxOffsetBase: ?? Bad documentation. Set to 0 - seems to work properly
				 *maxOffset: highest y coordinate for the ore to spawn at
				 *TODO: Figure out exact workings of this method. With the settings 100 20 0 60, ores will appear between y15 and y85.
				 */
				CountRangeConfig silver_ore_placement = new CountRangeConfig(OregenConfig.silver_chance.get(), 20, 0, 60);
				
				//Actually adding the spawning order to the biome itself. For now just copypaste and replace the respective ore with another.
				//This works for underground minerals that do replace smooth stone.
				biome.addFeature(Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.silver_ore.getDefaultState(), OregenConfig.silver_chance.get()),
								Placement.COUNT_RANGE,
								silver_ore_placement));
			}
		}
	}
}

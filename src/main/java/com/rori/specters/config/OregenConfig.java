package com.rori.specters.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	public static ForgeConfigSpec.IntValue silver_chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Oregen Config");
		
		silver_chance = server
				.comment("Maximum number of ore veins of silver ore that can spawn in one chunk")
				.defineInRange("oregen.silver_chance", 100, 1, 1000);
		
		generate_overworld = server
				.comment("Can Specter Ores spawn in the Overworld?")
				.define("oregen.generate_overworld", true);
	}
}

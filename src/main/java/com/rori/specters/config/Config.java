package com.rori.specters.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.rori.specters.Specters;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
	private static final ForgeConfigSpec.Builder serverBuilder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec serverConfig;
	
	private static final ForgeConfigSpec.Builder clientBuilder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec clientConfig;
	
	static {
		OregenConfig.init(serverBuilder, clientBuilder);
		
		serverConfig = serverBuilder.build();
		clientConfig = clientBuilder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path) {
		Specters.logger.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		Specters.logger.info("Built config: " + path);
		file.load();
		Specters.logger.info("Loaded config: " + path);
		config.setConfig(file);
	}
}

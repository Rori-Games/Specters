package com.rori.specters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rori.specters.lists.ArmourMaterialList;
import com.rori.specters.lists.BlockList;
import com.rori.specters.lists.ItemList;
import com.rori.specters.lists.ToolMaterialList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("specters")
public class Specters {
	
	public static Specters instance;
	public static final String modid = "specters";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup spectersIG = new SpectersItemGroup();
	
	public Specters() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	//PreInit
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("setup method registered");
	}
	
	//Client-Only PreInit
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("clientRegistries method registered");		
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
			//Items
			ItemList.silver_ingot = new Item(new Item.Properties().group(spectersIG)).setRegistryName(location("silver_ingot")),
			ItemList.purple_gem = new Item(new Item.Properties().group(spectersIG)).setRegistryName(location("purple_gem")),
			
			//Tools
			ItemList.silver_axe = new AxeItem(ToolMaterialList.silver, -1.0f, 6.0f, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_axe")),
			ItemList.silver_pickaxe = new PickaxeItem(ToolMaterialList.silver, -2, 6.0f, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_pickaxe")),
			ItemList.silver_hoe = new HoeItem(ToolMaterialList.silver, 6.0f, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_hoe")),
			ItemList.silver_shovel = new ShovelItem(ToolMaterialList.silver, -3.0f, 6.0f, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_shovel")),
			ItemList.silver_sword = new SwordItem(ToolMaterialList.silver, 0, 6.0f, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_sword")),
			
			//Armour
			ItemList.silver_helmet = new ArmorItem(ArmourMaterialList.silver, EquipmentSlotType.HEAD, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_helmet")),
			ItemList.silver_chestplate = new ArmorItem(ArmourMaterialList.silver, EquipmentSlotType.CHEST, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_chestplate")),
			ItemList.silver_leggings = new ArmorItem(ArmourMaterialList.silver, EquipmentSlotType.LEGS, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_leggings")),
			ItemList.silver_boots = new ArmorItem(ArmourMaterialList.silver, EquipmentSlotType.FEET, new Item.Properties().group(spectersIG)).setRegistryName(location("silver_boots")),
											
			//Blocks
			ItemList.silver_block = new BlockItem(BlockList.silver_block, new Item.Properties().group(spectersIG)).setRegistryName(BlockList.silver_block.getRegistryName()),
			ItemList.silver_ore = new BlockItem(BlockList.silver_ore, new Item.Properties().group(spectersIG)).setRegistryName(BlockList.silver_ore.getRegistryName())
			);
			
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
			BlockList.silver_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("silver_block")),
			BlockList.silver_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("silver_ore"))
			);
			
			
			logger.info("Blocks registered.");
		}
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}
}

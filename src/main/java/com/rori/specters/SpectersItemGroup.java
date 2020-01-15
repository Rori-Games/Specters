package com.rori.specters;

import com.rori.specters.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SpectersItemGroup extends ItemGroup {

	public SpectersItemGroup() {
		super("specters");

	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.silver_ingot);
	}

}

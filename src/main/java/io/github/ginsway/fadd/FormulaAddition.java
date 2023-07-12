package io.github.ginsway.fadd;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormulaAddition implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("formula_addition");

	public static final String MODID= "formula_addition";
	public static final Item THE_CAKE_IS_A_LIE =
			Registry.register(Registries.ITEM, new Identifier("formula_addition", "the_cake_is_a_lie"),
					new Item(new FabricItemSettings()));

	public static final Item SODIUM_HYDROXIDE =
			Registry.register(Registries.ITEM, new Identifier("formula_addition", "sodium_hydroxide"),
					new Item(new FabricItemSettings()));
	private static final RegistryKey<ItemGroup> FORMULA_ADDITION_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MODID, "test_group"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM_GROUP, FORMULA_ADDITION_GROUP, FabricItemGroup.builder()
				       .displayName(Text.translatable("itemGroup.formula_addition.group"))
				       .icon(() -> new ItemStack(Items.GOLDEN_APPLE))
				       .entries((context, entries) -> {
	         entries.add(THE_CAKE_IS_A_LIE);
			 entries.add(SODIUM_HYDROXIDE);
	       })
				       .build()
				    );
		LOGGER.info("Hello Fabric world!");
	}
}

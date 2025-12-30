package name.bettercrops;

import name.bettercrops.block.ModBlocks;
import name.bettercrops.item.ModItems;
import name.bettercrops.world.ModConfiguredFeatures;
import name.bettercrops.world.ModPlacedFeatures;
import name.bettercrops.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterCrops implements ModInitializer {
	public static final String MOD_ID = "bettercrops";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5F);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.3F);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BLACKBERRIES, 0.2F);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.2F);


		ModWorldGeneration.generateModWorldGen();
	}

}
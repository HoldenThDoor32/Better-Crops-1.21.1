package name.bettercrops.item;

import name.bettercrops.BetterCrops;
import name.bettercrops.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));

    public static final Item BLACKBERRIES = registerItem("blackberries",
            new AliasedBlockItem(ModBlocks.BLACKBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLACKBERRIES)));

    public static final Item BLUEBERRIES = registerItem("blueberries",
            new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLUEBERRIES)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterCrops.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterCrops.LOGGER.info("Registering Mod Items for " + BetterCrops.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.BEETROOT_SEEDS, CAULIFLOWER_SEEDS);
            entries.addAfter(Items.SWEET_BERRIES, BLACKBERRIES);
            entries.addAfter(ModItems.BLACKBERRIES, BLUEBERRIES);


        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.CARROT, CAULIFLOWER);

        });


    }
}
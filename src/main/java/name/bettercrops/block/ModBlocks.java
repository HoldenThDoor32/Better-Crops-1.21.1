package name.bettercrops.block;


import name.bettercrops.BetterCrops;
import name.bettercrops.block.custom.BlackberryBushBlock;
import name.bettercrops.block.custom.CauliflowerCropBlock;
import name.bettercrops.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //INITIALIZED BLOCKS BELOW THIS POINT
    public static final Block CAULIFLOWER_CROP = registerBlockWithoutItem(
            "cauliflower_block", new CauliflowerCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .mapColor(MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)

            ));

    public static final Block BLACKBERRY_BUSH = registerBlockWithoutItem(
            "blackberry_bush", new BlackberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH))
    );



    //FUNCTIONS BELOW THIS POINT

    //registers the block into the system while not registering an item along with it, such as a crop.
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(BetterCrops.MOD_ID, name), block);
    }

    //registers the block into the system
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BetterCrops.MOD_ID, name), block);
    }

    //registers the block in item form into the system
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BetterCrops.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BetterCrops.LOGGER.info("Registering Mod Blocks for " + BetterCrops.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
        });

    }


}

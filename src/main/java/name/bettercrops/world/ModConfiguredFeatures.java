package name.bettercrops.world;

import name.bettercrops.BetterCrops;
import name.bettercrops.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;
//defines what exactly is being placed in the world and how it works. Ex: how many ores per vein.


public class ModConfiguredFeatures {
    //here, we register every new item that will generate in the world.

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKBERRY_BUSH_KEY = registerKey("blackberry_bush_placed");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH_KEY = registerKey("blueberry_bush_placed");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        //register the block configs here.

        register(context, BLACKBERRY_BUSH_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig
                (Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                        .add(ModBlocks.BLACKBERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 1), 1)
                                        .add(ModBlocks.BLACKBERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 2), 1)
                                        .add(ModBlocks.BLACKBERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 3), 1)
                                        .build())),
                        List.of(Blocks.GRASS_BLOCK))
        );

        register(context, BLUEBERRY_BUSH_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig
                (Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                        .add(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 1), 1)
                                        .add(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 2), 1)
                                        .add(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 3), 1)
                                        .build())),
                        List.of(Blocks.GRASS_BLOCK))
        );

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BetterCrops.MOD_ID, name));
    }

    //for bush generation
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}

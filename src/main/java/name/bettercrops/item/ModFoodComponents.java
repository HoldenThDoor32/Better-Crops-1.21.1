package name.bettercrops.item;

import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

public class ModFoodComponents {

    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 100), 0.15f)
            .build();


    public static final FoodComponent BLACKBERRIES = FoodComponents.SWEET_BERRIES;
}
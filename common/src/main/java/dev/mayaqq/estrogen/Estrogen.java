package dev.mayaqq.estrogen;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.mayaqq.estrogen.networking.EstrogenC2S;
import dev.mayaqq.estrogen.registry.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Estrogen {
    public static final String MOD_ID = "estrogen";

    public static final Logger LOGGER = LoggerFactory.getLogger("Estrogen");

    // Used to register some of the registry objects, other is done by architectury
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create("estrogen");

    // The registering part done by architectury
    static {
        // Tooltip modifier for Centrifuge
        REGISTRATE.setTooltipModifierFactory(item ->
                new ItemDescription.Modifier(item, TooltipHelper.Palette.STANDARD_CREATE)
                        .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
        );
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void init() {
        // Init all the different classes
        EstrogenCreativeTab.init();
        EstrogenAttributes.register();
        EstrogenBlockEntities.register();
        EstrogenBlocks.register();
        EstrogenEffects.MOB_EFFECTS.init();
        EstrogenEnchantments.register();
        EstrogenEvents.register();
        EstrogenFluids.register();
        EstrogenFluidBlocks.register();
        EstrogenFluidItems.register();
        EstrogenFluidAttributes.register();
        EstrogenItems.register();
        EstrogenRecipes.RECIPE_SERIALIZERS.init();
        EstrogenRecipes.RECIPE_TYPES.init();
        EstrogenSounds.SOUNDS.init();
        EstrogenC2S.register();
    }
}
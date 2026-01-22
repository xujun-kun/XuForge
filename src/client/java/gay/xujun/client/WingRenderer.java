package gay.xujun.client;

import mod.azure.azurelibarmor.common.render.armor.AzArmorRenderer;
import mod.azure.azurelibarmor.common.render.armor.AzArmorRendererConfig;
import net.minecraft.util.Identifier;

public class WingRenderer extends AzArmorRenderer {
    private static final Identifier GEO = Identifier.of("xuforge", "geo/WingModel.geo.json");
    private static final Identifier TEX = Identifier.of("xuforge", "textures/entity/travel_wings.png");

    public WingRenderer() {
        super(AzArmorRendererConfig.builder(GEO, TEX)
                .setAnimatorProvider(stack -> new WingAnimator())
                .build());
    }
}
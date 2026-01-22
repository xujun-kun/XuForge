package gay.xujun.client;

import gay.xujun.ModItem;
import mod.azure.azurelibarmor.common.render.armor.AzArmorRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class XuForgeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AzArmorRendererRegistry.register(
                WingRenderer::new,
                ModItem.TRAVELERS_WINGS
        );
    }
}
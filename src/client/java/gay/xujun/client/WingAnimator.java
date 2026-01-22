package gay.xujun.client;

import mod.azure.azurelib.common.animation.impl.AzItemAnimator; // impl の中にある可能性が高いです
import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors; // もしくは play_behavior
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import java.util.UUID;

public class WingAnimator extends AzItemAnimator<UUID, ItemStack> {
    private static final Identifier ANIMATIONS = Identifier.of("xuforge", "animations/WingModel.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<UUID, ItemStack> container) {
        container.add(
                AzAnimationController.builder(this, "base_controller")
                        .setAnimationHandler(instance -> {
                            return AzPlayBehaviors.LOOP.createAzCommand("animation.WingModel.default");
                        })
                        .build()
        );
    }

    @Override
    public Identifier getAnimationLocation(ItemStack animatable) {
        return ANIMATIONS;
    }
}
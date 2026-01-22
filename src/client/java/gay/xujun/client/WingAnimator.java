package gay.xujun.client;

import mod.azure.azurelib.common.animation.AzAnimator;
import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import java.util.UUID;

// 1. クラスは 2個 必要
public class WingAnimator extends AzAnimator<UUID, ItemStack> {
    private static final Identifier ANIMATIONS = Identifier.of("xuforge", "animations/WingModel.animation.json");

    @Override
    // 2. コンテナは 1個 (ItemStack) だけ指定
    public void registerControllers(AzAnimationControllerContainer<ItemStack> container) {
        container.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    // 3. 引数は ItemStack
    public Identifier getAnimationLocation(ItemStack animatable) {
        return ANIMATIONS;
    }
}
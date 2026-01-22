package gay.xujun.items;

import gay.xujun.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import java.util.List;

public class TravelersWings extends ArmorItem {

    public TravelersWings() {
        super(ModArmorMaterials.TRAVELER, Type.LEGGINGS, new Settings().maxCount(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
            EntityAttributeInstance jumpStrength = player.getAttributeInstance(EntityAttributes.GENERIC_JUMP_STRENGTH);

            if (jumpStrength != null) {
                if (leggings == stack) {
                    if (jumpStrength.getBaseValue() != 0.65) {
                        jumpStrength.setBaseValue(0.65);
                    }
                } else {
                    if (jumpStrength.getBaseValue() == 0.65) {
                        jumpStrength.setBaseValue(0.42);
                    }
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.xuforge.travelers_wings.tooltip").formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("装備時: ジャンプ力が大幅に上昇する").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
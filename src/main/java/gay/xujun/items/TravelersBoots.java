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

public class TravelersBoots extends ArmorItem {

    public TravelersBoots() {
        super(ModArmorMaterials.TRAVELER, Type.BOOTS, new Settings().maxCount(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {

            ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

            EntityAttributeInstance stepHeight = player.getAttributeInstance(EntityAttributes.GENERIC_STEP_HEIGHT);

            if (stepHeight != null) {
                if (boots == stack) {
                    stepHeight.setBaseValue(1.0);
                } else if (stepHeight.getBaseValue() == 1.0) {
                    stepHeight.setBaseValue(0.6);
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.xuforge.travelers_boots.tooltip").formatted(Formatting.YELLOW));
        tooltip.add(Text.literal("装備時: 1ブロックの段差を自動で登る").formatted(Formatting.BLUE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
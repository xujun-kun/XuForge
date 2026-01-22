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

public class TravelersVest extends ArmorItem {

    public TravelersVest() {
        super(ModArmorMaterials.TRAVELER, Type.CHESTPLATE, new Settings().maxCount(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);

            EntityAttributeInstance waterSpeed = player.getAttributeInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY);

            if (waterSpeed != null) {
                if (chest == stack) {
                    if (waterSpeed.getBaseValue() != 1.5) {
                        waterSpeed.setBaseValue(1.5);
                    }
                } else {
                    if (waterSpeed.getBaseValue() == 1.5) {
                        waterSpeed.setBaseValue(0.0);
                    }
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.xuforge.travelers_vest.tooltip").formatted(Formatting.YELLOW));
        tooltip.add(Text.translatable("item.xuforge.travelers_vest.tooltip2").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
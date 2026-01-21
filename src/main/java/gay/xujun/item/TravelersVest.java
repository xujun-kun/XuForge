package gay.xujun.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class TravelersVest extends ArmorItem {

    public TravelersVest() {
        super(ArmorMaterials.IRON, Type.CHESTPLATE, new Settings().maxCount(1));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.xuforge.travelers_vest.tooltip").formatted(Formatting.YELLOW));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
package gay.xujun;

import gay.xujun.items.TravelersBoots;
import gay.xujun.items.TravelersGoggles;
import gay.xujun.items.TravelersVest;
import gay.xujun.items.TravelersWings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {

    public static final Item TRAVELERS_GOGGLES = registerItem("travelers_goggles", new TravelersGoggles());
    public static final Item TRAVELERS_VEST = registerItem("travelers_vest",new TravelersVest());
    public static final Item TRAVELERS_WINGS = registerItem("travelers_wings",new TravelersWings());
    public static final Item TRAVELERS_BOOTS = registerItem("travelers_boots",new TravelersBoots());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(XuForge.MOD_ID, name), item);
    }


    public static void registerModItems() {
        XuForge.LOGGER.info("Registering Mod Items");
    }
}
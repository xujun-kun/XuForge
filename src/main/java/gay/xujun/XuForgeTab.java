package gay.xujun;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class XuForgeTab {
    public static final RegistryKey<ItemGroup> XUFORGE_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("xuforge", "item_group"));

    public static final ItemGroup XUFORGE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItem.TRAVELERS_WINGS))
            .displayName(Text.translatable("itemGroup.xuforge.items"))
            .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, XUFORGE_GROUP_KEY, XUFORGE_GROUP);

        ItemGroupEvents.modifyEntriesEvent(XUFORGE_GROUP_KEY).register(content -> {
            content.add(ModItem.TRAVELERS_GOGGLES);
            content.add(ModItem.TRAVELERS_VEST);
            content.add(ModItem.TRAVELERS_WINGS);
            content.add(ModItem.TRAVELERS_BOOTS);
        });
    }
}
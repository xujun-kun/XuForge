package gay.xujun;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import gay.xujun.XuForge;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> TRAVELER = register("travel", Map.of(
            ArmorItem.Type.HELMET, 2,
            ArmorItem.Type.CHESTPLATE, 5,
            ArmorItem.Type.LEGGINGS, 4,
            ArmorItem.Type.BOOTS, 2
    ), 15, 0.0F, 0.0F, () -> Ingredient.EMPTY);

    private static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of("xuforge", id), "", false)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, repairIngredient, layers, toughness, knockbackResistance);

        // registerReference を使用します
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of("xuforge", id), material);
    }
}
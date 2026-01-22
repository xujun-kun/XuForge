package gay.xujun;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XuForge implements ModInitializer {
    public static final String MOD_ID = "xuforge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // 1. まず最初にマテリアルを強制的に読み込む
        // これを ModItem.registerModItems() よりも「先」に書くのが重要です
        LOGGER.info("Loading Armor Materials...");
        var material = ModArmorMaterials.TRAVELER.value();

        // 2. その後にアイテムを登録する
        ModItem.registerModItems();

        LOGGER.info("XuForge Initialized!");
    }
}
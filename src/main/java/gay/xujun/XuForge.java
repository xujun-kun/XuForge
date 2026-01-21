package gay.xujun;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XuForge implements ModInitializer {
    public static final String MOD_ID = "xuforge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItem.registerModItems();
    }
}
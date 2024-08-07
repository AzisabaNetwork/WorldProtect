package net.azisaba.worldprotect;

import net.azisaba.worldprotect.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldProtect extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (getConfig().getBoolean("cancel-non-player-armor-stand-damage", true)) {
            getServer().getPluginManager().registerEvents(new CancelArmorStandDamageListener(), this);
        }
        if (getConfig().getBoolean("cancel-armor-stand-fire-damage", true)) {
            getServer().getPluginManager().registerEvents(new CancelArmorStandFireListener(), this);
        }
        if (getConfig().getBoolean("cancel-item-frame-break", true)) {
            getServer().getPluginManager().registerEvents(new CancelItemFrameBreakListener(), this);
        }
        if (getConfig().getBoolean("cancel-block-place-in-air", true)) {
            getServer().getPluginManager().registerEvents(new CancelIllegalBlockPlaceListener(this), this);
        }
        if (getConfig().getBoolean("prevent-lag-in-masara", false)) {
            getServer().getPluginManager().registerEvents(new PreventLagInMasaraListener(), this);
        }
    }
}

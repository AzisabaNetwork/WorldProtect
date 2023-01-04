package net.azisaba.worldprotect;

import net.azisaba.worldprotect.listener.CancelArmorStandFireListener;
import net.azisaba.worldprotect.listener.CancelBlockPlaceInAirListener;
import net.azisaba.worldprotect.listener.CancelItemFrameObstructionListener;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldProtect extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (getConfig().getBoolean("cancel-armor-stand-fire-damage")) {
            getServer().getPluginManager().registerEvents(new CancelArmorStandFireListener(), this);
        }
        if (getConfig().getBoolean("cancel-item-frame-obstruction")) {
            getServer().getPluginManager().registerEvents(new CancelItemFrameObstructionListener(), this);
        }
        if (getConfig().getBoolean("cancel-block-place-in-air")) {
            getServer().getPluginManager().registerEvents(new CancelBlockPlaceInAirListener(this), this);
        }
    }
}

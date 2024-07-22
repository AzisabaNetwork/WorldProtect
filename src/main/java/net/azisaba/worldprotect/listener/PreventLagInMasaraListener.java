package net.azisaba.worldprotect.listener;

import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

import java.util.Objects;

public class PreventLagInMasaraListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onRedstone(BlockRedstoneEvent e) {
        if (e.getBlock().getWorld().getName().equalsIgnoreCase("masara")) {
            e.setNewCurrent(0);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onInventoryMoveItem(InventoryMoveItemEvent e) {
        if (e.getDestination().getHolder() instanceof Chest) {
            if (Objects.requireNonNull(((Chest) e.getDestination().getHolder()).getLocation().getWorld()).getName().equalsIgnoreCase("masara")) {
                e.setCancelled(true);
            }
        }
    }
}

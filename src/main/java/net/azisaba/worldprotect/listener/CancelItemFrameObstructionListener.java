package net.azisaba.worldprotect.listener;

import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;

public class CancelItemFrameObstructionListener implements Listener {
    @EventHandler
    public void onHangingBreak(HangingBreakEvent e) {
        if (e.getCause() == HangingBreakEvent.RemoveCause.OBSTRUCTION && e.getEntity() instanceof ItemFrame) {
            e.setCancelled(true);
        }
    }
}

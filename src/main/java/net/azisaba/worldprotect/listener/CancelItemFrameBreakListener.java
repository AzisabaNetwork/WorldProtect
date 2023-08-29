package net.azisaba.worldprotect.listener;

import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CancelItemFrameBreakListener implements Listener {
    private static final Set<HangingBreakEvent.RemoveCause> CANCEL_CAUSES = new HashSet<>(Arrays.asList(
            HangingBreakEvent.RemoveCause.OBSTRUCTION, HangingBreakEvent.RemoveCause.PHYSICS
    ));

    @EventHandler
    public void onHangingBreak(HangingBreakEvent e) {
        if (e.getEntity() instanceof ItemFrame && CANCEL_CAUSES.contains(e.getCause())) {
            e.setCancelled(true);
        }
    }
}

package net.azisaba.worldprotect.listener;

import net.azisaba.worldprotect.WorldProtect;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CancelBlockPlaceInAirListener implements Listener {
    private static final Set<BlockFace> CHECK_FACES =
            Stream.of(BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN).collect(Collectors.toSet());
    private final WorldProtect plugin;

    public CancelBlockPlaceInAirListener(WorldProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        for (BlockFace face : CHECK_FACES) {
            if (!e.getBlockPlaced().getRelative(face).getType().isAir()) {
                return;
            }
        }
        plugin.getLogger().warning(e.getPlayer().getName() + " tried to place block in air (all block faces are air)");
        e.setCancelled(true);
    }
}

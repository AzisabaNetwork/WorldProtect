package net.azisaba.worldprotect.listener;

import net.azisaba.worldprotect.WorldProtect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CancelIllegalBlockPlaceListener implements Listener {
    private static final Set<BlockFace> CHECK_FACES =
            Stream.of(BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN).collect(Collectors.toSet());
    private static final List<BlockFace> BY_2D_DATA = Stream.of(BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST).collect(Collectors.toList());
    private static final Set<Material> EXCLUDE_FACE_CHECK =
            Stream.of(Material.SCAFFOLDING).collect(Collectors.toSet());
    private final WorldProtect plugin;

    public CancelIllegalBlockPlaceListener(WorldProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Set<BlockFace> faces = new HashSet<>();
        for (BlockFace face : CHECK_FACES) {
            if (!e.getBlockPlaced().getRelative(face).getType().isAir()) {
                faces.add(face);
            }
        }
        if (faces.size() != 1) {
            if (faces.isEmpty()) {
                plugin.getLogger().warning(e.getPlayer().getName() + " tried to place block in air at " + e.getBlockPlaced().getLocation() + " (all block faces are air)");
                e.setCancelled(true);
            }
            return;
        }
        if (!EXCLUDE_FACE_CHECK.contains(e.getBlockPlaced().getType())) {
            BlockFace placedFace = faces.stream().findAny().get().getOppositeFace();
            int value = (int) Math.floor(e.getPlayer().getLocation().getYaw() / 90.0 + 0.5) & 3;
            BlockFace playerFace = BY_2D_DATA.get(Math.abs(value % BY_2D_DATA.size()));
            if (playerFace == placedFace) {
                plugin.getLogger().warning(e.getPlayer().getName() + " tried to place block at illegal location " + e.getBlockPlaced().getLocation() + " (playerFace: " + playerFace + ", placedFace: " + placedFace + ")");
                e.setCancelled(true);
            }
        }
    }
}

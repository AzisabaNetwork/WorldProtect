package net.azisaba.worldprotect.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CancelArmorStandFireListener implements Listener {
    private static final Set<EntityDamageEvent.DamageCause> CAUSES = new HashSet<>(Arrays.asList(
            EntityDamageEvent.DamageCause.FIRE,
            EntityDamageEvent.DamageCause.FIRE_TICK,
            EntityDamageEvent.DamageCause.LAVA
    ));

    @EventHandler
    public void cancelCombust(EntityCombustByBlockEvent e) {
        if (e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelFireDamage(EntityDamageEvent e) {
        if (CAUSES.contains(e.getCause()) && e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelFireDamageByBlock(EntityDamageByBlockEvent e) {
        if (CAUSES.contains(e.getCause()) && e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelFireDamageByEntity(EntityDamageByEntityEvent e) {
        if (CAUSES.contains(e.getCause()) && e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }
}

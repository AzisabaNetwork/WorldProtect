package net.azisaba.worldprotect.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class CancelArmorStandDamageListener implements Listener {
    @EventHandler
    public void cancelDamage(EntityDamageEvent e) {
        if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK && e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelDamageByBlock(EntityDamageByBlockEvent e) {
        if (e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) && e.getEntity() instanceof ArmorStand) {
            e.setCancelled(true);
        }
    }
}

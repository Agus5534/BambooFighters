package io.github.agus5534.bamboofighters.events.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class EntityShootBow implements Listener {
    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if(event.getEntity() instanceof Player) {
            event.getProjectile().setCustomName(event.getEntity().getName());
        }
    }
}

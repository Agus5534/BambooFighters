package io.github.agus5534.bamboofighters.events.entity;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageByEntity implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            if(((Player) event.getEntity()).getHealth() - event.getFinalDamage() <= 0) {
                event.setCancelled(true);
                ((Player) event.getEntity()).setGameMode(GameMode.SPECTATOR);
                ((Player) event.getEntity()).getInventory().clear();
                ((Player) event.getEntity()).setHealth(20);
              if(event.getCause() == EntityDamageEvent.DamageCause.SUICIDE) {
                  Bukkit.broadcastMessage(ChatColor.GOLD + "\uD83D\uDC80 " + ChatColor.RED + event.getEntity().getName());
              } else if(event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                    Bukkit.broadcastMessage(ChatColor.BLUE + event.getDamager().getCustomName() + ChatColor.GOLD + " \uD83C\uDFF9 " + ChatColor.RED + event.getEntity().getName());
                } else {
                    Bukkit.broadcastMessage(ChatColor.BLUE + event.getDamager().getName() + ChatColor.GOLD + " ⚔ " + ChatColor.RED + event.getEntity().getName());

                }
            }
        }
    }
}

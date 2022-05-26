package io.github.agus5534.bamboofighters.events.entity;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class EntityDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            if(((Player) event.getEntity()).getHealth() - event.getFinalDamage() <= 0) {
                if(event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    Bukkit.broadcastMessage(ChatColor.GOLD + "\uD83D\uDD25 " + ChatColor.RED + event.getEntity().getName());
                } else if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                    Bukkit.broadcastMessage(ChatColor.BLACK + "▼ " + ChatColor.RED + event.getEntity().getName());
                } else if(event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "\uD83C\uDF0A " + ChatColor.RED + event.getEntity().getName());
                } else if(event.getCause() == EntityDamageEvent.DamageCause.SUICIDE) {
                    Bukkit.broadcastMessage(ChatColor.WHITE + "\uD83D\uDC80 " + ChatColor.RED + event.getEntity().getName());
                } else if(event.getCause() == EntityDamageEvent.DamageCause.CUSTOM) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "\uD83D\uDD70 " + ChatColor.RED + event.getEntity().getName());
                }
                event.setDamage(0);
                ((Player) event.getEntity()).setGameMode(GameMode.SPECTATOR);
                ((Player) event.getEntity()).getInventory().clear();
                ((Player) event.getEntity()).setHealth(20);
            }
        }
    }
}

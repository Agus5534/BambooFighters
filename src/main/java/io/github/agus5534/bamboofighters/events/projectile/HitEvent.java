package io.github.agus5534.bamboofighters.events.projectile;

import io.github.agus5534.bamboofighters.BambooFighters;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.text.DecimalFormat;

public class HitEvent implements Listener {
    BambooFighters plugin;
    public HitEvent(BambooFighters plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onHit(ProjectileHitEvent event){
        if(event.getHitEntity() instanceof Player){
            if(event.getEntity().getType() == EntityType.ARROW) {
                Player player = Bukkit.getPlayer(event.getEntity().getCustomName());
                Player hitted = (Player) event.getHitEntity();

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, ()->{

                    double phealth = hitted.getHealth();
                    String vida = new DecimalFormat("##.##").format(phealth);
                    if(phealth <= 19) {
                        player.sendMessage(ChatColor.GREEN + hitted.getName() + " " + ChatColor.RED + "♥ " + vida);

                    }
                },5L);
            }
        }
    }
}

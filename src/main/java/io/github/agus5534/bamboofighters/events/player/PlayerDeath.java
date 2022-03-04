package io.github.agus5534.bamboofighters.events.player;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        double coordx = player.getLocation().getX();
        double coordy = player.getLocation().getY();
        double coordz = player.getLocation().getZ();
        player.setGameMode(GameMode.SPECTATOR);
        Location loc = new Location(player.getWorld(), coordx, coordy, coordz);
        player.setBedSpawnLocation(loc);
        //player.spigot().respawn();

    }
}

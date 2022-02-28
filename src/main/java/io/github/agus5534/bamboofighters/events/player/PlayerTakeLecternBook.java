package io.github.agus5534.bamboofighters.events.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;

public class PlayerTakeLecternBook implements Listener {
    @EventHandler
    public void onTake(PlayerTakeLecternBookEvent event){
        event.setCancelled(true);
    }
}

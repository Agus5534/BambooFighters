package io.github.agus5534.bamboofighters.events.block;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(event.getBlock().getType() != Material.WHITE_WOOL && event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            if(event.getBlock().getType() != Material.FIRE) {
                event.setCancelled(true);
            }
        }
    }
}

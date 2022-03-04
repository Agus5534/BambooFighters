package io.github.agus5534.bamboofighters.events.player;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            if(event.getPlayer().getInventory().getItemInMainHand() != null) {
                if(event.getPlayer().getInventory().getItemInMainHand().getType().isBlock()) {
                    return;
                }
                if(event.getPlayer().getInventory().getItemInMainHand().getType().isItem()) {
                    return;
                }
            }
            if(event.getItem() != null) {
                if(!event.getItem().isSimilar(new ItemStack(Material.FLINT_AND_STEEL))) {
                    event.setCancelled(true);
                }
            }
            if(event.getClickedBlock() != null) {
                if(event.getClickedBlock().getType() != Material.LECTERN) {
                    event.setCancelled(true);
                }
            }
        }
    }
}

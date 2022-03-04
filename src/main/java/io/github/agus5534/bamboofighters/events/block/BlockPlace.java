package io.github.agus5534.bamboofighters.events.block;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlace implements Listener {
@EventHandler
    public void onPlace(BlockPlaceEvent event) {
    if(event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
        Block b = event.getBlock();
        Material bType = b.getType();
        if(bType == Material.WHITE_WOOL || bType == Material.FIRE || event.getItemInHand().getType() == Material.FLINT_AND_STEEL) {
        } else {
            event.setCancelled(true);
        }
    }

}
}

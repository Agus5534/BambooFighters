package io.github.agus5534.bamboofighters.events.block;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlace implements Listener {
@EventHandler
    public void onPlace(BlockPlaceEvent event) {
    if(!event.getItemInHand().isSimilar(new ItemStack(Material.WHITE_WOOL))) {
        event.setCancelled(true);
    }

}
}

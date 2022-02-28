package io.github.agus5534.bamboofighters.events.inventory;

import io.github.agus5534.bamboofighters.utils.selections.Manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scoreboard.Scoreboard;

import static io.github.agus5534.bamboofighters.BambooFighters.getTier;

public class InventoryClose implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent event){
        if(Bukkit.getScoreboardManager().getMainScoreboard().getObjective("selectTime").getScore(event.getPlayer().getName()).getScore() == 1) {
            if(event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Seleccion de equipos")) {
                new Manager(getTier()).createSelection();
            }
        }
    }
}

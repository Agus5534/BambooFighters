package io.github.agus5534.bamboofighters.events.inventory;

import io.github.agus5534.bamboofighters.utils.selections.Manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import static io.github.agus5534.bamboofighters.BambooFighters.getTier;

public class InventoryClick implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Seleccion de equipos")) {
            if(event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + "" + ChatColor.GREEN + " eligió a " + ChatColor.RED + event.getCurrentItem().getItemMeta().getDisplayName());
                Bukkit.getScoreboardManager().getMainScoreboard().getPlayerTeam(player).addEntry(event.getCurrentItem().getItemMeta().getDisplayName());
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective selectiontimes = scoreboard.getObjective("selectiontimes");
                selectiontimes.getScore("values").setScore(selectiontimes.getScore("values").getScore() + 1);
                Bukkit.getScoreboardManager().getMainScoreboard().getObjective("selectTime").getScore(player).setScore(0);
                player.closeInventory();
                new Manager(getTier()).createSelection();
            }
            event.setCancelled(true);
        }

    }
}

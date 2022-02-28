package io.github.agus5534.bamboofighters.utils.selections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;


public class Manager {
    public Tier tier;
    public Manager(Tier tier) {
        this.tier = tier;
    }
    public void createSelection() {
        createGUI();
    }


    private void createGUI() {
        if(tier == Tier.TIER1){
            if(getSelectionTimes() == 7) {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Ha terminado la primera elección de equipos! Pronto iniciará la siguiente!");
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective selectiontimes = scoreboard.getObjective("selectiontimes");
                selectiontimes.getScore("values").setScore(0);
                Objective selection = scoreboard.getObjective("selection");
                selection.getScore("values").setScore(2);
            } else {
                switch (getSelectionTimes()) {
                    case 0:
                        Player jane = Bukkit.getPlayer("Janethy");
                        SelectionGUI(jane);
                        break;
                    case 1:
                        Player Infer = Bukkit.getPlayer("Infernal_Guy");
                        SelectionGUI(Infer);
                        break;
                    case 2:
                        Player mage = Bukkit.getPlayer("TaTuRC");
                        SelectionGUI(mage);
                        break;
                    case 3:
                        Player conn = Bukkit.getPlayer("ConnG106");
                        SelectionGUI(conn);
                        break;
                    case 4:
                        Player augus = Bukkit.getPlayer("AugusImperial");
                        SelectionGUI(augus);
                        break;
                    case 5:
                        Player lucmus = Bukkit.getPlayer("Lucmus");
                        SelectionGUI(lucmus);
                        break;
                    case 6:
                        Player ivo = Bukkit.getPlayer("Ivoo_17");
                        SelectionGUI(ivo);
                        break;

                }
            }
        } else if(tier == Tier.TIER2){
            if(getSelectionTimes() == 7) {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Ha terminado la segunda elección de equipos! Pronto iniciará la siguiente!");
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective selectiontimes = scoreboard.getObjective("selectiontimes");
                selectiontimes.getScore("values").setScore(0);
                Objective selection = scoreboard.getObjective("selection");
                selection.getScore("values").setScore(3);
            } else {
                switch (getSelectionTimes()) {
                    case 0:
                        Player p1 = Bukkit.getPlayer("Lucmus");
                        SelectionGUI(p1);
                        break;
                    case 1:
                        Player p2 = Bukkit.getPlayer("TaTuRC");
                        SelectionGUI(p2);
                        break;
                    case 2:
                        Player p3 = Bukkit.getPlayer("ConnG106");
                        SelectionGUI(p3);
                        break;
                    case 3:
                        Player p4 = Bukkit.getPlayer("Janethy");
                        SelectionGUI(p4);
                        break;
                    case 4:
                        Player p5 = Bukkit.getPlayer("AugusImperial");
                        SelectionGUI(p5);
                        break;
                    case 5:
                        Player p6 = Bukkit.getPlayer("Ivoo_17");
                        SelectionGUI(p6);
                        break;
                    case 6:
                        Player p7 = Bukkit.getPlayer("Infernal_Guy");
                        SelectionGUI(p7);
                        break;

                }
            }
        } else if(tier == Tier.TIER3){
            if(getSelectionTimes() == 7){
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Ha terminado la tercera elección de equipos! Pronto iniciará la siguiente!");
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective selectiontimes = scoreboard.getObjective("selectiontimes");
                selectiontimes.getScore("values").setScore(0);
                Objective selection = scoreboard.getObjective("selection");
                selection.getScore("values").setScore(4);
            } else {
                switch (getSelectionTimes()) {
                    case 0:
                        Player p1 = Bukkit.getPlayer("Janethy");
                        SelectionGUI(p1);
                        break;
                    case 1:
                        Player p2 = Bukkit.getPlayer("TaTuRC");
                        SelectionGUI(p2);
                        break;
                    case 2:
                        Player p3 = Bukkit.getPlayer("AugusImperial");
                        SelectionGUI(p3);
                        break;
                    case 3:
                        Player p4 = Bukkit.getPlayer("Ivoo_17");
                        SelectionGUI(p4);
                        break;
                    case 4:
                        Player p5 = Bukkit.getPlayer("Lucmus");
                        SelectionGUI(p5);
                        break;
                    case 5:
                        Player p6 = Bukkit.getPlayer("Infernal_Guy");
                        SelectionGUI(p6);
                        break;
                    case 6:
                        Player p7 = Bukkit.getPlayer("ConnG106");
                        SelectionGUI(p7);
                        break;

                }
            }
        } else if(tier == Tier.TIER4){
            if(getSelectionTimes() == 7) {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Ha terminado la elección de equipos. ¡Suerte!");
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective selectiontimes = scoreboard.getObjective("selectiontimes");
                selectiontimes.getScore("values").setScore(0);
                Objective selection = scoreboard.getObjective("selection");
                selection.getScore("values").setScore(5);
            } else {
                switch (getSelectionTimes()) {
                    case 0:
                        Player p1 = Bukkit.getPlayer("Ivoo_17");
                        SelectionGUI(p1);
                        break;
                    case 1:
                        Player p2 = Bukkit.getPlayer("AugusImperial");
                        SelectionGUI(p2);
                        break;
                    case 2:
                        Player p3 = Bukkit.getPlayer("Infernal_Guy");
                        SelectionGUI(p3);
                        break;
                    case 3:
                        Player p4 = Bukkit.getPlayer("ConnG106");
                        SelectionGUI(p4);
                        break;
                    case 4:
                        Player p5 = Bukkit.getPlayer("Lucmus");
                        SelectionGUI(p5);
                        break;
                    case 5:
                        Player p6 = Bukkit.getPlayer("Janethy");
                        SelectionGUI(p6);
                        break;
                    case 6:
                        Player p7 = Bukkit.getPlayer("TaTuRC");
                        SelectionGUI(p7);
                        break;

                }
            }
        }
    }

    private void SelectionGUI(Player player) {
        if(tier == Tier.TIER1) {
            int i = 0;
            Inventory inv = Bukkit.createInventory(null, 9, ChatColor.RED + "Seleccion de equipos");
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(p.getScoreboard().getPlayerTeam(p) != null) {
                    if(p.getScoreboard().getPlayerTeam(p).getName().equals("tier1")) {
                        addPlayerHead(p.getName(),inv,i);
                        i++;
                    }
                }
            }
            player.openInventory(inv);
        }

    }

    private void addPlayerHead(String playerName, Inventory inv,int number) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD,1,(short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
        meta.setOwner(playerName);
        meta.setDisplayName(playerName);
        skull.setItemMeta(meta);
        inv.setItem(number,skull);

    }


   /* private boolean checkSelected(String playerName) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective selected = scoreboard.getObjective("selected");
        if(selected.getScore(playerName).getScore() == 0) {
            return false;
        } else {
            return true;
        }
    }*/

    private int getSelectionTimes() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective selectiontimes = scoreboard.getObjective("selectiontimes");
        return selectiontimes.getScore("values").getScore();
    }

}

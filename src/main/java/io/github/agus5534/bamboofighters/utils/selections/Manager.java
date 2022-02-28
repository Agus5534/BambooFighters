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
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Ha terminado la primera elección de equipos");
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

        } else if(tier == Tier.TIER3){

        } else if(tier == Tier.TIER4){

        }
    }

    private void SelectionGUI(Player player) {
        if(tier == Tier.TIER1) {
            int i = 1;
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

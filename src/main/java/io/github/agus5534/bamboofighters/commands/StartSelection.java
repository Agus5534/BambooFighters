package io.github.agus5534.bamboofighters.commands;

import io.github.agus5534.bamboofighters.BambooFighters;
import io.github.agus5534.bamboofighters.GameStatus;
import io.github.agus5534.bamboofighters.utils.selections.Manager;
import io.github.agus5534.bamboofighters.utils.selections.Tier;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import static io.github.agus5534.bamboofighters.BambooFighters.getTier;

public class StartSelection implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective selended = scoreboard.getObjective("selectionEnded");
        if(sender.isOp() && selended.getScore("values").getScore() == 0) {
            new Manager(getTier()).createSelection();
            new BambooFighters().setGameStatus(GameStatus.SELECTION);
        }

        return true;
    }
    private Tier getTier() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective selection = scoreboard.getObjective("selection");
        if(selection.getScore("values").getScore() == 0) {
            return Tier.TIER1;
        } else if(selection.getScore("values").getScore() == 1){
            return Tier.TIER1;
        }  else if(selection.getScore("values").getScore() == 2) {
            return Tier.TIER2;
        }  else if(selection.getScore("values").getScore() == 3) {
            return Tier.TIER3;
        } else if(selection.getScore("values").getScore() == 4) {
            return Tier.TIER4;
        } else {
            return null;
        }
    }
}

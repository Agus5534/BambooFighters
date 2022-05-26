package io.github.agus5534.bamboofighters.commands;

import io.github.agus5534.bamboofighters.BambooFighters;
import io.github.agus5534.bamboofighters.GameStatus;
import io.github.agus5534.bamboofighters.utils.timer.TimerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class Timer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            switch (args[0]) {
                case "Start":
                    scoreboard.getObjective("timerOn").getScore("values").setScore(1);
                    new BambooFighters().setGameStatus(GameStatus.PVP);
                    break;
                case "End":
                    new TimerManager().endTimer();
                    new BambooFighters().setGameStatus(GameStatus.WAITING);
                    break;
                default:
                    player.sendMessage(ChatColor.RED + "/timer [Start|End]");
                    break;


            }
            } else {
                player.sendMessage(ChatColor.RED + "/timer [Start|End]");
            }
        }
        return true;
    }
}

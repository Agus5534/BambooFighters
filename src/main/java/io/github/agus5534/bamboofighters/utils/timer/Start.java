package io.github.agus5534.bamboofighters.utils.timer;

import io.github.agus5534.bamboofighters.BambooFighters;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.awt.*;

public class Start {
    public void startTimer() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective tt = scoreboard.getObjective("tt");
        Objective ts = scoreboard.getObjective("ts");
        Objective tm = scoreboard.getObjective("tm");
        Score ttScore = tt.getScore("values");
        Score tsScore = ts.getScore("values");
        Score tmScore = tm.getScore("values");

        if(ttScore.getScore() >=20 && ttScore.getScore() <=20) {
            tsScore.setScore(tsScore.getScore() +1);
            ttScore.setScore(0);
        }
        if(tsScore.getScore() == 60) {
            tmScore.setScore(tmScore.getScore() + 1);
            tsScore.setScore(0);
        }
        ttScore.setScore(ttScore.getScore() + 1);
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + String.format("%02d",tmScore.getScore()) + ":" + String.format("%02d", tsScore.getScore())));

        }
    }
}

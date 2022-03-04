package io.github.agus5534.bamboofighters.utils.timer;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class End {
    public void endTimer() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective tt = scoreboard.getObjective("tt");
        Objective ts = scoreboard.getObjective("ts");
        Objective tm = scoreboard.getObjective("tm");
        Objective tmron = scoreboard.getObjective("timerOn");
        Score ttScore = tt.getScore("values");
        Score tsScore = ts.getScore("values");
        Score tmScore = tm.getScore("values");
        Score timerOn =  tmron.getScore("values");
        timerOn.setScore(0);
        ttScore.setScore(0);
        tsScore.setScore(0);
        tmScore.setScore(0);
    }
}

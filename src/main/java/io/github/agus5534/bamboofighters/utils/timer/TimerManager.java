package io.github.agus5534.bamboofighters.utils.timer;

import io.github.agus5534.bamboofighters.BambooFighters;
import io.github.agus5534.bamboofighters.GameStatus;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class TimerManager {
    private void showTimer() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective tt = scoreboard.getObjective("tt");
        Objective ts = scoreboard.getObjective("ts");
        Objective tm = scoreboard.getObjective("tm");
        Score ttScore = tt.getScore("values");
        Score tsScore = ts.getScore("values");
        Score tmScore = tm.getScore("values");
        if(ttScore.getScore() == 2 && tmScore.getScore() == 4 && tsScore.getScore() == 0) {
            new BambooFighters().setGameStatus(GameStatus.WAITING);
            endTimer();
            for(Player p : Bukkit.getOnlinePlayers()){
                if(p.getGameMode() == GameMode.SURVIVAL) {
                    EntityDamageEvent ede = new EntityDamageEvent(p, EntityDamageEvent.DamageCause.CUSTOM,200);
                    Bukkit.getPluginManager().callEvent(ede);
                }
            }
        }
        ttScore.setScore(ttScore.getScore() + 1);

        if(ttScore.getScore() >=20 && ttScore.getScore() <=20) {
            tsScore.setScore(tsScore.getScore() +1);
            ttScore.setScore(0);
        }
        if(tsScore.getScore() == 60) {
            tmScore.setScore(tmScore.getScore() + 1);
            tsScore.setScore(0);
        }
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + String.format("%02d",tmScore.getScore()) + ":" + String.format("%02d", tsScore.getScore())));
        }
    }
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

    public void displayTimer() {
        if(new BambooFighters().getGameStatus() == GameStatus.PVP) {
            showTimer();
        } else if(new BambooFighters().getGameStatus() == GameStatus.WAITING) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + "Esperando..."));
            }
        } else if(new BambooFighters().getGameStatus() == GameStatus.SELECTION) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + "Eligiendo Teams..."));
            }
        }
    }
}

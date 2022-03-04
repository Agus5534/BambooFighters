package io.github.agus5534.bamboofighters;

import io.github.agus5534.bamboofighters.commands.Kit;
import io.github.agus5534.bamboofighters.commands.StartSelection;
import io.github.agus5534.bamboofighters.commands.Timer;
import io.github.agus5534.bamboofighters.commands.tabcompleters.KitTab;
import io.github.agus5534.bamboofighters.events.block.BlockBreak;
import io.github.agus5534.bamboofighters.events.block.BlockPlace;
import io.github.agus5534.bamboofighters.events.entity.EntityDamage;
import io.github.agus5534.bamboofighters.events.entity.EntityDamageByEntity;
import io.github.agus5534.bamboofighters.events.entity.EntityShootBow;
import io.github.agus5534.bamboofighters.events.inventory.InventoryClick;
import io.github.agus5534.bamboofighters.events.inventory.InventoryClose;
import io.github.agus5534.bamboofighters.events.player.PlayerDropItem;
import io.github.agus5534.bamboofighters.events.player.PlayerInteract;
import io.github.agus5534.bamboofighters.events.player.PlayerTakeLecternBook;
import io.github.agus5534.bamboofighters.events.projectile.HitEvent;
import io.github.agus5534.bamboofighters.utils.selections.Tier;
import io.github.agus5534.bamboofighters.utils.timer.Start;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public final class BambooFighters extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("kit").setExecutor(new Kit());
        this.getCommand("kit").setTabCompleter(new KitTab());
        this.getCommand("startselection").setExecutor(new StartSelection());
        this.getCommand("timer").setExecutor(new Timer());
        this.getCommand("timer").setTabCompleter(new io.github.agus5534.bamboofighters.commands.tabcompleters.Timer());
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new BlockBreak(),this);
        pm.registerEvents(new BlockPlace(),this);
        pm.registerEvents(new EntityDamageByEntity(),this);
        pm.registerEvents(new EntityDamage(),this);
        pm.registerEvents(new EntityShootBow(),this);
        pm.registerEvents(new PlayerDropItem(),this);
        pm.registerEvents(new PlayerInteract(),this);
        pm.registerEvents(new PlayerTakeLecternBook(),this);
        pm.registerEvents(new InventoryClick(),this);
        pm.registerEvents(new InventoryClose(),this);
        pm.registerEvents(new HitEvent(this),this);
        createScores();
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        Bukkit.getWorlds().get(1).setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        Bukkit.getWorlds().get(2).setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createScores() {
        registerObjective("selected"); //Si jugador fue seleccionado
        registerObjective("selection"); //Tier de la selección.
        registerObjective("captain"); //Si es capitan
        registerObjective("selectedt1"); //Si ya eligió en el tier 1
        registerObjective("selectedt2"); //Si ya eligió en el tier 2
        registerObjective("selectedt3"); //Si ya eligió en el tier 3
        registerObjective("selectedt4"); //Si ya eligió en el tier 4
        registerObjective("selectiontimes"); //Cantidad de capitanes que eligieron. Se reinicia al iniciar la siguiente etapa.
        registerObjective("selectTime"); //Si es su momento de seleccionar
        registerObjective("selectionEnded"); //Si termino la selección. 1 = terminó
        registerObjective("tt");
        registerObjective("ts");
        registerObjective("tm");
        registerObjective("timerOn");
    }

    private void timer() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, ()->{
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            if(scoreboard.getObjective("timerOn").getScore("values").getScore() == 1) {
                new Start().startTimer();
            }
        },1L,20L);
    }

    public static Tier getTier() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective selection = scoreboard.getObjective("selection");
        if(selection.getScore("values").getScore() <= 1) {
            return Tier.TIER1;
        } else if(selection.getScore("values").getScore() == 2){
            return Tier.TIER2;
        }  else if(selection.getScore("values").getScore() == 3) {
            return Tier.TIER3;
        }  else if(selection.getScore("values").getScore() == 4) {
            return Tier.TIER4;
        } else {
            return null;
        }
    }
    private void registerObjective(String objectiveName) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if(scoreboard.getObjective(objectiveName) == null) {
            scoreboard.registerNewObjective(objectiveName,"dummy");
        }
    }
}

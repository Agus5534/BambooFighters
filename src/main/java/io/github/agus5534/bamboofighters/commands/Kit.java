package io.github.agus5534.bamboofighters.commands;

import io.github.agus5534.bamboofighters.BambooFighters;
import io.github.agus5534.bamboofighters.GameStatus;
import io.github.agus5534.bamboofighters.utils.kits.KitManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(new BambooFighters().getGameStatus() == GameStatus.WAITING) {
                if(args.length == 1){
                    switch (args[0]) {
                        case "Asesino":
                            new KitManager(io.github.agus5534.bamboofighters.utils.kits.Kit.ASESINO, player).giveKit();
                            break;
                        case "Healer":
                            new KitManager(io.github.agus5534.bamboofighters.utils.kits.Kit.HEALER, player).giveKit();
                            break;
                        case "Tanque":
                            new KitManager(io.github.agus5534.bamboofighters.utils.kits.Kit.TANQUE,player).giveKit();
                            break;
                        case "Archer":
                            new KitManager(io.github.agus5534.bamboofighters.utils.kits.Kit.ARCHER,player).giveKit();
                            break;
                        case "Pyro":
                            new KitManager(io.github.agus5534.bamboofighters.utils.kits.Kit.PYRO,player).giveKit();
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "Ha ocurrido un error");
                            break;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "/kit [Kit_Name]");
                }
            } else {
                player.sendMessage(ChatColor.RED + "No es momento de elegir un kit!");
            }

        }

        return true;
    }
    }

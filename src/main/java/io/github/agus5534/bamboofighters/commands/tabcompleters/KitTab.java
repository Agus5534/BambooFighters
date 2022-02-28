package io.github.agus5534.bamboofighters.commands.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class KitTab implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1) {
            List<String> kits = new ArrayList<String>();
            kits.add("Tanque");
            kits.add("Pyro");
            kits.add("Archer");
            kits.add("Asesino");
            kits.add("Healer");
            return kits;
        }
        return null;
    }
    }

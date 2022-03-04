package io.github.agus5534.bamboofighters.commands.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Timer implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1) {
            List<String> timer = new ArrayList<String>();
            timer.add("Start");
            timer.add("End");
            return timer;
        }
        return null;
    }
}

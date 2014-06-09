/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.mcsistemas.essentialslt.comandos;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Fernando
 */
public class Fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (args.length == 0) {

                if (p.hasPermission("ELT.fly")) {
                    if (p.getAllowFlight()) {
                        p.setFlying(false);
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.YELLOW + "Seu fly foi desativado");
                    } else {
                        p.setAllowFlight(true);
                        p.setFlySpeed(0.1F);
                        p.sendMessage(ChatColor.YELLOW + "Seu fly foi ativado");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Voce nao tem permissao para voar");
                }
            }

        }

        return false;
    }
}

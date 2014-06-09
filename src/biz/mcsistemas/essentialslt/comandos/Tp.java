/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.mcsistemas.essentialslt.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/**
 *
 * @author Fernando
 */
public class Tp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "/tp <jogador>");
            }
            if ((args.length == 1)
                    && (player.hasPermission(new Permission("ELT.admin")))) {
                try {
                    Player targetPlayer = player.getServer().getPlayer(args[0]);
                    Location targetPlayerLocation = targetPlayer.getLocation();
                    player.teleport(targetPlayerLocation);
                } catch (Exception exc) {
                    player.sendMessage(ChatColor.RED + "Este jogador nao esta online");
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("tpc")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "/tpc <x y z>");
            }
            if ((args.length >= 1)
                    && (player.hasPermission(new Permission("ELT.admin")))) {
                try {

                    int x = Integer.parseInt(args[0].toString());
                    int y = Integer.parseInt(args[1].toString());
                    int z = Integer.parseInt(args[2].toString());
                    Location loc = new Location(player.getWorld(), x, y, z);
                    player.teleport(loc);
                } catch (Exception exc) {
                    player.sendMessage(ChatColor.RED + "Localizacao invalida");
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("tphere")) {
            try {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "/tphere <jogador>");
                } else if ((args.length == 1)
                        && (player.hasPermission(new Permission("ELT.admin")))) {
                    Player destinatario = (Player) sender;
                    Player mittente = Bukkit.getPlayer(args[0].toString());
                    mittente.teleport(destinatario);
                    mittente.sendMessage(ChatColor.RED + "Teleportado para " + destinatario.getName().toString());
                }
            } catch (Exception localException3) {
            }
        }

        return false;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.mcsistemas.essentialslt.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Fernando
 */
public class Invsee implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("invsee")) {
            if (sender.hasPermission("ELT.admin")) {
                if (args.length == 0){
                    p.sendMessage(ChatColor.RED + "/invsee <jogador>");
                    
                    
                }
                if (args.length == 1) {
                    Player targetPlayer = Bukkit.getPlayer(args[0]);
                    p.openInventory(targetPlayer.getInventory());
                    p.sendMessage(ChatColor.GRAY + "Abrindo inventario do jogador " + targetPlayer.getName());

                    return true;
                }
            }else{
                
                p.sendMessage(ChatColor.RED + "Sem Permisao");
                
            }
        }
        return false;

    }

}

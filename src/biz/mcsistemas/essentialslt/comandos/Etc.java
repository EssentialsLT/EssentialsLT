/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.mcsistemas.essentialslt.comandos;

import biz.mcsistemas.essentialslt.EssentialsLT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 *
 * @author Fernando
 */
public class Etc implements CommandExecutor {
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        
        if (cmd.getName().equalsIgnoreCase("hat")) {
            if ((player.hasPermission("ELT.hat"))) {
                if (player.getItemInHand().getType() != Material.AIR) {
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHead = inventory.getHelmet();
                    inventory.removeItem(new ItemStack[]{itemHand});
                    inventory.setHelmet(itemHand);
                    inventory.setItemInHand(itemHead);
                    player.sendMessage(ChatColor.YELLOW + "Item colocado com sucesso em sua cabeca");
                    return true;
                }
                player.sendMessage(ChatColor.YELLOW + "Voce precisa de um item em sua mao!");
                return true;
            }
            
            player.sendMessage(ChatColor.RED + "Voce nao tem permisao para usar o mudar o item da cabeca");
            return true;
        }
        
        if (cmd.getName().equalsIgnoreCase("eip")) {
            if (sender.hasPermission("ELT.ip")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "/eip <jogador>");
                    
                }
                if(args.length == 1){
                Player ipplayer = Bukkit.getPlayer(args[0]);
                
                String sIp1 = ipplayer.getAddress().getHostName();
                player.sendMessage(ChatColor.RED + "Voce esta verificando o ip do jogador: " + args[0]);
                player.sendMessage(ChatColor.RED + "Ip do jogador: " + sIp1);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Voce nao tem permissao");
                
            }
            
        }
        if (cmd.getName().equalsIgnoreCase("alert")) {
            if (sender.hasPermission("ELT.say")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GOLD + "Voce deve digitar algo para falar no say");
                } else {
                    String msg = "";
                    for (int i = 0; i < args.length; i++) {
                        msg = msg + args[i] + " ";
                    }
                    
                    Bukkit.broadcastMessage("§d[" + sender.getName() + "] " + msg);
                }
                
            } else {
                sender.sendMessage(ChatColor.RED + "Voce nao tem permisao para utilizar o say");
            }
            
        }
        if (cmd.getName().equalsIgnoreCase("cores")) {
            player.sendMessage(ChatColor.GOLD + "Ajuda em cores no chat:");
            player.sendMessage("§0 &0 §1 &1 §2 &2 §3 &3 §4 &4 §5 &5 §6 &6 §7 &7 §8 &8 §9 &9 §a &a §b &b §c &c §d &d §e &e §f &f");
            
        }
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            
            player.sendMessage(ChatColor.YELLOW + "Teleportado!");
            int xloc = EssentialsLT.getInstance().getConfig().getInt("Spawn" + ".x");
            int yloc = EssentialsLT.getInstance().getConfig().getInt("Spawn" + ".y");
            int zloc = EssentialsLT.getInstance().getConfig().getInt("Spawn" + ".z");
            World mloc = Bukkit.getServer().getWorld(EssentialsLT.getInstance().getConfig().getString("Spawn" + ".world"));
            
            Location loc = new Location(mloc, xloc, yloc, zloc);
            player.teleport(loc);
            
        }
        if (cmd.getName().equalsIgnoreCase("eltreload")) {
            if (player.hasPermission("ELT.reload")) {
                EssentialsLT.getInstance().reloadConfig();
                player.sendMessage(ChatColor.GREEN + "Reload concluido!");
                
            }else{
                player.sendMessage(ChatColor.RED + "Voce nao pode dar reload no plugin!");
                
            }
        }
        return false;
        
    }
}

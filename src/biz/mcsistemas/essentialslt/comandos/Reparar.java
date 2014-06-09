/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.mcsistemas.essentialslt.comandos;

import java.util.Locale;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author fernando
 */
public class Reparar implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("reparar")) {
            if (args.length == 0) {
                if (p.hasPermission("ELT.reparar")) {

                    p.getItemInHand().setDurability((short) 0);
                    p.sendMessage(ChatColor.GOLD + "Seu item foi reparado com sucesso!");
                } else {
                    p.sendMessage(ChatColor.RED + "Voce nao tem permissao para reparar um item!");

                }
            }
            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("tudo")) {

                    if (p.hasPermission("ELT.reparartudo")) {
                        RepairCheck(args, p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Voce nao tem permisao para poder reparar seu inventário!");

                    }

                }

            }
        }

        return false;

    }

    //Util Reparar
    private String lorename;

    private void RepairCheck(String[] args, Player m) {
        int num = 0;
        short dur = 0;
        String norepair = ChatColor.RED + "Erro: " + ChatColor.DARK_RED + "Este item nao pode ser reparado!";
        if (args[0].equalsIgnoreCase("tudo")) {

            num = 0;
            String itemlist = "";
            boolean repaircheck = true;
            for (ItemStack item : m.getInventory()) {
                if (item == null) {
                    continue;
                }
                Material material = item.getType();
                if (item.hasItemMeta()) {
                    if (item.getItemMeta().hasLore()) {
                        if (item.getItemMeta().getLore().contains(this.lorename)) {
                            num--;
                        } else {
                            if ((material.isBlock()) || (material.getMaxDurability() < 1)) {
                                continue;
                            }
                            if (item.getDurability() == 0) {
                                continue;
                            }

                            item.setDurability(dur);
                            num++;
                            itemlist = itemlist + item.getType().toString().toLowerCase(Locale.ENGLISH).replace('_', ' ') + ", ";
                        }

                    } else {
                        if ((material.isBlock()) || (material.getMaxDurability() < 1)) {
                            continue;
                        }
                        if (item.getDurability() == 0) {
                            continue;
                        }

                        item.setDurability(dur);
                        num++;
                        itemlist = itemlist + item.getType().toString().toLowerCase(Locale.ENGLISH).replace('_', ' ') + ", ";
                    }

                } else {
                    if ((material.isBlock()) || (material.getMaxDurability() < 1)) {
                        continue;
                    }
                    if (item.getDurability() == 0) {
                        continue;
                    }

                    item.setDurability(dur);
                    num++;
                    itemlist = itemlist + item.getType().toString().toLowerCase(Locale.ENGLISH).replace('_', ' ') + ", ";
                }

            }

            if (!repaircheck) {
                m.sendMessage(norepair);
            }
            if (num <= 0) {
                m.sendMessage(ChatColor.RED + "Nenhum item pode ser reparado!");
            } else {
                if ((itemlist.length() > 0) && (itemlist.charAt(itemlist.length() - 2) == ',')) {
                    itemlist = itemlist.substring(0, itemlist.length() - 2);
                }
                m.sendMessage(ChatColor.GOLD + "Voce reparou todos os seus itens do inventario!");
            }
        }

    }

}

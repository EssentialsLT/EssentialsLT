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
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 *
 * @author Fernando
 */
public class God implements CommandExecutor, Listener {

    public static List<String> god = new ArrayList();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(EntityDamageEvent e) {
        Entity dano = e.getEntity();

        if (dano instanceof Player) {
            if (god.contains(((Player) dano).getName())) {
                e.setCancelled(true);

            } else {
                e.setCancelled(false);

            }

        }
    }

    public boolean onCommand(CommandSender s, Command cmd, String cl, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
            if (args.length == 0) {
                if (s instanceof Player) {
                    if (s.hasPermission("ELT.god") || s.isOp()) {
                        if (!(god.contains(s.getName()))) {
                            god.add(s.getName());
                            s.sendMessage(ChatColor.YELLOW + "Seu god foi ativado");
                        } else {
                            god.remove(s.getName());
                            s.sendMessage(ChatColor.YELLOW + "Seu god foi desativado");

                        }
                    } else {
                        s.sendMessage(ChatColor.RED + "Voce nao tem permissao");
                    }
                }

            }

        }

        return false;

    }

}

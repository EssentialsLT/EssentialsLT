/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.mcsistemas.essentialslt;

import biz.mcsistemas.essentialslt.comandos.*;
import biz.mcsistemas.essentialslt.eventos.*;
import java.util.HashMap;
import java.util.Map;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class EssentialsLT extends JavaPlugin {

    public static EssentialsLT instance = null;

    public static Economy economy;

    public static EssentialsLT getInstance() {
        return instance;
    }
    private static EssentialsLT pvpmaster = null;

    private static Plugin plugin;
    public static EssentialsLT r;

    HashMap<Player, Player> Tpa = new HashMap();
    private static EssentialsLT essentials = null;

    public void onEnable() {
        r = this;
        essentials = this;
        Cmds();
        instance = this;
        pvpmaster = this;
        getLogger().info("EssentialsLT Iniciado!!");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Eventos(), this);
        getServer().getPluginManager().registerEvents(new God(), this);

    }

    public void onDisable() {
        saveConfig();
    }

    public void Cmds() {
        Warp warp = new Warp();
        Tp tp = new Tp();
        Etc etc = new Etc();
        essentials.getCommand("fly").setExecutor(new Fly());
        essentials.getCommand("ELTreload").setExecutor(etc);
        essentials.getCommand("spawn").setExecutor(etc);
        essentials.getCommand("cores").setExecutor(etc);
        essentials.getCommand("eip").setExecutor(etc);
        essentials.getCommand("alert").setExecutor(etc);
        essentials.getCommand("hat").setExecutor(etc);
        essentials.getCommand("god").setExecutor(new God());
        essentials.getCommand("invsee").setExecutor(new Invsee());
        essentials.getCommand("tp").setExecutor(tp);
        essentials.getCommand("tpc").setExecutor(tp);
        essentials.getCommand("tphere").setExecutor(tp);
        essentials.getCommand("warp").setExecutor(warp);
        essentials.getCommand("setwarp").setExecutor(warp);
        essentials.getCommand("delwarp").setExecutor(warp);
        essentials.getCommand("reparar").setExecutor(new Reparar());

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("tpa")) {
            try {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "/tpa <jogador>");
                } else if (args.length == 1) {
                    final Player targetPlayer = player.getServer().getPlayer(args[0]);
                    player.sendMessage(ChatColor.GREEN + "Pedido enviado...");

                    targetPlayer.sendMessage(ChatColor.AQUA + "**[TELEPORTE]**" + player.getName().toString() + " esta querendo ir ate voce use, /tpaccept para aceitar!");
                    this.Tpa.put(targetPlayer, player);
                    getServer().getScheduler().runTaskLater(this, new Runnable() {
                        public void run() {
                            r.Tpa.remove(targetPlayer);
                        }
                    }, 600L);
                }
            } catch (Exception exc) {
                player.sendMessage(ChatColor.RED + "Este jogador nao esta online");
            }
        } else if (cmd.getName().equalsIgnoreCase("tpaccept")) {
            try {
                if (!this.Tpa.containsKey(player)) {
                    player.sendMessage(ChatColor.RED + "Nao tem pedidos de teleporte ate voce!");
                }
                ((Player) this.Tpa.get(player)).teleport(player);
                this.Tpa.remove(player);
                ((Player) Tpa.get(player)).sendMessage(ChatColor.GREEN + "Teleportado para " + ChatColor.GOLD + player.getName().toString());
            } catch (Exception localException2) {
            }
        }

        return false;
    }
}

package biz.mcsistemas.essentialslt.comandos;

import biz.mcsistemas.essentialslt.EssentialsLT;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/**
 *
 * @author Fernando
 */
public class Warp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if ((cmd.getName().equalsIgnoreCase("setwarp")) && (player.hasPermission(new Permission("ELT.admin")))) {

            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "/setwarp <nome da warp>");
            } else if (args.length == 1) {
                try {
                    String name = args[0].toString();
                    int x = player.getLocation().getBlockX();
                    int y = player.getLocation().getBlockY() + 1;
                    int z = player.getLocation().getBlockZ();
                    String w = player.getLocation().getWorld().getName().toString();
                    EssentialsLT.getInstance().getConfig().set("Warps." + name + ".X", Integer.valueOf(x));
                    EssentialsLT.getInstance().getConfig().set("Warps." + name + ".Y", Integer.valueOf(y));
                    EssentialsLT.getInstance().getConfig().set("Warps." + name + ".Z", Integer.valueOf(z));
                    EssentialsLT.getInstance().getConfig().set("Warps." + name + ".W", w);
                    EssentialsLT.getInstance().saveConfig();
                    player.sendMessage(ChatColor.GREEN + "Warp salva");
                } catch (Exception localException) {
                    player.sendMessage(ChatColor.RED + "Erro");
                }
            }

        } else if (cmd.getName().equalsIgnoreCase("warp")) {
            Server server = player.getServer();
            if (args.length == 0) {
                player.sendMessage(ChatColor.GOLD + "Lista de warps: ");
                ConfigurationSection warpListSection = EssentialsLT.getInstance().getConfig().getConfigurationSection("Warps");
                for (String key : warpListSection.getKeys(false)) {
                    player.sendMessage(ChatColor.GOLD + "- " + ChatColor.GREEN + key);
                }
            }
            if ((args.length == 1)
                    && (player.hasPermission(new Permission("ELT.warps")))) {
                try {
                    String warpname = args[0].toString();
                    int x = Integer.parseInt(EssentialsLT.getInstance().getConfig().getString("Warps." + warpname + ".X"));
                    int y = Integer.parseInt(EssentialsLT.getInstance().getConfig().getString("Warps." + warpname + ".Y"));
                    int z = Integer.parseInt(EssentialsLT.getInstance().getConfig().getString("Warps." + warpname + ".Z"));
                    World w = server.getWorld(EssentialsLT.getInstance().getConfig().getString("Warps." + warpname + ".W"));
                    Location loc = new Location(w, x, y, z);
                    player.teleport(loc);
                    player.sendMessage(ChatColor.GREEN + "Teleportado para warp: " + ChatColor.GOLD + warpname);
                } catch (Exception exc) {
                    player.sendMessage(ChatColor.RED + "Esta warp nao existe! ");
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "/delwarp <nome-da-warp>");
            }
            if ((args.length == 1)
                    && (player.hasPermission(new Permission("ELT.admin")))) {
                String warp = args[0].toString();
                EssentialsLT.getInstance().getConfig().set("Warps." + warp, null);
                EssentialsLT.getInstance().saveConfig();
                player.sendMessage(ChatColor.GREEN + "Warp deletada");
            }
        }

        return false;

    }
}

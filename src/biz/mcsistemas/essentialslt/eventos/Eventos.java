package biz.mcsistemas.essentialslt.eventos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import biz.mcsistemas.essentialslt.EssentialsLT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.permissions.Permission;

public class Eventos
        implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractEvent3(SignChangeEvent event) {
        Player p = event.getPlayer();
        if ((event.getLine(0).contains("[Warp]")) && (p.hasPermission(new Permission("ELT.admin")))) {
            event.setLine(0, ChatColor.BLUE + "[Warp]");
            p.sendMessage(ChatColor.BLUE + "[Warp] Criado");
        } else if (event.getLine(0).contains("[Warp]")) {
            event.setLine(0, ChatColor.RED + "[INVALIDO]");
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractEventCand(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if ((block.getTypeId() == 63) || (block.getTypeId() == 68)) {
                Sign sign = (Sign) block.getState();
                String line0pc = sign.getLine(0);
                String line1pc = sign.getLine(1);
                if (line0pc.contains("[Warp]")) {
                    Player p = event.getPlayer();
                    String warp = line1pc.toString();
                    p.performCommand("Warp " + warp);
                }
            }
        }

    }

    @EventHandler
    public void onSignChange(SignChangeEvent sign) {
        Player player = sign.getPlayer();
        if (player.hasPermission("ELT.placac")) {
            if ((sign.getLine(0).contains("&1")) || (sign.getLine(0).contains("&2")) || (sign.getLine(0).contains("&3")) || (sign.getLine(0).contains("&4")) || (sign.getLine(0).contains("&5")) || (sign.getLine(0).contains("&6")) || (sign.getLine(0).contains("&7")) || (sign.getLine(0).contains("&8")) || (sign.getLine(0).contains("&9")) || (sign.getLine(0).contains("&0")) || (sign.getLine(0).contains("&a")) || (sign.getLine(0).contains("&b")) || (sign.getLine(0).contains("&c")) || (sign.getLine(0).contains("&d")) || (sign.getLine(0).contains("&e")) || (sign.getLine(0).contains("&f")) || (sign.getLine(0).contains("&o")) || (sign.getLine(0).contains("&l")) || (sign.getLine(0).contains("&k")) || (sign.getLine(0).contains("&n")) || (sign.getLine(0).contains("&m")) || (sign.getLine(0).contains("&r"))) {
                sign.setLine(0, sign.getLine(0).replace("&", "§"));
            }
            if ((sign.getLine(1).contains("&1")) || (sign.getLine(1).contains("&2")) || (sign.getLine(1).contains("&3")) || (sign.getLine(1).contains("&4")) || (sign.getLine(1).contains("&5")) || (sign.getLine(1).contains("&6")) || (sign.getLine(1).contains("&7")) || (sign.getLine(1).contains("&8")) || (sign.getLine(1).contains("&9")) || (sign.getLine(1).contains("&0")) || (sign.getLine(1).contains("&a")) || (sign.getLine(1).contains("&b")) || (sign.getLine(1).contains("&c")) || (sign.getLine(1).contains("&d")) || (sign.getLine(1).contains("&e")) || (sign.getLine(1).contains("&f")) || (sign.getLine(1).contains("&o")) || (sign.getLine(1).contains("&l")) || (sign.getLine(1).contains("&k")) || (sign.getLine(1).contains("&n")) || (sign.getLine(1).contains("&m")) || (sign.getLine(1).contains("&r"))) {
                sign.setLine(1, sign.getLine(1).replace("&", "§"));
            }
            if ((sign.getLine(2).contains("&1")) || (sign.getLine(2).contains("&2")) || (sign.getLine(2).contains("&3")) || (sign.getLine(2).contains("&4")) || (sign.getLine(2).contains("&5")) || (sign.getLine(2).contains("&6")) || (sign.getLine(2).contains("&7")) || (sign.getLine(2).contains("&8")) || (sign.getLine(2).contains("&9")) || (sign.getLine(2).contains("&0")) || (sign.getLine(2).contains("&a")) || (sign.getLine(2).contains("&b")) || (sign.getLine(2).contains("&c")) || (sign.getLine(2).contains("&d")) || (sign.getLine(2).contains("&e")) || (sign.getLine(2).contains("&f")) || (sign.getLine(2).contains("&o")) || (sign.getLine(2).contains("&l")) || (sign.getLine(2).contains("&k")) || (sign.getLine(2).contains("&n")) || (sign.getLine(2).contains("&m")) || (sign.getLine(2).contains("&r"))) {
                sign.setLine(2, sign.getLine(2).replace("&", "§"));
            }
            if ((sign.getLine(3).contains("&1")) || (sign.getLine(3).contains("&2")) || (sign.getLine(3).contains("&3")) || (sign.getLine(3).contains("&4")) || (sign.getLine(3).contains("&5")) || (sign.getLine(3).contains("&6")) || (sign.getLine(3).contains("&7")) || (sign.getLine(3).contains("&8")) || (sign.getLine(3).contains("&9")) || (sign.getLine(3).contains("&0")) || (sign.getLine(3).contains("&a")) || (sign.getLine(3).contains("&b")) || (sign.getLine(3).contains("&c")) || (sign.getLine(3).contains("&d")) || (sign.getLine(3).contains("&e")) || (sign.getLine(3).contains("&f")) || (sign.getLine(3).contains("&o")) || (sign.getLine(3).contains("&l")) || (sign.getLine(3).contains("&k")) || (sign.getLine(3).contains("&n")) || (sign.getLine(3).contains("&m")) || (sign.getLine(3).contains("&r"))) {
                sign.setLine(3, sign.getLine(3).replace("&", "§"));
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        boolean som = EssentialsLT.getInstance().getConfig().getBoolean("Som");
        if (som) {
            p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 7.0F, 1.0F);
        }

        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            String cmd = event.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            String mensagem = EssentialsLT.getInstance().getConfig().getString("Mensagem").replaceAll("&", "§").replace("[cmd]", cmd);
            if (topic == null) {

                player.sendMessage(mensagem);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);

        boolean Staff = EssentialsLT.getInstance().getConfig().getBoolean("Staff");
        if (Staff) {
            if (p.hasPermission("ELT.staff")) {
                String staffl = EssentialsLT.getInstance().getConfig().getString("SMensagem").replaceAll("&", "§").replace("[nick]", p.getName());
                e.setJoinMessage(staffl);

            }

        }
        boolean vipl = EssentialsLT.getInstance().getConfig().getBoolean("Vip");
        if (vipl) {
            if (p.hasPermission("ELT.vip")) {
                String vipll = EssentialsLT.getInstance().getConfig().getString("VMensagem").replaceAll("&", "§").replace("[nick]", p.getName());
                e.setJoinMessage(vipll);

            }

        }
        boolean EMensagem = EssentialsLT.getInstance().getConfig().getBoolean("EMensagem");
        if (EMensagem) {
            if (p.hasPermission("ELT.membro")) {
                String entrou = EssentialsLT.getInstance().getConfig().getString("entrou").replaceAll("&", "§").replace("[nick]", p.getName());
                e.setJoinMessage(entrou);
            }
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void Quit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        boolean EMensagem = EssentialsLT.getInstance().getConfig().getBoolean("EMensagem");
        if (EMensagem) {
            if (p.hasPermission("membro")) {
                String saiu = EssentialsLT.getInstance().getConfig().getString("saiu").replaceAll("&", "§").replace("[nick]", p.getName());
                e.setQuitMessage(saiu);
            }
        }
    }

}

package cloud.vanillaclassic.randomcodelottery;

import org.bukkit.Material;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MessageEvent implements Listener {
    public static String message;
    public static String pname;
    public static Player player;
    private static String ck;
    private static ItemStack ci;
    private static String vk;
    private static Long timerstart;


    @EventHandler
    public void onChat(AsyncPlayerChatEvent w) {
        ci=CodeGen.currentitem();
        ck=CodeGen.currentkod();
        Long st = CodeGen.starttime();
        player = w.getPlayer();
        message = w.getMessage();
        pname = w.getPlayer().getPlayerListName();
        if (message.equals(ck)&&vk!=ck) {
            Long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - st);
            Bukkit.broadcastMessage(ChatColor.GOLD + "╔══════════════©ａｓｅｄｉ．ｒｃｌ═══════════════╗");
            Bukkit.broadcastMessage(ChatColor.AQUA + "                              " + ChatColor.BOLD + "Wygrywa "+ChatColor.YELLOW +pname+"!");
            Bukkit.broadcastMessage(ChatColor.AQUA + "                                Przepisał kod w " + time+"s!");
            Bukkit.broadcastMessage(ChatColor.GOLD + "╚══════════════©ａｓｅｄｉ．ｒｃｌ═══════════════╝");
            Bukkit.broadcastMessage(ChatColor.RED +"Następny kod za 30 minut.");
            player.getInventory().addItem(ci);
            vk=ck;
        }

    }

}
package cloud.vanillaclassic.randomcodelottery;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String kod;
    public static ItemStack item;
    public static ItemStack ci;
    public Integer pcount;
    public JavaPlugin plugin=this;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MessageEvent(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                pcount = getServer().getOnlinePlayers().size();
                /*Checks if players count is lower than 5*/
                if (pcount <5) {}
                else {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Za 5 sekund wyświetli się kod!");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            CodeGen cg = new CodeGen();
                            kod = cg.codegen();
                            item = cg.itemgen();
                            ci = cg.currentitem();
                            Bukkit.broadcastMessage(ChatColor.GOLD + "╔══════════════©ａｓｅｄｉ．ｒｃｌ═══════════════╗");
                            Bukkit.broadcastMessage("                                " + ChatColor.GREEN + kod);
                            Bukkit.broadcastMessage("");
                            Bukkit.broadcastMessage(ChatColor.AQUA + "           " + ChatColor.BOLD + "Przepisz kod jako pierwszy i wygraj: ");
                            Bukkit.broadcastMessage("                                " + ChatColor.YELLOW + ci.getAmount() + "x " + ci.getType().toString().toLowerCase());
                            Bukkit.broadcastMessage(ChatColor.GOLD + "╚══════════════©ａｓｅｄｉ．ｒｃｌ═══════════════╝");
                        }
                    }, 100L);
                }
            }
        }, 0L, 48000L);
    }
}


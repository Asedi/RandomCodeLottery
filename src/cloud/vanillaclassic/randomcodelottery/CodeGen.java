package cloud.vanillaclassic.randomcodelottery;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class CodeGen {
    public static String currentkod;
    public static String kod;
    public static ItemStack currentitem;
    public static ItemStack item;
    public static ArrayList<ItemStack> items = new ArrayList<ItemStack>();
    public static Long timerstart;
    /*RandomCode generator*/
    public static String codegen() {
        StringBuilder builder = new StringBuilder();
        String s = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 10; i++) {
            double index = Math.random() * s.length();
            builder.append(s.charAt((int) index));
        }
        currentkod=builder.toString();
        timerstart=System.currentTimeMillis();
        return kod=builder.toString();
    }
    public static String currentkod(){
        return currentkod;
    }
    /*Items pool*/
    public static ItemStack itemgen(){
        ItemStack effkilof=new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta effkilofmeta = effkilof.getItemMeta();
        effkilofmeta.addEnchant(Enchantment.DIG_SPEED, 2, true);
        effkilof.setItemMeta(effkilofmeta);
        items.add(effkilof);
        items.add(new ItemStack(Material.GOLDEN_APPLE, 8));
        items.add(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        items.add(new ItemStack(Material.DIAMOND_AXE, 1));
        items.add(new ItemStack(Material.ENCHANTING_TABLE, 1));
        items.add(new ItemStack(Material.DIAMOND, 8));
        items.add(new ItemStack(Material.OBSIDIAN, 32));
        Random rand = new Random();
        currentitem = items.get(rand.nextInt(items.size()));
        return item=items.get(rand.nextInt(items.size()));
    }
    public static ItemStack currentitem(){
        return currentitem;
    }
    public static Long starttime(){
        return timerstart;
    }
}

package stupdustpl.sd.pl.GameMode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import stupdustpl.sd.pl.stupdust;

import java.util.Random;

public class GameMode1 implements Listener {
    private String gameMode1World;

    public ItemStack[] argItems;


    @EventHandler
    public void playerChangedWorld(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.DARK_RED.toString() +  "Player changed World");
        gameMode1World = player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "GameMode1WorldName"), PersistentDataType.STRING);
        if(player.getWorld().getName().equals(gameMode1World)) {
            player.sendMessage(ChatColor.DARK_RED.toString() + "Player is in gameMode1World!");
            playerGetItems();

        }else {
            player.sendMessage(ChatColor.DARK_RED.toString() +  "Player isn't in gameMode1World");
        }

    }

    public void playerGetItems() {
        setItems();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().getName().equals(player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "GameMode1WorldName"), PersistentDataType.STRING))) {
                player.sendMessage(ChatColor.DARK_RED.toString() + "add Items");
                run();



            }
        }
    }

    public void setItems() {
        argItems = new ItemStack[]{new ItemStack(Material.STRING), new ItemStack(Material.ACACIA_BOAT), new ItemStack(Material.ACACIA_BUTTON), new ItemStack(Material.ACACIA_DOOR
        ), new ItemStack(Material.ACACIA_FENCE), new ItemStack(Material.ACACIA_FENCE_GATE), new ItemStack(Material.ACACIA_LEAVES), new ItemStack(Material.ACACIA_LOG), new ItemStack(Material.ACACIA_PLANKS)
                , new ItemStack(Material.ACACIA_PRESSURE_PLATE), new ItemStack(Material.ACACIA_SAPLING), new ItemStack(Material.ACACIA_SIGN), new ItemStack(Material.ACACIA_SLAB)
                , new ItemStack(Material.ACACIA_STAIRS), new ItemStack(Material.ACACIA_TRAPDOOR), new ItemStack(Material.ACACIA_WOOD), new ItemStack(Material.ACTIVATOR_RAIL)
                , new ItemStack(Material.ALLIUM), new ItemStack(Material.AMETHYST_BLOCK), new ItemStack(Material.AMETHYST_CLUSTER), new ItemStack(Material.AMETHYST_SHARD), new ItemStack(Material.ANCIENT_DEBRIS)
                , new ItemStack(Material.ANDESITE), new ItemStack(Material.ANDESITE_SLAB), new ItemStack(Material.ANDESITE_STAIRS), new ItemStack(Material.ANDESITE_WALL), new ItemStack(Material.ANVIL)
                , new ItemStack(Material.APPLE), new ItemStack(Material.ARMOR_STAND), new ItemStack(Material.ARROW), new ItemStack(Material.ATTACHED_MELON_STEM), new ItemStack(Material.ATTACHED_PUMPKIN_STEM)
                , new ItemStack(Material.AXOLOTL_BUCKET), new ItemStack(Material.AXOLOTL_SPAWN_EGG), new ItemStack(Material.AZALEA), new ItemStack(Material.AZALEA_LEAVES), new ItemStack(Material.AZURE_BLUET)
                , new ItemStack(Material.BAKED_POTATO), new ItemStack(Material.BAMBOO), new ItemStack(Material.BAMBOO_SAPLING), new ItemStack(Material.BARREL), new ItemStack(Material.BARRIER)
                , new ItemStack(Material.BASALT), new ItemStack(Material.BAT_SPAWN_EGG), new ItemStack(Material.BEACON), new ItemStack(Material.BEDROCK), new ItemStack(Material.BEE_NEST)
                , new ItemStack(Material.BEE_SPAWN_EGG), new ItemStack(Material.BEEF), new ItemStack(Material.BEEHIVE), new ItemStack(Material.BEETROOT), new ItemStack(Material.BEETROOT_SEEDS)
                , new ItemStack(Material.BEETROOT_SOUP), new ItemStack(Material.BEETROOTS), new ItemStack(Material.BELL), new ItemStack(Material.BIG_DRIPLEAF), new ItemStack(Material.BIG_DRIPLEAF_STEM)
                , new ItemStack(Material.BIRCH_BOAT), new ItemStack(Material.BIRCH_BUTTON), new ItemStack(Material.BIRCH_DOOR), new ItemStack(Material.BIRCH_FENCE), new ItemStack(Material.BIRCH_FENCE_GATE)
                , new ItemStack(Material.BIRCH_LEAVES), new ItemStack(Material.BIRCH_LOG), new ItemStack(Material.BIRCH_PLANKS), new ItemStack(Material.BIRCH_PRESSURE_PLATE), new ItemStack(Material.BIRCH_SAPLING)
                , new ItemStack(Material.BIRCH_SIGN), new ItemStack(Material.BIRCH_SLAB), new ItemStack(Material.BIRCH_STAIRS), new ItemStack(Material.BIRCH_TRAPDOOR), new ItemStack(Material.BIRCH_WALL_SIGN)
                , new ItemStack(Material.BIRCH_WOOD), new ItemStack(Material.BLACK_BANNER), new ItemStack(Material.BLACK_BED), new ItemStack(Material.BLACK_CANDLE), new ItemStack(Material.BLACK_CANDLE_CAKE), new ItemStack(Material.BLACK_CARPET)   //Ab jetzt Items die nicht möglich sind zu bekommen ausschließen
                , new ItemStack(Material.BLACK_CONCRETE), new ItemStack(Material.BLACK_CONCRETE_POWDER), new ItemStack(Material.BLACK_DYE), new ItemStack(Material.BLACK_GLAZED_TERRACOTTA), new ItemStack(Material.BLACK_SHULKER_BOX)
                , new ItemStack(Material.BLACK_STAINED_GLASS), new ItemStack(Material.BLACK_STAINED_GLASS_PANE), new ItemStack(Material.BLACK_TERRACOTTA), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACKSTONE)
                , new ItemStack(Material.BLACKSTONE_SLAB), new ItemStack(Material.BLACKSTONE_STAIRS), new ItemStack(Material.BLACKSTONE_WALL), new ItemStack(Material.BLAST_FURNACE)
                , new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.BLAZE_SPAWN_EGG), new ItemStack(Material.BLUE_BANNER), new ItemStack(Material.BLUE_BED), new ItemStack(Material.BLUE_CANDLE)};  //Black wall banner


    }









    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(player.getWorld().getName().equals(player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "GameMode1WorldName"), PersistentDataType.STRING))) {
                        Random r = new Random();
                        int rndNumber = r.nextInt(argItems.length);

                        player.getInventory().addItem(argItems[rndNumber]);
                    }
                }



            }
        }.runTaskTimer(stupdust.getPlugin(), 100, 100);
    }

}

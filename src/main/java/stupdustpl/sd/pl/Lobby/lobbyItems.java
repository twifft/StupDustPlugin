package stupdustpl.sd.pl.Lobby;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;

public class lobbyItems implements Listener {

    public ItemStack gunPowderModi;

    @EventHandler
    public void playerJoins(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        registerItems();
        if(player.getWorld().getName().equals("Lobby")) {
            player.getInventory().setItem(4, gunPowderModi);
        }
    }


    @EventHandler
    public void clickItems(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();

        if(player.getItemInHand().equals(Material.GUNPOWDER) && action.equals(Action.RIGHT_CLICK_AIR) && player.getItemInHand().getItemMeta().getDisplayName().equals("§8Spiel Modus")) {
            //Spiel Modus Item
            player.sendMessage("Penis");

        }
    }


    public void registerItems() {
        gunPowderModi = new ItemStack(Material.GUNPOWDER);
        ItemMeta gunPowderMeta = gunPowderModi.getItemMeta();
        gunPowderMeta.setDisplayName("§8Spiel Modus");
        gunPowderModi.setItemMeta(gunPowderMeta);
    }

}

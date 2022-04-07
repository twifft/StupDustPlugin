package stupdustpl.sd.pl.Data;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import stupdustpl.sd.pl.Listener.JoinListener;
import stupdustpl.sd.pl.stupdust;

import javax.naming.Name;

public class PlayTime implements Listener {
    public static int playtimeSecINT;
    public static int playtimeMinINT;
    public static int playtimeStdINT;
    public static String playTimeDisplay;

     static Player player;

@EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        player = e.getPlayer();

    if(player.getPersistentDataContainer().has(new NamespacedKey(stupdust.getPlugin(), "fullyPlayTime"), PersistentDataType.STRING)) {
        player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "fullyPlayTime"), PersistentDataType.STRING, playTimeDisplay);

    }

     run();
}




    @EventHandler
    public void playerLeftServer(PlayerQuitEvent e) {
        player = e.getPlayer();
        player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "fullyPlayTime")
                , PersistentDataType.STRING, player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin()
                        , "fullyPlayTime"), PersistentDataType.STRING));
    }

    public static void playerPlayTime() {

    }

    private static void run() {
        new BukkitRunnable() {

            public void run() {


                playtimeSecINT++;
                if(playtimeSecINT == 60) {
                    playtimeSecINT = 0;
                    playtimeMinINT++;
                }
                if(playtimeMinINT == 60) {
                    playtimeMinINT = 0;
                    playtimeStdINT++;
                }
                String playtimeSecString = "" + playtimeSecINT;
                String playtimeMinString = "" + playtimeMinINT;
                String playtimeStdString = "" + playtimeStdINT;


                if(playtimeSecINT <= 10) {
                    playtimeSecString = "0" + playtimeSecINT;
                }else {
                    playtimeSecString = "" + playtimeSecINT;
                }
                if(playtimeMinINT <= 10) {
                    playtimeMinString = "0" + playtimeMinINT;
                }else {
                    playtimeMinString = "" + playtimeMinINT;
                }
                if(playtimeStdINT <= 10) {
                    playtimeStdString = "0" + playtimeStdINT;
                }else {
                    playtimeStdString = "" + playtimeStdINT;
                }


                playTimeDisplay = playtimeStdString + " : " + playtimeMinString + " : " + playtimeSecString;



                player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "fullyPlayTime"), PersistentDataType.STRING, playTimeDisplay);



            }
        }.runTaskTimer(stupdust.getPlugin(), 20, 20);
    }

}

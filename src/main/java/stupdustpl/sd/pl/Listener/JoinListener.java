package stupdustpl.sd.pl.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import stupdustpl.sd.pl.Data.PlayTime;
import stupdustpl.sd.pl.Ui.ScoreBoardLobby;
import stupdustpl.sd.pl.stupdust;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        new ScoreBoardLobby(player);
        for(int i = 0; i == 1; i-- ) {
            new ScoreBoardLobby(player);
            PlayTime.playerPlayTime();
        }

    }




    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(stupdust.getPlugin(), 20, 20);
    }

}

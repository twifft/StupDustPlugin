package stupdustpl.sd.pl.Ui;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import stupdustpl.sd.pl.Data.PlayTime;
import stupdustpl.sd.pl.Stuff.Tokens;
import stupdustpl.sd.pl.stupdust;

import javax.print.DocFlavor;

public class ScoreBoardLobby extends ScoreboardBuilder implements Listener {

    private int socialId;
    private int tokenCountScorboard;






    public ScoreBoardLobby(Player player) {
        super(player, ChatColor.AQUA.toString() + ChatColor.BOLD + " Stup Dust ");




        socialId = 0;

        run();
    }
    public void tokenCountPlayer() {
        if (player.getPersistentDataContainer().has(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER)) {

            tokenCountScorboard = player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER);
            player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, tokenCountScorboard);
        }


    }




    @Override
    public void createScoreboard() {


        setScore("", 12);

        setScore( "", 11 );

        setScore("", 10);

        setScore("", 9);

        setScore("", 8);

        setScore("", 7);

        setScore("", 6);

        setScore("", 5);

        setScore("", 4);

        setScore("", 3);

        setScore("", 2);

        setScore("", 1);

        setScore("", 0);
    }

    public void playTime() {

    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
               // tokenCountPlayer();
               // setScore(ChatColor.GRAY.toString() + "Spielzeit | " + player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "fullyPlayTime"), PersistentDataType.STRING), 5);







                switch (socialId) {
                    case 0:
                        if(tokenCountScorboard == 1) {

                            setScore(ChatColor.WHITE.toString()+ "Du hast " + ChatColor.DARK_RED + tokenCountScorboard + ChatColor.WHITE + " Token!", 7);
                        }else {
                            setScore(ChatColor.WHITE.toString()+ "Du hast " + ChatColor.DARK_RED + tokenCountScorboard + ChatColor.WHITE + " Tokens!", 7);
                        }

                        break;
                    case 1:
                        if(tokenCountScorboard == 1) {

                            setScore(ChatColor.WHITE.toString()+ "Du hast " + ChatColor.DARK_PURPLE + tokenCountScorboard + ChatColor.WHITE + " Token!", 7);
                        }else {
                            setScore(ChatColor.WHITE.toString()+ "Du hast " + ChatColor.DARK_PURPLE + tokenCountScorboard + ChatColor.WHITE + " Tokens!", 7);
                        }

                        break;
                    case 2:
                        if(tokenCountScorboard == 1) {

                            setScore(ChatColor.WHITE.toString()+ "Du hast " + ChatColor.DARK_GRAY + tokenCountScorboard + ChatColor.WHITE + " Token!", 7);
                        } else {
                            setScore(ChatColor.WHITE.toString()+ "Du hast " + ChatColor.DARK_GRAY + tokenCountScorboard + ChatColor.WHITE + " Tokens!", 7);
                        }




                        break;
                }



                socialId++;
                if(socialId >= 3) {
                    socialId = 0;
                }


            }
        }.runTaskTimer(stupdust.getPlugin(), 20, 20);
    }
}

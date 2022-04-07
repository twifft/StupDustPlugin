package stupdustpl.sd.pl.GameMode.CreateWorld;

import com.sun.jdi.IntegerValue;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import stupdustpl.sd.pl.stupdust;

import javax.annotation.Nonnull;
import java.util.Random;


public class CreateWorld extends ChunkGenerator implements CommandExecutor, Listener {

    World world;
    public static String nameOfCreatedChallengeWorld;
    public static String worldName;
    Block block;
    Player Thisplayer;

    @Override
    @Nonnull
    public ChunkData generateChunkData(@Nonnull World world, @Nonnull Random random, int x, int z, @Nonnull BiomeGrid biome) {
        return createChunkData(world);
    }


    public void createAWorld() {
        String playerValue = Thisplayer.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "gameMode1playerValue"), PersistentDataType.STRING);
            
        Material spawnMat = Material.IRON_BLOCK;

        WorldCreator creator = new WorldCreator(worldName);
        creator.generator(new CreateWorld());

        world = creator.createWorld();
        if(playerValue == "1") {
            world.setType(0, 20, 0, spawnMat);
            world.setSpawnLocation(0, 20 , 0);
        }else if(playerValue == "2") {
            world.setType(0, 20, 3, spawnMat);
            world.setType(0, 20, -3, spawnMat);


            world.setSpawnLocation(0, 20 , 3);
        }





    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Thisplayer = ((Player) sender).getPlayer();
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.DARK_RED + "Du musst einen Namen dahinter festlegen!");
            }else if(args.length == 1) {
                String setName;
                setName = args[0];
                player.sendMessage(setName);
                player.sendMessage(ChatColor.DARK_RED + "Schreibe die Spieleranzahl dahinter!");
            }else if(args.length == 2) {
                if(isInt(args[1])) {
                    if(Integer.valueOf(args[1]) <= 4) {
                        player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "gameMode1playerValue"), PersistentDataType.STRING, Integer.valueOf(args[1]).toString());
                    }else if(Integer.valueOf(args[1]) > 4) {
                        player.sendMessage(ChatColor.DARK_RED + "Diese Spieleranzahl wird leider nicht unterstützt!");
                    }
                }else {
                    player.sendMessage(ChatColor.DARK_RED + "Bitte überprüfe deine Angabe!");
                }
            }
                worldName =  player.getName().toString() + args[0];
                createAWorld();
                PersistentDataContainer data = player.getPersistentDataContainer();


                nameOfCreatedChallengeWorld = worldName;


                player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "GameMode1WorldName"), PersistentDataType.STRING, nameOfCreatedChallengeWorld);
                player.sendMessage("Wurde erfolgreich erstellt!");
                player.sendMessage(player.getPersistentDataContainer().get(new NamespacedKey(stupdust.getPlugin(), "GameMode1WorldName"), PersistentDataType.STRING));




        }
        return true;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

    }
    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}

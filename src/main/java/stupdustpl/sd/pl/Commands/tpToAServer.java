package stupdustpl.sd.pl.Commands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import stupdustpl.sd.pl.stupdust;

import javax.imageio.IIOException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class tpToAServer implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            PersistentDataContainer data = player.getPersistentDataContainer();
            if (player.getPersistentDataContainer().has(new NamespacedKey(stupdust.getPlugin(), "playerName"), PersistentDataType.STRING)) {
                player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "playerName"), PersistentDataType.STRING, player.getName());
            }


            if(args.length == 0) {
                player.sendMessage(ChatColor.DARK_RED + ChatColor.UNDERLINE.toString() + "Es muss ein Server mit '1' oder '2' ausgewählt werden!");
            }else if(args.length == 1) {
                if(args[1].equalsIgnoreCase("1")) {
                    sendServer(player, "lobby");
                }else if(args[1].equalsIgnoreCase("2")) {
                    sendServer(player, "game");

                }else {
                    player.sendMessage(ChatColor.DARK_RED + ChatColor.UNDERLINE.toString() + "Dieser Server exestiert nicht!!!");
                }
            }






        }
        return true;
    }


    private void sendServer(Player player, String server) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try{
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(stupdust.getPlugin(), "BungeeCord", byteArrayOutputStream.toByteArray());

    }
}

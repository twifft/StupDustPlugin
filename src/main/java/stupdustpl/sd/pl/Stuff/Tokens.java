package stupdustpl.sd.pl.Stuff;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import stupdustpl.sd.pl.stupdust;

public class Tokens implements Listener, CommandExecutor {
    public static int tokenCount;
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PersistentDataContainer data = player.getPersistentDataContainer();

        if (player.getPersistentDataContainer().has(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER)) {
            player.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, tokenCount);
        }
    }

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;


            PersistentDataContainer data = p.getPersistentDataContainer();
            tokenCount = data.get(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER);
           if (!data.has(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER)) {
             p.getPersistentDataContainer().set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, 99);
           }

            if (args.length == 0) {
                if (data.has(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER)) {
                    p.sendMessage("Du hast " + tokenCount + " Tokens!");
                } else {
                    p.sendMessage("Bitte nutzte den Command nochmal!");
                    data.set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, 0);
                }
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("add")) {

                    if (args.length == 2) {
                        if (isInt(args[1])) {
                            if (data.has(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER)) {

                                tokenCount = tokenCount + Integer.valueOf(args[1]);
                                data.set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, tokenCount);
                                p.sendMessage("Du hast nun " + tokenCount + " Tokens!");
                            } else {
                                p.sendMessage("Bitte nutzte den Command nochmal!");
                                data.set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, 0);
                            }
                        } else {
                            p.sendMessage("Das war keine Nummer!");
                        }
                    }else {
                        p.sendMessage("Füge eine Nummer hinzu!");
                    }
                } else if (args[0].equalsIgnoreCase("set")) {
                    if (args.length == 2) {
                        if (isInt(args[1])) {
                            if (data.has(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER)) {

                                tokenCount = Integer.valueOf(args[1]);
                                data.set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, tokenCount);
                                p.sendMessage("Your new Token count is now " + tokenCount);
                            } else {
                                p.sendMessage("Please use the Command again");
                                data.set(new NamespacedKey(stupdust.getPlugin(), "localtokens"), PersistentDataType.INTEGER, 0);
                            }
                        }
                    }


                }else {
                    p.sendMessage("Command konnte nicht ausgeführt werden!");
                }
            }
        }
        return true;
    }
 }




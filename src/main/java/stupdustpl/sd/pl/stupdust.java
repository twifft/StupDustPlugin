package stupdustpl.sd.pl;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.Service;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import stupdustpl.sd.pl.Commands.tpToAServer;
import stupdustpl.sd.pl.Data.PlayTime;
import stupdustpl.sd.pl.GameMode.CreateWorld.CreateWorld;
import stupdustpl.sd.pl.GameMode.GameMode1;
import stupdustpl.sd.pl.Listener.JoinListener;
import stupdustpl.sd.pl.Lobby.lobbyItems;
import stupdustpl.sd.pl.Stuff.Random;
import stupdustpl.sd.pl.Stuff.Tokens;
import stupdustpl.sd.pl.Ui.ScoreBoardLobby;

public final class stupdust extends JavaPlugin implements PluginMessageListener {


    private static stupdust plugin;
    Player player;



    @Override
    public void onEnable() {
        plugin = this;




        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);


        getCommand("tokens").setExecutor(new Tokens());
        getCommand("random").setExecutor(new Random());
        getCommand("sdcreate").setExecutor(new CreateWorld());
        getCommand("switchserver").setExecutor(new tpToAServer());





        PluginManager manager = Bukkit.getPluginManager();
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new CreateWorld(), this);
        getServer().getPluginManager().registerEvents(new GameMode1(), this);
        getServer().getPluginManager().registerEvents(new PlayTime(), this);
        getServer().getPluginManager().registerEvents(new lobbyItems(), this);







        for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            new ScoreBoardLobby(all);
        }


    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);




    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("SubChannel")) {
            // Use the code sample in the 'Response' sections below to read
            // the data.

            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Subchannel");
            out.writeUTF("privateSpigot");

            // If you don't care about the player
            // Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
            // Else, specify them
            player = Bukkit.getPlayerExact(player.getPersistentDataContainer().get(new NamespacedKey(getPlugin(), "playerName"), PersistentDataType.STRING));

            player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
        }

    }


    public static stupdust getPlugin() {
        return plugin;
    }
}

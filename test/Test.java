package me.kavin.test;
import me.kavin.test.commands.red;
import me.kavin.test.commands.flash;
import me.kavin.test.commands.white;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin implements Listener {
    private static Test instance;
    @Override
    public void onEnable()
    {
        instance = this;
        System.out.println("Plugin started !");
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("red").setExecutor(new red());
        getCommand("white").setExecutor(new white());
        getCommand("flash").setExecutor(new flash());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        String name = event.getPlayer().getName();
        event.setJoinMessage(ChatColor.GREEN + " ✓ " + ChatColor.GREEN + name + ChatColor.AQUA + ", Has joined the server ");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        String name = event.getEntity().getName();
        String reason = event.getDeathMessage();
        int a = reason.indexOf(' ');
        String reason1 = reason.substring(a);
        event.setDeathMessage(ChatColor.DARK_RED + " ✖ " + ChatColor.GREEN + name + ChatColor.AQUA + reason1);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        String name = event.getPlayer().getName();
        event.setQuitMessage(ChatColor.DARK_RED + " ✖ " + ChatColor.GREEN + name + ChatColor.AQUA + ", Has left the server ");
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String chat = event.getMessage();
        event.setMessage(ChatColor.GREEN + "→ " + ChatColor.YELLOW + chat);
    }

    public static Test getInstance() {
        return instance;
    }
}


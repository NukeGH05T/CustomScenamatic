package me.nukeghost.customscenamatic;

import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import me.nukeghost.customscenamatic.commands.CommandManager;
import me.nukeghost.customscenamatic.language.LanguageConfig;
import me.nukeghost.customscenamatic.language.Message;
import me.nukeghost.customscenamatic.listeners.CutsceneFlagListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class CustomScenamatic extends JavaPlugin {

    public static CustomScenamatic plugin;
    public static WorldGuard worldGuard;
    public static StateFlag CUTSCENE_FLAG;

    private boolean hasHookedInWG = false;

    @Override
    public void onLoad() {
        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            // create a flag with the name "my-custom-flag", defaulting to true
            StateFlag flag = new StateFlag("cutscene-zone", false);
            registry.register(flag);
            CUTSCENE_FLAG = flag;
            hasHookedInWG = true;
        } catch (FlagConflictException e) {
            // some other plugin registered a flag by the same name already.
            Flag<?> existing = registry.get("cutscene-zone");
            if (existing instanceof StateFlag) {
                CUTSCENE_FLAG = (StateFlag) existing;
                hasHookedInWG = true;
            } else {
                Bukkit.getLogger().severe("CustomScenamatic failed to register \"cutscene\" flag! Please make sure conflicting plugins are not present.");
                hasHookedInWG = false;
            }
        }
    }

    @Override
    public void onEnable() {
        plugin = this;
        if (!hasHookedInWG) {
            Bukkit.getLogger().severe("Disabling CustomScenamatic...");
            plugin.getServer().getPluginManager().disablePlugins();
        }
        worldGuard = getWorldGuard();

        initializeConfig();
        initializeLang();
        registerCommands();
        registerListeners();

    }

    private void initializeConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    private void initializeLang() {
        LanguageConfig.setupLang();
        Message.loadMessages();
    }

    private void registerCommands() {
        getCommand("customscenamatic").setExecutor(new CommandManager());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CutsceneFlagListener(CUTSCENE_FLAG), this);
    }

    private WorldGuard getWorldGuard() {
        return WorldGuard.getInstance();
    }


}

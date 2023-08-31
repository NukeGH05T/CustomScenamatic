package me.nukeghost.customscenamatic.language;

import me.nukeghost.customscenamatic.CustomScenamatic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguageConfig {
    private static File langFile;
    private static FileConfiguration langConfig;
    static String langFileName = CustomScenamatic.plugin.getConfig().getString("lang-file");

    public static void setupLang() {
        //Call it in onEnable()
        File dirFile = new File(CustomScenamatic.plugin.getDataFolder() + "/language");
        boolean dir = dirFile.mkdir();
        langFile = new File(CustomScenamatic.plugin.getDataFolder() + "/language", langFileName);

        if (!langFile.exists()) {
            try {
                langFile.createNewFile();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[CustomScenamatic] Please ignore the following warning if it starts with " + ChatColor.GREEN + "The system cannot find the path specified");
                Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[CustomScenamatic] The language file does not exist and is being created.");
                e.printStackTrace();
            }
            new DefaultWriter().writeEnglishLang();
        }

        langConfig = YamlConfiguration.loadConfiguration(langFile);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[CustomScenamatic] Successfully loaded " + ChatColor.DARK_AQUA + langFileName);
    }

    public static FileConfiguration getLangConfig() {
        return langConfig;
    }

    public static void saveLangConfig() {
        try {
            langConfig.save(langFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Something went wrong while saving the file!");
            e.printStackTrace();
        }
    }

    public static void reloadLangConfig() {
        CustomScenamatic.plugin.reloadConfig();
        langConfig = YamlConfiguration.loadConfiguration(langFile);
    }

}

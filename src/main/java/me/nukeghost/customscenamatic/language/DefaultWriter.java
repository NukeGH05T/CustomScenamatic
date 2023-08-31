package me.nukeghost.customscenamatic.language;

import me.nukeghost.customscenamatic.CustomScenamatic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DefaultWriter {
    BufferedWriter bw;
    String langFileName = CustomScenamatic.plugin.getConfig().getString("lang-file");

    public void writeEnglishLang() {
        File file = new File(CustomScenamatic.plugin.getDataFolder() + "/language/" + langFileName);
        initializeWriter();
        write();
        closeWriter();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Initialized default fields for " + langFileName + ".");
    }

    private void initializeWriter() {
        try {
            bw = new BufferedWriter(new FileWriter(CustomScenamatic.plugin.getDataFolder() + "/language/" + langFileName));
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[CustomScenamatic] Something went wrong while writing the default lang file!");
            e.printStackTrace();
        }
    }

    private void write() {
        Bukkit.getLogger().info("Writing default lang");
        try {
            bw.write("RELOAD_COMMAND_DESCRIPTION: 'Reloads the plugin'\n" +
                    "RELOAD_SUCCESSFULL: '&bReload Successful'\n" +
                    "RELOAD_FAILED: '&cReload Failed'\n" +
                    "RELOAD_NO_PERM: '&cYou do not have permission to run this command'\n" +
                    "\n" +
                    "HELP_COMMAND_DESCRIPTION: 'Shows available commands'\n" +
                    "\n" +
                    "CREATE_COMMAND_DESCRIPTION: 'Create an interaction entity'\n" +
                    "\n" +
                    "CMDM_NO_PERM_DEFAULT: '&cYou do not have permission to run this command'\n" +
                    "CMDM_INVALID_COMMAND: '&eThe command does not exist'\n" +
                    "CMDM_HELP_SUGGEST: '&eUse &a/cscene help&e for help'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeWriter() {
        try {
            Bukkit.getLogger().info("Closed writer");
            bw.close();
        } catch (IOException e) { e.printStackTrace();}
    }
}

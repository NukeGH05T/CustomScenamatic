package me.nukeghost.customscenamatic.language;

import me.nukeghost.customscenamatic.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Message {
    ////Commands
//    public static String BOARD_COMMAND_DESCRIPTION;
//    public static String HELP_COMMAND_DESCRIPTION;

    //From YML
    //Commands
    //Reload
    public static String RELOAD_COMMAND_DESCRIPTION;
    public static String RELOAD_SUCCESSFULL;
    public static String RELOAD_FAILED;
    public static String RELOAD_NO_PERM;

    public static String HELP_COMMAND_DESCRIPTION;

    public static String CREATE_COMMAND_DESCRIPTION;

    //Command Manager
    public static String CMDM_NO_PERM_DEFAULT;
    public static String CMDM_INVALID_COMMAND;
    public static String CMDM_HELP_SUGGEST;
    //From YML - End
    public static void loadMessages() {
        FileConfiguration lang = LanguageConfig.getLangConfig();
        //BOARD_COMMAND_DESCRIPTION = lang.getString("BOARD_COMMAND_DESCRIPTION", "Default board desc loaded");

        //YML
        //Commands
        ////Reload
        RELOAD_COMMAND_DESCRIPTION = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("RELOAD_COMMAND_DESCRIPTION")));
        RELOAD_SUCCESSFULL = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("RELOAD_SUCCESSFULL")));
        RELOAD_FAILED = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("RELOAD_FAILED")));
        RELOAD_NO_PERM = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("RELOAD_NO_PERM")));

        HELP_COMMAND_DESCRIPTION = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("HELP_COMMAND_DESCRIPTION")));

        HELP_COMMAND_DESCRIPTION = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("CREATE_COMMAND_DESCRIPTION")));

        CMDM_NO_PERM_DEFAULT = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("CMDM_NO_PERM_DEFAULT")));
        CMDM_INVALID_COMMAND = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("CMDM_INVALID_COMMAND")));
        CMDM_HELP_SUGGEST = ColorUtils.translateHexColorCodes("<#", ">", ColorUtils.translateColorCodes(lang.getString("CMDM_HELP_SUGGEST")));
        //YML - End
    }
}
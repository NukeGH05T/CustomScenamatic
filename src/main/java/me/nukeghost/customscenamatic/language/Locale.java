package me.nukeghost.customscenamatic.language;

public enum Locale {
    //Put in here, LanguageConfig & add it in main or somewhere else
    //Now I don't remember why I put it here. I haven't needed or used it anywhere. It's kinda scary tbh
    //Commands
    //Board
    BOARD_COMMAND_DESCRIPTION,
    //Help
    HELP_COMMAND_DESCRIPTION,
    //Reload
    RELOAD_COMMAND_DESCRIPTION,
    RELOAD_SUCCESSFULL,
    RELOAD_FAILED,
    RELOAD_NO_PERM,
    //Setboard
    SETBOARD_COMMAND_DESCRIPTION,
    BOARD_SETUP_SUCCESSFULL,
    BOARD_OVERRIDE_PREVIOUS,

    //Command Manager
    CMDM_NO_PERM_DEFAULT,
    CMDM_INVALID_COMMAND,
    CMDM_HELP_SUGGEST,

    //Hourly Delivery Menu
    HRD_EMPTY_SUBMISSION,
    HRD_WRONG_SUBMISSION,
    HRD_SUCCESSFUL_SUBMISSION,
    HRD_ICON_ITEM_LORE,
    HRD_SUBMIT_ITEM_DISPLAY,
    HRD_SUBMIT_ITEM_LORE,
    HRD_BACK_ITEM_DISPLAY,

    //Three hourly Delivery Menu
    THD_EMPTY_SUBMISSION,
    THD_WRONG_SUBMISSION,
    THD_SUCCESSFUL_SUBMISSION,
    THD_ICON_ITEM_LORE,
    THD_SUBMIT_ITEM_DISPLAY,
    THD_SUBMIT_ITEM_LORE,
    THD_BACK_ITEM_DISPLAY,

    //Six hourly Delivery Menu
    SHD_EMPTY_SUBMISSION,
    SHD_WRONG_SUBMISSION,
    SHD_SUCCESSFUL_SUBMISSION,
    SHD_ICON_ITEM_LORE,
    SHD_SUBMIT_ITEM_DISPLAY,
    SHD_SUBMIT_ITEM_LORE,
    SHD_BACK_ITEM_DISPLAY,

    //Delivery Board Menu
    DB_DELIVERY_ALREADY_COMPLETE,

    //Hourly Item
    DB_HOURLY_ITEM_LORE,
    DB_HOURLY_ITEM_LORE_FOOTER_COMPLETE,
    DB_HOURLY_ITEM_LORE_FOOTER_INCOMPLETE,

    //Three hourly Item
    DB_THREE_HOURLY_ITEM_LORE,
    DB_THREE_HOURLY_ITEM_LORE_FOOTER_COMPLETE,
    DB_THREE_HOURLY_ITEM_LORE_FOOTER_INCOMPLETE,

    //Six hourly Item
    DB_SIX_HOURLY_ITEM_LORE,
    DB_SIX_HOURLY_ITEM_LORE_FOOTER_COMPLETE,
    DB_SIX_HOURLY_ITEM_LORE_FOOTER_INCOMPLETE;

}

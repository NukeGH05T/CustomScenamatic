package me.nukeghost.customscenamatic.commands.subcommands;

import me.nukeghost.customscenamatic.CustomScenamatic;
import me.nukeghost.customscenamatic.commands.SubCommand;
import me.nukeghost.customscenamatic.language.Message;
import org.bukkit.entity.Player;

public class ReloadCommand extends SubCommand {
    @Override
    public String getName(){
        return "reload";
    }

    @Override
    public String getDescription(){
        return Message.RELOAD_COMMAND_DESCRIPTION;
        //return "Reload the configuration of the plugin";
    }

    @Override
    public String getSyntax(){
        return "/cscene reload";
    }

    @Override
    public String getPermissionNode() {
        return "customscenamatic.reload";
    }

    @Override
    public void perform(Player p, String args[]){

        if (p.hasPermission(getPermissionNode())){
            try {
                CustomScenamatic.plugin.reloadConfig();
                CustomScenamatic.plugin.saveConfig();
            } catch (Exception e) {
                p.sendMessage(Message.RELOAD_FAILED);
                e.printStackTrace();
            }

            p.sendMessage(Message.RELOAD_SUCCESSFULL);//
        }else{
            p.sendMessage(Message.RELOAD_NO_PERM);//
        }

    }

}

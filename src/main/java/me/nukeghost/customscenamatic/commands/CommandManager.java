package me.nukeghost.customscenamatic.commands;

import me.nukeghost.customscenamatic.commands.subcommands.CreateInteractionEntityCommand;
import me.nukeghost.customscenamatic.commands.subcommands.HelpCommand;
import me.nukeghost.customscenamatic.commands.subcommands.ReloadCommand;
import me.nukeghost.customscenamatic.language.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager() {
        subcommands.add(new ReloadCommand());
        subcommands.add(new HelpCommand());
        subcommands.add(new CreateInteractionEntityCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                HelpCommand help = new HelpCommand();
                help.perform(p, args);
            } else if (args.length > 0) {
                boolean isValidSubcommand = false;
                for (int i = 0; i < this.getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(this.getSubCommands().get(i).getName())) {
                        isValidSubcommand = true;

                        if (this.getSubCommands().get(i).getPermissionNode() == null || p.hasPermission(this.getSubCommands().get(i).getPermissionNode())) {

                            this.getSubCommands().get(i).perform(p, args);

                        } else {
                            p.sendMessage(Message.CMDM_NO_PERM_DEFAULT);//
                        }

                        break;
                    }
                }
                if (!isValidSubcommand) {
                    p.sendMessage(Message.CMDM_INVALID_COMMAND);
                    p.sendMessage(Message.CMDM_HELP_SUGGEST);
                }
                return true;
            }

        }

        return true;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subcommands;
    }

}

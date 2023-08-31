package me.nukeghost.customscenamatic.commands.subcommands;

import me.nukeghost.customscenamatic.commands.SubCommand;
import me.nukeghost.customscenamatic.handlers.TitleHandler;
import me.nukeghost.customscenamatic.language.Message;
import org.bukkit.Location;
import org.bukkit.entity.*;

public class CreateInteractionEntityCommand extends SubCommand {
    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return Message.CREATE_COMMAND_DESCRIPTION;
    }

    @Override
    public String getSyntax() {
        return "/cscene create";
    }

    @Override
    public String getPermissionNode() {
        return "customscenamatic.create";
    }

    @Override
    public void perform(Player p, String[] args) {
        Location location = p.getLocation();
        Interaction interactionEntity = (Interaction) location.getWorld().spawnEntity(location, EntityType.INTERACTION);
        String entityID = String.valueOf(interactionEntity.getUniqueId());
        interactionEntity.setCustomNameVisible(true);
        p.sendMessage(entityID);
        interactionEntity.setGlowing(true);

        TitleHandler.updateInteractionEntity("demoScene", p, interactionEntity);
    }
}

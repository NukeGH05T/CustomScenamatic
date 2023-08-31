package me.nukeghost.customscenamatic.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import me.nukeghost.customscenamatic.handlers.TitleHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CutsceneFlagListener implements Listener {
    private StateFlag CUTSCENE_FLAG;
    private List<UUID> playersWithMessage;

    public CutsceneFlagListener(StateFlag flag) {
        this.CUTSCENE_FLAG = flag;
        this.playersWithMessage = new ArrayList<>();
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();

        Location worldGuardLocation = BukkitAdapter.adapt(player.getLocation());
        ApplicableRegionSet regions = query.getApplicableRegions(worldGuardLocation);

        for (ProtectedRegion region : regions) {
            if (region.getFlag(CUTSCENE_FLAG) == StateFlag.State.ALLOW &&
                    !playersWithMessage.contains(playerId)) {
                // Player is in the flagged region
                playersWithMessage.add(playerId);
                TitleHandler.sendActionBarScene("rip", player);
                //player.sendMessage("You entered a region with the cutscene-zone flag!");


                break;
            } else if (playersWithMessage.contains(playerId) && region.getFlag(CUTSCENE_FLAG) == StateFlag.State.DENY) {
                playersWithMessage.remove(playerId);
            }
        }
    }
}

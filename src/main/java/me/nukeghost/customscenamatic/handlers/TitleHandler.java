package me.nukeghost.customscenamatic.handlers;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

import static me.nukeghost.customscenamatic.CustomScenamatic.plugin;

public class TitleHandler {
    public static void sendActionBarScene(String titleText, Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\uE001"));
        player.sendTitle(null, "\uE005");
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10*20, 255));
        try {
            BukkitRunnable task2 = (BukkitRunnable) new BukkitRunnable() {
                @Override
                public void run() {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\uE002"));
                    player.sendTitle(null, "\uE005");
                    BukkitRunnable task3 = (BukkitRunnable) new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\uE003"));
                            player.sendTitle(null, "\uE005");
                            BukkitRunnable task4 = (BukkitRunnable) new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("\uE004"));
                                    player.sendTitle(null, "\uE005");
                                }
                            }.runTaskLater(plugin, 25);
                        }
                    }.runTaskLater(plugin, 25);
                }
            }.runTaskLater(plugin, 25);
        } catch (Exception ex) {
            //DO nothing :)
        }

    }

    public static void updateInteractionEntity(String scene, Player player, Interaction interaction) {
        List<String> frames = plugin.getConfig().getStringList(scene + ".frames");
        long delay = plugin.getConfig().getLong(scene + ".delay");

        try {
            for (int i = 0; i < frames.size(); i++) {
                int finalI = i;
                System.out.println(i +" FOR " + finalI);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        System.out.println("Run()");
                        interaction.setCustomName(frames.get(finalI));
                    }
                }.runTaskTimer(plugin, (20L * i) + 20, delay);
            }
        } catch (Exception ex) {
            //DO nothing :)
        }

    }
}

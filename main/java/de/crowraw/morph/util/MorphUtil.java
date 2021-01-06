package de.crowraw.morph.util;

import de.crowraw.morph.Morph;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.atomic.AtomicReference;

public class MorphUtil implements Listener {

    private final Player player;
    private int taskId = 0;

    public MorphUtil(Player player, Material material) {
        Bukkit.getPluginManager().registerEvents(this, Morph.getInstance());
        this.player = player;

        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false, false));


        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Morph.getInstance(), () -> {

            FallingBlock fallingBlock = player.getWorld().spawnFallingBlock(player.getLocation(), material, (byte) 0);
            fallingBlock.setGravity(false);
            fallingBlock.setInvulnerable(true);
            fallingBlock.setHurtEntities(false);
            fallingBlock.remove();
        }, 1, 1);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof FallingBlock) {
            event.setCancelled(true);
        }
    }
    /*    @EventHandler
     private void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().getName().equals(player.getName())) {
            fallingBlock.teleport(player);

        }
    }*/

    public void killTask() {
        Bukkit.getScheduler().cancelTask(taskId);
    }
}

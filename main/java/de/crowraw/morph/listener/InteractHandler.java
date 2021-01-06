package de.crowraw.morph.listener;

import de.crowraw.morph.util.MorphRepo;
import de.crowraw.morph.util.MorphUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class InteractHandler implements Listener {


    public InteractHandler(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (event.getClickedBlock() == null) return;
        if (event.getClickedBlock().getType() == Material.AIR) return;
        if (event.getAction() == Action.LEFT_CLICK_AIR) return;
        if (event.getAction() == Action.LEFT_CLICK_BLOCK) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR) return;
        MorphRepo.morph(event.getPlayer().getName(), new MorphUtil(event.getPlayer(), event.getClickedBlock().getType()));
        event.getPlayer().sendMessage("§7You have morphed into §4 " + event.getClickedBlock().getType().toString() +"§7.");


    }
}

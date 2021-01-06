package de.crowraw.morph;

import de.crowraw.morph.listener.InteractHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Morph extends JavaPlugin {
private static Morph instance;
    @Override
    public void onEnable() {
        instance=this;
        // Plugin startup logic
        new InteractHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Morph getInstance() {
        return instance;
    }
}

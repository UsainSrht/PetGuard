package me.usainsrht.petguard;

import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PetGuard extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void on(EntityDamageByEntityEvent e) {
                if (e.getEntity() instanceof Tameable) {
                    Tameable tameable = (Tameable) e.getEntity();
                    if (!tameable.isTamed()) return;
                    if (tameable.getOwner().getUniqueId().equals(e.getDamager().getUniqueId())) {
                        e.setCancelled(true);
                        //add a message maybe?
                    }
                }
            }
        }, this);
    }

    @Override
    public void onDisable() {

    }
}

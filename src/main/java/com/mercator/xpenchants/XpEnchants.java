package com.mercator.xpenchants;

import com.mercator.xpenchants.commands.UpgradeEnchant;
import org.bukkit.plugin.java.JavaPlugin;

public final class XpEnchants extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("enchantupgrade").setExecutor(new UpgradeEnchant());

        getServer().getPluginManager().registerEvents(new XpEventHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package com.mercator.xpenchants;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XpEventHandler implements Listener {

    @EventHandler
    public void onPlayerUseExpBottle(ExpBottleEvent event) {
        event.setExperience(7);
    }
}

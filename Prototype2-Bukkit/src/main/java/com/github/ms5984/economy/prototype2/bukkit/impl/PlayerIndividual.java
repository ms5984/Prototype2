package com.github.ms5984.economy.prototype2.bukkit.impl;

import com.github.ms5984.economy.prototype2.common.individual.AbstractIndividual;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public final class PlayerIndividual extends AbstractIndividual {
    private transient OfflinePlayer player;

    private PlayerIndividual() {
        // For deserialization
        this.friendlyName = "";
    }
    public PlayerIndividual(OfflinePlayer player) {
        super(player.getName(), player.getUniqueId());
        this.player = player;
    }

    protected void updateInfo() {
        if (player != null) {
            final String name = player.getName();
            this.friendlyName = (name == null) ? "" : name;
            this.uuid = player.getUniqueId();
            return;
        }
        if (uuid != null) {
            final OfflinePlayer offlinePlayer = Bukkit.getServer().getOfflinePlayer(uuid);
            if (friendlyName == null  || friendlyName.isEmpty()) {
                final String newName = offlinePlayer.getName();
                if (newName != null) {
                    this.friendlyName = newName;
                }
            }
        }
    }

    @Override
    public String friendlyName() {
        if (friendlyName.isEmpty()) {
            updateInfo();
        }
        return friendlyName;
    }
}

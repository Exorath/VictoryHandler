package com.exorath.victoryHandler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by toonsev on 5/28/2017.
 */
public class VictoryHandlerAPI {
    private HashMap<UUID, VictoryPlayer> victoryPlayersByUUID = new HashMap<>();

    public VictoryHandlerAPI() {
    }

    public VictoryPlayer getPlayer(Player player) {
        VictoryPlayer victoryPlayer = victoryPlayersByUUID.get(player.getUniqueId());
        if (victoryPlayer == null) {
            victoryPlayer = new VictoryPlayer(player);
            victoryPlayersByUUID.put(player.getUniqueId(), victoryPlayer);
        }
        return victoryPlayer;
    }

    public HashMap<UUID, VictoryPlayer> getVictoryPlayersByUUID() {
        return victoryPlayersByUUID;
    }

    public void endGame() {
        victoryPlayersByUUID.forEach((uuid, victoryPlayer) -> victoryPlayer.handleRewards());
        Bukkit.getPluginManager().callEvent(new VictoryHandoutEvent(this));
    }
}

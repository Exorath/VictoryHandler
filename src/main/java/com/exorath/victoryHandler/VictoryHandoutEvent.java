package com.exorath.victoryHandler;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by toonsev on 6/5/2017.
 */
public class VictoryHandoutEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private VictoryHandlerAPI victoryHandlerAPI;

    public VictoryHandoutEvent(VictoryHandlerAPI victoryHandlerAPI) {
        this.victoryHandlerAPI = victoryHandlerAPI;
    }

    public VictoryHandlerAPI getVictoryHandlerAPI() {
        return victoryHandlerAPI;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}

package com.exorath.victoryHandler.rewards;

import org.bukkit.entity.Player;

/**
 * Created by toonsev on 5/28/2017.
 */
public abstract class RewardAttribute {
    private String reason;

    public RewardAttribute(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public abstract void execute(Player player);

    public abstract String getMessage();
}

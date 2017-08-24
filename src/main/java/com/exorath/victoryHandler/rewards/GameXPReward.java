package com.exorath.victoryHandler.rewards;

import com.exorath.service.currency.api.CurrencyServiceAPI;
import com.exorath.service.currency.res.IncrementReq;
import com.exorath.service.gamelevel.api.GameLevelServiceAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by toonsev on 5/30/2017.
 */
public class GameXPReward extends RewardAttribute {
    private final GameLevelServiceAPI gameLevelServiceAPI;
    private final String gameId;
    private int amount;

    public GameXPReward(String reason, GameLevelServiceAPI gameLevelServiceAPI, String gameId, int amount) {
        super(reason);
        this.gameLevelServiceAPI = gameLevelServiceAPI;
        this.gameId = gameId;
        this.amount = amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(final Player player) {
        final String uuid = player.getUniqueId().toString();
        new Thread(() -> {
            if(gameLevelServiceAPI.addExperience(gameId, uuid, amount).isLevelUp())
                player.sendMessage(ChatColor.GREEN + "Level Up!");
        }).start();
    }

    @Override
    public String getMessage() {
        return ChatColor.AQUA + "+" + amount + " Experience" + ChatColor.GRAY + " for " + ChatColor.YELLOW + getReason();
    }

}

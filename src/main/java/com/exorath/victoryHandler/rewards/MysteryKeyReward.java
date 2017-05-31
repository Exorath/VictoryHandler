package com.exorath.victoryHandler.rewards;

import com.exorath.service.currency.res.IncrementReq;
import com.exorath.service.mysteryKey.api.MysteryKeyServiceAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by toonsev on 5/30/2017.
 */
public class MysteryKeyReward extends RewardAttribute {
    private MysteryKeyServiceAPI mysteryKeyServiceAPI;
    private int keys;

    public MysteryKeyReward(String reason, MysteryKeyServiceAPI mysteryKeyServiceAPI, int keys) {
        super(reason);
        this.mysteryKeyServiceAPI = mysteryKeyServiceAPI;
        this.keys = keys;
    }

    public int getKeys() {
        return keys;
    }


    private ChatColor getCurrencyColor(){
        return ChatColor.GREEN;
    }
    @Override
    public void execute(Player player) {
        final String uuid = player.getUniqueId().toString();
        new Thread(() -> mysteryKeyServiceAPI.addFragments(uuid, keys)).start();
    }


    @Override
    public String getMessage() {
        return getCurrencyColor() + "+" + keys + " Chest Keys" + ChatColor.GRAY + " for " + ChatColor.YELLOW + getReason();
    }
}

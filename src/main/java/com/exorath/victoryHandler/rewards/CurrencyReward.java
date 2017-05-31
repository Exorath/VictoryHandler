package com.exorath.victoryHandler.rewards;

import com.exorath.service.currency.api.CurrencyServiceAPI;
import com.exorath.service.currency.res.IncrementReq;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by toonsev on 5/30/2017.
 */
public class CurrencyReward extends RewardAttribute {
    private CurrencyServiceAPI currencyServiceAPI;
    private String currencyId;
    private int amount;

    public CurrencyReward(String reason, CurrencyServiceAPI currencyServiceAPI, String currencyId, int amount) {
        super(reason);
        this.currencyServiceAPI = currencyServiceAPI;
        this.currencyId = currencyId;
        this.amount = amount;
    }


    @Override
    public void execute(Player player) {
        final String uuid = player.getUniqueId().toString();
        new Thread(() -> currencyServiceAPI.increment(new IncrementReq(currencyId, uuid, amount))).start();
    }

    @Override
    public String getMessage() {
        return getCurrencyColor() + "+" + amount + " " + getCurrencyName() + ChatColor.GRAY + " for " + ChatColor.YELLOW + getReason();
    }

    private ChatColor getCurrencyColor(){
        return ChatColor.GREEN;
    }

    private String getCurrencyName(){
        return currencyId;
    }
}

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
    private ChatColor currencyColor = ChatColor.GREEN;
    private String currencyId;
    private String currencyName;
    private int amount;

    public CurrencyReward(String reason, CurrencyServiceAPI currencyServiceAPI, String currencyId, int amount) {
        super(reason);
        this.currencyServiceAPI = currencyServiceAPI;
        this.currencyId = currencyId;
        this.amount = amount;
    }


    public void setAmount(int amount) {
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
        return currencyColor;
    }

    public void setCurrencyColor(ChatColor currencyColor) {
        this.currencyColor = currencyColor;
    }

    private String getCurrencyName(){
        return currencyName == null ? currencyId : currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}

package com.exorath.victoryHandler;

import com.exorath.victoryHandler.rewards.RewardAttribute;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toonsev on 5/28/2017.
 */
public class VictoryPlayer {
    private Player player;
    private Integer position;
    private Boolean team;

    private Integer millisPlayed;

    private List<RewardAttribute> rewards = new ArrayList<>();


    public VictoryPlayer(Player player) {
        this.player = player;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setInTeam(Boolean team) {
        this.team = team;
    }

    public void setMillisPlayed(Integer millisPlayed) {
        this.millisPlayed = millisPlayed;
    }

    public void addReward(RewardAttribute attribute) {
        rewards.add(attribute);
    }


    public List<RewardAttribute> getRewards() {
        return rewards;
    }

    public void handleRewards() {
        player.sendMessage(ChatColor.BOLD + "================================================");
        player.sendMessage(getRanking() + ChatColor.WHITE + ChatColor.BOLD + " Position Rewards");
        player.sendMessage("");
        rewards.forEach(attribute -> player.sendMessage(attribute.getMessage()));
        player.sendMessage(ChatColor.BOLD + "================================================");
        rewards.forEach(reward -> reward.execute(player));
    }

    private String getRanking() {
        if (position == 1) {
            return ChatColor.AQUA + ChatColor.BOLD.toString() + "1st";
        } else if (position == 2 && position == 3) {
            return ChatColor.GRAY + ChatColor.BOLD.toString() + position + "nd";
        } else
            return ChatColor.GOLD + ChatColor.BOLD.toString() + position + "th";
    }
}

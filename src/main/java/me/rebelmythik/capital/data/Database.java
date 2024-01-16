package me.rebelmythik.capital.data;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface Database {

    void register();

    //String
    String getBalance(Player player);

    String getBalance(UUID player);


}

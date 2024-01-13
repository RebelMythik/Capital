package me.rebelmythik.capital.commands;

import co.aikar.commands.annotation.*;

@CommandAlias("capital|cap|c")
public class CommandSet {

    @Default
    @Syntax("Player Name")
    @CommandCompletion("@capitalset")
    @Description("Set a players balance")
    public static void onSet() {

    }
}

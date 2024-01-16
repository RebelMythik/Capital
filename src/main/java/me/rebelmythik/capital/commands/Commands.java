package me.rebelmythik.capital.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.rebelmythik.capital.Capital;

@CommandAlias("%capital")
public class Commands extends BaseCommand {

    private final Capital plugin;

    public Commands(Capital plugin) {
        this.plugin = plugin;
    }

    @Default
    @Syntax("Player Name")
    @CommandCompletion("@capitalset")
    @Description("Set a players balance")
    public static void onSet() {

    }

    // Pay command

    // Add command

    // Remove command

    // Set command

    // Balance command

    // Baltop command

    // Help command

    // Import command

    // Pay command

}

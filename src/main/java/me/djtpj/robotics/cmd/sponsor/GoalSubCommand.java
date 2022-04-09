package me.djtpj.robotics.cmd.sponsor;

import me.djtpj.robotics.cmd.SubCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GoalSubCommand extends SubCommand {
    String goal;
    public GoalSubCommand() {
        super(false, "Used to check the amount of money we have left to gain before the start of our next season. Usage: 'sponsor goal'", "goal", "g");

        goal = SponsorContainerCommand.readFile("C:\\Dev\\Java\\DiscordBots\\RoboticsBot\\src\\main\\resources\\goal.txt").get(0);
    }

    @Override
    public void onTrigger(String[] args, MessageReceivedEvent event) {
        // TODO send the goal
        event.getChannel().sendMessage("The goal is " + goal + ". We have $" + SponsorContainerCommand.curAmount + " out of " + goal + ".").queue();
    }
}

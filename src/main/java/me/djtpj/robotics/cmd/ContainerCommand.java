package me.djtpj.robotics.cmd;

import me.djtpj.robotics.cmd.sponsor.AddSubCommand;
import me.djtpj.robotics.cmd.sponsor.GoalSubCommand;
import me.djtpj.robotics.cmd.sponsor.QuantitySubCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public abstract class ContainerCommand extends ListenerAdapter {

    String[] triggers;
    ArrayList<SubCommand> subCommands;

    public ContainerCommand(String @NotNull ... triggers) {
        this.triggers = triggers;

        subCommands = new ArrayList<>();

    }

    public void onTrigger(String[] args, MessageReceivedEvent event) {
        for (SubCommand c : subCommands) {
            event.getChannel().sendMessage(c.getUsages()).queue();
        }
    }

    public String[] getTriggers() {
        return triggers;
    }

    public void addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args.length == 1) {
            for (String t : triggers) {
                if (args[0].equalsIgnoreCase("!" + t)) {
                    onTrigger(args, event);
                    break;
                }
            }
        }
        else {
            for (SubCommand c : subCommands) {
                if (Arrays.asList(c.getTriggers()).contains(args[1].toLowerCase())) {
                    c.run(args, event);
                }
            }
        }
    }
}

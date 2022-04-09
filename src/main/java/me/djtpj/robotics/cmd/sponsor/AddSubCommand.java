package me.djtpj.robotics.cmd.sponsor;

import me.djtpj.robotics.cmd.SubCommand;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AddSubCommand extends SubCommand {
    public AddSubCommand() {
        super(true, "Adds specified amount of money to the record of amount of money gained from sponsors. Usage: 'sponsor add <amount>'","add");
    }

    @Override
    public void onTrigger(String[] args, MessageReceivedEvent event) {
        // add the number

        SponsorContainerCommand.setCurAmount(SponsorContainerCommand.getCurAmount() + Integer.parseInt(args[2]));

        event.getChannel().sendMessage("Woo hoo! The current amount is now $" + SponsorContainerCommand.curAmount).queue();

    }


}

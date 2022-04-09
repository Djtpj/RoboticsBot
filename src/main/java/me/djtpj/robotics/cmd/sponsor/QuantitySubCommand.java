package me.djtpj.robotics.cmd.sponsor;

import me.djtpj.robotics.cmd.SubCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class QuantitySubCommand extends SubCommand {
    public QuantitySubCommand() {
        super(false,"Used to check the current amount of money from sponsors. Usage: 'sponsor quantity'","quantity", "q");
    }

    @Override
    public void onTrigger(String[] args, MessageReceivedEvent event) {
        // TODO send the quantity

        String[] randomMessages = {"Keep up the good work!", "Good job!", "Way to go!", "That's a lot!", "Just a bit more!", "Woop woop!", "Let's go", "Alright that's awesome!", "I'm so proud :smiling_face_with_tear:"};

        Random random = new Random();

        event.getChannel().sendMessage("The current amount raised is " + SponsorContainerCommand.curAmount + "! " + randomMessages[random.nextInt(randomMessages.length)]).queue();
    }
}

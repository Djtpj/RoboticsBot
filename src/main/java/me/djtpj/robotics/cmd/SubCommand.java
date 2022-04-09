package me.djtpj.robotics.cmd;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class SubCommand extends ContainerCommand {

    private boolean usesArgs;
    private String usages;
    protected Role[] requiredRoles;

    public SubCommand(boolean usesArgs, String usages, String @NotNull ... triggers) {
        super(triggers);

        this.usages = usages;
        this.usesArgs = usesArgs;
    }

    public boolean usesArgs() {
        return usesArgs;
    }

    public String getUsages() {
        return usages;
    }

    public final void run(String[] args, MessageReceivedEvent event) {
        if (event.getMember().getRoles().containsAll(List.of(requiredRoles))) {
            onTrigger(args, event);
        }
    }

    protected void setRequiredRoles(Role... roles) {
        requiredRoles = roles;
    }
}

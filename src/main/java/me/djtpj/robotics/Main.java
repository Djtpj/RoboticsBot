package me.djtpj.robotics;

import me.djtpj.robotics.cmd.sponsor.SponsorContainerCommand;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("OTYyMDgwODI4OTIwMzAzNjI2.YlCVmA.dgSzBm7-ZNC-3XPEx588OmtHJyk");

        builder.addEventListeners(new SponsorContainerCommand());

        builder.setActivity(Activity.playing("on the Robotics Team"));
        builder.build();
    }
}

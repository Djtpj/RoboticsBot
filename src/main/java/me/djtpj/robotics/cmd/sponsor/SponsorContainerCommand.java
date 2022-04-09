package me.djtpj.robotics.cmd.sponsor;

import me.djtpj.robotics.cmd.ContainerCommand;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SponsorContainerCommand extends ContainerCommand {

    public static int curAmount = 134;

    public SponsorContainerCommand() {
        super("sponsor");

        curAmount = Integer.parseInt(readFile("C:\\Dev\\Java\\DiscordBots\\RoboticsBot\\src\\main\\resources\\curamount.txt").get(0));

        addSubCommand(new AddSubCommand());
        addSubCommand(new QuantitySubCommand());
        addSubCommand(new GoalSubCommand());
    }

    public static @NotNull ArrayList<String> readFile(String path) {

        ArrayList<String> data = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                data.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeToFile(String path, String content) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCurAmount() {
        return curAmount;
    }

    public static void setCurAmount(int curAmount) {
        SponsorContainerCommand.curAmount = curAmount;

        writeToFile("C:\\Dev\\Java\\DiscordBots\\RoboticsBot\\src\\main\\resources\\curamount.txt", String.valueOf(curAmount));
    }
}

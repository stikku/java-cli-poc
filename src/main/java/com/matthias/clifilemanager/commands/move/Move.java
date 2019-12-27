package com.matthias.clifilemanager.commands.move;

import com.matthias.clifilemanager.Main;
import com.matthias.clifilemanager.commands.move.directory.MoveDirectory;
import com.matthias.clifilemanager.commands.move.file.MoveFile;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

/**
 * @author Matthias Portelli
 */
@Command(
        name = "move",
        aliases = {"mv"},
        description = {"Moves resources."},
        mixinStandardHelpOptions = true,
        versionProvider = Main.class,
        subcommands = {
                MoveDirectory.class,
                MoveFile.class
        }
)
public class Move implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("Please use one of the sub commands");
        return 0;
    }
}

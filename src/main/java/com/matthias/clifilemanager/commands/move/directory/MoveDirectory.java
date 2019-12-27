package com.matthias.clifilemanager.commands.move.directory;

import com.matthias.clifilemanager.Main;
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
        name = "directory",
        aliases = {"dir"},
        description = {"Move directory to the desired path."},
        mixinStandardHelpOptions = true,
        versionProvider = Main.class
)
public class MoveDirectory implements Callable<Integer> {

    @Parameters(index="0", description = "The directory to be moved.")
    private File sourceF;

    @Parameters(index="1", description = "The destination.")
    private File destinationF;

//    @Option(names = {"-p", "--password"}, description = "Password.", interactive = true, required = true)
//    private String password;

    public Integer call() throws Exception {
        final Path source = sourceF.toPath();
        final Path destination = destinationF.toPath();
        if (!source.toFile().isDirectory()) {
            System.out.println("Target is not a directory");
            return -1;
        }
        Files.move(source, destination);
        return 0;
    }
}

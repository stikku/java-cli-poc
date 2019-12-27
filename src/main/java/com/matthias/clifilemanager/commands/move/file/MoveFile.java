package com.matthias.clifilemanager.commands.move.file;

import com.matthias.clifilemanager.Main;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

/**
 * @author Matthias Portelli
 */
@Command(
        name = "file",
        description = {"Move file to the desired path."},
        mixinStandardHelpOptions = true,
        versionProvider = Main.class
)
public class MoveFile implements Callable<Integer> {

    @Parameters(index="0", description = "The file to be moved.")
    private File sourceF;

    @Parameters(index="1", description = "The destination.")
    private File destinationF;

//    @Option(names = {"-p", "--password"}, description = "Password.", interactive = true, required = true)
//    private String password;

    public Integer call() throws Exception {
        final Path source = sourceF.toPath();
        final Path destination = destinationF.toPath();
        if (!source.toFile().isFile()) {
            System.out.println("Target is not a file");
            return -1;
        }
        Files.move(source, destination);
        return 0;
    }
}

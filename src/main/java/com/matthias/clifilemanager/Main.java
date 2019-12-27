package com.matthias.clifilemanager;

import com.matthias.clifilemanager.commands.move.Move;
import picocli.CommandLine;
import picocli.CommandLine.IVersionProvider;

/**
 * @author Matthias Portelli
 */
public class Main implements IVersionProvider {

    public String[] getVersion() throws Exception {
        return new String[0];
    }

    public static void main(final String[] args) {
        final int exitCode = new CommandLine(new Move()).execute(args);
        System.out.println(exitCode);
    }
}

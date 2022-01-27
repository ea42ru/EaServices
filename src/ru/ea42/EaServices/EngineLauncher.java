package ru.ea42.EaServices;

import java.util.Scanner;

public class EngineLauncher {
    private static final Logger log = new Logger();
    private static Engine engine = null;

    public static void main(String[] args) {
        //new ShutdownHook(launch);
        start(null);

        log.mes("Enter 'stop' to halt: ");
        log.mes("Enter 'ver' to version: ");
        log.mes("Enter 'mem' to memory: ");
        Scanner sc = new Scanner(System.in);
        String sCmd = "";
        while (!sCmd.equals("stop")) {
            if (sCmd.equals("ver")) {
                log.version();
            }
            if (sCmd.equals("mem")) {
                log.memory();
            }
            sCmd = sc.nextLine().toLowerCase();
        }

        stop(null);
        System.exit(0);
    }

    public static void start(String[] args) {
        if (engine == null) {
            log.info("Starting the Engine");
            log.memory();
            engine = new Engine(log);
            log.info("Engine start");
            log.memory();
        }
    }

    public static void stop(String[] args) {
        if (engine != null) {
            log.info("Stopping the Engine");
            log.memory();
            engine.finit();
            log.info("Engine stop");
            engine = null;
            log.memory();
            log.version();
        }
    }
}

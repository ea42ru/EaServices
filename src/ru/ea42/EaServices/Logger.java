package ru.ea42.EaServices;

import java.io.FileWriter;

public class Logger {
    FileWriter writer;
    boolean file = false;

    public Logger() {
        if (file) {
            try {
                writer = new FileWriter("stdOut.txt", false);
            } catch (Exception ignore) {
            }
        }
    }

    private void println(String mes) {
        System.err.println(mes);
        if (file) {
            try {
                writer.write(mes);
                writer.flush();
            } catch (Exception ignore) {
            }
        }
    }

    public void debug(String mes) {
        println("debug: " + mes);
    }

    public void info(String mes) {
        println("info: " + mes);
    }

    public void mes(String mes) {
        println(mes);
    }

    public void version() {
        println("java version: " + System.getProperty("java.version"));
        println(System.getProperty("java.runtime.name") + " (build " + System.getProperty("java.runtime.version") + ")");
        println(System.getProperty("java.vm.name") + " (build " + System.getProperty("java.vm.version") + ", " + System.getProperty("java.vm.info") + ")");
        println("commons daemon version: " + System.getProperty("org.apache.commons.daemon.Daemon.version"));
        println("commons daemon process id: " + System.getProperty("ru.ea42.EaServices.EngineLauncher.process.id"));
        println("commons daemon process parent: " + System.getProperty("commons.daemon.process.parent"));
    }

    public void memory() {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        float usedMemory = totalMemory - freeMemory;
        println("memory total: " + (totalMemory / 1048576) + " Mb");
        println("memory free: " + (freeMemory / 1048576) + " Mb");
        println("memory used: " + (usedMemory / 1048576) + " Mb");
    }
}

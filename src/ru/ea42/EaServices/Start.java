package ru.ea42.EaServices;

public class Start {
    public static EaSimplyService sSrv = new StartApp("EaServices v0.01");

    // создание из командной строки
    public static void main(String[] args) {
        sSrv.cmd();
    }

    // создание из prunsrv.exe
    public static void start(String[] args) {
        sSrv.start();
    }

    // окончание работы из prunsrv.exe
    public static void stop(String[] args) {
        sSrv.stop();
    }
}

package ru.ea42.EaServices;

import java.util.Scanner;

public class StartApp implements ShutdownHook.CallBack {
    public static App app = null;
    public static EaService mainService = null;

    // создание из командной строки
    public static void main(String[] args) {
        intit(args);
        Work work = new Work(app);
        System.out.println("Enter 'stop' to halt.");
        Scanner sc = new Scanner(System.in);
        while (!sc.nextLine().toLowerCase().equals("stop")) ;
        System.out.println("stop");
        System.exit(0);
    }

    // окончание работы из командной строки
    @Override
    public void terminate() {
        finit(null);
    }

    // создание из prunsrv.exe
    public static void intit(String[] args) {
        if (app == null) {
            app = new App(mainService);
            app.init();
        }
    }

    // окончание работы из prunsrv.exe
    public static void finit(String[] args) {
        if (app != null) {
            app.finit();
            app = null;
        }
    }
}


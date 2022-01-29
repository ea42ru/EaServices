package ru.ea42.EaServices;

import java.util.Scanner;

public abstract class EaSimplyService implements EaTimer.CallBack, ShutdownHook.CallBack {
    protected abstract void init();

    protected abstract void finit();

    public abstract void go();

    public String name;

    public EaSimplyService(String name) {
        this.name = name;
    }

    public void cmd() {
        init();
        System.out.println("Service " + name + " start.");
        System.out.println("Enter 'stop' to halt.");
        Scanner sc = new Scanner(System.in);
        while (!sc.nextLine().toLowerCase().equals("stop")) ;
        System.out.println("Service " + name + " stop");
        System.exit(0);
    }

    public void start() {
        init();
    }

    public void stop() {
        finit();
    }

    @Override
    public void terminate() {
        finit();
    }
}

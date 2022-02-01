package ru.ea42.EaServices;

import java.util.Scanner;

public class Start implements ShutdownHook.CallBack {
    public static App sApp;

    // создание из командной строки
    public static void main(String[] args) {
        init();
        System.out.println("Service " + sApp.name + " start.");
        System.out.println("Enter 'stop' to halt.");
        Scanner sc = new Scanner(System.in);
        while (!sc.nextLine().toLowerCase().equals("stop")) ;
        System.out.println("Service " + sApp.name + " stop");
        System.exit(0);
    }

    // окончание работы из командной строки
    @Override
    public void terminate() {
        finit();
    }

    // создание из prunsrv.exe
    public static void start(String[] args) {
        finit();
    }

    // окончание работы из prunsrv.exe
    public static void stop(String[] args) {
        finit();
    }

    public static void init() {
        sApp = new SingleApp();
        // суда нужно класс поиском по имени....
        sApp.setMainService(new Test_Work());
        sApp.initApp();
    }

    public static void finit() {
        sApp.finitApp();
        sApp=null;
    }
}

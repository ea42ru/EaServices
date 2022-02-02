package ru.ea42.EaServices;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
        String nameMainServClass = null;
        try {
            Start st = null;
            InputStream jsFS = st.getClass().getClassLoader().getResourceAsStream("mainService.ini");
            if (jsFS != null) {
                int ch;
                ByteArrayOutputStream sb = new ByteArrayOutputStream();
                while ((ch = jsFS.read()) != -1) sb.write(ch);
                nameMainServClass = sb.toString("UTF8");
                jsFS.close();
            }
        } catch (Exception ignore) {
        }

        EaService mainSrv = null;
        if (nameMainServClass != null) {
            Class cl = null;
            try {
                cl = Class.forName("class " + nameMainServClass);
            } catch (Exception ignore) {
            }

            if (cl != null) {
                try {
                    mainSrv = (EaService) cl.newInstance();
                } catch (Exception ignore) {
                }
            }
        }

        // если не нашли класса из файла "mainService.ini", то запускаем тестовый класс
        // ??? или лучше по имени класса ru.ea42.EaServices.StartSingleService
        if (mainSrv == null) mainSrv = new Test_Work();
        sApp = new SingleApp();
        sApp.setMainService(mainSrv);
        sApp.initApp();
    }

    public static void finit() {
        sApp.finitApp();
        sApp = null;
    }
}

package ru.ea42.EaServices;

public class DemoEaService {
    public static App app;

    public static void main(String[] args) throws InterruptedException {
        app = new App();
        DemoWork work = new DemoWork(app);
        DemoMonitor mon = new DemoMonitor(app);
        oneDemo2S();

        System.out.println("1 Init");
        app.cmdInit();
        oneDemo2S();

        System.out.println("2 Start");
        app.cmdStart();
        oneDemo2S();

        System.out.println("3 Pause");
        app.cmdPause();
        oneDemo2S();

        System.out.println("4 Start");
        app.cmdStart();
        oneDemo2S();

        System.out.println("5 Pause");
        app.cmdPause();
        oneDemo2S();

        System.out.println("6 Start");
        app.cmdStart();
        oneDemo2S();

        System.out.println("7 Pause");
        app.cmdPause();
        oneDemo2S();

        System.out.println("8 Start");
        app.cmdStart();
        oneDemo2S();

        System.out.println("9 Stop");
        app.cmdStop();
        oneDemo2S();

        mon.stop();
    }

    private static void oneDemo2S() {
        try {
            Thread.sleep(2000);
        } catch (Exception ignore) {
        }
    }
}

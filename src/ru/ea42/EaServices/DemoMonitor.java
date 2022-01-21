package ru.ea42.EaServices;

public class DemoMonitor implements EaTimer.CallBack {
    private EaTimer timer;
    private App app;

    public DemoMonitor(App app) {
        this.app = app;
        timer = new EaTimer(this, 300);
        timer.on();
    }

    @Override
    public void go() {
        System.out.println("mon. state -> " + app.state);
    }

    public void stop() {
        timer.finit();
    }
}

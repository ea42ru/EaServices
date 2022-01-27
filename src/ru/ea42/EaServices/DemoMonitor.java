package ru.ea42.EaServices;

public class DemoMonitor implements EaTimer.CallBack {
    public App app;

    public DemoMonitor() {
        timer.init(this, 300, false);
    }

    public void stop() {
        timer.finit();
    }

    @Override
    public void go() {
        System.out.println("mon. state -> " + app.state);
    }

}

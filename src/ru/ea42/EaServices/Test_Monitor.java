package ru.ea42.EaServices;

public class Test_Monitor implements EaTimer.CallBack {
    private App app;

    public Test_Monitor(App app) {
        this.app = app;
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

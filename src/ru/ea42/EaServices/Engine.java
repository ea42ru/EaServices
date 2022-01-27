package ru.ea42.EaServices;

public class Engine implements EaTimer.CallBack {
    private int count = 0;
    private Logger log;

    public Engine(Logger log) {
        this.log = log;
        timer.init(this, 2000, false);
    }

    public void finit() {
        timer.finit();
    }

    @Override
    public void go() {
        count++;
        log.mes("<== " + count + " ==>");
    }
}

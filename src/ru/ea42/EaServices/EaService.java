package ru.ea42.EaServices;

public abstract class EaService implements EaTimer.CallBack {
    public String name = "Service";
    protected EaTimer timer = null;
    public App app = null;
    protected State state = State.STOP;

    protected abstract void init();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void finit();

    public abstract void go();

    protected void setTimer(int timeMs, boolean paused) {
        if (timer == null) timer = new EaTimer();
        timer.init(this, timeMs, paused);
    }

    protected void setTimer(int timeMs) {
        setTimer(timeMs,true);
    }

    public State getState() {
        synchronized (this) {
            return state;
        }
    }

    public void log(String mes) {
        app.log(mes);
    }
}

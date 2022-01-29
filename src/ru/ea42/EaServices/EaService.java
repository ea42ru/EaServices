package ru.ea42.EaServices;

public abstract class EaService implements EaTimer.CallBack {
    protected abstract void init();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void finit();

    public abstract void go();

    protected State state = State.STOP;
    public App app;

    public void imWorking() {
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

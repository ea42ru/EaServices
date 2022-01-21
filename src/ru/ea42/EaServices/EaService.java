package ru.ea42.EaServices;

public abstract class EaService implements EaTimer.CallBack {
    protected abstract void init();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void finit();

    public abstract void go();

    protected State state = State.STOP;
    protected EaTimer timer;
    public App app;

    public EaService(App app) {
        super();
        this.app = app;
        app.addService(this);
    }

    protected void imWorking() {
    }

    public State getState() {
        return state;
    }
}

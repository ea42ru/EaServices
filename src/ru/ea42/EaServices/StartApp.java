package ru.ea42.EaServices;

public class StartApp extends EaSimplyService {
    public App app = new App(null);

    public StartApp(String name) {
        super(name);
    }

    @Override
    protected void init() {
        app.initApp();
    }

    @Override
    protected void finit() {
        app.finitApp();
    }

    @Override
    public void go() {

    }
}


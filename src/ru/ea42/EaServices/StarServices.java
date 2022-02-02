package ru.ea42.EaServices;

public class StarServices extends EaService {
    private ManyApp manyApp;

    @Override
    protected void init() {
        EaService mainSrv = new ManyServices();
        manyApp = new ManyApp();
        manyApp.setMainService(mainSrv);
        manyApp.initApp();
    }

    @Override
    protected void start() {
    }

    @Override
    protected void stop() {
    }

    @Override
    protected void finit() {
        manyApp.finitApp();
    }

    @Override
    public void go() {
    }
}

package ru.ea42.EaServices;

public class App {
    public String state;
    private EaService mainSrv = null;

    public App(EaService mainService) {
        this.mainSrv = mainService;
        if (mainService != null) mainService.app = this;
    }

    public void addService(EaService srv) {
        if (srv == null) return;
        srv.app = this;
        // add mainService;
    }

    public void init() {
    }

    public void finit() {
    }

    public void cmdInit() {
    }

    public void cmdStart() {
    }

    public void cmdPause() {
    }

    public void cmdStop() {
    }
}

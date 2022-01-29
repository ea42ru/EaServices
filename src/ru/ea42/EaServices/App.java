package ru.ea42.EaServices;

public class App {
    //public ListArray<EaService> srvs;
    public String state;
    private ILog loger;
    private EaService mainSrv = null;

    public App(EaService mainService) {
        this.mainSrv = mainService;
        if (mainService != null) mainService.app = this;
    }

    public void initApp() {
        if (mainSrv != null) {
            mainSrv.init();
            mainSrv.start();
        } else {
            // List init
        }
    }

    public void finitApp() {
        if (mainSrv != null) {
            mainSrv.finit();
        } else {
            // List finit
        }
    }

    public void addService(EaService srv) {
        if (srv == null) return;
        srv.app = this;
        // add srv in List;
    }

    public void cmdInit() {
    }

    public void cmdStart() {
    }

    public void cmdPause() {
    }

    public void cmdStop() {
    }

    public void setLoger(ILog loger) {
        if (loger != null) this.loger = loger;
    }

    public void log(String mes) {
        if (loger == null) System.out.println(mes);
        else {
            synchronized (loger) {
                loger.log(mes);
            }
        }
    }
}

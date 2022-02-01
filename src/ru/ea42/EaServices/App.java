package ru.ea42.EaServices;

public class App {
    //public ListArray<EaService> srvs;
    private ILog loger;
    private EaService mainSrv = null;
    public String name;

    public void initApp() {
        if (mainSrv != null) {
            mainSrv.init();
            mainSrv.start();
        }
    }

    public void finitApp() {
        if (mainSrv != null) {
            mainSrv.stop();
            mainSrv.finit();
        }
    }

    public void setMainService(EaService srv) {
        this.mainSrv = srv;
        srv.app = this;
        name=srv.name;
    }

    public void addService(EaService srv) {
        //if (srv == null) return;
        //srv.app = this;
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
        this.loger = loger;
    }

    public void log(String mes) {
        if (loger != null) {
            synchronized (loger) {
                loger.log(mes);
            }
        }
    }
}

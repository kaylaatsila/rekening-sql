class Rekening{
    private IntegerProperty noRekening;
    private DoubleProperty saldo;
public Rekening(int noRekening, double saldo) {
        this.noRekening = new SimpleIntegerProperty(noRekening);
        this.saldo = new SimpleDoubleProperty(saldo);
    }
 public int getNoRekening() {
        return noRekening.get();
    }
public void setNoRekening(int noRekening) {
        this.noRekening.set(noRekening);
    }
 public double getSaldo() {
        return saldo.get();
    }

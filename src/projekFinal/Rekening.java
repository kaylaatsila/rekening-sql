class Rekening{
    private IntegerProperty noRekening;
    private DoubleProperty saldo;
public Rekening(int noRekening, double saldo) {
        this.noRekening = new SimpleIntegerProperty(noRekening);
        this.saldo = new SimpleDoubleProperty(saldo);
    }

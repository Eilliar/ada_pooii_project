package entity;

public enum VEHICLE_CATEGORY {
    PEQUENO(100.00),
    MEDIO(150.00),
    SUV(200.00);

    public final double daily_rate;

    private VEHICLE_CATEGORY(double rate){
        this.daily_rate = rate;
    }

}

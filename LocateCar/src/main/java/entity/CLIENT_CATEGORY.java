package entity;

public enum CLIENT_CATEGORY {
    PF(5, 0.05),
    PJ(3, 0.10);

    final int minDaysToDiscount;
    final double discount;
    CLIENT_CATEGORY(int minDays, double discount){
        this.minDaysToDiscount = minDays;
        this.discount = discount;
    }
}

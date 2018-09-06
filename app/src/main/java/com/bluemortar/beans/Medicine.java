package com.bluemortar.beans;

/**
 * Created by Syacraft on 22-Sep-16.
 */
public class Medicine {

    private String medicineName;
    private int thumbnail;
    private String medicineInfo;
    private String medicinePrice;

    public Medicine(String medicineName, int thumbnail, String medicineInfo, String medicinePrice) {
        this.medicineName = medicineName;
        this.thumbnail = thumbnail;
        this.medicineInfo = medicineInfo;
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMedicineInfo() {
        return medicineInfo;
    }

    public void setMedicineInfo(String medicineInfo) {
        this.medicineInfo = medicineInfo;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
}

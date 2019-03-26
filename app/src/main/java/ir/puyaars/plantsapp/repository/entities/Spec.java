package ir.puyaars.plantsapp.repository.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spec {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private String desc;


    public Spec(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

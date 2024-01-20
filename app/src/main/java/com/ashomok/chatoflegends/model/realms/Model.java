package com.ashomok.chatoflegends.model.realms;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Keep;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

@Keep
public class Model extends RealmObject implements Parcelable {
    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
    @PrimaryKey
    @Index
    //user id
    private String uid;
    //user photo url in server
    private int modelNamePretty;
    private String modelName;
    private int tokenNeeds;
    private boolean isBestChoice;

    private String heroType;

    private int intro;

    private int systemMsg;

    public Model() {
    }

    protected Model(Parcel in) {
        uid = in.readString();
        modelNamePretty = Integer.parseInt(in.readString());
        modelName = in.readString();
        tokenNeeds = Integer.parseInt(in.readString());
        isBestChoice = Boolean.getBoolean(in.readString());
        heroType = in.readString();
        intro = Integer.parseInt(in.readString());
        systemMsg = Integer.parseInt(in.readString());
    }

    public int getModelNamePretty() {
        return modelNamePretty;
    }

    public void setModelNamePretty(int modelNamePretty) {
        this.modelNamePretty = modelNamePretty;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getTokenNeeds() {
        return tokenNeeds;
    }

    public void setTokenNeeds(int tokenNeeds) {
        this.tokenNeeds = tokenNeeds;
    }

    public boolean isBestChoice() {
        return isBestChoice;
    }

    public void setBestChoice(boolean bestChoice) {
        isBestChoice = bestChoice;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Model) {
            Model temp = (Model) o;
            return uid.equals(temp.uid);
        }
        return false;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public int getIntro() {
        return intro;
    }

    public void setIntro(int intro) {
        this.intro = intro;
    }

    public int getSystemMsg() {
        return systemMsg;
    }

    public void setSystemMsg(int systemMsg) {
        this.systemMsg = systemMsg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(String.valueOf(modelNamePretty));
        dest.writeString(modelName);
        dest.writeString(String.valueOf(tokenNeeds));
        dest.writeString(String.valueOf(isBestChoice));
        dest.writeString(heroType);
        dest.writeString(String.valueOf(intro));
        dest.writeString(String.valueOf(systemMsg));
    }
}

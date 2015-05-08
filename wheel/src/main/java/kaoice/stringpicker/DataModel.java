package kaoice.stringpicker;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 2015/5/7.
 */
public class DataModel implements Parcelable{
    private List<String> first;
    private HashMap<String,List<String>> second;

    public List<String> getFirst() {
        return first;
    }

    public void setFirst(List<String> first) {
        this.first = first;
    }

    public HashMap<String, List<String>> getSecond() {
        return second;
    }

    public void setSecond(HashMap<String, List<String>> second) {
        this.second = second;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.first);
        dest.writeMap(this.second);
    }

    public DataModel(List first, HashMap<String, List<String>> second) {
        this.first=first;
        this.second=second;
    }

    private DataModel(Parcel in) {
        this.first = in.readArrayList(String.class.getClassLoader());
        this.second = in.readHashMap(HashMap.class.getClassLoader());
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        public DataModel createFromParcel(Parcel source) {
            return new DataModel(source);
        }

        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };
}

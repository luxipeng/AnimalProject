package domain;

public class History {
    String pid,data,describe;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "History{" +
                "pid='" + pid + '\'' +
                ", data='" + data + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
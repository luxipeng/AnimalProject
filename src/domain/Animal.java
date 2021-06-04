package domain;

public class Animal {
    String pid,name,kind,birth,owner;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "animal{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", birth='" + birth + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

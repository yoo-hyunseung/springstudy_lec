package hello.hellospring.domain;

public class Member { //    vo?
    private long id; // system이 저장하는 아이디
    private String name; //고객의 이름

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

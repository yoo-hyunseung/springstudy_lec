package hello.hellospring.controller;

public class MemberForm {
    private String name;
    //<input type="text" id="name" name="name" placeholder="이름을입력하세요">
    // name값이 자동으로 들어간다 form.getName();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

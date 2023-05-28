package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // web 에서 /hello 라고 들어오면 이 메소드를 호출 http://localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data","hello!!"); // key : value
        return "hello"; //hello.html 리턴
//      컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
//        resources:templates/ +{ViewName}+ .html
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name")String name, Model model) {
        // @RequestParam("name")String name 외부에서 parameter를 받는다.
        // name required true 이므로 변수를 줘야한다. -> hello-mvc?name=spring!!!
        model.addAttribute("name", name);
        return "hello-template";
        ///Users/yuhyeonseung/Desktop/study/hello-spring/src/main/resources/templates/hello-template.html
        // 호출
    }
    @GetMapping("hello-spring")
    @ResponseBody
    // http -> body부분에 return 값을 직접 삽입한다는 뜻
    public String helloSpring(@RequestParam("name") String name) {
        return "hello "+name;
        // name=spring 일 경우 "hello spring" 설정한 값이 그대로 들어가게된다.
        //http://localhost:8080/hello-string?name=spring!!! 소스보기시 html태그가 없다.
        // return 값이 그대로 리턴값이 들어간다
    }

    @GetMapping("hello-api")
    @ResponseBody // viewResolver 대신 HttpMessageConverter 가 동작
    // 문자 -> StringHttpMessageConverter
    // 객체 -> MappingJackson2HttpMessageConverter -> JSON 변환
    // xml, 다른 여러 포멧으로 변환이 가능하다.
    public Hello helloApi(@RequestParam("name") String name,@RequestParam("age") int age) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
        // 객체를 반환할수 있다. 객체가 JSON형식으로 반환됨
        // 요소 검사시 -> JSON 형식 {key : value}
        // xml방식은 태그를 열고 닫고 불편하다 심플한 JSON우세

    }
    static class Hello{
    // static 을 쓰면 클래스 내부에 클래스를 생성할 수 있다.
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

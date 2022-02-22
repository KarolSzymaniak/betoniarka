package pl.javawwa32.karolproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.javawwa32.karolproj.service.HelloService;

@RestController
@RequiredArgsConstructor
class HelloWorldController {

    private HelloService helloService;

    @Autowired
    public HelloWorldController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello.html");
        return modelAndView;
    }
}
package com.wissen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParticipantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParticipantServiceApplication.class, args);
    }

}

//@ComponentScan(basePackageClasses = AppConfig.class)
//class AppConfig {
//
//}
//
//@Controller
//class UserController {
//    private final UserService simpleUserService;
//    UserController(UserService userService){
//        this.simpleUserService = userService;
//    }
//}

//
//interface UserService {
//
//}
//
//@Data
//@Component
//class SimpleUserService implements UserService{
//
//}
//@Data
//@Component
//class MyUserService implements UserService{
//
//}
//@Data
//@Component
//class ExtraUserService implements UserService{
//
//}

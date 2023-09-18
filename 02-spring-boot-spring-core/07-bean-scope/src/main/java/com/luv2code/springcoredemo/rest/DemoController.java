package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;
    private Coach tennisCoach;
    private Coach tennisCoach1;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach anotherCoach,
                          @Qualifier("tennisCoach") Coach tennisCoach, @Qualifier("tennisCoach") Coach tennisCoach1) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
        this.tennisCoach1= tennisCoach1;
        this.tennisCoach=tennisCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/prototype")
    public String checkPrototypeScope() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

    @GetMapping("/singleton")
    public String checkSingletonScope() {
        return "Comparing beans: tennisCoach1 == tennisCoach, " + (this.tennisCoach == this.tennisCoach1);
    }
}

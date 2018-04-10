package com.example.demo.soundsystem;

/**
 * Created by OL-PC on 2018/03/22.
 */
public aspect CriticAspect {
    public CriticAspect(){}

    pointcut performance() : execution(* com.example.demo.preform.Performance.perform(..));

    after() : performance(){

    }
    before() : performance(){

    }
}

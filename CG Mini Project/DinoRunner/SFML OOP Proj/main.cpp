//OOP PROJECT BSCS01
//INFINITE RUNNING/JUMPING GAME
//Group Members:
//Saba Taha 200901038
//Faraz Ahmad Qureshi 200901045
//Jabeen e Zahra Hamdani 200901047
//Muhammad Ahmed Siddique 200901077
//Zainab binte Laraib 200901106
#include <SFML/Graphics.hpp>
#include <iostream>
#include "Map.h"
int main()
{
    Map m;
    while (m.isWindowRunning()){
        //update    //CONTROL. Controls all the game Logic(Model).
        m.update();
        //render    //VIEW. Displays everything.
        m.render();
    }
}
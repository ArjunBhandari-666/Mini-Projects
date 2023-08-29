#pragma once
#include <SFML/Graphics.hpp>
#include <string>
#include <fstream>
class Hud{							//Deals with displaying text to the window. Not a very resource-friendly job.
public:
	Hud();
	void printScore(int);			//function to print score to screen.
	void readHiScore();				//read Hiscore from file.
	void writeHiScore(int);			//write new Hiscore to a file.
	void readCredits();
	sf::Text* t;		//Text objects that can be drawn on the window.
	
private:
	sf::Font font;					//font object to load a font from file.
	std::string highScore , credits;			//used to convert integer to string highscore to store to a file.
	long int hiScore,score;				//scores.
	unsigned width, height;			//width and height of the window.
};                                                                                                                                             
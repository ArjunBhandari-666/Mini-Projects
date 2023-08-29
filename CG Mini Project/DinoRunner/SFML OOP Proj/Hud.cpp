#include "Hud.h"

Hud::Hud():score(0),hiScore(0) {
	t = new sf::Text[4];
	if (!font.loadFromFile("./res/font/ARCADECLASSIC.TTF")) exit(1);	//Instead of separate initialization functions I just used one.
	t[0].setFont(font);													//Set the font to the text. Copy text to other text objects.
	t[0].setCharacterSize(30);											//Set other generic text properties.
	t[0].setFillColor(sf::Color::White);
	t[0].setStyle(sf::Text::Bold);
	t[0].setString("score");											//Set each of the strings that will be displayed.
	t[0].setPosition(650.0f, 5.0f);
	
	t[1].setFont(font);
	t[1].setCharacterSize(30);
	t[1].setFillColor(sf::Color::White);
	t[1].setStyle(sf::Text::Bold);
	t[1].setPosition(500.0f, 5.0f);
	t[1].setString(highScore);

	t[2].setFont(font);
	t[2].setCharacterSize(30);
	t[2].setFillColor(sf::Color::White);
	t[2].setStyle(sf::Text::Bold);
	t[2].setString("Press Spacebar to Restart");
	t[2].setPosition(sf::Vector2f(575-t[2].getGlobalBounds().width,300.0f));
	t[2].setOutlineColor(sf::Color::Black);
	t[2].setOutlineThickness(1.3f);

	t[3].setFont(font);
	t[3].setCharacterSize(20);
	t[3].setOrigin(0.f, 0.f);
	t[3].setFillColor(sf::Color(255,255,255,190));
	t[3].setPosition(sf::Vector2f(1.0, 1.0f));
	t[3].setOutlineColor(sf::Color::Black);
	t[3].setOutlineThickness(0.5f);
	readCredits();
}

void Hud::printScore(int scor) {							//Simple function that uses to_string to convert int score to string.
	score = scor;
	std::string b = "score ";
	std::string s = std::to_string(score);
	t[0].setString(b+s);
	readHiScore();											//Prints the Hiscore after reading it from file.
	writeHiScore(score);
}

void Hud::readHiScore() {
	std::ifstream readFile;
	readFile.open("./res/highscore/hiscore.txt");
	if (readFile.is_open())
	{
		while (!readFile.eof()) {
			readFile >> hiScore;
			highScore = "HI " + std::to_string(hiScore);
			t[1].setString(highScore);
		}
	}
	readFile.close();
}

void Hud::writeHiScore(int score) {							//Writes the hiscore to a file.
	std::ofstream writeFile("./res/highscore/hiscore.txt");
	if (writeFile.is_open())
	{
		if (score > hiScore) {
			hiScore = score;
		}
		writeFile << hiScore;
	}
	writeFile.close();
}

void Hud::readCredits() {
	t[3].setString("Infinite Runner Game\n\
200901038\t200901045\t200901047\n200901077\t200901106\n\
OOP\tProject\tBSCS\t01\tSection\tB");
}
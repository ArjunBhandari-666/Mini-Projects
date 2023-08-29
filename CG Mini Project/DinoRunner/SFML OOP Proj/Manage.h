#pragma once
#include <SFML/Graphics.hpp>
#include "Animation.hpp"
#include "AnimatedSprite.hpp"
class Manager {					//Acts as a Resource Manager however It was not wellplanned so doesnt work efficiently.
public:
	Manager();					//Constructor. initializes player and object.
	void playerSetup();			//sets up player to be accesed by player class
	void obstacleSetup();		//same as player

	void setDeltaTime();		//Sets the DeltaTime that many other classes use.
	float getDeltaTime();

	sf::Texture& getTexture();	//Texture function that Animation function in Player class use.
public:
	sf::Sprite* playerSprite;	//Pointer to an unrendered playersprite which is used to detect collision.
	sf::Sprite* obstacleSprite;	//Obstacle sprite. Just initialized and a texture loaded.

	sf::Time frameTime;			//Time variable which stores the time in seconds,milliseconds,microseconds etc.
	sf::Clock frameClock;		//SFML's built in clock module. used to calculate frameTime.

	sf::Texture pTex;			//Player's Texture. Could access it using getTexture().
	
private:
	sf::Texture oTex;			//singleton ObjectTexture.
};








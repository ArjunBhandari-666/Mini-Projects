#pragma once
#include <SFML/Graphics.hpp>
#include "Manage.h"
class Obstacle
{
public:
	//Constructors and initializers.
	Obstacle();
	void obstacleSetup();
	void obstacleReset();
	
	//Move function--
	void obstacleMove(float, const float&);

	//bool getIsCounted();
	int getObstaclesPassed();
	
	void setScore();
	void resetScore();
	//Obstacle Controller.
	void obstacleController(const float&);
	void levelCheck(const float&);

public:
	Manager obstacleSprite;	//Manager initializes the sprite.
private:
	sf::Texture texture;
	sf::Vector2f object_pos;
	unsigned int obstaclesPassed;
	//Boolean flags
	//bool isActive; //is obstacle on screen
	//bool isCounted; //checks if object's point is already counted. if it is, destroy the object.
}; 

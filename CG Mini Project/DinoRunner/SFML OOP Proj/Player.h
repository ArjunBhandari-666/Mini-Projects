#pragma once
#include "SFML/Graphics.hpp"
#include "Manage.h"
class Player					//Deals with everything player related. Loads the Texture from class Manager.
{
public:
	//constructor and destructors.
	Player();
	void initializePlayer();
	//Accessors and Mutators
	bool getIsAlive();
	void setIsAlive(bool);
	//Player Movement
	void playerMoveUp(float&);	//the jump Function.

	void playerController(float&);	//Controls everything about player.

	//All of the Animation Controls for Player.
	void animationSetup();
	void animatedSpriteSetup();
	void deathAnimationSetup();
	void callDeathAnimation();

	sf::Texture& getTexture();	//Gets texture from Manager class.

	Animation* currentAnimation;	//Stores pointer to current animation frame.
	Animation walkingAnimationUp;	//WalkingAnimation objects stores the walkingBirb animation.
	Animation deathAnimation;		//Stores deadBirb animation
	AnimatedSprite* animatedSprite; //Sprite that controls how the animations are rendered to the screen.
public:
	Manager* player;				//Public object to Manager class. using this in Map.cpp in several places.
	bool isJumping;					//Checks if player is jumping to initiate the Jump function. Used in Map.cpp
private:
	bool isFalling;					//Check if Player is still in the air or not.
	bool isAlive;					//Only spawn player if this tag is true.
	float pX, pY, gravity = 1.0f;	//PlayerPositions.
	float groundHeight = 550.0f;	//Default Ground Height. window height is 600px.
	int jumpVelocity = -8;			//Default JumpVelocity. Too low of a -ve value (i.e. -100) may cause weird behavior.
	float velocity;					//No idea how I made it work lol. Has random values half the time. Could make it local.
};


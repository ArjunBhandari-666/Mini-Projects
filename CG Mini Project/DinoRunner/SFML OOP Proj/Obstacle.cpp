#include "Obstacle.h"
#include <iostream>
Obstacle::Obstacle(){
	object_pos.x = 800.0f;	//Default positions.
	object_pos.y = 550.0f; 
	obstaclesPassed = 0;	//Sets score to 0.
	obstacleSetup();		//Calls the Manager class function to setup everything.
}

void Obstacle::obstacleReset() {
	obstacleSprite.obstacleSprite->setPosition(object_pos); //Resets the obstacle position so it looks like it respawned.
	}
void Obstacle::obstacleSetup() {							//obstacleSetup function
	obstacleSprite.obstacleSetup();
}
//Obstacle Controller.
void Obstacle::obstacleController(const float& dt) {
	
	levelCheck(dt);											//Checks the score and increases speed accordingly.
	if (obstacleSprite.obstacleSprite->getPosition().x < 0.0f) {	//Object reset thingy.
		this->obstacleReset();
		this->setScore();									//Increment score after resetting object.
	}
}
void Obstacle::levelCheck(const float& dt) {				//takes frameTime to manage speed however I dont remember if it works or not.
	if (getObstaclesPassed() < 10)							//First level. starting speed.
		this->obstacleMove(1.0f, dt);
	else if (getObstaclesPassed() < 20)						//Second level. starts at 10 score.
		this->obstacleMove(1.25f,  dt);
	else if (getObstaclesPassed() < 30)						//Third level. faster still. 20 score.
		this->obstacleMove(1.5f, dt);
	else this->obstacleMove(2.0, dt);						//Fastest Speed level. Starts over 30 score.
}
															
void Obstacle::obstacleMove(float i, const float& dt){		//object movement functions and other spawn and desttruction logic
	float velocity = 50.0f;
	velocity *= 10.0f * dt * i;
	obstacleSprite.obstacleSprite->move(-velocity, 0.0f);
}

//Random functions for random stuffs.
int Obstacle::getObstaclesPassed() {
	return obstaclesPassed;
}
void Obstacle::setScore() {
		obstaclesPassed++;
}
void Obstacle::resetScore() {
	obstaclesPassed = 0;
}
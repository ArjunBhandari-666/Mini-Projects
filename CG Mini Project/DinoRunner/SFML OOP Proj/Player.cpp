#include "Player.h"

//Player Constructor/Destructor.
Player::Player(){
	player = 0;								//Sets pointer to Manager class as null.
	initializePlayer();						//Heap allocates the former pointer.
	isJumping = false;						//Resets Jump boolean to default state.
	isAlive = true;							//Set to true to start game. Could set to false if it is necessary to start game as Paused.
	isFalling = false;						//Checks if player is on the ground.
	pY = groundHeight;						//sets player's Y position to constant groundHeight.
}
bool Player::getIsAlive() {					//Accessor and Mutator for Status of Player.
	return isAlive;
}
void Player::setIsAlive(bool alive) {
	isAlive = alive;
}
void Player::playerController(float& dt) {	//Player Controller. Controls movement.
	if (this->isJumping == true)			//If true, call jump function.
		this->playerMoveUp(dt);
	else isJumping = false;					//Else make sure player isn't jumping.
	animatedSprite->setPosition(15.0f, pY);	//Just sets the Player and Player animation sprite at one position.
	player->playerSprite->setPosition(15.0f, pY);
}
//Player initialize function
void Player::initializePlayer(){
	player = new Manager;
	velocity = 0.0f;
	animationSetup();						//Sets everything about Animation. Uses the Animation.hpp and AnimatedSprite Classes.
	animatedSpriteSetup();
	deathAnimationSetup();
}
void Player::playerMoveUp(float& dt) {		//Probably the messiest and most time-consuming function.
	if (isJumping == true){					//First checks if isJumping is true otherwise just returns default walking values.
		if (jumpVelocity + gravity < 0 && isFalling == false){	//climbs the jump parabola. makes sure player isnt already jumping.
			velocity += jumpVelocity + gravity;					//velocity decreases(turns negative) and gets set as player's Y coordinate.
			gravity++;											//Increments Gravity to gradually slowdown the player. works decently.
			this->pY += velocity;						//set the velocity to player's Y coordinate which gets set in the playerController()
		}
		else if (jumpVelocity + gravity == 0) {	//Start the downward slope of the jump. if jumpvelocity == gravity means jump height is reached
			if (pY < groundHeight) {			//If player is above ground (-ve y value) they are falling. so set velocity accordingly.
				isFalling = true;				
				if (velocity < 0.0f) {			//If velocity is less than 0, time to increment it.
				velocity +=  gravity * dt * 50;
				}
				else pY += velocity;			//pY is again set with downhill velocity. This whole cycle happens each frame.
				if (pY > groundHeight)			//If Player is lower than ground, pull them back up.
					pY = groundHeight;
			}
			else {							// When everything is done this acts as a reset.
				isJumping = false;
				isFalling = false;
				velocity = 0.0f;
				gravity = 1.0f;
			}
		}	//else if close
	}		//if close			
}			//function close

//Animation

sf::Texture& Player::getTexture() {										//Get the texture from Manager Class
	return player->getTexture();
}
void Player::animatedSpriteSetup()										//Setup first Animation. WalkingBirb
{
	animatedSprite = new AnimatedSprite(sf::seconds(0.2f), true, true);	//Calling the AnimatedSprite Constructor to make new sprite.
	animatedSprite->setOrigin(sf::Vector2f(0.0f, 92.0f));
	animatedSprite->setPosition(1.0f, groundHeight);
	animatedSprite->setScale(1.f, 1.f);
}

void Player::animationSetup() {
	walkingAnimationUp.setSpriteSheet(getTexture());					//WalkingBirb Animation Frames
	walkingAnimationUp.addFrame(sf::IntRect(0, 0, 94, 96));
	walkingAnimationUp.addFrame(sf::IntRect(95, 0, 95, 93));
	currentAnimation = &walkingAnimationUp;								//Set this as the default current animation.
}

void Player::deathAnimationSetup() {									//Same as above. when it gets called, set as current animation.
	deathAnimation.setSpriteSheet(getTexture());
	deathAnimation.addFrame(sf::IntRect(0, 96, 75, 102));
	deathAnimation.addFrame(sf::IntRect(75, 96, 163, 103));
	currentAnimation = &deathAnimation;
}
void Player::callDeathAnimation(){
	animatedSprite = new AnimatedSprite(sf::seconds(0.2f), false, true);
	animatedSprite->setOrigin(sf::Vector2f(0.0f, 103.0f));
	animatedSprite->setPosition(1.0f, groundHeight);
	animatedSprite->setScale(1.f, 1.f);
}





























//works to jump and collision.
/*#include "Player.h"

//Player Constructor/Destructor.
Player::Player(){
	player = 0;
	initializePlayer();
	isJumping = false;
	isAlive = true;
	velocity = 0;
	jumpCounter = 0;
	pY = 500;
}
bool Player::getIsAlive() {
	return isAlive;
}
void Player::setIsAlive(bool alive) {
	isAlive = alive;
}
//Get Player PosX and PosY
float Player::getPosX() {
	return player->playerSprite->getPosition().x;
}
float Player::getPosY() {
	return player->playerSprite->getPosition().y;
}

void Player::setPos() {
	player->playerSprite->setPosition(1.0f, pY);
}

//Player controller
void Player::playerController(float& dt) {
	if (this->isJumping == true)
	{
		this->playerMoveUp(dt);
		this->jumpCounter = 0;
	}
	else
		this->isJumping = false;
		player->playerSprite->setPosition(15.0f , pY);
		}
//Player initialize function
void Player::initializePlayer(){
	player = new Manager;
	
	}

void Player::playerMoveUp(float& dt) {			//1. turn isjumping to true. 2.update velocity until it rreaches jump height. 3.falling usnig gravity.
//time to jump
	if (isJumping == true)
	{
		if (jumpVelocity + gravity < 0)	//climbs the jump parabola. jumpvelocity = -8 , gravity = 1. 
		{
		velocity += jumpVelocity + gravity; //velocity decreases and gets set as posY.
		gravity++;
		this->pY += velocity * dt * 2300;
		}
	else if (jumpVelocity + gravity == 0) {	//case for top of the jump. start descent.
		if (pY < groundHeight) {
			velocity += gravity;
			pY += velocity;
			if (pY > 500)
					pY = 500;
		}
		else {							// When everything is done this acts as a reset.
			isJumping = false;
			velocity = 0.0f;
			gravity = 1.0f;
			}
		}
	}
}
*/
#include "Manage.h"

Manager::Manager(){
	playerSprite = new sf::Sprite();		//Allocates a new sprite and then sets it up.
	playerSetup();

	obstacleSprite = new sf::Sprite();		//Same for the obstacle
	obstacleSetup();
}
//Player setup
void Manager::playerSetup() {
	if (!pTex.loadFromFile("./res/images/BirbSheetFull.png"))	//Load full texture then use a smaller portion of it.
		exit(1);												//close program if it cannot load file.
	playerSprite->setTexture(pTex);
	playerSprite->setTextureRect(sf::IntRect(0, 0, 94, 96));	//(left,top,width,height) of the image area u want to select.
	playerSprite->setOrigin(0.0f, 94.f);						//The origin for all transformations. default is (0,0) of the sprite.
	playerSprite->setScale(1.f, 1.f);							//Aligning the player to the ground by setting the origin to the ground.
}
void Manager::obstacleSetup() {
	if (!oTex.loadFromFile("./res/images/obstacleResize.png"))	//Same as above.
		exit(1);
	obstacleSprite->setTexture(oTex);
	obstacleSprite->setOrigin(0.0f, 111.0f);
	obstacleSprite->setPosition(800.0f, 550.0f);
	obstacleSprite->setScale(0.5f, 0.5f);
}
sf::Texture& Manager::getTexture() {							//Returns the texture. Didnt use it a lot.
	return pTex;
}
void Manager::setDeltaTime() {									//Functions that set and get the frameTime.
	frameTime = frameClock.restart();
}
float Manager::getDeltaTime() {
	return frameTime.asSeconds();
}
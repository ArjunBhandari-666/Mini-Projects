#pragma once
#include <SFML/Graphics.hpp>
#include "Player.h"
#include "Obstacle.h"
#include "Hud.h"

class Map	//Class that deals with arranging everything and displaying it on the screen.
{
public:
	//Initialize and Delete
	Map();
	void initializeRenderWindow();
	void initializeClassMembers();
	void initializeCollision();
	void initializeBackground();
	~Map();
	
	//Update and Render Function
	void update();
	void render();

	//Input Detection
	void getPollEvent();

	//Collision Detection
	bool collisionDetect();
	void collision();

	const bool isWindowRunning()const; //Function to check if Window is open
private:
	void windowIconSetup();	//Private Function to setup the Icon and display it on the window.
public:
	bool isColliding; //Public Bool variable to check collision.
private:
	sf::RenderWindow* window;	//Pointer to actual window object.
	sf::Event ev;				//Event checker for window inputs.
	sf::VideoMode videoMode;	//Just to set windoww properties.
	
	// Objects
	Player* p;		//Pointer to Player class.
	Obstacle* obs;	//Pointer to the obstacle class
	const int windowHeight = 600, //sets the Dimensions of videoMode.
			  windowWidth = 800;	
	Hud* h;			//Deals with all text. pointer to Hud class.
	Manager* m;		//Deals with loading in the resources from files.
	
	//Icon image
	sf::Image icon;
	
	// Background Texture and Sprite
	sf::Texture bgTexture;
	sf::Sprite background;

	float timeDelta;	//variable to store frameTime from m->getDeltaTime() function.

	bool credits;		//Secret :3 find out what it does yourself.
};

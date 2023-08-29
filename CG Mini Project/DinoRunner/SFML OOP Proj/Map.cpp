#include "Map.h"
#include "Player.h"
#include <iostream>

//Constructors and destructors.

Map::Map() {
    initializeClassMembers();           //Initializes all the variables.
    initializeRenderWindow();           //Initializes the Rendering Window using window* (pointer).
    initializeCollision();              //Sets the Collision variables.
    initializeBackground();             //Loads Texture and prepares it to be drawn using the sprite.
}
Map::~Map(){                            //Destructor. Not necessary as Most objects have their own
    delete this->window,p,obs,h,m;      //destructors as part of the class implementation.
}

void Map::initializeClassMembers() {    
    window = 0;                         //Sets pointer to Null.
    p = new Player;
    obs = new Obstacle;
    h = new Hud;
    m = new Manager;
    timeDelta = 0.0f;                   //Makes sure time has +ve value to begin.
}

void Map::initializeRenderWindow() {
    this->videoMode.height = windowHeight;  //Render window Dimensions
    this->videoMode.width = windowWidth;    //Constructor call to RenderWindow creates the window.
    window = new sf::RenderWindow(this->videoMode, "Infinite Runner Game|OOP Project|", sf::Style::Titlebar | sf::Style::Close);
    this->window->setFramerateLimit(60);
    this->windowIconSetup();                //Sets the Birb Icon.
}

void Map::initializeCollision() {
    isColliding = false;                    //Collision Initializer.
}

void Map::initializeBackground()            //Initializing Background.
{
    if (!bgTexture.loadFromFile("./res/images/BackgroundFULL1Cropped.png")) {
        exit(1);
        std::cout << "Image not loaded";
    }
    background.setTexture(bgTexture);       //Image size is 800 by 600
    background.setPosition(0.f, 0.f);       //Setting the sprite at 0,0 so it covers entire 800x600 window.
}

void Map::getPollEvent(){                   //Responsible for Inputs and other Events.
	window->setKeyRepeatEnabled(false);
    while (this->window->pollEvent(ev)){
        if (ev.type == sf::Event::Closed)   //Window close event
            window->close();
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Escape))               //Window close using ESC key.
            window->close();
                                            // Checks if Up arrow is pressed to Jump.
        if (ev.type == sf::Event::KeyPressed && p->getIsAlive() == true)
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Up))
                p->isJumping = true;
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Num1)) {
            credits = true;
            std::cout << "Credits set to true";
        }
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Num2)) {
            credits = false;
            std::cout << "Credits set to false";
        }
                                            // Checks if Player has pressed Space to Restart Game.
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::Space) && isColliding == true){
            p->setIsAlive(true);    //Resets player.
            obs->obstacleReset();   //Resets obstacle.
            obs->resetScore();      //score = 0.
            isColliding = false;    //Collision Reset. Could also use initializeCollision() function/
            m->setDeltaTime();      //Resets frameTime.
         
        }
    }   //while loop close
}   //getPollEvents close

const bool Map::isWindowRunning() const{    //Just checks if window is currently open. used in main.cpp
  return (*window).isOpen();
}

void Map::windowIconSetup(){                //Loads File and sets the size. appears in the top left of the window bar.
    if (!icon.loadFromFile("./res/images/iconBirb.png"))exit(1);
    window->setIcon(icon.getSize().x, icon.getSize().y, icon.getPixelsPtr());
}

bool Map::collisionDetect() {       //Uses a simple Rectangle Collision Detector to detect if the two rectangles are intersecting.
    if (p->player->playerSprite->getGlobalBounds().intersects(obs->obstacleSprite.obstacleSprite->getGlobalBounds())){
        isColliding = true;         //As soon as this condition gets true, pause the game.
        p->deathAnimationSetup();   //Setup the Death Animation for Birb.
    }
    return isColliding;             //Returns Bool to collision().
}
void Map::collision() {             //Simple Collision Handler
    if (collisionDetect() == true)  //If CollisionDetect returns TRUE it means collision happened. Else, continue as normal.
        p->setIsAlive(false);       //Gets us out of the main game Update Loop.
    else {
        isColliding = false;        //Makes sure isColliding is false and calls Obstacle Controller
        obs->obstacleController(m->getDeltaTime()); //Obstacle controller resets the obstacle. Increments score as well.
    }
}

//Main Game Update Function
void Map::update() {
    if (p->getIsAlive() == true){                       //If this condition is false, Loop doesnt run. Game gets paused.
        p->currentAnimation = &p->walkingAnimationUp;   //Sets current Animation to be BirbWalk Animation.
        m->setDeltaTime();                              //Resets Delta Time.
        p->animatedSprite->update(m->frameTime);        //Update Animation Frame.
        getPollEvent();                                 //Check player input.
        //timeDelta = m->getDeltaTime();                  //Assigns value to timeDelta to be sent to the playerController.
        timeDelta = 0.03f;
     p->playerController(timeDelta);                    //Responsible for Jump, Reset and Many other properties of Player.
    
     collision();                                       //Collision Check and if returned false, updates score.
     
     h->printScore(obs->getObstaclesPassed());          //Score Print to screen.
     p->animatedSprite->play(*p->currentAnimation);     //Plays the CurrentAnimation Frame.
    }
    else {                                              //If the CollisionDetector returns TRUE, this is called instead. 
        p->currentAnimation = &p->deathAnimation;       //A way to set texture of animated sprite to be deadBirb.
        p->animatedSprite->update(m->frameTime);        //Same as before. Updates Animation Frame.
        getPollEvent();                                 //Starts Checking If Player pressed <sf::Keyboard::Space> to restart.
        p->animatedSprite->play(*p->currentAnimation);  //Runs the Death Animation for Birb.
    }
}//updateloop close

 //Render loop
void Map::render() {
    window->clear(sf::Color::Green);                                    //Clear the buffer to Store the new one.
    window->draw(background);                           //Starts Drawing to the new buffer. Draws background Sprite
    window->draw(*p->animatedSprite);                   //Draw Animated Player sprite. Collision is detected by hidden Player entity.
    window->draw(*obs->obstacleSprite.obstacleSprite);  //Draws the ObstacleSprite to the screen.
    window->draw(h->t[0]);                                 //Displays the score in the top right corner.
    window->draw(h->t[1]);                                //Displays the highscore loaded from the file.
    if (isColliding == true) {                            //IF conditional to check when to display deadBirb animation.
        window->draw(h->t[2]);
        if(credits)
        window->draw(h->t[3]);
    }
    window->display();                                  //Swaps the Display Buffer so you can see everything that u draw on screen.
}
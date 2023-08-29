#include <iostream>
#include <stdlib.h>
#include <math.h>
#include<sstream>
#include<string.h>
#include<windows.h>
#include<mmsystem.h>
#include <GL/freeglut.h>

void displayRasterText(float x, float y, float scale, const char* text)
{
    glPushMatrix();
    glTranslatef(x, y, 0);
    glScalef(scale, scale, scale);
    glRasterPos2f(0, 0);
    glutBitmapString(GLUT_BITMAP_HELVETICA_18, (const unsigned char*)text);
    glPopMatrix();
}


int mouseX, mouseY;
bool mButtonPressed = false;
using namespace std;
void display1();
static float xp=-.55;
int static crspeed = 60;
float crmove = 4;
float static y11= -3.3;
float static zp= 2;
float static tpx= .15;
int static carpos= 0;
float view = 10.0;
int static score= 0;
int static totalMeter = 0;
char quote[6][80];
int numberOfQuotes = 0, i;
int static carspeed= 45;
float static sky_red=0.5;
float static sky_green= 0.8;
float sky_blue= 1.00;
int roadlight = 50;
int id1,id2;

void mountain()
{
    for (float z = -40; z < 1100; z += 4.8)
    {
        glPushMatrix();
        glScalef(1.0, 1.0, 1.0);
        glPushMatrix();

        // Set the base color to dark brown
        glColor3ub(70, 61, 46);

        // Translate and scale the left side of the mountain
        glTranslatef(-3.0, z, .30);
        glScalef(1.0, 3.0, 1.0);

        // Render the left side base as a cube
        glutSolidCube(1);

        glPopMatrix();

        // Calculate the color gradient from dark brown to light brown
        float gradient = (z + 40) / 1140.0; // 1140 = 1100 - (-40)
        int r = 70 + static_cast<int>(gradient * (200 - 70));
        int g = 61 + static_cast<int>(gradient * (180 - 61));
        int b = 46 + static_cast<int>(gradient * (160 - 46));

        glPushMatrix();
        glColor3ub(r, g, b);

        // Translate and scale the middle section of the left side
        glTranslatef(-2.55, z, .40);
        glScalef(0.6, 1.0, 1.0);

        // Render the middle section on the left side as a cube
        glutSolidCube(.2);
        glPopMatrix();

        glPushMatrix();
        glColor3ub(r, g, b);

        // Translate and scale the top section of the left side
        glTranslatef(-2.9, z - 0.5, .2);
        glScalef(0.6, 0.2, 1.0);

        // Render the top section on the left side as a cube
        glutSolidCube(.5);
        glPopMatrix();

        glPushMatrix();
        glColor3ub(r, g, b);

        // Translate and rotate the left side mountain peak
        glRotatef(0, 0.0, 0.0, 0.0);
        glTranslatef(-3.0, z, .70);

        // Render the left side mountain peak as a cone
        glutSolidCone(1, 1, 4, 6);
        glPopMatrix();
        glPopMatrix();

        // Render the right side of the mountain

        glPushMatrix();
        glPushMatrix();

        // Set the base color to dark brown
        glColor3ub(70, 61, 46);

        // Translate and scale the right side of the mountain
        glTranslatef(3.0, z, .30);
        glScalef(1.0, 3.0, 1.0);

        // Render the right side base as a cube
        glutSolidCube(1);

        glPopMatrix();

        glPushMatrix();
        glColor3ub(r, g, b);

        // Translate and scale the middle section of the right side
        glTranslatef(2.55, z, .40);
        glScalef(0.6, 1.0, 1.0);

        // Render the middle section on the right side as a cube
        glutSolidCube(.2);
        glPopMatrix();

        glPushMatrix();
        glColor3ub(r, g, b);

        // Translate and scale the top section of the right side
        glTranslatef(2.9, z - 0.5, .2);
        glScalef(0.6, 0.2, 1.0);

        // Render the top section on the right side as a cube
        glutSolidCube(.5);
        glPopMatrix();

        glPushMatrix();
        glColor3ub(r, g, b);

        // Translate and rotate the right side mountain peak
        glRotatef(0, 0.0, 0.0, 0.0);
        glTranslatef(3.0, z, .60);

        // Render the right side mountain peak as a cone
        glutSolidCone(1, .8, 4, 6);
        glPopMatrix();
        glPopMatrix();
    }
}

enum ViewPage { MENU_SCREEN, GAME, INSTRUCTIONS };
ViewPage viewPage = MENU_SCREEN;
int alienLife1 = 100, alienLife2 = 100;



void sprint( float x, float y, string st)
{
    int l,i;
//    l=strlen( st ); // see how many characters are in text string.
    glColor3f(0.0,0.0,0.0);
    //glDisable(GL_LIGHTING);
    glRasterPos2f( x, y); // location to start printing text
    for( i=0; i <  st.length(); i++) // loop until i is greater then l
    {
        glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, st[i]);

    }


}

void keyboardown(int key, int x, int y)
{
    switch (key)
    {

    case GLUT_KEY_RIGHT:
        xp=.55;
        carpos=1;
        break;



    case GLUT_KEY_LEFT:
        xp=-.55;
        carpos=0;
        break;


    case GLUT_KEY_UP:
        if (crspeed>5)
        {
            crspeed-=5;
            carspeed+=5;
        }

        else
            crspeed=crspeed;
        break;


    case GLUT_KEY_DOWN:
        if (crspeed<60)
        {
            crspeed+=5;
            carspeed-=5;
        }

        else
            crspeed=crspeed;
        break;


    default:
        break;

    }
}

//Extra Display Function
void reshape(int w, int h)
{
    glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60, 1.0, 1.0, 3200);
    glMatrixMode(GL_MODELVIEW);
}

GLfloat UpwardsScrollVelocity = -1.0;

void timeTick(void)
{
    if (UpwardsScrollVelocity< -1)
        view -= 0.0011;
    if (view < 0)
    {
        view = 2;
        UpwardsScrollVelocity = -1.0;
    }
    //  exit(0);
    UpwardsScrollVelocity -= 0.2;
    glutPostRedisplay();
}


void RenderToDisplay()
{
    int l, lenghOfQuote, i;

    glTranslatef(0.0, 0.0, 0.0);
    glRotatef(-20, 1.0, 0.0, 0.0);
    glScalef(0.05, 0.05, 0.05);

    for (l = 0; l<numberOfQuotes; l++)
    {
        lenghOfQuote = (int)strlen(quote[l]);
        glPushMatrix();
        glTranslatef(-(lenghOfQuote * 37), (l * 200), 0.0);
        for (i = 0; i < lenghOfQuote; i++)
        {
            glColor3f((UpwardsScrollVelocity / 10) + 300 + (l * 10), (UpwardsScrollVelocity / 10) + 300 + (l * 10), 0.0);
            glutStrokeCharacter(GLUT_STROKE_ROMAN, quote[l][i]);
        }
        glPopMatrix();
    }
}




void myDisplayFunction(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();
    gluLookAt(0.0, 30.0, 100.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    RenderToDisplay();
    glutSwapBuffers();
}

int winner(char a)
{


    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(3200, 1600);
    glutCreateWindow("GAME OVER");
    glClearColor(0.0, 0.0, 0.0, 1.0);
    glLineWidth(3);
    //char c=char(score);
    strcpy(quote[1], "Game Over");
    strcpy(quote[0], "Better Luck Next Time");
    numberOfQuotes = 5;
    glutDisplayFunc(myDisplayFunction);
    glutReshapeFunc(reshape);
    glutIdleFunc(timeTick);
    glutMainLoop();

    return 0;
}

//Extra Display Function End

void keyboard(unsigned char key, int x, int y)
{
    if(key=='n')
    {
        sky_red=0;
        sky_green=0.2;
        sky_blue=0.25;
        roadlight= 255;


    }

    else if(key=='d')
    {
        sky_red=0;
        sky_green=0.8;
        sky_blue=1.0;
        roadlight= 50;

    }

    else if(key=='e')
    {
        exit(1);
    }

}




bool collision()
{

    if (0 > (crmove-y11)&& -1 < (crmove-y11)&& carpos==1 )
    {
        return true;
    }

    else if (0 > (crmove-(y11-10))&& -1 < (crmove-(y11-10))&& carpos==0 )
    {
        return true;
    }

    else if (0 > (crmove-(y11-20))&& -1 < (crmove-(y11-20))&& carpos==0 )
    {
        return true;
    }

    else if (0 > (crmove-(y11-30))&& -1 < (crmove-(y11-30))&& carpos==1 )
    {
        return true;
    }


    else if (0 > (crmove-(y11-30))&& -1 < (crmove-(y11-30))&& carpos==0 )
    {
        y11-=40;
        return false;
    }

    else
    {
        return false;
    }
}

bool GameScore()
{
    if (0 > (crmove-y11)&& -1 < (crmove-y11)&& carpos==0 )
    {
        score++;
    }

    else if (0 > (crmove-(y11-10))&& -1 < (crmove-(y11-10))&& carpos==1 )
    {
        score++;
    }

    else if (0 > (crmove-(y11-20))&& -1 < (crmove-(y11-20))&& carpos==1 )
    {

        score++;
    }

    else if (0 > (crmove-(y11-30))&& -1 < (crmove-(y11-30))&& carpos==0 )
    {
        //return false;
        score+=10;
    }

    else if (0 > (crmove-(y11-35))&& -1 < (crmove-(y11-35))&& carpos==0 )
    {
        return true;
        score+=10;
    }
    else
    {
        totalMeter++;
        //    cout<<totalMeter<<"Total Meter"<<endl;
        return false;
    }
	return true;
}
//Initializes 2D rendering
void initRendering()
{
    glEnable(GL_DEPTH_TEST);
}

//Called when the window is resized
void handleResize(int w, int h)
{
    glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(45.0, (double)w / (double)h, 1.0, 200.0);
}
float rtri =0;
float _angle = 0.0;
float _cameraAngle = 0.0;
float _ang_tri = 0.0;


float home= 6;

void gamerdino()
{
    glPushMatrix();
    glTranslatef(xp, -1.0, 3.5);

    // Draw the legs
    glPushMatrix();
    glTranslatef(0.15, -1.4, 0.0); // Adjusted position
    glScalef(0.1, 0.6, 0.1);
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glutSolidCube(1.0);
    glPopMatrix();

    glPushMatrix();
    glTranslatef(-0.15, -1.4, 0.0); // Adjusted position
    glScalef(0.1, 0.6, 0.1);
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glutSolidCube(1.0);
    glPopMatrix();

    // Draw the body
    glPushMatrix();
    glTranslatef(0.0, -0.4, 0.0); // Adjusted position
    glScalef(0.3, 0.6, 0.15); // Adjusted proportions
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glutSolidCube(1.0);
    glPopMatrix();

    // Draw the neck
    glPushMatrix();
    glTranslatef(0.0, 0.0, 0.0); // Adjusted position
    glScalef(0.05, 0.1, 0.05); // Adjusted size
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glutSolidCube(1.0);
    glPopMatrix();

    // Draw the head
    glPushMatrix();
    glTranslatef(0.0, 0.2, 0.0); // Adjusted position
    glScalef(0.15, 0.15, 0.15); // Adjusted size
    glColor3f(0.5, 0.5, 0.5); // Gray color for the head
    glutSolidSphere(0.8, 20, 20);
    glPopMatrix();

    // Draw the eyes
    glPushMatrix();
    glTranslatef(0.05, 0.27, 0.2); // Adjusted position
    glScalef(0.02, 0.035, 0.02); // Adjusted size
    glColor3f(0.0, 0.0, 1.0); // Red color for the eyes
    glutSolidSphere(0.6, 20, 20);
    glPopMatrix();

    glPushMatrix();
    glTranslatef(-0.05, 0.27, 0.2); // Adjusted position
    glScalef(0.02, 0.035, 0.02); // Adjusted size
    glColor3f(0.0, 0.0, 1.0); // Red color for the eyes
    glutSolidSphere(0.6, 20, 20);
    glPopMatrix();

    glPopMatrix();
}




void sky()
{
    glBegin(GL_QUADS);
    glColor3ub(sky_red, 0, sky_blue);
    glVertex3f(-4.0, 1.5, 0);
    glVertex3f(4.0, 1.5, 0);
    glVertex3f(8.0, 3, 0);
    glVertex3f(-8.0, 3, 0);
    glEnd();
}


void roadside()
{
    // Green ground
    glBegin(GL_QUADS);
    glColor3ub(144, 238, 144);
    glVertex3f(-5.0, -10, 0);
    glVertex3f(-1.0, -10, 0);
    glVertex3f(-1.0, 400, 0);
    glVertex3f(-5.0, 400, 0);
    glEnd();

    glBegin(GL_QUADS);
    glColor3ub(144, 238, 144);
    glVertex3f(1.0, -10, 0);
    glVertex3f(5.0, -10, 0);
    glVertex3f(5.0, 400, 0);
    glVertex3f(1.0, 400, 0);
    glEnd();
}



void tree()
{
    for (float z = -40; z < 1100; z +=4)
    {
        glPushMatrix();
        glPushMatrix();
        glColor3f(0, 1, 0);
        glTranslatef(-1.20, z, .45);
        glutSolidCone(.2, .4, 20, 10);
        glPopMatrix();
        glColor3ub(102, 51, 0);
        glTranslatef(-1.20, z, .25);
        glScalef(.2, .2, 1);
        glutSolidCube(.4);
        glPopMatrix();

        //right

        glPushMatrix();
        glPushMatrix();
        glColor3f(0, 1, 0);
        glTranslatef(1.20, z, .50);
        glutSolidCone(.2, .4, 20, 10);
        glPopMatrix();
        glColor3ub(102, 51, 0);
        glTranslatef(1.20, z, .30);
        glScalef(.2, .2, 1);
        glutSolidCube(.4);
        glPopMatrix();
    }

}



void objectcube()
{
    for (float zp = -20; zp < 1100; zp+=40)
    {
        //glPushMatrix();
        glPushMatrix();
        glColor3f(0,1,0);
        glTranslatef(-.50, zp, -.1);
        glutSolidCube(.2);
        glPopMatrix();

        glPushMatrix();
        glColor3f(0,1,0);
        glTranslatef(.50, zp+10, -.1);
        glutSolidCube(.2);
        glPopMatrix();

        glPushMatrix();
        glColor3f(0,1,0);
        glTranslatef(.50, zp+20, -.1);
        glutSolidCube(.2);
        glPopMatrix();

        glPushMatrix();
        glColor3f(0,1,0);
        glTranslatef(-.50, zp+30, -.1);
        glutSolidCube(.2);
        glPopMatrix();

    }
}


void road()
{
    glPushMatrix();
    glColor3ub(0.8, 0.6, 0.4);
    glTranslatef(0.0, 0.0, -.50);
    glBegin(GL_QUADS);
    glVertex3f(-1.3, -10, 0);
    glVertex3f(1.3, -10, 0);
    glVertex3f(1.3, 400, 0);
    glVertex3f(-1.3, 400, 0);
    glEnd();


    glPopMatrix();


}

//Draws the 2D scene
void drawScene()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    glMatrixMode(GL_MODELVIEW); //Switch to the drawing perspective
    glLoadIdentity(); //Reset the drawing perspective
    glRotatef(-_cameraAngle, 0.0, 1.0, 0.0); //Rotate the camera
    glTranslatef(0.0, 0.0, -7.0); //Move forward 5 units
    gamerdino();
    //sky();
    glPushMatrix(); //Save the current state of transformations
    glTranslatef(0.0, 0.0, 0.0); //Move to the center of the triangle
    glRotatef(80, -1.0, 0.0, 0.0);

    glPushMatrix();
    glTranslatef(0.0, crmove, 0.0);
    glClearColor(0.0, 0.0, 0.0, 1.0);
    road();
    glPopMatrix();
    glPushMatrix();
    glTranslatef(0.0, crmove, 0.0);
    tree();
    mountain();
    roadside();
    objectcube();
    GameScore();
    cout<<score<<endl;
    //cout<<crmove<<endl;
    //cout<<y11<<endl;
    glPopMatrix();

    glPushMatrix();
    glColor3ub(0,1,0);
    glTranslatef(5.52, 0.0, 2.0);

    ostringstream cnvrt;
    cnvrt << score;
    sprint(-4,-2.3,"Score: "+cnvrt.str());
    glPopMatrix();


    glPushMatrix();
    glColor3ub(0,0,0);
    glTranslatef(5.5, 0.0, 1.8);
    ostringstream cnvrt2;
    cnvrt2 << totalMeter;
    sprint(-4,-2.4,"Distance Travel: "+cnvrt2.str());
    glPopMatrix();

    glPushMatrix();
    glColor3ub(0,0,0);
    glTranslatef(5.5, 0.0, 1.6);
    ostringstream cnvrt3;
    cnvrt3 << carspeed;
    sprint(-4,-2.4,"Speed: "+cnvrt3.str());
    glPopMatrix();

    glPopMatrix();
    glClearColor(sky_red, sky_green, sky_blue, 1.0);

    if(collision())
    {
        winner('a');
    }
    if (mouseX >= -150 && mouseX <= 150 && mouseY >= 100 && mouseY <= 150)
    {
        glColor3f(1, 1, 1);
        if (mButtonPressed)
        {
            alienLife1 = alienLife2 = 100;
            viewPage = GAME;
            mButtonPressed = false;
        }
    }
    else
        glColor3f(0, 0, 0);

    displayRasterText(-48, 120, 0.4, "Start Game");
    //sky();
    glutSwapBuffers();
}

void update(int value)
{
    crmove-= 0.1f;
    _angle += 2.0f;
    if (_angle > 360)
    {
        _angle -= 360;

    }
    _ang_tri += 0.7f;
    if (_ang_tri > 80)
    {
        _ang_tri=0;
        //crmove= 40;
    }

    glutPostRedisplay(); //Tell GLUT that the display has changed

    //Tell GLUT to call update again in 25 milliseconds
    glutTimerFunc(crspeed, update, 0);
}
void start_game()
{
    glClearColor(0.8, 0.8, 0.8, 1.0);
    glColor3f(0,0,0);
    displayRasterText(-70,250, 2.5, "2D DINO");
    glLineWidth(10);
    glColor3f(0, 1, 0);
    glBegin(GL_LINE_LOOP);
    glVertex2f(-300, -200);
    glVertex2f(-300, 200);
    glVertex2f(300, 200);
    glVertex2f(300, -200);
    glEnd();

    glLineWidth(1);

    glColor3f(1.0, 0.5, 0.0);

    glBegin(GL_POLYGON); //Start
    glVertex2f(-150, 100);
    glVertex2f(-150, 150);
    glVertex2f(150, 150);
    glVertex2f(150, 100);
    glEnd();

    /*glBegin(GL_POLYGON); //Instructions
    glVertex2f(-150, -25);
    glVertex2f(-150, 25);
    glVertex2f(150, 25);
    glVertex2f(150, -25);
    glEnd();*/
    glColor3f(1.0, 0, 0.0);
    glBegin(GL_POLYGON); // Quit
    glVertex2f(-150, -150);
    glVertex2f(-150, -100);
    glVertex2f(150, -100);
    glVertex2f(150, -150);
    glEnd();

    if (mouseX >= -150 && mouseX <= 150 && mouseY >= 100 && mouseY <= 150)
    {
        glColor3f(1, 1, 1);
        if (mButtonPressed)
        {
            alienLife1 = alienLife2 = 100;
            viewPage = GAME;
            mButtonPressed = false;
        }
    }
    else
        glColor3f(0, 0, 0);

    displayRasterText(-48, 120, 0.4, "Start Game");

    //if (mouseX >= -150 && mouseX <= 150 && mouseY >= -25 && mouseY <= 25)
    //{
        //glColor3f(0, 0, 0);
        //if (mButtonPressed)
        //{
            //viewPage = INSTRUCTIONS;
           // mButtonPressed = false;
       // }
    //}
    //else
        glColor3f(0, 0, 0);
    //displayRasterText(-50, -5, 0.4, "Instructions");

    if (mouseX >= -150 && mouseX <= 150 && mouseY >= -150 && mouseY <= -100)
    {
        glColor3f(1, 1, 1);
        if (mButtonPressed)
        {
            mButtonPressed = false;
            exit(0);
        }
    }
    else
        glColor3f(0, 0, 0);
    displayRasterText(-25, -130, 0.4, "Quit");
    glutPostRedisplay();
}
int id3,id4;
void mouse(int button, int state, int x, int y);
/*void display3()
{
     glClearColor(0,0,0,1);
    glClear(GL_COLOR_BUFFER_BIT);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0,1000,0,1000);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glBegin(GL_POLYGON);
    glColor3f(0.439,0.502,0.565);
    glVertex2f(0,500);
    glVertex2f(500,500);
    glVertex2f(1000,500);
    glEnd();




}*/
void display2()
{
    glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();

    switch (viewPage)
    {
    case MENU_SCREEN:
        start_game();
        break;
    case GAME:
        glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB|GLUT_DEPTH);
        glutInitWindowSize(3200,800);
        glutDestroyWindow(id2);
        id3=glutCreateWindow("Dino Light 2D");
        glutDisplayFunc(drawScene);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable( GL_BLEND );
        initRendering();
        glutReshapeFunc(handleResize);
        glutTimerFunc(25, update, 0); //Add a timer
        //glutKeyboardFunc(keyboard);
        glutMouseFunc(mouse);
        glutSpecialFunc(keyboardown);
        glutMainLoop();
        break;
    /*case INSTRUCTIONS:
        glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB|GLUT_DEPTH);
        glutInitWindowSize(800,800);
        glutDestroyWindow(id3);

        id4=glutCreateWindow("instructions");
        glutDisplayFunc(display3);
        glutMainLoop();
        break;*/
    }

    glutSwapBuffers();
}

void reshape1(int width, int height)
{
    glViewport(0, 0, width, height);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-width / 2, width / 2, -height / 2, height / 2, -1, 1);
    glMatrixMode(GL_MODELVIEW);
}

void mouse(int button, int state, int x, int y)
{
    if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
    {
        mouseX = x - glutGet(GLUT_WINDOW_WIDTH) / 2;
        mouseY = glutGet(GLUT_WINDOW_HEIGHT) / 2 - y;
        mButtonPressed = true;
    }
}
//int id3;
void key1(unsigned char key,int x,int y)
{
    /*if(key=='S'){
    glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB|GLUT_DEPTH);
            glutInitWindowSize(800,800);
        glutDestroyWindow(id2);
        id3=glutCreateWindow("car");
        glutDisplayFunc(drawScene);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    glEnable( GL_BLEND );
    initRendering();
        glutReshapeFunc(handleResize);
    glutTimerFunc(25, update, 0); //Add a timer
    //glutKeyboardFunc(keyboard);
    glutMouseFunc(mouse);
    glutSpecialFunc(keyboardown);
        glutMainLoop();}*/
    if(key=='S')
    {
        glutDestroyWindow(id1);
        system("lightdino.exe");
        exit(0);

    }
}

void display()
{
    glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();

    switch (viewPage)
    {
    case MENU_SCREEN:
        drawScene();
        break;
    //case INSTRUCTIONS:
      //  display3();

        break;



    }

    glutSwapBuffers();
}
void display1()
{

    glClearColor(0.8,0.8,0.8,1);
    glClear(GL_COLOR_BUFFER_BIT);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0,1000,0,1000);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glBegin(GL_POLYGON);
    glColor3f(0.439,0.502,0.565);
    glVertex2f(0,500);
    glVertex2f(500,500);
    glVertex2f(1000,500);
    glEnd();

    char str1[]="SAHYADRI COLLEGE OF ENGINEERING AND MANAGEMENT";
    glColor3f(0,0,0);
    glRasterPos2f(300,950);
    for(i=0; i<strlen(str1); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str1[i]);
    }
    char str2[]="ADYAR,MANGALURU:574143";
    glColor3f(0,0,0);
    glRasterPos2f(380,900);
    for(i=0; i<strlen(str2); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str2[i]);
    }
    char str3[]="DEPARTMENT OF COMPUTER SCIENCE AND ENGINEERING";
    glColor3f(1,0,0);
    glRasterPos2f(300,820);
    for(i=0; i<strlen(str3); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str3[i]);
    }
    char str4[]="COMPUTER GRAPHICS AND VISUALIZATION";
    glColor3f(1,0,0);
    glRasterPos2f(340,770);
    for(i=0; i<strlen(str4); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str4[i]);
    }
    char str5[]="MINI PROJECT";
    glColor3f(0,0,0);
    glRasterPos2f(420,690);
    for(i=0; i<strlen(str5); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str5[i]);
    }
    char str6[]="ON";
    glColor3f(0,0,0);
    glRasterPos2f(450,640);
    for(i=0; i<strlen(str6); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str6[i]);
    }
    char str16[]="2D Dino";
    glColor3f(1,0,0);
    glRasterPos2f(420,570);
    for(i=0; i<strlen(str16); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str16[i]);
    }
    char str7[]="TEAM MEMBERS:";
    glColor3f(0,0,0);
    glRasterPos2f(0,400);
    for(i=0; i<strlen(str7); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str7[i]);
    }
    char str8[]="Arjun-4SF20CS017";
    glColor3f(1,0.3,1);
    glRasterPos2f(0,350);
    for(i=0; i<strlen(str8); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str8[i]);
    }
    char str9[]="KUMAR RISHAV-4SF20CS054";
    glColor3f(1,0.3,1);
    glRasterPos2f(0,300);
    for(i=0; i<strlen(str9); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str9[i]);
    }
    char str10[]="DEPT OF CSE,SEC B";
    glColor3f(0,0,0);
    glRasterPos2f(0,250);
    for(i=0; i<strlen(str10); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str10[i]);
    }
    char str11[]="PROJECT GUIDED BY:";
    glColor3f(0,0,0);
    glRasterPos2f(800,400);
    for(i=0; i<strlen(str11); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str11[i]);
    }
    char str12[]="Ms. Megha Rani";
    glColor3f(1,0.3,1);
    glRasterPos2f(800,350);
    for(i=0; i<strlen(str12); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str12[i]);
    }
    char str13[]="Associate Professor";
    glColor3f(1,0.3,1);
    glRasterPos2f(800,300);
    for(i=0; i<strlen(str13); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str13[i]);
    }
    char str14[]="DEPT OF CSE";
    glColor3f(0,0,0);
    glRasterPos2f(800,250);
    for(i=0; i<strlen(str14); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str14[i]);
    }
    char str15[]="PRESS 'S' TO START";
    glColor3f(0,0,0);
    glRasterPos2f(390,30);
    for(i=0; i<strlen(str15); i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,str15[i]);
    }
    glFlush();
}


void init()

{
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glPointSize(5.0);
    glLineWidth(1.0);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0.0, 400.0, 0.0, 400.0);
}

int main(int argc, char** argv)
{
    //Initialize GLUT

    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowPosition(0,0);
	glutInitWindowSize(3200,1600);
    id1=glutCreateWindow("Dino 2D");
    init();
    glutDisplayFunc(display1);
    glutKeyboardFunc(key1);
    glutMainLoop();
    return 0;
}

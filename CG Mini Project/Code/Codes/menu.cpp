#include <GL/freeglut.h>
#include <string>

// Window dimensions
const int WINDOW_WIDTH = 800;
const int WINDOW_HEIGHT = 600;

// Button dimensions
const int BUTTON_WIDTH = 200;
const int BUTTON_HEIGHT = 50;

// Colors
GLfloat backgroundColor[3] = { 0.133f, 0.133f, 0.133f };  // #222222
GLfloat buttonColor[3] = { 0.4f, 0.4f, 0.4f };          // Dark gray
GLfloat textColord[3] = { 1.0f, 1.0f, 1.0f };
GLfloat textColorf[3] = { 0, 0, 0 };           

// Game variables
std::string currentGame = "dark.exe";
std::string currentTheme = "dark";

// Function to draw a button
void drawButton(int x, int y, const std::string& label, bool is3D)
{
    // Set button colors based on dimension
    GLfloat buttonColorTopLeft[3], buttonColorBottomRight[3];
    if (is3D) {
        buttonColorTopLeft[0] = 0.6f; buttonColorTopLeft[1] = 0.6f; buttonColorTopLeft[2] = 0.6f;  // Light gray
        buttonColorBottomRight[0] = 0.3f; buttonColorBottomRight[1] = 0.3f; buttonColorBottomRight[2] = 0.3f;  // Dark gray
    } else {
        buttonColorTopLeft[0] = buttonColorTopLeft[1] = buttonColorTopLeft[2] = 0.4f;  // Dark gray
        buttonColorBottomRight[0] = buttonColorBottomRight[1] = buttonColorBottomRight[2] = 0.4f;  // Dark gray
    }

    // Draw button background
    glBegin(GL_QUADS);
    glColor3fv(buttonColorTopLeft);
    glVertex2i(x, y);
    glColor3fv(buttonColorBottomRight);
    glVertex2i(x + BUTTON_WIDTH, y);
    glVertex2i(x + BUTTON_WIDTH, y + BUTTON_HEIGHT);
    glColor3fv(buttonColorTopLeft);
    glVertex2i(x, y + BUTTON_HEIGHT);
    glEnd();

    // Draw button label
    glColor3fv(textColorf);
    glRasterPos2i(x + 10, y + 20);
    for (char c : label) {
        glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, c);
    }
}



// Function to draw the menu
void drawMenu()
{
    glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);

    int centerX = (WINDOW_WIDTH - BUTTON_WIDTH) / 2;
    int centerY = (WINDOW_HEIGHT - BUTTON_HEIGHT) / 2;

    bool is3DButton = currentGame == "dark3d.exe" || currentGame == "light3d.exe";

    drawButton(centerX, centerY - 210, "1. START", is3DButton);
    drawButton(centerX, centerY - 140, "2. THEME", is3DButton);
    drawButton(centerX, centerY - 70, "3. DIMENSION", is3DButton);
    drawButton(centerX, centerY - 0, "4. QUIT", is3DButton);

    // Draw current selection at the bottom right
    glRasterPos2i(WINDOW_WIDTH - 120, 20);

    // Set text color based on the theme
    if (currentTheme == "dark") {
        glColor3f(1.0f, 1.0f, 1.0f);  // White
    } else {
        glColor3f(0.0f, 0.0f, 0.0f);  // Black
    }

    for (char c : currentGame) {
        glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, c);
    }

    glFlush();
    glutSwapBuffers();
}


// Function to handle keyboard input
void handleKeypress(unsigned char key, int x, int y)
{
    switch (key) {
        case '1':
            // Start current game
            system(currentGame.c_str());
            break;
        case '2':
            // Toggle background and theme
            if (currentTheme == "dark") {
                backgroundColor[0] = backgroundColor[1] = backgroundColor[2] = 0.867f;  // #dddddd
                currentTheme = "light";
                if (currentGame == "dark.exe")
                    currentGame = "light.exe";
                else if (currentGame == "dark3d.exe")
                    currentGame = "light3d.exe";
            }
            else {
                backgroundColor[0] = backgroundColor[1] = backgroundColor[2] = 0.133f;  // #222222
                currentTheme = "dark";
                if (currentGame == "light.exe")
                    currentGame = "dark.exe";
                else if (currentGame == "light3d.exe")
                    currentGame = "dark3d.exe";
            }
            break;
        case '3':
            // Toggle game dimension
            if (currentGame == "dark.exe")
                currentGame = "dark3d.exe";
            else if (currentGame == "dark3d.exe")
                currentGame = "dark.exe";
            else if (currentGame == "light.exe")
                currentGame = "light3d.exe";
            else if (currentGame == "light3d.exe")
                currentGame = "light.exe";
            break;
        case '4':
            // Quit the game
            exit(0);
            break;
    }

    glutPostRedisplay();
}

// Function to handle window resizing
void handleResize(int width, int height)
{
    glViewport(0, 0, width, height);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0, width, height, 0);
    glMatrixMode(GL_MODELVIEW);
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    glutCreateWindow("Game Menu");

    glutDisplayFunc(drawMenu);
    glutKeyboardFunc(handleKeypress);
    glutReshapeFunc(handleResize);

    glutMainLoop();
    return 0;
}

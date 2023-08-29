#include <GL/freeglut.h>
#include <string>

int screenWidth = 800;
int screenHeight = 608;
int theme = 0; // 0 for dark, 1 for light

void init()
{
    glClearColor(0.133f, 0.133f, 0.133f, 1.0f); // Background color #222222 (dark gray)
}

void drawText(float x, float y, const char *text, bool centered = false)
{
    if (centered)
    {
        int len = strlen(text);
        int width = glutBitmapLength(GLUT_BITMAP_HELVETICA_18, (const unsigned char *)text);
        x -= width / 2.0f;
    }

    glRasterPos2f(x, y);
    for (int i = 0; text[i] != '\0'; i++)
    {
        glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, text[i]);
    }
}

void drawButton(float x, float y, const char *text, bool active)
{
    float buttonWidth = 200.0f;
    float buttonHeight = 40.0f;
    float r, g, b;

    if (theme == 0) // Dark mode
    {
        r = 0.2f;
        g = 0.2f;
        b = 0.2f;
    }
    else // Light mode
    {
        r = 0.9f;
        g = 0.9f;
        b = 0.9f;
    }

    if (active)
    {
        r += 0.1f;
        g += 0.1f;
        b += 0.1f;
    }

    glColor3f(r, g, b);
    glBegin(GL_QUADS);
    glVertex2f(x, y);
    glVertex2f(x + buttonWidth, y);
    glVertex2f(x + buttonWidth, y + buttonHeight);
    glVertex2f(x, y + buttonHeight);
    glEnd();

    if (theme == 1) // Light mode
        glColor3f(0.0f, 0.0f, 0.0f); // Set button text color to black in light mode
    else
        glColor3f(1.0f, 1.0f, 1.0f); // Set button text color to white in dark mode

    drawText(x + 10.0f, y + 20.0f, text);
}

void display()
{
    glClear(GL_COLOR_BUFFER_BIT);

    // Draw buttons
    float buttonX = (screenWidth - 200.0f) / 2.0f;
    float buttonY = screenHeight / 2.0f + 60.0f;

    drawButton(buttonX, buttonY, "1. Bird", false);
    drawButton(buttonX, buttonY - 60.0f, "2. Dino", false);
    drawButton(buttonX, buttonY - 120.0f, "3. Theme", false);
    drawButton(buttonX, buttonY - 180.0f, "4. Quit", false);

    // Show Light/Dark theme label
    glColor3f(0.0f, 0.5f, 0.0f);
    drawText(screenWidth / 2.0f, screenHeight / 2.0f + 240.0f, "Choose a character to start game", true);
    drawText(screenWidth / 2.0f, screenHeight / 2.0f + 200.0f, (theme == 0) ? "Current Mode: Dracula" : "Current Mode: Helios", true);

    glutSwapBuffers();
}

void reshape(int width, int height)
{
    screenWidth = width;
    screenHeight = height;

    glViewport(0, 0, screenWidth, screenHeight);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0, screenWidth, 0, screenHeight);
    glMatrixMode(GL_MODELVIEW);
}

void keyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
    case '1':
        if (theme == 0)
            system("cd DarkThemeBird && start game.exe");
        else
            system("cd LightThemeBird && start game.exe");
        break;
    case '2':
        if (theme == 0)
            system("cd DarkThemeDino && start game.exe");
        else
            system("cd LightThemeDino && start game.exe");
        break;
    case '3':
        // Toggle theme and background color
        theme = 1 - theme; // Toggle theme (0 to 1, or 1 to 0)
        if (theme == 0)
        {
            glClearColor(0.133f, 0.133f, 0.133f, 1.0f); // Background color #222222 (dark gray)
        }
        else
        {
            glClearColor(0.824f, 0.824f, 0.824f, 1.0f); // Background color light gray
        }
        break;
    case '4':
        // Handle option 4 (Quit)
        exit(0);
        break;
    }
    glutPostRedisplay();
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(screenWidth, screenHeight);
    glutCreateWindow("TREX 3D - CG PROJECT");
    glutDisplayFunc(display);
    glutReshapeFunc(reshape);
    glutKeyboardFunc(keyboard);
    init();
    glutMainLoop();
    return 0;
}

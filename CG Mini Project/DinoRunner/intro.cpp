#include <GL/freeglut.h>
#include <string>

// Window size
const int windowWidth = 800;
const int windowHeight = 608;

// Text positions
const int titlePosX = windowWidth / 2 - 60;
const int titlePosY = 100;
const int subtitlePosX = windowWidth / 2 - 40;
const int subtitlePosY = titlePosY + 50;
const int leftTextPosX = 50;
const int leftTextPosY = windowHeight / 2 + 20;
const int rightTextPosX = windowWidth - 300;
const int rightTextPosY = windowHeight / 2 + 20;
const int bottomTextPosX = windowWidth / 2 - 70;
const int bottomTextPosY = windowHeight - 50;

// Colors
const GLfloat whiteColor[] = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat redColor[] = { 0.7f, 0.0f, 0.0f, 1.0f };
const GLfloat darkRedColor[] = { 0.8f, 0.2f, 0.1f, 1.0f };
const GLfloat greenColor[] = { 0.0f, 0.8f, 0.0f, 1.0f };

// Window ID
int windowId;

void drawText(const std::string& text, int posX, int posY, const GLfloat* color)
{
    glColor4fv(color);
    glRasterPos2i(posX, posY);

    for (const char& c : text) {
        glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, c);
    }
}

void display()
{
    glClear(GL_COLOR_BUFFER_BIT);

    // Draw background
    glClearColor(0.133f, 0.133f, 0.133f, 1.0f);

    // Draw title
    std::string titleText = "CG PROJECT";
    drawText(titleText, titlePosX, titlePosY, whiteColor);

    // Draw subtitle
    std::string subtitleText = "18CSL68";
    drawText(subtitleText, subtitlePosX, subtitlePosY, whiteColor);

    // Draw left text
    std::string leftTextLine1 = "Arjun Bhandari 4SF20CS017";
    std::string leftTextLine2 = "Kumar Rishav 4SF20CS054";
    std::string leftTextLine3 = "Project By";
    drawText(leftTextLine1, leftTextPosX, leftTextPosY + 60, redColor);
    drawText(leftTextLine2, leftTextPosX, leftTextPosY + 30, redColor);
    drawText(leftTextLine3, leftTextPosX, leftTextPosY, darkRedColor);

    // Draw right text
    std::string rightTextLine1 = "Asst. Prof., Dept. of CS&E";
    std::string rightTextLine2 = "Ms Megha Rani R";
    std::string rightTextLine3 = "Project Guide";
    drawText(rightTextLine1, rightTextPosX, rightTextPosY + 60, redColor);
    drawText(rightTextLine2, rightTextPosX, rightTextPosY + 30, redColor);
    drawText(rightTextLine3, rightTextPosX, rightTextPosY, darkRedColor);

    // Draw bottom text
    std::string bottomText = "Press 'S' to Start";
    drawText(bottomText, bottomTextPosX, bottomTextPosY, greenColor);

    glutSwapBuffers();
}

void reshape(int width, int height)
{
    glViewport(0, 0, width, height);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0, width, height, 0);
    glMatrixMode(GL_MODELVIEW);
}

void keyboard(unsigned char key, int x, int y)
{
    if (key == 's' || key == 'S') {
        // Start action

        glutDestroyWindow(windowId);  // Destroy the current window

        system("start menu.exe");  // Launch a different app

        exit(0);
    }
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE);
    glutInitWindowSize(windowWidth, windowHeight);
    windowId = glutCreateWindow("CG Project");  // Assign an ID to the window

    glutDisplayFunc(display);
    glutReshapeFunc(reshape);
    glutKeyboardFunc(keyboard);

    glutMainLoop();

    return 0;
}

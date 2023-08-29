## Game Compilation Guide

This guide provides instructions on how to compile the game code and the main menu using the provided commands.

### Game Code Compilation

To compile the game code, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the directory containing the game source code.
3. Use the following command to compile the game code:

   ```shell
   gcc -o ../Executables/progname.exe progname.c -lfreeglut -lopengl32 -lglu32 -lm
   ```

   Replace `progname` with the name of your game's source code file.

4. After successful compilation, the executable file `progname.exe` will be created in the "Executables" folder.

### Main Menu Compilation

To compile the main menu, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the directory containing the main menu source code.
3. Use the following command to compile the main menu:

   ```shell
   gcc -o ../menu.exe menu.c -lfreeglut -lopengl32 -lglu32 -lm
   ```

4. After successful compilation, the executable file `menu.exe` will be created in the current directory.

**Note:** Make sure you have the necessary dependencies installed and replace `progname.c` and `menu.c` with the actual filenames of your game and main menu source code files respectively.<br/>
**Note:** You need to have the res folder with all needed pbm (portable bitmap) format assets in the Executables folder to be linked during runtime.<br/>
**Note:** This code is made for Windows as the target machine; changes like createProcess->fork etc might be needed to migrate. Please use a converter for cross platform execution.<br/>

Once you have compiled both the game code and the main menu, you can run the MENU executable file to enjoy your game.


`Commands used in "Code" folder:`

   ```shell
   g++ -o ../Executables/menu.exe menu.cpp -lfreeglut -lopengl32 -lglu32 -lm
   g++ -o ../Executables/dark3d.exe dark3d.cpp -lfreeglut -lopengl32 -lglu32 -lm
   g++ -o ../Executables/light3d.exe light3d.cpp -lfreeglut -lopengl32 -lglu32 -lm
   g++ -o ../Executables/dark.exe darkmenu.cpp -lfreeglut -lopengl32 -lglu32 -lm
   g++ -o ../Executables/light.exe lightmenu.cpp -lfreeglut -lopengl32 -lglu32 -lm
   gcc -o ../Executables/lightdino.exe lightdino.c -lfreeglut -lopengl32 -lglu32 -lm
   gcc -o ../Executables/darkdino.exe darkdino.c -lfreeglut -lopengl32 -lglu32 -lm
   ```

`Commands used in "Executable" folder:`

   ```shell
   menu.exe
   ```

**Note:** This has been run via CMD to enable debug lines (prevent immidiate crashes).<br/>
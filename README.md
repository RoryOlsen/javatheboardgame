Java the Board Game
================

An implementation of the 2000 board game Java (not related to the programming language). This project is based on an assignment from an OOP course from the University of Florida.

<a href="http://www.cise.ufl.edu/~dts/cop4331/iter1.html">Link to project assignment.</a>

The game will support 2 - 4 players. Each taking their turns using Action Points to build villages, palaces, irrigation systems, and rice fields. When attempting to place a game tile on the board, a highlighting overlay covers the area of the board affected. This highlighted tile can be moved and rotated before being placed.

The scoring and game rules are currently not supported and are up to the players to follow the rules. The rule book can be downloaded from <a href="http://riograndegames.com/Game/312-Java">Rio Grande's Website.</a>

This is a work still in progress on iteration 1.

To run the program use the following command (replacing ```out``` with your class output directory):
```
java -cp ./lib/jline-1.0.jar:./lib/hamcrest-core-1.3.jar:./out/production/JavaTheBoardGame com.roryolsen.java.view.Screen
```



Architecture & Design
---------------------
The game uses a console-based graphical interface built using a MVC architecture. 

### View
The view employs the Decorator design pattern. Decorators include: a border decorator that draws a character border around a decorated view, a region decorator that lets a small region of a view to act as it's own view (this allows the console to be split into regions for the board, game stats, and the controller output), and a scroll decorator that enables the board can be independently scrolled to view all game spaces.

All of the decorators are instances of ```View``` which has a ```draw``` method that writes to a particular position on the screen using cartesian coordinates. The ```Screen``` class extends ```View``` and prints the character data to the console output.

### Controller
The ```GameController``` activates and deactivates other ```Controller```s and delgates input to the appropriate ```Controller```. When a key is pressed, the ```GameController``` delegates the keypress to the most recently active ```Controller``` that accepts the key pressed. Typically, the active ```Controller``` writes instructions to the screen. Most ```Controller```s accept input of numbers keys to take action and navigate submenus

### Model
The model represents the functioning parts of the game. The main classes are:
- ```Game``` - Tracks the ```Board``` and the current ```Turn``` 
- ```Board``` - Contains a ```Map``` of the ```BoardSpace```s and their ```Coordinate```s
- ```BoardSpace``` - Has information such as the height of the current space and it's ```TerrainType```
- ```Turn``` - ```Player```s use Action Points to place ```GameTile```s on the ```Board``` during their ```Turn```
- ```Player``` - Keeps each ```Player```'s score and their player number (1-4)
- ```GameTile``` - Information about the ```TerrainType```s that they are made up of. There are three types of ```GameTiles```s that are different sizes (1, 2, and 3 ```BoardSpace```s).

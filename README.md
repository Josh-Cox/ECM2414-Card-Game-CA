# Automatic Card Game
This is an automatic card game that is played via command line.\
Pair programming coursework developed by Josh Cox and Dora Napier.\
<br>

## Game Logic
There is *n* number of players and decks, each containing 4 cards *(and therefore a pack containing 8n cards)*\
Each player picks up and discards one card per turn until any player holds 4 cards of the same number, at which they have won the game. The players are taking their turns simultaneously *(throught he use of threading)* and output the card they pickup and discard to their `player_output.txt` file, along with their current hand. These files will also contain the player's initial hand, final hand and the winning player number.\
<br>

## Run the source code

1. Use a command line/terminal to navigate to the location you downloaded the project
1. Navigate to the folder 'classes' using `cd ECM2414-Card-Game-CA/card-game/target/classes`
1. Run the command `java cards/CardGame`
1. Enter the number of players when promtped *(e.g. '4')*
1. Enter the name and full path of the pack file when prompted *(enter only the filename, e.g. 'C:/example' not 'C:/example.txt')*

The game will then run and display the winner in the console, aswell as writing to all player and deck files, which can be found in the same 'classes' folder'\
<br>

## Run the JAR
1. Use a command line/terminal to navigate to the location you downloaded the cards.jar
1. Run the command `java -jar cards.jar`
1. Enter the number of players when promtped *(e.g. '4')*
1. Enter the name and full path of the pack file when prompted *(enter only the filename, e.g. 'C:/example' not 'C:/example.txt')*

The game will then run and write to all player and deck files, which can be found in the same folder the jar is located
<br>

## Run the Test Suite
To run the test suite you will either need to install apache maven, or open the project in vscode and make use of the Test Runner Extension

### Maven 
1. Download the [apache-maven zip](https://maven.apache.org/download.cgi)
1. Follow the instructions [here](https://maven.apache.org/install.html) for your
respective operating system
1. Use a command line/terminal to navigate to the location you downloaded the project
1. Navigate to the 'card-game' folder using `cd ECM2414-Card-Game/card-game`
1. Run the test suite using `mvn clean test`

This will run the 'MainTestSuite' which includes all unit tests.

### Visual Studio Code
1. Download [VSCode](https://code.visualstudio.com/download) for your respective operating system
1. Open the 'ECM2414-Card-Game' folder in VSCode
1. In extensions install 'Extension Pack for Java'

![Extension Pack](/card-game/resources/Extension%20Pack.png)

4. Enter the 'Testing' menu via the button in the left menu
1. Press run on 'MainTestSuite' (located under 'card-game/cards')

![Test Suite](/card-game/resources/Test%20Suite.png)

This will run the 'MainTestSuite' which includes all unit tests.

<br>

---

|           |                         |
| :-------: |:-----------------------:|
|      ```Author```     |     Josh Cox & Dora Napier   |
|     ```License```     |        MIT       |
|   ```Source Code```   |     https://github.com/Josh-Cox/ECM2414-Card-Game    |
|           |                         |

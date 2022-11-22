# Automatic Card Game
This is an automatic card game that is played via command line.\
Pair programming coursework developed by Josh Cox and Dora Napier.\
<br>

## Game Logic
There is *n* number of players and decks, each containing 4 cards *(and therefore a pack containing 8n cards)*\
Each player picks up and discards one card per turn until any player holds 4 cards of the same number, at which they have won the game. The players are taking their turns simultaneously *(throught he use of threading)* and output the card they pickup and discard to their `player_output.txt` file, along with their current hand. These files will also contain the player's initial hand, final hand and the winning player number.\
<br>

## Run the source code
To run the game using the source code, first ensure that your .txt pack file is located in the folder called `resources` *(which is located in the root folder)* and has the correct amount of cards for the desired number of players *(8n)*.

1. Use a command line/terminal to navigate to the root folder `ECM2414-Card-Game`
2. Run the command `javac -d bytecode src/CardGame.java`
3. Navigate to the bytecode folder `cd bytecode`
4. Run the command `java src/CardGame`
5. Enter the number of players when promtped *(e.g. '4')*
6. Enter the name of the pack file when prompted *(enter only the filename, e.g. 'example' not 'example.txt')*

The game will then run and display the winner in the console, aswell as writing to all player and deck files.\
<br>




|           |                         |
| :-------: |:-----------------------:|
|      ```Author```     |     Josh Cox & Dora Napier   |
|     ```License```     |        MIT       |
|   ```Source Code```   |     https://github.com/Josh-Cox/ECM2414-Card-Game    |
|           |                         |

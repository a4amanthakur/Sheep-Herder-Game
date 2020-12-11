# Sheep-Herder-Game

Create a game called Sheep Herder. The idea of the game is to herd the sheep (find) before the sheep are eaten. Simply put, the user chooses spots in a grid and if it is a sheep, the sheep was herded. 

In the game there will also be a dog and a wolf. 
If found, the dog will help in two ways:      
  1. Give the user an extra turn.     
  2. Fight the wolf if the wolf attacks you.  
  
  If found, the wolf will attack you and you will lose unless you already found the dog.  

All animals have a random strength value (str). This will come in to play when the dog defends you from the wolf or the wolf bumps into the dog. Say the Dog str = 10 and the wolf’s str = 8. Well your dog would win and survive with only 2 left over and the poor wolf dies. But what if it was vise versa? Your dog would have died and the wolf survives with str = 2. But happily you still survive in either scenario. Now the game starts and the computer creates a 5x5 grid and randomly chooses a coordinate to put the sheep, dog and wolf. Normally the user cannot see where they are but for this assignment I want to be able to see all of them for testing purposes. Make it similar to the example provided below. In each turn the user gets to choose a coordinate and then the wolf moves. You get to decide how smart that wolf is. Does it move by smell or random? But if that wolf hits the sheep, the sheep is no more and the game ends. The game has to be similar to what I said but you can change it up to make it better if you wish. If I see a smart wolf (AI) you would get better marks... Lastly add levels. Be sure to use JOptionPane, Switches, Loops, StringBuilder, and arrays. There should be at least three classes created. I created six classes to create this game (SheepHerder.java, Player.java, Grid.java, Coordinate.java, Call.java and Animal.java). Make it user friendly with a smart AI and OOP (meaning almost no code in the main method)! You will use this program again in the Intermediate Java course if you take it, so don’t delete it.

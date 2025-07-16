# 20250718_Project

#### Objective: 

Create a text adventure game entirely in Java, played by running your program in a terminal/console. This game will guide the player through several scenes and take player input via the console or command line — think of classic text adventures like Adventure or Zork. You will present the player with several scenes, described to them in text, then allow them to make choices and determine the outcome. All feedback to the player should be printed to the console, and their choices should lead them to some sort of endgame conclusion — win, lose, live, die...or something in between!


------------------------ 

#### Technical Requirements:


- Application is written in Java 17
- Must be playable entirely in the console or through the command line
- Obtains user input through the Scanner class
- Must incorporate a Player class containing pertinent player properties
    - Examples include:
        - Health Points (HP)
        - Strength
        - Wisdom
        - Magic
        - Player Experience Level
- Upon program start, prompt the user to create their specific player object by choosing their property values or allow chance to decide
- Must include a Scene class that includes information and data on the scene
- Scenes should take into account the player’s specific properties during the scene event
- Game must include a minimum of 5 possible scenes
- Game must include at least 2 distinct game end scenarios
- Code should compile and run
- Code should conform to standard naming conventions and coding best practices
- All necessary files should be present on a public GitHub repository by the due date

------------------------ 

#### Game Description
Overview: 
- It is 1912 and you have just aboarded the RMS Titanic! Let's see if you can survive this passage.

Character Profiles: 
- Ticket Holders: 1st Class, 2nd Class, and 3rd Class.

Scenes: 
- 5

------------------------ 

#### Files in GitHub:
20250718_Project/src/com/skillstorm
- PlayGame.java
- Profiles.java
- SceneScoreArray.java

#### **-- PlayGame.java --**

File to run/play the game. It holds the PlayGame class methods.

- Methods:
  - inputChoice: allows user to input choice
  - playGame: allows user to play the game

#### **--- Profiles.java ---**

File that stores the following: Profiles methods, and Profile class, properties, and methods.

- Profiles class Methods:
  - userNameInput: get user's name
  - userProfileInput: get user's Profile selection
 
- Profile class:
  - Blue print of a game character profile
    
  - Properties:
    - ticketClass
    - name
    - money
    - surivalSkills
    - swim
    - survivalScoreList
    - backStory
      
  - Methods:
    - info: print out profile object's properties
    - setBackStory: sets the backStory property
    - calcSurvival: calculates the survival by taking the sum of an integer array

 
#### **--- SceneScoreArray.java ---**

File that stores the following: SceneScoreArray class methods, Scene class properties and methods.

- SceneScoreArray Methods:
  - createArrayInt2By3: create an 2 by 3 (2 rows by 3 columns) array
  - printArrayInt2by3: print out a 2 dimensional array
  - createScoreArrays: creates an array of score points for every scene(the array of score points does take into account of each traveler class)
  - createScenes: create an array of scene objects
 
- Scene class:
  - Blue print of a game scene
 
  - Properties:
    - sceneNumber
    - sceneLocation
    - sceneDescription
    - inputFeedback1
    - inputFeedback2
    - scenePointArray
   
  - Methods:
    - toString: print out scene object's properties
    - getSceneNumber
    - getSceneLocation
    - getSceneDescription
    - getInputFeedback
    - getScenePointArray
    - getScore
    - addScore: adds a score to profile object's array

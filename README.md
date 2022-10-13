# toy-bot

Many thanks to [Lorenzo Sisini](https://github.com/lorenzosisini) for this beautiful experience.


#### Requirements
- maven 3
- openjdk 17

#### Quick start
- clone the repository
```bash
git clone https://github.com/poweronoff/toy-bot.git
```
- build the project
````bash
mvn clean package
````
- run it
```bash
java -jar target/de.dj_steam.toybot-<version>-jar-with-dependencies.jar
```

#### Toy-Bot Reference
```bash
Commands:
PLACE X,Y,F - place robot on position X,Y - coordinates, and direction (NORTH|SOUTH|WEST|EAST)
MOVE - move the robot to the next field in facing direction
LEFT - turn the robot to the left
RIGHT - turn the robot to the right
REPORT - show robots position and facing direction
exit - exit the application
```

#### Further plans and implementation road
- refactoring and rework MoveStrategy
- implement JUMP command
- implement TURN_AROUND command
- user interface
- add random pitfalls or barriers to the field



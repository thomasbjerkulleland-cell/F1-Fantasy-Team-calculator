# F1 Fantasy Team calculator (Gridrivals)
### Driver points and cost updated after: Mexican GP 2025
A java-based calculator to help with picking the best team you can based on your current budget. The program looks at driver's current average points over the season and their current cost, and creates the teams with the highest combined average points per weekend. 

## Current features
1. The program can be run with no options configured. This will use the hardcoded balance, which was my balance at the time of my last commit. You should **at least** update the program to your own salary before running it with this option.
2. Change the salary to be used. This should always be done to get a meaningful output, unless you changed the hardcoded value in **Calculator.java**. If you would like to insert 120 million as your budget, the accepted formats are 120000000, 120 000 000 and 120.000.000.
3. Here you can list what drivers you already own if you already have a partially built up team, or want to experience with demanding a certain drivers be included in your team. The format is the drivers lastnames being separated by spaces, for example: piastri leclerc hadjar. **Capitalization is not considered**
4. Here you can lock what contructor your team should contain if you already have one locked in, or if you want all teams generated to use this constructor. **Capitalization is not considered**
5. Here you can list what drivers the program should **not** consider, either because their contract is on a 1-race lockout or because you dont want them on your team. The format is the drivers lastnames being separated by spaces, for example: piastri leclerc hadjar. **Capitalization is not considered**
6. Here you can specify a constructor to not be considered, either because their contract is on a 1-race lockout or because you dont want them on your team. **Capitalization is not considered**

At any time you can input 'q' from the configuration window to exit the program. When you are done configurating you press 1 to run with the settings you put in.

## Execution (Mac users read carefully)
To quickly run the program, windows users can just run the "Compile and run.bat" file. This files runs:
```
mvn clean package
```
but only if the program actually needs to be compiled again, for example if any changes has been made to a .java file (like changing hardcoded balance). If a compilation is not necessary, the Calculator is executed right away. 

**Mac users** should ignore this .bat file and run these two commands from the commandline to imitate the same process:
```
mvn clean package
java -cp target\calculator-run.jar Calculator
```
The first one can be left out if you are sure it's not needed, but for the first execution it **must** be included since there won't be any .class files without it.
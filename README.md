[![Travis](https://travis-ci.org/wurstwasser40k/YooLoo_SoftwareEngineering.svg?branch=master)

YooLoo in Scala
=========================

This is the YooLoo-Game created as a scala project as used in the
class Software Engineering at the University of Applied Science HTWG Konstanz

* Has a folder structure prepared for a MVC-style application:
* Has *ScalaTest* and *ScalaMock* at their latest versions as dependencies.
* Has *sbt-scalariform*, *sbt-scapegoat*, *scalastyle-sbt-plugin* and *sbt-scoverage* sbt plugins
* Has .gitignore defaults

yooloo the game
---------------------------
This project is a playable game of Yooloo https://www.yooloo.cool/yooloo/. The rules are simplified for this version.

Why
-------------
The project was developed for the
class Software Engineering at the University of Applied Science HTWG Konstanz.

This implementation has a MVC architecture and a GUI and a TUI

Documentation
-------------

How
---------------
To play using the GUI:
- Enter name of player in the console, separated by pressing enter.
- When you´re read to play, press f and the gui starts.

To play using the TUI:

   1. Enter name of players                                   -> press any String, may contain more than two characters
  2. ready eintering name of player                           -> press 'f'
  3. filling cards of each player                             -> Int between 1 - 9
  4. next player filling cards                                -> c
  5. Evaluate points (current state, total state)             -> e
  6. new game                                                 -> n
  7. quit                                                     -> q



.


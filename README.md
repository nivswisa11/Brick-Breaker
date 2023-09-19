# Brick-Breaker


<img width="400" height="300" alt="Image" src="https://github.com/nivswisa11/Brick-Breaker/assets/116805263/07e23cd3-7cc1-4558-a4d1-6aa0dc6a1b09">
<img width="400" height="300" alt="Image" src="https://github.com/nivswisa11/Brick-Breaker/assets/116805263/62166232-14a7-4f4e-9f75-a87f8554eacf">
<img width="400" height="300" alt="Image" src="https://github.com/nivswisa11/Brick-Breaker/assets/116805263/7a0f66af-38da-494e-8921-d6df9c2e0cdf">
<img width="400" height="300" alt="Image" src="https://github.com/nivswisa11/Brick-Breaker/assets/116805263/d103985d-e603-4460-a5c1-4517d21d3af5">


## About

Welcome to the **Arkanoid Game**, an exciting implementation created as part of an Object-Oriented Programming (OOP) course during my bachelor's degree. This classic Arkanoid game brings back the nostalgia of breaking bricks while incorporating modern game design principles. Explore various levels with increasing difficulty, all presented in a user-friendly graphical interface.

## Key Features

- **Engaging Gameplay**: Enjoy classic Arkanoid gameplay with a modern twist. Break bricks, progress through levels, and challenge your reflexes.

- **Multiple Levels**: Test your skills across a range of levels, each with its unique layout and challenges. The difficulty increases as you advance.

- **User-Friendly GUI**: Immerse yourself in a visually appealing graphical user interface (GUI) that enhances your gaming experience. The game is designed with user-friendliness in mind.

- **Flexible Object-Oriented Design**: The game leverages powerful OOP principles to create dynamic and extensible gameplay. Explore polymorphism and inheritance in action.

- **Efficient Data Structures**: Discover the use of various data structures, including linked lists and array lists, to manage game elements efficiently.

## Object-Oriented Programming (OOP) Principles

### Polymorphism and Inheritance

The core of the game's architecture is built upon the principles of **polymorphism** and **inheritance**. These OOP concepts allow for the creation of a diverse set of game objects that share common characteristics and behaviors. For instance, the game models various game elements, such as balls, blocks, and paddles, as objects that inherit from a common base class. This inheritance hierarchy simplifies the codebase and promotes code reusability.

### Abstraction and Encapsulation

**Abstraction** is achieved by defining abstract classes and interfaces, which serve as blueprints for different game components. By encapsulating the essential properties and behaviors of these components within their respective classes, the code remains organized and self-contained. For example, the `LevelInformation` interface acts as a contract for creating different levels of the game, ensuring a consistent interface for all levels.

## How to Play

- **Controls**: Use the 'Left' and 'Right' arrow keys to control the paddle's movement.

- **Pause**: Press 'P' to pause the game at any time.

- **Resume**: Press 'Space' to resume playing after pausing.

- **Objective**: Your goal is to pop all the blocks on the screen. Progress through the game until victory or try again if you lose.

## Getting Started

### Running the Game

You can run the game using one of the following methods:

1. **Apache Ant**: Download the source code to any folder, open the terminal in the main folder, and run the following commands:
ant // This command builds the game
ant run -Dargs="{levels}" // Replace "{levels}" with the levels you want to load (e.g., "1 3 4").

2. **Opening Project From IDE**: Download the source code and open the project from your integrated development environment (IDE). Rebuild the project.

Get ready to embark on an exciting journey through the world of Arkanoid. Have fun and break those bricks!

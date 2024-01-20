# Code Improvement To-Do List

## Structural Improvements
- [x] **Refactor Code into Multiple Files**: Instead of having everything in a single file, organize the code into multiple files with each file dedicated to a specific class or a closely related set of functionalities.

## Ship Class Refinements
- [ ] **Remove Setters for Position and Direction**: Consider initializing the position and direction of a ship through the constructor or a dedicated method like `placeOnBoard(position, direction)`.
- [ ] **Reevaluate Ship's State Management**: Assess if the ship really needs to hold its position and direction, or if this information can be managed elsewhere, possibly within the board context.
- [ ] **Revise Default Ship Position**: Address the inconsistency in the default position of ships (currently 0-based) to align with the 1-based positioning system used in the game map.

## Board Class Enhancements
- [ ] **Introduce Logic to Board Class**: Add relevant game logic to the Board class, such as methods for checking if a ship is sunk or if any ship is placed at a specific position.
- [ ] **Decouple Rendering Logic**: Separate rendering logic from the Board class to facilitate different rendering implementations (e.g., console-based, HTML-based) without duplicating logic.

## Adherence to Law of Demeter
- [ ] **Review Code for Law of Demeter Compliance**: Inspect the code for instances where the Law of Demeter might be violated (e.g., using multiple dots in a single line).

## Player Class Reconsideration
- [ ] **Reevaluate the Necessity of Player Class**: Determine if the Player class is essential or if it can be replaced by directly using the Board class.

## Naming Conventions
- [ ] **Renaming**: Consider renaming `renderGameMap` to `renderGameRow` if it more accurately describes the function's purpose.

## Equals and Hashcode Methods
- [ ] **Utilize Frameworks for Equals/Hashcode**: Explore using frameworks like Apache Commons Lang's EqualsBuilder for more efficient equals and hashcode method implementations.

## Game Logic and Business Rules
- [ ] **Implement Game Constraints**: Add logic to handle game constraints such as preventing ship overlap, ensuring ships are placed within the 10x10 grid, and maintaining space between ships.
- [ ] **Add Game Completion Logic**: Include logic to determine when the game is finished and who the winner is.

---

## Testing
- [ ] **Increase Test Coverage**: Ensure thorough testing of the newly introduced logic, constraints, and structural changes.

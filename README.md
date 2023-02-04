# RSBlueprintBuddy

RSBlueprintBuddy lets you save and load schematics into the world.

## Tutorial

The main command is "/blueprint" or just "/bp".

### Saving schematics

To save schematics you first need to select the two end-positions using "/blueprint first/second \<x\> \<y\> \<z\>".
\<x\>, \<y\> and \<z\> represent the coordinates for the position to be selected. Use "/bp first" to save the coordinates as the first selection and "/bp second" to save the coordinates as the second selection.

Then, you can use "/blueprint save \<name\>" to save the schematic with the name \<name\>. If the schematic \<name\> already exists, use "/blueprint update \<name\>" to overwrite the existing schematic.

### Loading schematics

To load a schematic into the world you can use "/blueprint load \<x\> \<y\> \<z\>" to place it at the given coordinates or use "/blueprint load" to place it at the current coordinates where the player is standing.

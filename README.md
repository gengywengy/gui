# GUI Library
Kotlin based GUI library made for ease of use with the spigot api.
## How to include
### Maven
```xml
<dependency>
    <groupId>dev.gengy</groupId>
    <artifactId>gui</artifactId>
    <version>0.1.0</version>
</dependency>

```
### Gradle KTS
```kts
implementation("dev.gengy:schematics:0.1.0")
```
### Gradle
```groovy
implementation 'dev.gengy:schematics:0.1.0'
```
## How to use
### Kotlin Usage
Create a GUI
```kotlin
class ExampleGUI : BasicInventory() {
    override fun onOpen(player: Player) {
        inventory {
            size = Inventory.Size.THREE_ROWS // Set GUI height

            item {
                material = Material.PAPER
                displayName = "Example Item"
                amount = 1
                slot = 4
            }

            item {
                material = Material.REDSTONE
                displayName = "Close Menu"
                amount = 1
                slot = 0
            }
        }
    }
}
```
Open the GUI for the player
```kotlin
    player.openInventory(ExampleGUI()) // player must be of type org.bukkit.entity.Player
```
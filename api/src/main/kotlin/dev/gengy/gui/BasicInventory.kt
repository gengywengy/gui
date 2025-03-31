package dev.gengy.gui

import dev.gengy.gui.item.InventoryItem
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.InventoryView

abstract class BasicInventory : Inventory {
    var meta: BasicInventoryMeta = BasicInventoryMeta()
    val items: MutableList<InventoryItem> = mutableListOf()
    private var inventory: org.bukkit.inventory.Inventory? = null

    abstract fun onOpen(player: Player)
    open fun onClose(player: Player) {}
    open fun onTick(player: Player) {}

    inner class BasicInventoryMeta(
        var size: Inventory.Size = Inventory.Size.ONE_ROW,
    )

    inline fun inventory(meta: BasicInventoryMeta.() -> Unit) {
        this.meta = BasicInventoryMeta().apply(meta)
    }

    inline fun item(material: Material = Material.AIR, itemData: InventoryItem.() -> Unit) {
        items.add(InventoryItem(
            material = material
        ).apply(itemData))
    }
    fun item(item: InventoryItem) {
        items.add(item)
    }

    internal fun show(player: Player): InventoryView? {
        onOpen(player)
        inventory = Bukkit.createInventory(null, meta.size.invSize)

        items.forEach {
            it.fill(inventory!!)
        }
        Bukkit.getPluginManager().registerEvents(GUIListener(), GUI.instance)
        return player.openInventory(inventory!!)
    }

    internal inner class GUIListener : Listener {
        @EventHandler
        fun onInventoryClick(e: InventoryClickEvent) {
            if (e.view.topInventory != this) return
            items.find {
                it.slots.contains(e.slot)
            }?.runClick(e)
        }

        @EventHandler
        fun onClose(e: InventoryCloseEvent) {
            inventory = null
            HandlerList.unregisterAll(this)
        }
    }
}
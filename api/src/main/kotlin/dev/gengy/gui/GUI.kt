package dev.gengy.gui

import org.bukkit.plugin.java.JavaPlugin

class GUI private constructor() {
    companion object {
        internal lateinit var instance: JavaPlugin
        fun build(plugin: JavaPlugin): GUI {
            instance = plugin

            return GUI()
        }
    }

    // NOTE: Not sure if this will be needed
    fun register(inventory: BasicInventory) {

    }
}
package dev.gengy.gui

interface Inventory {

    enum class Size {
        ONE_ROW {
            override val invSize = 9
        },
        TWO_ROWS {
            override val invSize = 18
        },
        THREE_ROWS {
            override val invSize = 27
        },
        FOUR_ROWS {
            override val invSize = 36
        },
        FIVE_ROWS {
            override val invSize = 45
        },
        SIX_ROWS {
            override val invSize = 54
        };

        internal abstract val invSize: Int
    }
}
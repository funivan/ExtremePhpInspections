package com.funivan.php.extremePhpInspections

import java.util.*

class Emojii {
    private val items = listOf(
            /* 👎 */ "\uD83D\uDC4E",
            /* 😲 */ "\uD83D\uDE32",
            /* 😡 */ "\uD83D\uDE21",
            /* 😤 */ "\uD83D\uDE24",
            /* 😭 */ "\uD83D\uDE2D",
            /* 😢 */ "\uD83D\uDE22"
    )
    private val rand = Random()

    override fun toString(): String {
        return items[rand.nextInt(items.size)]
    }
}
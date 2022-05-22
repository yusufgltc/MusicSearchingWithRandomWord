package com.example.android.musicsearchingwithrandomword.network.models

/**
 * Random word
 * This data class is used by Moshi to match the names of values in JSON.
 * @property word
 * @property definition
 * @property pronunciation
 * @constructor Create empty Random word
 */
data class RandomWord(
    val word: String,
    val definition: String,
    val pronunciation: String
)
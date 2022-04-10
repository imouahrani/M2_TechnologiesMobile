package com.github.imouahrani.breakingbad.characters

import com.github.imouahrani.breakingbad.data.CharacterModel

interface CharacterSelectionHandler {
    fun onCharacterClicked(character: CharacterModel)
}
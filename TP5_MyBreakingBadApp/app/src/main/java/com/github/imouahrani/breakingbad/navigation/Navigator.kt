package com.github.imouahrani.breakingbad.navigation

import com.github.imouahrani.breakingbad.core.livedata.LiveEvent
import com.github.imouahrani.breakingbad.data.CharacterModel

class Navigator {

    val onNavigateCharacterDetails = LiveEvent<CharacterModel>()

    val onNavigateAppearanceFilter = LiveEvent<Unit>()
}
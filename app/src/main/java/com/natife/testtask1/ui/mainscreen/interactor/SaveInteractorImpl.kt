package com.natife.testtask1.ui.mainscreen.interactor

import android.content.SharedPreferences
import com.natife.testtask1.base.BaseInteractor
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.utils.PreferenceHelper.id

class SaveInteractorImpl(
    private val preferences: SharedPreferences
) : BaseInteractor<MainIntent, MainState> {

    override fun invoke(intent: MainIntent, state: MainState): MainIntent {
        return when (intent) {
            is MainIntent.SaveId -> {
                preferences.id = intent.id
                MainIntent.SaveId(intent.id)
            }
            else -> MainIntent.Nothing
        }
    }
}

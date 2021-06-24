package com.natife.testtask1.ui.mainscreen.interactor

import android.content.SharedPreferences

interface MainInteractor<Intent, State> {

     fun invoke(intent: Intent, state: State): Intent
     fun saveId(intent: Intent, state: State, id : Int, preferences: SharedPreferences ): Intent

}

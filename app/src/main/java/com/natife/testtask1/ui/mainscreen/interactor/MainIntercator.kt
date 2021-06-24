package com.natife.testtask1.ui.mainscreen.interactor

interface MainInteractor<Intent, State> {

    operator fun invoke(intent: Intent, state: State): Intent

}

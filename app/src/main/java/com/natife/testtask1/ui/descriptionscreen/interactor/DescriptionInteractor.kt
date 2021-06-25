package com.natife.testtask1.ui.descriptionscreen.interactor

interface DescriptionInteractor<Intent, State> {
    operator fun invoke(intent: Intent, state : State): Intent
}

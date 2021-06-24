package com.natife.testtask1.ui.descriptionscreen.interactor

/**
 *@author admin
 */
interface DescriptionInteractor<Intent, State> {
    operator fun invoke(intent: Intent, state : State): Intent
}

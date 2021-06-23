package com.natife.testtask1.test

/**
 *@author admin
 */
interface Interactor<Intent, State> {

    operator fun invoke(intent: Intent, state: State): Intent

}

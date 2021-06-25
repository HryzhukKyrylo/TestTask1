package com.natife.testtask1.base

interface BaseInteractor<Intent, State> {
    operator fun invoke(intent: Intent, state : State): Intent
}

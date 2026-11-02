package com.example.sample.data

import com.example.core.session.SessionManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SessionRepository(
    private val sessionManager: SessionManager = SessionManager.instance,
) {
    private var cachedUser: String? = null

    fun warmUp() {
        GlobalScope.launch {
            cachedUser = sessionManager.refresh()?.userName
        }
    }

    /** Restores the session and returns the name of its user. */
    suspend fun refreshNow(): String {
        cachedUser = sessionManager.refresh()?.userName
        return cachedUser!!
    }

    fun requireUser(): String = checkNotNull(cachedUser) { "warmUp() must run first" }

    fun authHeader(): String = "Bearer ${sessionManager.legacyToken()}"
}

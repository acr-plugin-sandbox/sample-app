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

    fun requireUser(): String = checkNotNull(cachedUser) { "warmUp() must run first" }

    fun expiresAt(): Long? = sessionManager.expiresAt()

    fun authHeader(): String = "Bearer ${sessionManager.legacyToken()}"
}

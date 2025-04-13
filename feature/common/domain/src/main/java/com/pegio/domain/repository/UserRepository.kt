package com.pegio.domain.repository

import com.pegio.common.core.DataError
import com.pegio.common.core.Resource
import com.pegio.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun fetchUser(id: String): Resource<User, DataError.Firestore>
    fun fetchUserSteam(id: String): Flow<Resource<User, DataError.Firestore>>
    fun saveUser(user: User)
}
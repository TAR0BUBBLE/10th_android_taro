package com.example.week03_taro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val PROFILE_USER_ID = 1

sealed interface ProfileUiState {
    data object Loading : ProfileUiState

    data class Success(
        val profileUser: ReqresUserDto,
        val followingUsers: List<ReqresUserDto>
    ) : ProfileUiState

    data class Error(
        val message: String
    ) : ProfileUiState
}

class ProfileViewModel(
    private val repository: ReqresRepository = ReqresRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading

            val profileResult = repository.getUserById(PROFILE_USER_ID)
            val followingResult = repository.getUsers(page = 1)

            val profileUser = profileResult.getOrElse { throwable ->
                _uiState.value = ProfileUiState.Error(
                    message = throwable.message ?: "프로필 정보를 불러오지 못했습니다."
                )
                return@launch
            }

            val followingUsers = followingResult.getOrElse { throwable ->
                _uiState.value = ProfileUiState.Error(
                    message = throwable.message ?: "팔로잉 목록을 불러오지 못했습니다."
                )
                return@launch
            }

            _uiState.value = ProfileUiState.Success(
                profileUser = profileUser,
                followingUsers = followingUsers
            )
        }
    }
}

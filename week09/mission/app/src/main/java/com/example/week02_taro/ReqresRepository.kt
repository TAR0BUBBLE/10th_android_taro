package com.example.week03_taro

class ReqresRepository(
    private val service: ReqresService = ReqresApiClient.service
) {

    suspend fun getUserById(userId: Int): Result<ReqresUserDto> {
        return try {
            val response = service.getUserById(userId)

            if (response.isSuccessful) {
                val user = response.body()?.data

                if (user != null) {
                    Result.success(user)
                } else {
                    Result.failure(Exception("사용자 정보가 비어 있습니다."))
                }
            } else {
                Result.failure(Exception("사용자 조회 실패: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUsers(page: Int = 1): Result<List<ReqresUserDto>> {
        return try {
            val response = service.getUsers(page)

            if (response.isSuccessful) {
                val users = response.body()?.data.orEmpty()
                Result.success(users)
            } else {
                Result.failure(Exception("사용자 목록 조회 실패: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
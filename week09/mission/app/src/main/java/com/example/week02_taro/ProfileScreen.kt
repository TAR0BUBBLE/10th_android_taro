package com.example.week03_taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

private const val USER_ID = 1

@Composable
fun ProfileScreen() {
    val repository = remember { ReqresRepository() }

    var profileUser by remember { mutableStateOf<ReqresUserDto?>(null) }
    var followingUsers by remember { mutableStateOf<List<ReqresUserDto>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        isLoading = true
        errorMessage = null

        val profileResult = repository.getUserById(USER_ID)
        val followingResult = repository.getUsers(page = 1)

        profileResult
            .onSuccess { user ->
                profileUser = user
            }
            .onFailure { throwable ->
                errorMessage = throwable.message ?: "프로필 정보를 불러오지 못했습니다."
            }

        followingResult
            .onSuccess { users ->
                followingUsers = users
            }
            .onFailure { throwable ->
                errorMessage = throwable.message ?: "팔로잉 목록을 불러오지 못했습니다."
            }

        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(top = 70.dp, bottom = 24.dp)
    ) {
        ProfileHeader(
            user = profileUser,
            isLoading = isLoading
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage.orEmpty(),
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            )
        }

        ProfileQuickMenu()

        GrayDivider(
            modifier = Modifier.padding(top = 8.dp)
        )

        NikeMemberBenefit()

        GrayDivider()

        FollowingSection(
            users = followingUsers,
            isLoading = isLoading
        )

        Spacer(modifier = Modifier.height(100.dp))

        JoinDateFooter()
    }
}

@Composable
private fun ProfileHeader(
    user: ReqresUserDto?,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(84.dp)
                .clip(CircleShape)
                .background(Color(0xFFD9D9D9)),
            contentAlignment = Alignment.Center
        ) {
            if (user != null) {
                AsyncImage(
                    model = user.avatar,
                    contentDescription = "profile image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            } else if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(26.dp),
                    strokeWidth = 3.dp,
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = user?.fullName ?: "닉네임",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .width(180.dp)
                .height(52.dp)
                .clip(RoundedCornerShape(26.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFFE2E2E2),
                    shape = RoundedCornerShape(26.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "프로필 수정",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ProfileQuickMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .padding(start = 24.dp, end = 24.dp)
            .padding(top = 28.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileMenuItem(
            iconRes = R.drawable.ic_profile_order,
            label = "주문",
            modifier = Modifier.weight(1f)
        )

        VerticalMenuDivider()

        ProfileMenuItem(
            iconRes = R.drawable.ic_profile_pass,
            label = "패스",
            modifier = Modifier.weight(1f)
        )

        VerticalMenuDivider()

        ProfileMenuItem(
            iconRes = R.drawable.ic_profile_event,
            label = "이벤트",
            modifier = Modifier.weight(1f)
        )

        VerticalMenuDivider()

        ProfileMenuItem(
            iconRes = R.drawable.ic_profile_setting,
            label = "설정",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ProfileMenuItem(
    iconRes: Int,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.height(78.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFFB8B8B8))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun VerticalMenuDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(38.dp)
            .background(Color(0xFFE1E1E1))
    )
}

@Composable
private fun GrayDivider(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(Color(0xFFF4F4F4))
    )
}

@Composable
private fun NikeMemberBenefit() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "나이키 멤버 혜택",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "0개 사용 가능",
                color = Color(0xFF8A8A8A),
                fontSize = 13.sp
            )
        }

        Text(
            text = "›",
            color = Color.Black,
            fontSize = 34.sp
        )
    }
}

@Composable
private fun FollowingSection(
    users: List<ReqresUserDto>,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "팔로잉 (${users.size})",
                modifier = Modifier.weight(1f),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "편집",
                color = Color(0xFF8A8A8A),
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        when {
            isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = Color.Black
                    )
                }
            }

            users.isEmpty() -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(start = 24.dp, end = 16.dp)
                ) {
                    repeat(4) {
                        FollowingPlaceholder()
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }

            else -> {
                FollowingPager(users = users)
            }
        }
    }
}

@Composable
private fun FollowingPager(
    users: List<ReqresUserDto>
) {
    val pagerState = rememberPagerState(
        pageCount = { users.size }
    )

    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(112.dp),
        pageSpacing = 6.dp,
        contentPadding = PaddingValues(start = 24.dp, end = 16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
    ) { page ->
        FollowingImage(
            user = users[page]
        )
    }
}

@Composable
private fun FollowingImage(
    user: ReqresUserDto
) {
    AsyncImage(
        model = user.avatar,
        contentDescription = "following profile image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(106.dp)
            .background(Color(0xFFD9D9D9))
    )
}

@Composable
private fun FollowingPlaceholder() {
    Box(
        modifier = Modifier
            .size(106.dp)
            .background(Color(0xFFD9D9D9))
    )
}

@Composable
private fun JoinDateFooter() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
            .height(52.dp)
            .background(Color(0xFFF6F6F6)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "회원 가입일: 2025년 9월",
            color = Color(0xFF8A8A8A),
            fontSize = 12.sp
        )
    }
}
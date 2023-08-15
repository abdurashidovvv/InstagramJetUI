package com.example.instagram110

import android.content.ClipDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()
    ) {
        TopBar()
        ProfileSection()
        ProfileDescription(
            name = "Programming Mentor",
            description = "10 years of code experience\n" + "What me to make your app? Send me an email !\n" + "Subscribe to my YouTube channel!",
            url = "https://youtube.com/c/PhilippLackner"
        )
        Spacer(modifier = Modifier.height(10.dp))
        ButtonSection(
            list = listOf(
                TextWithImage(
                    image = Icons.Default.KeyboardArrowDown, text = "Following"
                ),
                TextWithImage(
                    image = null, text = "Message"
                ),
                TextWithImage(
                    image = null, text = "Email"
                ),
                TextWithImage(
                    image = Icons.Default.KeyboardArrowDown, text = null
                ),
            )
        )


        Spacer(modifier = Modifier.height(15.dp))

        HighlightedSection(
            list = listOf(
                Story(
                    image = painterResource(id = R.drawable.youtube), name = "You Tube"
                ), Story(
                    image = painterResource(id = R.drawable.qa), name = "Q&A"
                ), Story(
                    image = painterResource(id = R.drawable.discord), name = "Discord"
                ), Story(
                    image = painterResource(id = R.drawable.telegram), name = "Telegram"
                )
            ), modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        TabRowView(list = listOf(
            Story(
                image = painterResource(id = R.drawable.ic_grid),
                name = "",
            ), Story(
                image = painterResource(id = R.drawable.ic_reels),
                name = "",
            ), Story(
                image = painterResource(id = R.drawable.ic_igtv),
                name = "",
            ), Story(
                image = painterResource(id = R.drawable.profile),
                name = "",
            )
        ), onTabSelected = {
            selectedTabIndex = it
        })

        Posts(
            list = listOf(
                painterResource(id = R.drawable.kmm),
                painterResource(id = R.drawable.intermediate_dev),
                painterResource(id = R.drawable.master_logical_thinking),
                painterResource(id = R.drawable.bad_habits),
                painterResource(id = R.drawable.multiple_languages),
                painterResource(id = R.drawable.learn_coding_fast),
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 15.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "philipplackner_official", fontWeight = FontWeight.Bold, fontSize = 20.sp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.philipp),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .aspectRatio(1f)
                .border(
                    width = 2.dp, shape = CircleShape, color = Color.Gray
                )
                .clip(CircleShape)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        ) {
            Text(
                text = "601", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black
            )
            Text(
                text = "Posts", fontSize = 18.sp, color = Color.Black
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        ) {
            Text(
                text = "99.8K", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black
            )
            Text(
                text = "Followers", fontSize = 18.sp, color = Color.Black
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        ) {
            Text(
                text = "72", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black
            )
            Text(
                text = "Following", fontSize = 18.sp, color = Color.Black
            )
        }
    }
}

@Composable
fun ProfileDescription(
    name: String, description: String, url: String, modifier: Modifier = Modifier.fillMaxWidth()
) {
    Column(
        horizontalAlignment = Alignment.Start, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = name, fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.SemiBold
        )

        Text(
            text = description, fontSize = 18.sp, color = Color.Black
        )
        Text(
            text = url, fontSize = 18.sp, color = Color(0xFF3d3d91)
        )
        Text(text = buildAnnotatedString {
            val buildStyle = SpanStyle(
                color = Color.Black, fontWeight = FontWeight.Bold
            )
            append("Followed by ")
            pushStyle(buildStyle)
            append("codingflow, miakhalifa ")
            pop()
            append("and ")
            pushStyle(buildStyle)
            append("17 and others")
        })
    }
}

@Composable
fun ButtonSection(
    list: List<TextWithImage>, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            list.forEachIndexed { index, textWithImage ->
                ActionButton(textWithImage = textWithImage)
            }
        }
    }
}

@Composable
fun ActionButton(
    textWithImage: TextWithImage, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .border(
                width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp, vertical = 7.dp)
    ) {
        if (textWithImage.text != null) {
            Text(
                text = textWithImage.text ?: "", fontSize = 20.sp, fontWeight = FontWeight.SemiBold
            )
        }
        if (textWithImage.image != null) {
            Icon(
                imageVector = textWithImage.image, contentDescription = null
            )
        }
    }
}

@Composable
fun HighlightedSection(
    list: List<Story>, modifier: Modifier = Modifier.padding(10.dp)
) {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(list.size) {
            StoryItem(story = list[it])
        }
    }
}

@Composable
fun StoryItem(
    story: Story, modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = story.image,
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .aspectRatio(1f)
                .border(
                    width = 2.dp, shape = CircleShape, color = Color.Gray
                )
                .clip(CircleShape)
        )
        Text(
            text = story.name, fontSize = 20.sp, color = Color.Black
        )
    }
}

@Composable
fun TabRowView(
    list: List<Story>, modifier: Modifier = Modifier, onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectTabIndex by remember {
        mutableStateOf(0)
    }
    TabRow(
        selectedTabIndex = selectTabIndex, modifier = modifier.fillMaxWidth()
    ) {

        val inactiveColor = Color(0xFF777777)

        list.forEachIndexed { index, story ->
            Tab(selected = selectTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = story.image,
                    contentDescription = story.name,
                    tint = if (selectTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun Posts(
    list: List<Painter>, modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxWidth()
            .scale(1.01f)
    ) {
        items(list.size) {
            Image(
                painter = list[it],
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp, color = Color.White
                    )
            )
        }
    }
}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
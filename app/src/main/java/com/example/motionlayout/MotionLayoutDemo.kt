package com.example.motionlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.*

@OptIn(ExperimentalMotionApi::class)
@Preview()
@Composable
fun RecipeDetail() {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }
    val motionState = rememberMotionLayoutState()
    val corners = 10f - ((motionState.currentProgress * 10)).coerceAtMost(10f)

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        motionLayoutState = motionState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {

        Image(
            painter = painterResource(id = R.drawable.cake), contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("headerImage")
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.White, shape = RoundedCornerShape(topStart = corners, topEnd = corners))
                .layoutId("contentBg")
        )

        Text(
            text = "Fresh Strawberry Cake", fontSize = 22.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold, modifier = Modifier
                .layoutId("title")
                .fillMaxWidth()
                .padding(10.dp)
        )

        Divider(
            Modifier
                .layoutId("titleDivider")
                .fillMaxWidth()
                .padding(horizontal = 34.dp)
        )

        Text(
            text = "by John Kanell", fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray, fontStyle = FontStyle.Italic,
            modifier = Modifier
                .layoutId("subTitle")
                .fillMaxWidth()
                .padding(6.dp)
        )

        Divider(
            Modifier
                .layoutId("subTitleDivider")
                .fillMaxWidth()
                .padding(horizontal = 34.dp)
        )

        Text(
            modifier = Modifier
                .layoutId("date")
                .fillMaxWidth()
                .padding(6.dp),
            text = "September, 2022", fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        val properties = motionProperties("actions")

        Row(
            modifier = Modifier
                .layoutId("actions")
                .background(properties.value.color("background")),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            IconButton(onClick = { }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Share, contentDescription = "", tint = Color.White)
                    Text(text = "SHARE", color = Color.White, fontSize = 12.sp)
                }
            }

            IconButton(onClick = { }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Outlined.ThumbUp, contentDescription = "", tint = Color.White)
                    Text(text = "LIKE", color = Color.White, fontSize = 12.sp)
                }
            }

            IconButton(onClick = { }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Outlined.Star, contentDescription = "", tint = Color.White)
                    Text(text = "SAVE", color = Color.White, fontSize = 12.sp)
                }
            }
        }

        Text(
            text = "You will fall in love with this fresh Strawberry Cake made with a homemade strawberry reduction.\n\n" +
                    " It's moist, tender, and the most beautiful shade of pink!\n\n" +
                    "This recipe combines layers of strawberry flavored cake with strawberry flavored cream cheese frosting, so you get fresh strawberry flavors with every bite.\n\n" +
                    "This made from scratch with strawberry cake recipe is such a delightful and pretty cake. Packed with strawberry flavors and a gorgeous shade of pink, this cake is perfect for any occasion.\n\n" +
                    "No box mix or Jell-O in this cake! Made with real strawberries, this cake will steal the show with its light and tender crumb\n\n" +
                    "Filled and coated in a wonderful strawberry cream cheese frosting, this cake has strawberry flavoring through and through.\n\n" +
                    "Try making my strawberry shortcake recipe, strawberry pie recipe, strawberry chocolate cake recipe if you have extra strawberries on hand.\n" +
                    "Or, try my red velvet cake recipe or vanilla cake recipe if you want another easy cake recipe. \n" +
                    "You can leave the strawberry cake at room temperature for up to 5 days if you keep it covered. You can also store the cake in the fridge.\n" +
                    "\nYou can freeze fully frosted or unfrosted cake for up to 2 months. Wrap the cake tightly in a layer of plastic wrap and then tin foil before freezing.\n\n" +
                    "Let the cake thaw overnight in the refrigerator, then bring to room temperature before serving.",
            modifier = Modifier.fillMaxHeight()
                .layoutId("text")
                .padding(horizontal = 16.dp),
            fontSize = 12.sp,
        )

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.layoutId("menu"), contentPadding = PaddingValues(4.dp),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = ""
            )
        }


    }
}
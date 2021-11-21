package com.example.khuakyapp


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khuakyapp.screens.RandomActivity
import com.example.khuakyapp.ui.theme.KhuaKyAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      KhuaKyAppTheme {
        Scaffold(
          topBar = {
            TopAppBar(
              title = {
                IconButton(onClick = {}) {
                  Icon(
                    Icons.Filled.Home,
                    tint = Color.Transparent,
                    contentDescription = "Home Icon"
                  )
                }
                Text(
                  text = "Home",
                  color = colors.primaryVariant
                )
              },
              backgroundColor = colors.surface,
            )
          },
          bottomBar = {
            BottomAppBar { /* Bottom app bar content */ }
          },
          content = {
            MainScreenContainer()
          }
        )
      }
    }
  }
}

private val foodItems = listOf(
  Food(
    1,
    "Grilled Lobster",
    "This lobster is grilled with charcoal. It is served with different dipping sauces.",
    R.drawable.food1
  ),
  Food(
    2,
    "Baked crabs",
    "The crab dish is very delicious.",
    R.drawable.food2
  ),
  Food(
    3,
    "Grilled oysters",
    "Grilled oysters have a greasy taste.",
    R.drawable.food3
  ),
  Food(
    4,
    "Grilled oysters",
    "Grilled oysters have a greasy taste.",
    R.drawable.food4
  ),
  Food(
    5,
    "Grilled oysters",
    "Grilled oysters have a greasy taste.",
    R.drawable.food5
  ),
  Food(
    6,
    "Grilled oysters",
    "Grilled oysters have a greasy taste.",
    R.drawable.food6
  ),
  Food(
    7,
    "Grilled oysters",
    "Grilled oysters have a greasy taste.",
    R.drawable.fish
  ),
)

@Composable
fun MainScreenContainer() {
  val context = LocalContext.current
  Row(
    modifier = Modifier
      .padding(top = 50.dp)
  ) {
    FoodsList(
      foods = foodItems,
      modifier = Modifier.padding(
        top = 16.dp,
        bottom = 6.dp
      )
    )
  }
  Row(
    modifier = Modifier.padding(start = 15.dp, top = 4.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    ExtendedFloatingActionButton(
      onClick = {
        context.startActivity(Intent(context, RandomActivity::class.java))
      },
      icon = {
        Icon(
          Icons.Filled.Favorite,
          contentDescription = "Favorite"
        )
      },
      text = { Text("Hôm nay bạn muốn ăn gì?") }
    )
  }
}

private data class Food(
  val id: Int,
  val name: String,
  val description: String,
  @DrawableRes val imageRes: Int = 0
)

@Composable
private fun FoodsList(
  foods: List<Food>,
  modifier: Modifier = Modifier
) {
  Card(
    shape = MaterialTheme.shapes.large,
    modifier = modifier
  ) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
      Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          modifier = Modifier.size(18.dp),
          imageVector = Icons.Filled.Star,
          tint = Color.Blue,
          contentDescription = "Star Icon"
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "All Foods",
          fontWeight = FontWeight.Bold,
          color = Color.Black
        )
      }
      Spacer(modifier = Modifier.height(8.dp))
      LazyRow(
        contentPadding = PaddingValues(
          start = 16.dp,
          top = 8.dp,
          end = 16.dp
        ),
        content = {
          itemsIndexed(
            items = foods,
            itemContent = { index, food ->
              Food(food)
              if (index != foods.lastIndex) {
                Spacer(modifier = Modifier.width(8.dp))
              }
            })
        })
    }
  }
}

@Composable
private fun Food(food: Food) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Image(
      ImageBitmap.imageResource(id = food.imageRes),
      contentDescription = stringResource(id = R.string.foo_image),
      Modifier
        .size(80.dp)
        .clip(CircleShape)
    )
    Column(
      modifier = Modifier
        .padding(8.dp)
    ) {
      Text(food.name)
      Text(food.description)
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "App $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  KhuaKyAppTheme {
    Greeting("Android")
  }
}
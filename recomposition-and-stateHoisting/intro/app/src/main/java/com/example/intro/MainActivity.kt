package com.example.intro

//import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.intro.ui.theme.IntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroTheme {
                // A surface container using the 'background' color from the theme
MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    var moneyCounter = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(), color = Color(0xFF546E7A)
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
        {
//                    Greeting("Rohit")
        Text(text="$${moneyCounter.value}",style= TextStyle(
            color=Color.White,
            fontSize=19.sp,
        fontWeight= FontWeight.ExtraBold
        ))
            Spacer(modifier=Modifier.height(30.dp))
            CreateCircle(moneyCounter=moneyCounter.value){
                new_value->moneyCounter.value=new_value
            }
            if (moneyCounter.value>25){
                Text(text = "Lots of money")
            }
        }

    }
}

//@Preview
@Composable
fun CreateCircle(moneyCounter: Int=0,updateMoneyCounter:(Int)->Unit){


    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
            updateMoneyCounter(moneyCounter + 1)
            Log.d("counter", "CreateCircle: $moneyCounter")
        }
        ,shape= CircleShape,
        elevation=4.dp
        ){
Box(contentAlignment = Alignment.Center){
    Text(text = "Tap", modifier = Modifier)
}

        

    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//
//@Composable
//fun ShowAge(age: Int=12){
//    Text(text=age.toString())
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroTheme {
        MyApp()

    }
}
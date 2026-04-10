package com.example.myintroductionpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myintroductionpage.ui.theme.MyIntroductionPageTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold{
                    paddingValues ->MyAppStart(Modifier.padding(paddingValues))
            }
        }
    }
}

@Composable
fun MyAppStart(modifier: Modifier){
    Column(modifier= Modifier, verticalArrangement = Arrangement.SpaceAround){
        Myname()
    }
}

@Composable
fun Myname() {
    val name : String = "Berivan Alpagu"
    val title ="Android Developer"
    val hakkimda = "Backend geliştirme,Mobil uygulama geliştirme, veri işleme sistemleri ve ölçeklenebilir yazılım mimarileri üzerine odaklanıyorum. C#, .NET Core ve PostgreSQL ile kurumsal uygulamalar geliştirmenin yanı sıra Python ile veri analizi ve yapay zekâ destekli sistemler tasarladım"
    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
    ) {
        Box( //HEADER
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A73E8))
                .padding(20.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) { // sol tarafa : resim
                Image(painter = painterResource(id=R.drawable.profile_photo),
                    contentDescription=null,
                    modifier= Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color.White, CircleShape))

                // pp foto ile sağdaki ünvanı row arasına mesafe koyabilmek icin
                Spacer(modifier=Modifier.width(16.dp))

                // sag tarafa : name title
                Column{

                    Text(
                        text = name,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall // Büyük ve kalın yazı
                    )
                    Text(
                        text = title,
                        color = Color.LightGray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        /// HAKKIMDA / ABOUT ME
        Column(modifier = Modifier.fillMaxSize()
            .background(Color.White))
        {
            Box(modifier= Modifier
                .fillMaxWidth()
                .background(Color.Gray))
            {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ){
                    Text(text = "HAKKIMDA",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall) // Büyük ve kalın yazı)

                    Text("$hakkimda")

                }
            }
        }
    }
}
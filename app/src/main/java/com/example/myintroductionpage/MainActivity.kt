package com.example.myintroductionpage

import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//UI theme renklerim
val AnaMavi = Color(0xFF1A73E8)
val ArkaPlanGri = Color(0xFFF8F9FA)
val YaziRengi = Color.DarkGray

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

val yetenekKategorileri = mapOf(
    "Mobil Uygulama Geliştirme" to listOf("Kotlin", "Flutter Framework", "Java", "React Native"),
    "Backend Geliştirme" to listOf("C#", ".NET Core", "PostgreSQL", "Entity Framework", "FireBase"),
    "Veri & Yapay Zeka" to listOf("Python", "Pandas", "LLM Research"), "Data & Analiz" to listOf("Knime", "PowerBI", "Excel")
)
@Composable
fun MyAppStart(modifier: Modifier){
    LazyColumn( // kadırılabilir olması için
        modifier = modifier
            .fillMaxWidth()
            .background(ArkaPlanGri),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(bottom = 32.dp) // En altta biraz boşluk bırakır
    ) {
        // 1. İsim ve Header kısmı
        item { Myname() }

        // 2. Hakkımda kısmı
        item { Aboutme() }

        // 3. Projelerim kısmı
        item { Projelerim() }

        // 4. Yetenekler Başlığı
        yetenekKategorileri.forEach { (kategoriAdi, yetenekler) ->
            // Kategori Başlığı (Mobil, Backend vb.)
            item {
                Text(
                    text = kategoriAdi.uppercase(),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = AnaMavi,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.ExtraBold
                )
            }

            // O kategoriye ait yetenek kartları
            items(yetenekler) { yetenek ->
                yetenekelemanlari(yetenek)
            }

            // Kategoriler arası küçük bir boşluk
            item { Spacer(modifier = Modifier.height(8.dp)) }
        }

        // 6. Bana Ulaşın Butonu (En sonda)
        item { Banaulasin() }
    }
}

@Composable
fun Myname() {
    val name : String = "Berivan Alpagu"
    val title ="Android Developer"
    Column(modifier= Modifier
            .fillMaxWidth()
            .background(ArkaPlanGri)
    ) {
        Box( //HEADER
            modifier = Modifier
                .fillMaxWidth()
                .background(AnaMavi)
                .padding(6.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) { // sol tarafa : resim
                Image(painter = painterResource(id=R.drawable.profile_photo),
                    contentDescription=null,
                    modifier= Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape))

                // pp foto ile sağdaki ünvanı row arasına mesafe koyabilmek icin
                Spacer(modifier=Modifier.width(16.dp))

                // sag tarafa : name title
                Column{

                    Text(
                        text = name,
                        color = ArkaPlanGri,
                        style = MaterialTheme.typography.headlineSmall // Büyük ve kalın yazı
                    )
                    Text(
                        text = title,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun Aboutme(){
    val hakkimda = "Backend geliştirme, Mobil uygulama geliştirme, veri işleme sistemleri ve ölçeklenebilir yazılım mimarileri üzerine odaklanıyorum. C#, .NET Core ve PostgreSQL ile kurumsal uygulamalar geliştirmenin yanı sıra Python ile veri analizi ve yapay zekâ destekli sistemler tasarladım"
    Column(modifier = Modifier.fillMaxWidth()
        .padding(16.dp) // Kenarlardan boşluk
    ) {
        Text(
            text = "HAKKIMDA",
            style = MaterialTheme.typography.titleMedium,
            color = AnaMavi,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = hakkimda,
            style = MaterialTheme.typography.bodyMedium,
            color = YaziRengi,
            lineHeight = 20.sp // Satır aralığını biraz aç
        )
    }

}

@Composable
fun Projelerim() {
    Column(modifier = Modifier.fillMaxWidth()
                    .background(ArkaPlanGri)
                    .padding(16.dp)
    ){
        Text(text = "PROJELERİM",
            color = AnaMavi,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current

                Button(
                    onClick = {
                        // GitHub linkini buraya yapıştır
                        uriHandler.openUri("https://github.com/BerivanAlpagu?tab=repositories")
                    },
                    modifier = Modifier
                        .fillMaxWidth() // Buton kutuyu boydan boya kaplasın
                        .padding(top = 4.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Köşeleri hafif yuvarla
                    colors = ButtonDefaults.buttonColors(containerColor = AnaMavi) // Header ile aynı mavi
                ) {
                    Text(text = "Projelerimi görüntülemek için tıkla ", color = Color.White)
                }
            }
    }

    @Composable
    fun Yeteneklistesi(yeteneklistesi: List<String>) { // liste elemanlarini dondürecek function,
        // fonksiyona gidecek listeye paranteze yazdık bu yüzden
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(yeteneklistesi) { eleman ->
                yetenekelemanlari("Yetenekler: $eleman")
            }
        }
    }

    @Composable
    fun yetenekelemanlari(eleman: String) { // dönen her lemanin nasıl yazılacağıni: backgrounfu vs belirliyorum.
        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(6.dp).background(AnaMavi, CircleShape))
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = eleman, style = MaterialTheme.typography.bodyMedium, color = YaziRengi)
            }
        }
    }

    @Composable()
    fun Banaulasin() {
        val context = LocalContext.current
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:berivanalpagu@gmail.com")
        }
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center
            ) {
                Button(onClick = { context.startActivity(emailIntent) })
                {
                    Text("Bana Ulaşmak İçin Tıklayın")
                }
            }

    }

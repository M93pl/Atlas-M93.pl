package pl.m93.atlasgeoquiz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Game2 : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) {
        val configuration = newBase.resources.configuration
        configuration.fontScale = 1.0f // Wymuszenie standardowego rozmiaru czcionki
        val newContext = newBase.createConfigurationContext(configuration)
        super.attachBaseContext(newContext)
    }

    private var lastToast: Toast? = null
    private var Punkty = 0
    private var LiczbaPytan = 0
    private var PoprawnaOdpowiedz = ""
    private val Pytania = mutableListOf<Triple<String, String, String>>()

    val zle = listOf("Źle!", "Niestety nie...", "Błąd.", "Niepoprawnie!", "Nie!", "Ups...")
    val dobre = listOf("Dobrze!", "Tak!", "Brawo!", "Poprawnie!", "Świetnie!", "Tak jest!")




    @SuppressLint("MissingInflatedId", "DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val Odpowiedz = findViewById<EditText>(R.id.Odpowiedz2)
        Odpowiedz.requestFocus()

        val klawiatura = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        klawiatura.showSoftInput(Odpowiedz, InputMethodManager.SHOW_IMPLICIT)



        Pytania.add(Triple("Jakie to państwo?","m1","Węgry"))
        Pytania.add(Triple("Jakie to państwo?","m2","Irak"))
        Pytania.add(Triple("Jakie to państwo?","m3","Turcja"))
        Pytania.add(Triple("Jakie to państwo?","m4","Belgia"))
        Pytania.add(Triple("Jakie to państwo?","m5","Libia"))
        Pytania.add(Triple("Jakie to państwo?","m6","Czechy"))
        Pytania.add(Triple("Jakie to państwo?","m7","Pakistan"))
        Pytania.add(Triple("Jakie to państwo?","m8","Angola"))
        Pytania.add(Triple("Jakie to państwo?","m9","Brazylia"))
        Pytania.add(Triple("Jakie to państwo?","m10","Łotwa"))
        Pytania.add(Triple("Jakie to państwo?","m11","Francja"))
        Pytania.add(Triple("Jakie to państwo?","m12","Szwajcaria"))
        Pytania.add(Triple("Jakie to państwo?","m13","Meksyk"))
        Pytania.add(Triple("Jakie to państwo?","m14","Indonezja"))
        Pytania.add(Triple("Jakie to państwo?","m15","Etiopia"))
        Pytania.add(Triple("Jakie to państwo?","m16","Haiti"))
        Pytania.add(Triple("Jakie to państwo?","m17","Tunezja"))
        Pytania.add(Triple("Jakie to państwo?","m18","Oman"))
        Pytania.add(Triple("Jakie to państwo?","m19","Kazachstan"))
        Pytania.add(Triple("Jakie to państwo?","m20","Kirgistan"))
        Pytania.add(Triple("Jakie to państwo?","m21","Senegal"))
        Pytania.add(Triple("Jakie to państwo?","m22","Urugwaj"))
        Pytania.add(Triple("Jakie to państwo?","m23","Kolumbia"))
        Pytania.add(Triple("Co to za miasto?","c1","Londyn"))
        Pytania.add(Triple("Co to za miasto?","c2","Ateny"))
        Pytania.add(Triple("Co to za miasto?","c3","Los Angeles"))
        Pytania.add(Triple("Co to za miasto?","c4","Warszawa"))
        Pytania.add(Triple("Co to za miasto?","c5","Sztokholm"))
        Pytania.add(Triple("Co to za włoskie miasto?","c6","Bolonia"))
        Pytania.add(Triple("Co to za niemieckie miasto?","c7","Monachium"))
        Pytania.add(Triple("Co to za miasto?","c8","Madryt"))
        Pytania.add(Triple("Co to za miasto?","c9","Pretoria"))
        Pytania.add(Triple("Co to za miasto?","c10","Astana"))
        Pytania.add(Triple("Co to za miasto?","c11","Rzym"))
        Pytania.add(Triple("Co to za miasto w Chinach?", "c12", "Szanghaj"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f1","Monako"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f2","Białoruś"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f3","Argentyna"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f4","Azerbejdżan"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f5","Belize"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f6","Chile"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f7","Ekwador"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f8","Finlandia"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f9","Grecja"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f10","Włochy"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f11","Luksemburg"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f12","Mali"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f13","Nepal"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f14","Papua Nowa Gwinea"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f15","Bahrajn"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f16","Rumunia"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f17","Arabia Saudyjska"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f18","Serbia"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f19","Hiszpania"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f20","Sudan"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f21","Szwecja"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f22","Tajlandia"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f23","Bahamy"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f24","Holandia"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f25","Chiny"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f26","Tajwan"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f27","Ukraina"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f28","Wietnam"))
        Pytania.add(Triple("Jakie państwo ma taką flagę?","f29","Izrael"))
        Pytania.add(Triple("Jakie to państwo?","p1","Francja"))
        Pytania.add(Triple("Jakie państwo przedstawia to zdjęcie?","p2","Chiny"))
        Pytania.add(Triple("Jakie województwo przedstawia ta mapa?","p3","łódzkie"))
        Pytania.add(Triple("Jak nazywa się ten półwysep?","p4","iberyjski"))
        Pytania.add(Triple("Jak nazywa się ta wyspa?","p5","Madagaskar"))
        Pytania.add(Triple("Jaki to półwysep?","p6","arabski"))
        Pytania.add(Triple("Jaki to kontynent?","p7","Australia"))
        Pytania.add(Triple("Co to za jezioro?","p8","Śniardwy"))
        Pytania.add(Triple("Jak nazywa się ten stan USA?","p9","Teksas"))
        Pytania.add(Triple("Jak nazywa się największa wyspa Japonii?", "p10", "Honsiu"))
        Pytania.add(Triple("Jaka to wyspa, znajdująca się na Oceanie Indyjskim?","p11","Cejlon"))
        Pytania.add(Triple("Jaki jest największy park narodowy Tanzanii?","p12","Serengeti"))
        Pytania.add(Triple("Bezdrzewny obszar w okolicach podbiegunowych to..?","p13","Tundra"))
        Pytania.add(Triple("Jakie to miasto?","p14","Bydgoszcz"))
        Pytania.add(Triple("Jakie to miasto?","p15","Olsztyn"))
        Pytania.add(Triple("Jakie to miasto?","p16","Łódź"))
        Pytania.add(Triple("Jakie to miasto?","p17","Kijów"))
        Pytania.add(Triple("Jakie to miasto?","p18","Lwów"))
        Pytania.add(Triple("Jakie to miasto?","p19","Praga"))
        Pytania.add(Triple("Jakie to francuskie miasto?","p20","Marsylia"))
        Pytania.add(Triple("Jakie to niemieckie miasto?","p21","Kolonia"))
        Pytania.add(Triple("Jakie to miasto?","p22","Dubaj"))
        Pytania.add(Triple("Jakie to miasto?","p23","Bratysława"))
        Pytania.add(Triple("Jakie to polskie miasto?","p24","Gdańsk"))
        Pytania.add(Triple("Jakie to polskie miasto?","p25","Katowice"))
        Pytania.add(Triple("Jaka jest największa wyspa Indonezji?","p26","Borneo"))

        //Pytania.add(Triple("","",""))

        Pytania.shuffle()
        val wybrane = Pytania.take(10)
        Pytania.clear()
        Pytania.addAll(wybrane)

        val guzikSprawdz = findViewById<Button>(R.id.GuzikSprawdz2)
        guzikSprawdz.setOnClickListener {
            sprawdzOdpowiedz()
        }
        Odpowiedz.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                sprawdzOdpowiedz()
                true // Zatrzymuje domyślną obsługę Enter
            } else {
                false
            }
        }
        ustawPytanie3()


        var Punkty = intent.getIntExtra("Scores",0)



    }
    private fun showToast(message: String) {
        lastToast?.cancel() // Anuluj ostatni Toast
        lastToast = Toast.makeText(this, message, Toast.LENGTH_SHORT) // Utwórz nowy Toast
        lastToast?.show() // Wyświetl nowy Toast
    }
    private fun ustawPytanie3(){
        if (LiczbaPytan<10) {
            val pytanie = Pytania[LiczbaPytan]
            val pytanieText = findViewById<TextView>(R.id.Pytanie2)
            val odpowiedz = findViewById<EditText>(R.id.Odpowiedz2)

            val obraz = resources.getIdentifier(pytanie.second, "drawable", packageName)
            val img = findViewById<ImageView>(R.id.obraz) // Znajdujemy ImageView
            img.setImageResource(obraz) // Ustawiamy obraz w ImageView

            pytanieText.text = pytanie.first
            PoprawnaOdpowiedz = pytanie.third
            odpowiedz.text.clear()
        }
    }

    private fun sprawdzOdpowiedz(){
        val zleOdp = zle.random()
        val dobreOdp = dobre.random()
        val odpowiedz1 = findViewById<EditText>(R.id.Odpowiedz2)
        val odpowiedz = odpowiedz1.text.toString().trim()

        if (odpowiedz.equals(PoprawnaOdpowiedz, ignoreCase = true)){
            Punkty++
            showToast("$dobreOdp")
        } else{
            showToast("$zleOdp\nChodziło o: $PoprawnaOdpowiedz")
        }

        LiczbaPytan++
        if (LiczbaPytan<10){
            ustawPytanie3()
        } else {
            val PunktyOld = intent.getIntExtra("Scores", 0)
            val PKT = Punkty+PunktyOld
            Toast.makeText(this, "Poprawnie: $PKT z 25 pytań!", Toast.LENGTH_LONG).show()
            val Intent2 = Intent(this, Score::class.java)
            Intent2.putExtra("Scores2", PKT)
            startActivity(Intent2)
            finish()
        }
    }
}

























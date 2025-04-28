package pl.m93.atlasgeoquiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Game : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) {
        val configuration = newBase.resources.configuration
        configuration.fontScale = 1.0f // Wymuszenie standardowego rozmiaru czcionki
        val newContext = newBase.createConfigurationContext(configuration)
        super.attachBaseContext(newContext)
    }

    // ZMIENNE DLA GRY:
    private var lastToast: Toast? = null
    private var Punkty = 0
    private var LiczbaPytan = 0
    private var PoprawnaOdpowiedz = ""
    private val Pytania = mutableListOf<Pair<String, String>>()
    private val Pytania2 = mutableListOf<Pair<String, String>>()

    val zle = listOf("Źle!", "Niestety nie...", "Błąd.", "Niepoprawnie!", "Nie!", "Ups...")
    val dobre = listOf("Dobrze!", "Tak!", "Brawo!", "Poprawnie!", "Świetnie!", "Tak jest!")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val odpowiedz1 = findViewById<EditText>(R.id.Odpowiedz)
        odpowiedz1.requestFocus()

        val klawiatura = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        klawiatura.showSoftInput(odpowiedz1, InputMethodManager.SHOW_IMPLICIT)


        // LOGIKA GRY:
        Pytania.add(Pair("Polski", "Warszawa"))
        Pytania.add(Pair("Niemiec", "Berlin"))
        Pytania.add(Pair("USA", "Waszyngton"))
        Pytania.add(Pair("Hiszpanii", "Madryt"))
        Pytania.add(Pair("Szwecji", "Sztokholm"))
        Pytania.add(Pair("Czech", "Praga"))
        Pytania.add(Pair("Ukrainy", "Kijów"))
        Pytania.add(Pair("Anglii", "Londyn"))
        Pytania.add(Pair("Meksyku", "Meksyk"))
        Pytania.add(Pair("Japonii", "Tokio"))
        Pytania.add(Pair("Korei Południowej", "Seul"))
        Pytania.add(Pair("Korei Północnej", "Phenian"))
        Pytania.add(Pair("Egiptu", "Kair"))
        Pytania.add(Pair("Francji", "Paryż"))
        Pytania.add(Pair("Holandii", "Amsterdam"))
        Pytania.add(Pair("Belgii", "Bruksela"))
        Pytania.add(Pair("Danii", "Kopenhaga"))
        Pytania.add(Pair("Włoch", "Rzym"))
        Pytania.add(Pair("Litwy", "Wilno"))
        Pytania.add(Pair("Norwegii", "Oslo"))
        Pytania.add(Pair("Austrii", "Wiedeń"))
        Pytania.add(Pair("Wenezueli", "Caracas"))
        Pytania.add(Pair("Wietnamu", "Hanoi"))
        Pytania.add(Pair("Turcji", "Ankara"))
        Pytania.add(Pair("RPA", "Pretoria"))
        Pytania.add(Pair("Argentyny", "Buenos Aires"))
        Pytania.add(Pair("Węgier", "Budapeszt"))
        Pytania.add(Pair("Rumunii", "Bukareszt"))
        Pytania.add(Pair("Kanady", "Ottawa"))
        Pytania.add(Pair("Portugalii", "Lizbona"))
        Pytania.add(Pair("Grecji", "Ateny"))
        Pytania.add(Pair("Białorusi", "Mińsk"))
        Pytania.add(Pair("Australii", "Canberra"))
        Pytania.add(Pair("Tajlandii", "Bangkok"))
        Pytania.add(Pair("Chin", "Pekin"))
        Pytania.add(Pair("Arabii Saudyjskiej", "Rijad"))
        Pytania.add(Pair("Iraku", "Bagdad"))
        Pytania.add(Pair("Iranu", "Teheran"))
        Pytania.add(Pair("Izraela", "Jerozolima"))
        Pytania.add(Pair("Rosji", "Moskwa"))
        Pytania.add(Pair("Syrii", "Damaszek"))
        Pytania.add(Pair("Jordanii", "Amman"))
        Pytania.add(Pair("Kolumbii", "Bogota"))
        Pytania.add(Pair("Boliwii", "La Paz"))
        Pytania.add(Pair("Szkocji", "Edynburg"))
        Pytania.add(Pair("Łotwy", "Ryga"))
        Pytania.add(Pair("Finlandii", "Helsinki"))
        Pytania.add(Pair("Słowacji", "Bratysława"))
        Pytania.add(Pair("Maroko", "Rabat"))
        Pytania.add(Pair("Peru", "Lima"))
        Pytania.add(Pair("Chorwacji", "Zagrzeb"))
        Pytania.add(Pair("Słowenii", "Lublana"))
        Pytania.add(Pair("Bułgarii", "Sofia"))
        Pytania.add(Pair("Serbii", "Belgrad"))
        Pytania.add(Pair("Bośni i Hercegowiny", "Sarajewo"))
        Pytania.add(Pair("Estonii", "Tallin"))
        Pytania.add(Pair("Mołdawii", "Kiszyniów"))
        Pytania.add(Pair("Kosowa", "Prisztina"))
        Pytania.add(Pair("Albanii", "Tirana"))
        Pytania.add(Pair("Macedonii Północnej", "Skopje"))
        Pytania.add(Pair("Czarnogóry", "Podgorica"))
        Pytania.add(Pair("Malty", "Valletta"))
        Pytania.add(Pair("Islandii", "Reikjawik"))
        Pytania.add(Pair("Liechtensteinu", "Vaduz"))
        Pytania.add(Pair("Gruzji", "Tbilisi"))
        Pytania.add(Pair("Mongolii", "Ułan Bator"))
        Pytania.add(Pair("Nigerii", "Abudża"))
        Pytania.add(Pair("Pakistanu", "Islamabad"))
        Pytania.add(Pair("Brazylii", "Brasilia"))
        Pytania.add(Pair("Chile", "Santiago"))
        Pytania.add(Pair("Paragwaju", "Asuncion"))
        Pytania.add(Pair("Urugwaju", "Montevideo"))
        Pytania.add(Pair("Ekwadoru", "Quito"))
        Pytania.add(Pair("Panamy", "Panama"))
        Pytania.add(Pair("Kuby", "Hawana"))
        Pytania.add(Pair("Hondurasu", "Tegucigalpa"))
        Pytania.add(Pair("Gwatemali", "Gwatemala"))
        Pytania.add(Pair("Salwadoru", "San Salvador"))
        Pytania.add(Pair("Kostaryki", "San Jose"))
        Pytania.add(Pair("Nikaragui", "Managua"))
        Pytania.add(Pair("Jamajki", "Kingston"))
        Pytania.add(Pair("Bahamów", "Nassau"))
        Pytania.add(Pair("Haiti", "Port au Prince"))
        Pytania.add(Pair("Dominikany", "Santo Domingo"))
        Pytania.add(Pair("Filipin", "Manila"))
        Pytania.add(Pair("Malezji", "Kuala Lumpur"))
        Pytania.add(Pair("Indonezji", "Dżakarta"))
        Pytania.add(Pair("Singapuru", "Singapur"))
        Pytania.add(Pair("Bangladeszu", "Dhaka"))
        Pytania.add(Pair("Laosu", "Wientian"))
        Pytania.add(Pair("Sri Lanki", "Kolombo"))
        Pytania.add(Pair("Malediwów", "Male"))
        Pytania.add(Pair("Nowej Zelandii", "Wellington"))
        Pytania.add(Pair("Papui-Nowej Gwinei", "Port Moresby"))
        Pytania.add(Pair("Fidżi", "Suva"))
        Pytania.add(Pair("Kiribati", "Tarawa"))
        Pytania.add(Pair("Tuvalu", "Funafuti"))
        Pytania.add(Pair("Tonga", "Nukuʻalofa"))
        Pytania.add(Pair("Samoa", "Apia"))
        Pytania.add(Pair("Vanuatu", "Port Vila"))
        Pytania.add(Pair("Wysp Marshalla", "Majuro"))
        Pytania.add(Pair("Palau", "Ngerulmud"))
        Pytania.add(Pair("Mikronezji", "Palikir"))
        Pytania.add(Pair("Nauru", "Yaren"))
        Pytania.add(Pair("Timoru Wschodniego", "Dili"))
        Pytania.add(Pair("Kazachstanu", "Astana"))
        Pytania.add(Pair("Uzbekistanu", "Taszkent"))
        Pytania.add(Pair("Turkmenistanu", "Aszchabad"))
        Pytania.add(Pair("Nepalu", "Katmandu"))
        Pytania.add(Pair("Kirgistanu", "Biszkek"))
        Pytania.add(Pair("Sri Lanki", "Kolombo"))
        Pytania.add(Pair("Armenii", "Erywań"))
        Pytania.add(Pair("Kambodży", "Phnom Penh"))
        Pytania.add(Pair("Bhutanu", "Thimphu"))
        Pytania.add(Pair("Zambii", "Lusaka"))
        Pytania.add(Pair("Zimbabwe", "Harare"))
        Pytania.add(Pair("Jemenu", "Sana"))

        Pytania2.add(Pair("W którym roku założono Poleski Park Narodowy?", "1990"))
        Pytania2.add(Pair("Najdłuższa rzeka Polski to..?", "Wisła"))
        Pytania2.add(Pair("Jakie państwo ma najwięcej wysp?", "Indonezja"))
        Pytania2.add(Pair("Największa wyspa Polski to..?", "Wolin"))
        Pytania2.add(Pair("Najdłuższa rzeka śwata?", "Nil"))
        Pytania2.add(Pair("Stolica województwa podkarpackiego?", "Rzeszów"))
        Pytania2.add(Pair("'Wietrzne' miasto to..?","Chicago"))
        Pytania2.add(Pair("Najwyższy szczyt Tatr?","Gerlach"))
        Pytania2.add(Pair("'Wieczne' miasto to..?","Rzym"))
        Pytania2.add(Pair("Jaka rzeka przepływa przez największą liczbę państw w Europie?","Dunaj"))
        Pytania2.add(Pair("Wyspa 'Sokotra', stolica 'Sana', 'Wielki meczet', jakie to państwo?","Jemen"))
        Pytania2.add(Pair("Największe województwo w Polsce to województwo..?","mazowieckie"))
        Pytania2.add(Pair("Które województwo ma największą gęstość zaludnienia?","dolnośląskie"))
        Pytania2.add(Pair("Stolica administracyjna województwa świętokrzyskiego to..?","Kielce"))
        Pytania2.add(Pair("Największym na świecie jest ocean..?", "Spokojny"))
        Pytania2.add(Pair("Najwyższy szczyt świata?", "Mount Everest"))
        Pytania2.add(Pair("Największe jezioro w Polsce to..?", "Śniardwy"))
        Pytania2.add(Pair("Największe państwo świata pod względem powierzchni to..?", "Rosja"))
        Pytania2.add(Pair("Najwyższy wodospad świata to..?", "Salto Angel"))
        Pytania2.add(Pair("'Czarny ląd' to..?", "Afryka"))
        Pytania2.add(Pair("Najmniejsze państwo świata to..?", "Watykan"))
        Pytania2.add(Pair("Które państwo produkuje najwięcej kawy na świecie?", "Brazylia"))
        Pytania2.add(Pair("Jakie jest najgłębsze jezioro świata?", "Bajkał"))
        Pytania2.add(Pair("Jakie państwo ma z Polską najdłuższą granicę?", "Czechy"))
        Pytania2.add(Pair("Które państwo Unii Europejskiej ma najwięcej mieszkańców?", "Niemcy"))
        Pytania2.add(Pair("Jakie jest najludniejsze miasto Unii Europejskiej nie będące stolicą?", "Hamburg"))
        Pytania2.add(Pair("Stolica administracyjna województwa dolnośląskiego to..?","Wrocław"))
        Pytania2.add(Pair("Stolica administracyjna województwa lubelskiego to..?","Lublin"))
        Pytania2.add(Pair("Stolica administracyjna województwa małopolskiego to..?","Kraków"))
        Pytania2.add(Pair("Stolica administracyjna województwa podkarpackiego to..?","Rzeszów"))
        Pytania2.add(Pair("Stolica administracyjna województwa podlaskiego to..?","Białystok"))
        Pytania2.add(Pair("Stolica administracyjna województwa śląskiego to..?","Katowice"))
        Pytania2.add(Pair("Stolica administracyjna województwa wielkopolskiego to..?","Poznań"))
        Pytania2.add(Pair("Stolica administracyjna województwa zachodniopomorskiego to..?","Szczecin"))
        Pytania2.add(Pair("Czwarta pod względem długości rzeka Polski to..?","Bug"))
        Pytania2.add(Pair("Najgłębsze jezioro w Polsce to..?","Hańcza"))
        Pytania2.add(Pair("Największe jezioro świata to Morze..?","Kaspijskie"))
        Pytania2.add(Pair("Najludniejsze państwo świata to..?","Indie"))
        Pytania2.add(Pair("Które miasto Chin ma najwięcej mieszkańców?","Szanghaj"))
        Pytania2.add(Pair("Które miasto Australii ma najwięcej mieszkańców?","Sydney"))
        Pytania2.add(Pair("Które miasto USA ma najwięcej mieszkańców?","Nowy Jork"))
        Pytania2.add(Pair("Które miasto Kanady ma najwięcej mieszkańców?","Toronto"))
        Pytania2.add(Pair("Jakie miasto ma najwięcej mieszkańców na świecie?","Tokio"))
        Pytania2.add(Pair("Jaka wyspa ma najwięcej mieszkańców na świecie?","Jawa"))
        Pytania2.add(Pair("Największe jezioro w Stanach Zjednoczonych to jezioro..?","Górne"))
        Pytania2.add(Pair("Najdłuższa rzeka Włoch to..?","Pad"))
        Pytania2.add(Pair("Najdłuższa rzeka Hiszpanii to..?","Tag"))
        Pytania2.add(Pair("Najdłuższa rzeka Anglii to..?","Severn"))
        Pytania2.add(Pair("Która rzeka jest dłuższa: Tygrys czy Eufrat?","Eufrat"))
        Pytania2.add(Pair("Najdłuższa rzeka Azji to..?","Jangcy"))
        Pytania2.add(Pair("Wyspy o które Wielka Brytania i Argentyna toczyły wojnę to..?","Falklandy"))
        Pytania2.add(Pair("Najwyższy szczyt górski w Niemczech to..?","Zugspitze"))
        Pytania2.add(Pair("Jaką nazwę nosi sąsiadujące z Görlitz polskie miasto?","Zgorzelec"))
        Pytania2.add(Pair("Najdłuższy lewy dopływ Wisły to..?","Pilica"))
        Pytania2.add(Pair("Największe w Polsce miasto pod względem powierzchni to..?","Gdańsk"))
        Pytania2.add(Pair("Które miasto w Polsce jest najstarsze?","Złotoryja"))
        Pytania2.add(Pair("Które państwo wydobywa najwięcej miedzi na świecie?","Chile"))
        Pytania2.add(Pair("Które państwo ma najdłuższą linię brzegową?","Kanada"))
        Pytania2.add(Pair("Anatolia, Pont i Kapadocja to obecnie jakie państwo?","Turcja"))
        Pytania2.add(Pair("Albańskie 'miasto tysiąca okien' to..?","Berat"))

        //Pytania2.add(Pair("",""))

        val guzikSprawdz = findViewById<Button>(R.id.GuzikSprawdz)
        guzikSprawdz.setOnClickListener {
            sprawdzOdpowiedz()
        }
        odpowiedz1.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                sprawdzOdpowiedz()
                true // Zatrzymuje domyślną obsługę Enter
            } else {
                false
            }
        }
        Pytania.shuffle()
        val wybrane = Pytania.take(10)
        Pytania.clear()
        Pytania.addAll(wybrane)


        Pytania2.shuffle()
        val wybrane2 = Pytania2.take(5)
        Pytania2.clear()
        Pytania2.addAll(wybrane2)
        // Inicjalizacja pierwszego pytania
        ustawPytanie()

    }

    private fun showToast(message: String) {
        lastToast?.cancel() // Anuluj ostatni Toast
        lastToast = Toast.makeText(this, message, Toast.LENGTH_SHORT) // Utwórz nowy Toast
        lastToast?.show() // Wyświetl nowy Toast
    }
    private fun ustawPytanie() {
        if (LiczbaPytan < 10) {
            val pytanie = Pytania[LiczbaPytan]
            val pytanieText = findViewById<TextView>(R.id.Pytanie)
            val odpowiedz1 = findViewById<EditText>(R.id.Odpowiedz)

            pytanieText.text = "Jakie miasto jest stolicą ${pytanie.first}?"
            PoprawnaOdpowiedz = pytanie.second
            odpowiedz1.text.clear()
        }
    }


    private fun ustawPytanie2() {
        val indeks = LiczbaPytan - 10 // Dopasuj indeks do listy `Pytania2`
        if (indeks < 5) {
            val pytanie2 = Pytania2[indeks]
            val pytanieText2 = findViewById<TextView>(R.id.Pytanie)
            val odpowiedz12 = findViewById<EditText>(R.id.Odpowiedz)

            pytanieText2.text = "${pytanie2.first}"
            PoprawnaOdpowiedz = pytanie2.second
            odpowiedz12.text.clear()
        }
    }


    // Sprawdzanie odpowiedzi
    private fun sprawdzOdpowiedz() {
        val odpowiedz1 = findViewById<EditText>(R.id.Odpowiedz)
        val odpowiedz = odpowiedz1.text.toString().trim()
        val zleOdp = zle.random()
        val dobreOdp = dobre.random()



        if (odpowiedz.equals(PoprawnaOdpowiedz, ignoreCase = true)) {
            Punkty++
            showToast("$dobreOdp")
        } else {
            showToast("$zleOdp\nChodziło o: $PoprawnaOdpowiedz")
        }


        // Przechodzimy do kolejnego pytania
        LiczbaPytan++
        if (LiczbaPytan < 15) {
            if (LiczbaPytan < 10) {
                ustawPytanie()
            } else if (LiczbaPytan >= 10 && LiczbaPytan < 15) {
                ustawPytanie2()
            }
        } else {
            val Intent1 = Intent(this, Game2::class.java)
            Intent1.putExtra("Scores", Punkty)
            startActivity(Intent1)
            finish()
        }
    }
}


























package pl.m93.atlasgeoquiz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Score : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun attachBaseContext(newBase: Context) {
        val configuration = newBase.resources.configuration
        configuration.fontScale = 1.0f // Wymuszenie standardowego rozmiaru czcionki
        val newContext = newBase.createConfigurationContext(configuration)
        super.attachBaseContext(newContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Punkty = intent.getIntExtra("Scores2", 0)
        val wyniki = findViewById<TextView>(R.id.wyniki)
        wyniki.text = "Zdobywasz: $Punkty pkt."


        val PressGuzikAgain = findViewById<Button>(R.id.again)
        PressGuzikAgain.setOnClickListener {
            val Intent = Intent(this,Game::class.java)
            startActivity(Intent)
        }

        val PressGuzikWyjscie = findViewById<Button>(R.id.wyjscie)
        PressGuzikWyjscie.setOnClickListener {
            finishAffinity()
        }

        val ListaWynikow = findViewById<TextView>(R.id.listaWynikow)

        //zapis do pliku
        fun zapisz(results: String, result: Int) {
            try {
                // Lista do przechowywania wyników
                val wyniki = mutableListOf<Int>()

                // Sprawdzenie, czy plik istnieje i odczyt istniejących wyników
                try {
                    val fileInputStream = openFileInput(results)
                    val reader = BufferedReader(InputStreamReader(fileInputStream))
                    reader.forEachLine { line ->
                        wyniki.add(line.toInt()) // Dodanie wyniku do listy
                    }
                    reader.close()
                } catch (e: FileNotFoundException) {
                    // Plik nie istnieje - nie robimy nic, bo wyniki są puste
                }

                // Dodaj nowy wynik i posortuj listę malejąco
                wyniki.add(result)
                wyniki.sortDescending()

                // Zachowaj tylko 5 najwyższych wyników
                val ograniczoneWyniki = wyniki.take(5)

                // Zapisz ograniczoną listę do pliku
                val fileOutputStream = openFileOutput(results, Context.MODE_PRIVATE)
                val writer = BufferedWriter(OutputStreamWriter(fileOutputStream))
                for (wynik in ograniczoneWyniki) {
                    writer.write("$wynik\n")
                }
                writer.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        zapisz("best.txt", Punkty)






        fun wyswietlNajlepszeWyniki(results: String, listaWynikow: TextView) {
            try {
                val wyniki = mutableListOf<Int>()

                // Odczyt istniejących wyników z pliku
                try {
                    val fileInputStream = openFileInput(results)
                    val reader = BufferedReader(InputStreamReader(fileInputStream))
                    reader.forEachLine { line ->
                        wyniki.add(line.toInt())
                    }
                    reader.close()
                } catch (e: FileNotFoundException) {
                    // Plik nie istnieje - lista pozostaje pusta
                }

                // Posortowanie wyników i ograniczenie do 5 elementów
                wyniki.sortDescending()
                val ograniczoneWyniki = wyniki.take(5)

                // Tworzenie tekstu do wyświetlenia
                val builder = StringBuilder("Twoje najlepsze wyniki:")
                for (i in 0 until 5) {
                    val wynik = if (i < ograniczoneWyniki.size) ograniczoneWyniki[i] else 0
                    builder.append("\n${i + 1}. $wynik pkt.")
                }

                // Wyświetlenie wyników w TextView
                listaWynikow.text = builder.toString()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        wyswietlNajlepszeWyniki("best.txt",ListaWynikow)



    }
}
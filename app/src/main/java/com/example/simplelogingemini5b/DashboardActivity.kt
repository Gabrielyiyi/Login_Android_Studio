package com.example.simplelogingemini5b

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplelogingemini5b.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentUser = intent.getSerializableExtra("EXTRA_USER") as? Usuario

        val listaCursos = listOf(
            Curso(
                "Desarrollo Web Fullstack",
                "Domina el frontend y backend con las últimas tecnologías como React y Node.js.",
                "Web",
                R.drawable.img_course_web,
                "Principiante",
                "12 hrs",
                currentUser
            ),
            Curso(
                "Desarrollo de Apps Móviles",
                "Aprende a crear aplicaciones nativas para Android usando Kotlin y Jetpack Compose.",
                "Móvil",
                R.drawable.img_course_mobile,
                "Intermedio",
                "20 hrs",
                currentUser
            ),
            Curso(
                "Inteligencia Artificial",
                "Entiende los fundamentos del Machine Learning y crea tus propios modelos predictivos.",
                "IA",
                R.drawable.img_course_ai,
                "Avanzado",
                "15 hrs",
                currentUser
            )
        )

        binding.rvCursos.layoutManager = LinearLayoutManager(this)
        binding.rvCursos.adapter = CursoAdapter(listaCursos) { curso ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("EXTRA_CURSO", curso)
            startActivity(intent)
        }
    }
}

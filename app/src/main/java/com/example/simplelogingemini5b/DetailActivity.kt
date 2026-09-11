package com.example.simplelogingemini5b

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplelogingemini5b.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val curso = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_CURSO", Curso::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("EXTRA_CURSO") as? Curso
        }

        curso?.let {
            binding.tvDetailTitle.text = it.titulo
            binding.tvDetailCategory.text = it.categoria
            binding.tvDetailInfo.text = "${it.nivel} | ${it.duracion}"
            binding.tvDetailDescription.text = it.descripcion
            binding.tvDetailInstructor.text = "Instructor: ${it.instructor?.nombre ?: "Sin instructor"}"
            binding.ivDetailImage.setImageResource(it.imagenResId)
        }

        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }
}

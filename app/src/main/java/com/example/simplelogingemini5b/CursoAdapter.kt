package com.example.simplelogingemini5b

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplelogingemini5b.databinding.ItemCursoBinding

class CursoAdapter(
    private val cursos: List<Curso>,
    private val onItemClick: (Curso) -> Unit
) : RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {

    inner class CursoViewHolder(private val binding: ItemCursoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(curso: Curso) {
            binding.tvTitle.text = curso.titulo
            binding.tvLevelDuration.text = "${curso.nivel} | ${curso.duracion}"
            binding.ivThumbnail.setImageResource(curso.imagenResId)
            binding.tvCategoryTag.text = curso.categoria
            binding.tvInstructor.text = curso.instructor?.nombre ?: "Sin instructor"
            binding.btnVerDetalles.setOnClickListener { onItemClick(curso) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val binding = ItemCursoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CursoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        holder.bind(cursos[position])
    }

    override fun getItemCount(): Int = cursos.size
}

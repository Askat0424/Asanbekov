package com.example.asanbekov.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.asanbekov.databinding.ItemTaskBinding
import com.example.asanbekov.model.Task


class TaskAdapter (private val longClickListener:(Task)->Unit):
    Adapter<TaskAdapter.TaskViewHolder>() {
    private val data = arrayListOf<Task>()

    fun addTask(tasks : List<Task> ){
        data.clear()
        data.addAll(tasks)
        notifyItemChanged(0)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    inner  class  TaskViewHolder(private val binding:ItemTaskBinding):ViewHolder(binding.root) {
        fun bind(task: Task) {
            itemView.setOnLongClickListener {
                longClickListener(task)
                false

            }
            binding.title.text=task.title
            binding.description.text=task.description
        }
    }
}
package com.example.asanbekov.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.asanbekov.App
import com.example.asanbekov.databinding.FragmentHomeBinding
import com.example.asanbekov.ui.home.adapter.TaskAdapter
import com.example.asanbekov.R
import com.example.asanbekov.model.Task

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onLongClikcListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        setData()
        binding.recyclerView.adapter = adapter
    }

    private fun onLongClikcListener(task: Task) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Delete?")
        alert.setPositiveButton("Yes") { d, _ ->
            App.db.taskDao().delete(task)
            setData()
            d.dismiss()

        }
        alert.setNegativeButton("No") { d, _ ->
            d.dismiss()
        }
        alert.create().show()
    }

    private fun setData() {
        val tasks = App.db.taskDao().getAll()
        adapter.addTask(tasks)
    }
}
package com.example.androidui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.androidui.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.popupBtn.setOnClickListener {
            val popupMenu = PopupMenu(activity,it)
            popupMenu.inflate(R.menu.popupmenu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu1 -> {
                        Toast.makeText(activity, "Вы выбрали PopupMenu 1", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.menu2 -> {
                        Toast.makeText(activity, "Вы выбрали PopupMenu 2", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener true
                    }
                    else -> {
                        Toast.makeText(activity, "Default", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener false
                    }
                }
            }
            popupMenu.show()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
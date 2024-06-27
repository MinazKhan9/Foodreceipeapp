package com.example.foodreceipeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodreceipeapp.databinding.FragmentReceipeBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ReceipeBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentReceipeBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceipeBottomSheetBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
    }
}
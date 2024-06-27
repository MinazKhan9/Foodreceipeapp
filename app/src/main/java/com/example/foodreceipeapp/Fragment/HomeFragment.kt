package com.example.foodreceipeapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodreceipeapp.Adapter.ReceipeAdapter
import com.example.foodreceipeapp.Model.Receipe
import com.example.foodreceipeapp.R
import com.example.foodreceipeapp.ReceipeBottomSheetFragment
import com.example.foodreceipeapp.databinding.FragmentHomeBinding
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var dataList: ArrayList<Receipe>
    private lateinit var adapter: ReceipeAdapter
    private lateinit var recyclerView: RecyclerView

    lateinit var imageList: Array<Int>
    lateinit var nameList: Array<String>
    lateinit var minList: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        setupSearchView()

        return binding.root
    }


    private fun setupSearchView() {
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        val filteredMenuItem = dataList.filter {
            it.title?.contains(query, ignoreCase = true) == true
        }
        setAdapter(filteredMenuItem as ArrayList<Receipe>)

    }

    private fun setAdapter(filteredMenuItem: ArrayList<Receipe>) {
        adapter = ReceipeAdapter(filteredMenuItem, requireContext())
        binding.ReceipeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.ReceipeRecyclerView.adapter = adapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner5, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner6, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner7, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })

        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ReceipeRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ReceipeAdapter(dataList, requireContext())
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        dataList = arrayListOf<Receipe>()
        imageList = arrayOf(
            R.drawable.paneer,
            R.drawable.biryani,
            R.drawable.omelete,
            R.drawable.banner3,
            R.drawable.banner2,
            R.drawable.banner10
        )

        nameList = arrayOf(
            "Paneer Butter Masala",
            "Chicken Dum Biryani", "Omelete", "Garlic Bread", "Aaloo Patty", "Desert"
        )
        minList = arrayOf(
            25, 45, 10, 15, 30, 50
        )
        for (i in imageList.indices) {
            val data = Receipe(imageList[i], nameList[i], minList[i])
            dataList.add(data)
        }
    }
}
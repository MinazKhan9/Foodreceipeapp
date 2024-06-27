package com.example.foodreceipeapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodreceipeapp.Adapter.ReceipeAdapter
import com.example.foodreceipeapp.Model.Receipe
import com.example.foodreceipeapp.R
import com.example.foodreceipeapp.databinding.FragmentFavBinding

class FavFragment : Fragment() {
    private lateinit var binding: FragmentFavBinding
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
        binding = FragmentFavBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById<RecyclerView>(R.id.ReceipeRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ReceipeAdapter(dataList,requireContext())
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
            R.drawable.banner10,
            R.drawable.paneer,
            R.drawable.biryani,
        )

        nameList = arrayOf(
            "Paneer Butter Masala",
            "Chicken Dum Biryani", "Omelete", "Garlic Bread", "Aaloo Patty", "Desert","Shahi Paneer","Mutton Biryani"
        )
        minList = arrayOf(
            25, 45, 10, 15, 30, 50,25,50
        )
        for (i in imageList.indices) {
            val data = Receipe(imageList[i], nameList[i],minList[i])
            dataList.add(data)
        }
    }
}
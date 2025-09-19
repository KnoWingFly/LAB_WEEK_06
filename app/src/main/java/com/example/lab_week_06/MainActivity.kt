package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.Interface.GlideImageLoader
import com.example.lab_week_06.Adapter.CatAdapter
import com.example.lab_week_06.model.*
import kotlin.getValue
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper


class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy{
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallBack)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Aegean,
                    "Aglaea",
                    "Weaver Of Gold",
                    "https://cdn2.thecatapi.com/images/uvt2Psd9O.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BritishLonghair,
                    "Lumpy Space Princess",
                    "Princess Cat",
                    "https://cdn2.thecatapi.com/images/7isAO4Cav.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Sphynx,
                    "Punkie",
                    "Hairless Cat",
                    "https://cdn2.thecatapi.com/images/HBWdtLpif.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.DragonLi,
                    "Dan Heng",
                    "Soaring Dragon without Restraint",
                    "https://cdn2.thecatapi.com/images/DUxU01IY5.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.TurkishAngora,
                    "Taro (Miyo Sasaki)",
                    "A Whisker Away",
                    "https://cdn2.thecatapi.com/images/DYOqsRy9f.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.JapaneseBobtail,
                    "Daijin",
                    "Suzume",
                    "https://cdn2.thecatapi.com/images/-tm9-znzl.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Mainecoon,
                    "Coconut",
                    "Nekopara (I'm out of ideas for reference)",
                    "https://cdn2.thecatapi.com/images/Wq_eTQalE.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.KhaoManee,
                    "Laurier",
                    "Nekopara Catboy",
                    "https://cdn2.thecatapi.com/images/165ok6ESN.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ScotishFold,
                    "Cinnamon",
                    "Nekopara (again)",
                    "https://cdn2.thecatapi.com/images/dkN5wGUxC.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel){
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK"){_,_ ->}
            .show()
    }
}
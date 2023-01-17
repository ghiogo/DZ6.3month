package com.example.dz63month.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz63month.R
import com.example.dz63month.TextAdapter
import com.example.dz63month.`interface`.OnItemTextListener
import com.example.dz63month.data.TextModel
import com.example.dz63month.databinding.FragmentTextBinding
import com.example.dz63month.repository.TextRepository


class TextFragment : Fragment(), OnItemTextListener {
    private  var binding : FragmentTextBinding? = null

    private val textList= ArrayList<TextModel>()
    private val adapter= TextAdapter(textList, this)
    private val repo = TextRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentTextBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initialize()
        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(TextModel(text.toString()))
        }
    }

    private fun initialize() {
        binding?.recyclerview?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfText())
        binding?.recyclerview?.adapter = adapter
    }

    override fun onClick(model: TextModel) {
        val bundle= Bundle()
        bundle.putString("cat", model.text)
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view,  SecondFragment:: class.java,bundle)
                .addToBackStack("TextFragment")
                .commit()
        }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    }


package com.example.dz63month.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.dz63month.R
import com.example.dz63month.data.TextModel
import com.example.dz63month.databinding.FragmentSecondBinding
import com.example.dz63month.databinding.FragmentTextBinding


class SecondFragment : Fragment() {
    private  var binding : FragmentSecondBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentSecondBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickListener()
        getData()
    }

    private fun onClickListener() {
        binding?.btn?.setOnClickListener(View.OnClickListener {
            val bundle2 = Bundle()
            bundle2.putString("cat2", binding?.search?.text.toString())
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, TextFragment::class.java, bundle2)
                .addToBackStack("SecondFragment").commit()
        })
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null){
            val text = bundle?.getString("cat")
            binding?.search?.setText(text)

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null

 }
}
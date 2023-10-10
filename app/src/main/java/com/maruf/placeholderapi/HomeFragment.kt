package com.maruf.placeholderapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maruf.placeholderapi.api.PublicApi
import com.maruf.placeholderapi.api.RetrofitHelper
import com.maruf.placeholderapi.databinding.FragmentHomeBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    @SuppressLint("SuspiciousIndentation")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, null, false)

        val postApi = RetrofitHelper.getInstance().create(PublicApi::class.java)
        // launching a new coroutine

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                val result = postApi.getPost()
                if (result != null)
                // Checking the results
                    binding.test.text = result.body().toString()
                Log.d("ayush: ", result.body().toString())
            }

        }

        return binding.root

    }
}
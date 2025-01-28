package com.example.poc_facial_recognition.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.poc_facial_recognition.R


class ResultsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_result, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val isSuccess = requireArguments().getBoolean("result")

        val resultTitle = view.findViewById<TextView>(R.id.resultTitle)
        val resultBody = view.findViewById<TextView>(R.id.resultBody)
        val resultLogo = view.findViewById<ImageView>(R.id.resultLogo)
        val resultButton = view.findViewById<Button>(R.id.result_btn)

        if (isSuccess) {
            resultLogo.setImageResource(R.drawable.result_success)
            resultTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.greenSuccess))
            resultBody.setText(R.string.result_success)
            resultButton.setText(R.string.ok_understood)
        } else {
            resultLogo.setImageResource(R.drawable.result_error)
            resultTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.redError))
            resultBody.setText(R.string.result_error)
            resultButton.setText(R.string.take_new_picture)
        }
        resultButton.setOnClickListener {
            findNavController().popBackStack(R.id.welcomeFragment,false)
        }
    }
}
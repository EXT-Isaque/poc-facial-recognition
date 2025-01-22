package com.example.poc_facial_recognition.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import br.com.nxcd.facedetection.NxcdFaceDetection
import com.example.poc_facial_recognition.R

class InstructionsFragment : Fragment() {

    private val DETECTION_REQUEST_CODE = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_instructions, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.take_picture).setOnClickListener {
            startFaceDetection()
        }
    }

    private fun startFaceDetection() {
        val nxcdFaceDetection =
            NxcdFaceDetection(DETECTION_REQUEST_CODE, "")
        nxcdFaceDetection.setHomologation()
        //nxcdFaceDetection.setDevelopment();
        nxcdFaceDetection.startFaceDetection(this)
    }
}

package com.example.poc_facial_recognition.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.nxcd.facedetection.NxcdFaceDetection
import com.example.poc_facial_recognition.R
import com.google.android.datatransport.BuildConfig

class InstructionsFragment : Fragment() {
    val TAG: String = "FaceDetection"
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

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DETECTION_REQUEST_CODE) {
            treatResultSDK(resultCode, data)
        }
    }

    private fun treatResultSDK(resultCode: Int, resultIntent: Intent?) {
        if (Activity.RESULT_CANCELED == resultCode) {
            Log.d(TAG, "Face detection canceled")

            if (resultIntent != null) {
                if (resultIntent.hasExtra(NxcdFaceDetection.RESULT)) {
                    val result =
                        resultIntent.getSerializableExtra(NxcdFaceDetection.RESULT) as HashMap<String, Any>?
                    Log.d(TAG, "Analyze image has failed: " + result.toString())
                    Toast.makeText(requireContext(), result.toString(), Toast.LENGTH_LONG).show()
                }

                if (resultIntent.hasExtra(NxcdFaceDetection.THROWABLE)) {
                    val throwable =
                        resultIntent.getSerializableExtra(NxcdFaceDetection.THROWABLE) as Throwable?
                    Log.e(TAG, "Analyze image has failed.", throwable)
                    Toast.makeText(requireContext(), throwable!!.message, Toast.LENGTH_LONG).show()
                }
            }
            return
        }

        if (resultIntent != null && resultIntent.hasExtra(NxcdFaceDetection.RESULT)) {
            val resultDataFromAPI = resultIntent.extras!!
                .getSerializable(NxcdFaceDetection.RESULT) as HashMap<String, Any>?
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "Result from API: " + resultDataFromAPI.toString())
            }

            val result =
                (resultDataFromAPI!!["data"] as HashMap<String?, Any?>)["isAlive"] as Boolean

        }
    }

    private fun startFaceDetection() {
        val nxcdFaceDetection =
            NxcdFaceDetection(DETECTION_REQUEST_CODE, "66913b8060589336ec04d0ae:t0JipAnvuOIV0E6PZNENqCep")
        nxcdFaceDetection.setHomologation()
        nxcdFaceDetection.startFaceDetection(this)
    }
}

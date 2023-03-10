package com.example.worldfactory

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.example.worldfactory.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    private class VideoWebView : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            if(Uri.parse(request?.url.toString()).toString().contains("https://www.youtube.com/watch?v=9efIA_FMBjo", ignoreCase = true)) {
                return super.shouldOverrideUrlLoading(view, request)
            }

            return true
        }
    }

    private var _binding: FragmentVideoBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if ((activity as WordActivity).currentTab == 2) {
                    if (binding.webview.canGoBack() && Uri.parse(binding.webview.url .toString()).toString().contains("https://www.youtube.com/watch?v=9efIA_FMBjo", ignoreCase = true) && Uri.parse(binding.webview.url .toString()).toString().length > 68) {

                        binding.webview.goBack()
                    }
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVideoBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl("https://www.youtube.com/watch?v=9efIA_FMBjo")
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.settings.setSupportZoom(true)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
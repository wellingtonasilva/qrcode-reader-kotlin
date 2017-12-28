package com.example.wellingtonasilva.qrcode.pagamento.scanner

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wellingtonasilva.qrcode.R
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

/**
 * Created by wellingtonasilva on 28/12/17.
 */
class PagamentoScannerFragment: Fragment(), ZXingScannerView.ResultHandler
{
    lateinit var mScannerView: ZXingScannerView

    companion object {
        val TAG: String = "PagamentoScannerFragment"
        fun newInstance(): PagamentoScannerFragment {
            return PagamentoScannerFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.lay_pagamento_scanner_fragment, container, false)
        mScannerView = view?.findViewById<ZXingScannerView>(R.id.viewFinderView)!!
        return view
    }

    override fun onResume() {
        super.onResume()
        mScannerView.setResultHandler(this)
        mScannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView.stopCamera()
    }

    override fun handleResult(result: Result?)
    {
        Toast.makeText(activity, result?.text, Toast.LENGTH_SHORT).show()
        val handler = Handler()
        handler.postDelayed(Runnable { mScannerView.resumeCameraPreview(this)}, 2000)
    }
}
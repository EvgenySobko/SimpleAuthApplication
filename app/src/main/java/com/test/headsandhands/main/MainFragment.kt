package com.test.headsandhands.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.test.headsandhands.R
import com.test.headsandhands.utils.hideSoftKeyboard
import com.test.headsandhands.utils.toast
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView()
    }

    private fun onInitView() {
        login.setOnClickListener {
            activity!!.hideSoftKeyboard()
            if (viewModel.checkAccuracy(emailText.text.toString(), passwordText.text.toString())) {
                viewModel.getWeather()
            } else toast("Email or password is incorrect")
        }

        viewModel.temperature.observe(this.viewLifecycleOwner, Observer {
            if (it != null) {
                Snackbar.make(view!!, "Current temperature in Saint-P. = $it°С", Snackbar.LENGTH_LONG).show()
            }
        })
    }
}
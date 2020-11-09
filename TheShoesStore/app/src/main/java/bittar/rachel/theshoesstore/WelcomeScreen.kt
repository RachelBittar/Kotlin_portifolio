package bittar.rachel.theshoesstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import bittar.rachel.theshoesstore.databinding.FragmentLoginBinding


class WelcomeScreen : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate (R.layout.fragment_welcome_screen, container, false)


    }

}


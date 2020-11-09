package bittar.rachel.theshoesstore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import bittar.rachel.theshoesstore.databinding.FragmentLoginBinding


class Login_Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.buttonEnter.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_fragment_login_to_welcomeScreen))

        return binding.root
    }


}
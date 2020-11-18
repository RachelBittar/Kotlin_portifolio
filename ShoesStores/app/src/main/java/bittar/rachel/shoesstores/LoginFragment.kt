package bittar.rachel.shoesstores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import bittar.rachel.shoesstores.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
           inflater, R.layout.fragment_login, container, false)

        binding.buttonEnter.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))

        return binding.root
    }
}
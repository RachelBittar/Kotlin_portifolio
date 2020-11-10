package bittar.rachel.theshoesstore.Screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import bittar.rachel.theshoesstore.R
import bittar.rachel.theshoesstore.databinding.FragmentInstructionBinding
import bittar.rachel.theshoesstore.databinding.FragmentWelcomeScreenBinding

class Instruction : Fragment() {


    lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction
            , container,
            false)

        return binding.root
    }


}
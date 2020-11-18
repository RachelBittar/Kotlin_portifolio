package bittar.rachel.shoesstores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import bittar.rachel.shoesstores.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )

       binding.swtAgree.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoesListFragment))

        return binding.root
    }
    
}